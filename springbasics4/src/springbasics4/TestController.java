package springbasics4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class TestController {
        
  @RequestMapping("/devstring")
  public String testExeJsString(Model model) 
  {
	  model = setearModelo(model);
	  	
	  return "booking";
  }

  @RequestMapping("/devview")
  public View testExeJsView(Model model) 
  {
	  ExeJsView vista = null;
	  
		  setearModelo(model);
		  vista = new ExeJsView();
		  vista.setViewName("booking"+ExeJsView.EXE_JS_EXT);
    
	return vista;
  }

  @RequestMapping("/devmodelandview")
  public ModelAndView testExeJsModelAndView(Model model) 
  {
	  ModelAndView modelAndView = null;
	  
	  
	    setearModelo(model);
	    modelAndView = new ModelAndView();
	    modelAndView.setViewName("booking");
	    
	    return modelAndView;
   
	    
  }

 
  
  private Model setearModelo(Model model) 
  {
	  Model model_local = model;
	  
	  
		  model_local.addAttribute("item_id", 394);
		  model_local.addAttribute("is_bookable", false);
		  model_local.addAttribute("success_title", "Booking successfull !");
		  model_local.addAttribute("success_message", "The item 394 was correctly booked");
		  model_local.addAttribute("error_title", "An error occurred when booking");
		  model_local.addAttribute("error_message", "Item 394 can't be booked because of some technical problems");
		  model_local.addAttribute("booking_url", "/booking/make-book");
	    
	  return model_local;
  }
}