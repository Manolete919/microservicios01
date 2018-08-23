package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Person;

@Controller
public class PersonController {
	
	@ResponseBody
	@RequestMapping("/")
	String entry() {
		return "My Bootspring Application";
	}
	
	@RequestMapping("/person")
	public String person(Model model) {
		
		Person p = new Person();
		p.setFirstName("Manuel");
		p.setLastName("Garcia");
		p.setAge(31);
		
		model.addAttribute("person",p);
		
		return "personview";
	}

}
