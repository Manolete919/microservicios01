package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Person;
import service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService ps;

	@RequestMapping("/all")
	public List<Person> getAll() {
		return ps.getAll();
	}

	@RequestMapping("{id}")
	public Person getPerson(@PathVariable("id") Long id) {
		return ps.  getPerson(id);
	}
}