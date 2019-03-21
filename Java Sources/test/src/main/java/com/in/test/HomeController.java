package com.in.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController implements Validator{
	
	@Autowired
	Parent child;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/redirectAttributes", method = RequestMethod.POST)
	public String sendTest(RedirectAttributes redirectAttributes){
	    redirectAttributes.addFlashAttribute("KeyName", "KeyValue");
	    return "redirect:redirectAttributes2";
	}
	
	@RequestMapping(value = "/redirectAttributes2")
	public ModelAndView sendTest2(){
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("formTest");
	    
	    return mav;
	}

	
	
	
	@RequestMapping(value = "/redirectTest", method = RequestMethod.POST)
	public ModelAndView redirect(@ModelAttribute("userForm")RedirectAttributes ra) {
		System.out.println("11111");
		ModelAndView mav = new ModelAndView();
		UserVO user = new UserVO();
		user.setUserId("wtf!!!");
		System.out.println("2222222");
	/*	ra.addAttribute("userId","WTF!");*/
		System.out.println("333333");
		ra.addAttribute("userId","DDD");
		System.out.println("444444");
		mav.setViewName("redirect:/formTest2.jsp");	
		System.out.println("55555");
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/validateTest", method = RequestMethod.POST)
	public final String submit(UserVO user, BindingResult binding, RedirectAttributes attr) {
		validate(user, binding);
		
		if (binding.hasErrors()) {
		    attr.addFlashAttribute("org.springframework.validation.BindingResult", binding);
		    attr.addFlashAttribute("user", user);
		    return "redirect:/formTest.jsp";
		}

	return "redirect:/register/success";
	}
	
	
	@RequestMapping(value = "/multiTest", method = RequestMethod.GET)
	public ModelAndView home(MultiVO multi) {
		ModelAndView mav = new ModelAndView();
		
		for(int i =0;i<multi.getStr().size();i++){
			System.out.println(multi.getStr().get(i));
		}
		
		
		return mav;
	}


	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		if(1==1) errors.rejectValue("userId", "userId.error");
	}
	
}
