package springbasics4;

import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class ExeJsViewResolver implements ViewResolver, Ordered {

	private int order;

	/**
	 * Dado un nombre lógico de la vista, comprobaos si existe un fichero con esa denominación 
	 * nombrevista + extensión 
	 * 
	 * En caso de que exista, se devuelve el objeto que se
	 * encargará de generar la vista, llamado View 
	 * 
	 * En caso de que no exista, se
	 * devuelve null y Spring probará con otro ViewResolver 
	 * (el siguiente en
	 * prioridad)
	 */
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		View vista = null;

		ExeJsView exeJsView = new ExeJsView();
		exeJsView.setViewName(viewName + ExeJsView.EXE_JS_EXT);
		if (exeJsView.exists()) {
			vista = exeJsView;
		}

		return vista;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int getOrder() {
		return this.order;
	}

}