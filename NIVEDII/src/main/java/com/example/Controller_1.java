package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controller_1 {

	
	@Autowired
	private UserRepository r;

	@GetMapping(name ="/")
	String login() {
		return "index";
	}
	
	
	@GetMapping("/singup")
	String sin(Model m) {
		m.addAttribute("user",new User());
		return "singup";
	}
	
	@PostMapping("/do_register")
	public  String get_info(@ModelAttribute("user") User u,@RequestParam(value =  "argument",defaultValue = "false" )boolean f,
			Model m, HttpSession h
			) {
		
		
		
		try {
			// if condition ont check 
			if(!f) {
				System.out.println("there is some thik ony got");
				throw  new Exception("you not good");
				
			}
			
			this.r.save(u);
			
		} catch (Exception e) {
			// TODO: handle exception
			h.setAttribute("message", "SOME THINK IS WRONG CHECK IT.....!" );
			return "singup";
		}
	
		return "v";
	}
	
	
	@GetMapping("/login")
	String logingpage() {
		return "login";
	}
	
	
	
	@PostMapping("/log_info")
	public String login_info(@RequestParam("email") String email,
            @RequestParam("password") String password,Model m, HttpSession h) {
		 User u = r.findByEmail(email);

		    if (u == null) {
		        System.out.println("❌ No user found for: " + email);
		        h.setAttribute("message1", "	EMAIL OR PASSWORD IS  WRONG CHECK IT.....!" );
		        return "login";
		    }

		    if (password.equals(u.getPassword())) { // or equalsIgnoreCase if needed
		        System.out.println("✅ Login success");
		        m.addAttribute("user",new User());
		        return "user/index";
		    }

		    System.out.println("❌ Wrong password");
		    return "login";
	}
	
	
	@GetMapping("/l")
	public String name() {
		return "user/index";
	}
	
	@GetMapping("/map")
	String map() {
		return "user/map";
	}
	
	
	
	@GetMapping("/a")
	String about1() {
		return "about";
	}
	

}
