package springbasics4;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.AbstractView;

public class ExeJsView extends AbstractView {
    
	  public static final String EXE_JS_EXT = ".exejs";
	  private static final String EXE_JS_TEMPLATE_NAME = "template.exejs";
	  private static final String CONTENT_PART_ATTR = "[[CONTENT_PART]]";
	  
	  private String viewName;
	  private Resource resContentPart;
	  
	  public void setViewName(String viewName) 
	  {
		  this.viewName = viewName;
	  }
	  
	  /**
	    * Elaboramos la vista devuelta, usando los datos del modelo en la vista indicada
	    * A su vez, la vista indicada ocupa el contenido de una plantilla
	    * 
	    * PLANTILLA --> VISTA --> DATOS DE LA VISTA (MODELO)
	    */
	  @Override
	  protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception 
	  {
		  	//tomo la plantilla
		  	Resource template = new ClassPathResource(EXE_JS_TEMPLATE_NAME);
		    //cargo la vista
		  	this.resContentPart = new ClassPathResource(this.viewName);
		    
		  	//obtengo la plantilla
		    String templateContent = FileUtils.readFileToString(template.getFile());
		    //obtengo la vista
		    String viewContent = FileUtils.readFileToString(this.resContentPart.getFile());
	
		    // sustituyo en plantilla la vista 
		    String fileContent = templateContent.replace(CONTENT_PART_ATTR, viewContent);
		    
		    //por último, "relleno la vista con los datos del modelo" -voy recorriendo los datos del modelo y sustituyo por los valores en el fichero
		    if (model != null && model.size() > 0) 
		    {
		    	for (Map.Entry<String, Object> entry : model.entrySet()) 
		    	{
		    		fileContent = fileContent.replaceAll(constructVariable(entry.getKey()), entry.getValue().toString());
		    	}
		    }
		    // una vez finalizado el proceso, seteo las cabeceras y el cuerpo de la respuesta y listo!
		    
		    response.setContentType(this.getContentType());
		    response.getOutputStream().write(fileContent.getBytes("UTF-8"));
	  }
	  
	  /**
	    * indicamos el timpode vuelto de la respuesta
	    */
	  @Override
	  public String getContentType() 
	  {
		  return "application/javascript";
	  }
	  
	  @Override
	  public void setContentType(String contentType) {
	    
	  }

	  /**
	    * 
	    * @return True si la vista existe.
	    */
	  public boolean exists() 
	  {
		  boolean br = false;
		  this.resContentPart = new ClassPathResource(this.viewName);
		  
			  try 
			  {
				  br = this.resContentPart.getFile() != null && this.resContentPart.getFile().exists();
			  } 
			  catch (IOException e) 
			  {
				  e.printStackTrace();
			  }
			  
	    return br;
	  }
	  
	  /**
	    * Preparamos la corrrespondecia de las variables bind de la vista
	    * con la entrada del mapa:
	    * 
	    * EJEMPLO: entry<"name", "My name"> devolvemos [[name]].
	    * 
	    * @param modelAttrName la clave del mapa
	    * @return variable bind reconocible en la vista.
	    */
	  private String constructVariable(String modelAttrName) 
	  {
		  return "\\[\\["+modelAttrName+"\\]\\]";
	  }

	}