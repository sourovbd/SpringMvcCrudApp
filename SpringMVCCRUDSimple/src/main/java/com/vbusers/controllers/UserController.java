package com.vbusers.controllers;   

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vbusers.entity.VbUser;
import com.vbusers.service.UserService;

@Controller  
public class UserController {  
	
    @Autowired  
    private UserService userService;  
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, VbUser vbUser)
	{
		ModelAndView model = new ModelAndView("login");
		model.addObject("vbUser", vbUser);
		return model;
	}
    
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("vbUser") VbUser vbUser)
	{
		ModelAndView model= null;
	
		boolean isValidUser = userService.isValidUser(vbUser.getUserName(), vbUser.getPassword());
		if(isValidUser) {
			System.out.println("User Login Successful");
			model = new ModelAndView("redirect:/viewUsers");
		} else {
			model = new ModelAndView("login");
			request.setAttribute("message", "Invalid credentials!!");
		}
		return model;
	}
	
	  
	 @RequestMapping(value="/viewUsers", method=RequestMethod.GET) 
	 public String viewVbUsers(Model model){
	  
		  model.addAttribute("userLists",userService.getVbUsers());
	  
		  return "viewemp"; 
	  }
	  
	@RequestMapping(value="/fetchVbUser/{id}", method=RequestMethod.GET)  
    public String fetchVbUser(@PathVariable long id, Model model){  
		 
		VbUser vbUser = userService.getVbUserById(id);
        model.addAttribute("command", vbUser);
        
        return "empeditform";  
    }  
	
	@RequestMapping(value="/updateVbUser", method = RequestMethod.POST)  
    public String editVbUser(@ModelAttribute("vbUser") VbUser vbUser){  
		
        userService.update(vbUser);
        
        return "redirect:/viewUsers";  
    }  
	
	@RequestMapping(value="/addVbUser",method=RequestMethod.GET)
	public ModelAndView viewAddUserForm(VbUser vbUser)
	{
		ModelAndView model = new ModelAndView("empform");
		model.addObject("vbUser", vbUser);
		
		return model;
	}
	
	@RequestMapping(value="/addVbUser", method=RequestMethod.POST)
	public String addVbUser(@ModelAttribute("vbUser") VbUser vbUser)
	{
		userService.save(vbUser);	
		
		return "redirect:/viewUsers";
	}
	
	@RequestMapping(value="/deleteVbUser/{id}", method=RequestMethod.GET)
	public String deleteVbUser(@PathVariable long id)
	{
		userService.delete(id);	
		
		return "redirect:/viewUsers";
	}
	
}  