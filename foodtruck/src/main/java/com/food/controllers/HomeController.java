package com.food.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/home")
    public String homePageurl() {
        return "index";
    }
   
    @RequestMapping(value = "/contact")
    public String redirect() {
       return "contact";
    }
    
    @RequestMapping(value = "/menu")
    public String menuDirext() {
       return "menu";
    }
    
    @RequestMapping(value = "/aboutus")
    public String aboutusDirext() {
       return "aboutus";
    }
    
    @RequestMapping(value = "/login")
    public String loginDirext() {
       return "login";
    }
    
    @RequestMapping(value = "/cart")
    public String CartPage() {
        return "cart";
    }
    
//    @RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
//    public String loginSubmitDirext(@ModelAttribute("userName") String userName, @ModelAttribute("password") String password) {
//    	User user = new User();
//    	return "indexUser";
//    	
//    }
}
