package service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Person;
import repository.PersonRepositoryInterface;

@Service
public class PersonService {
	Hashtable<String, Person> persons = new Hashtable<String, Person>();
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PersonRepositoryInterface personRepository;
	
	public PersonService() {
				 
	}
	public Person getPerson(Long id) {
		Person p = new Person();
		p.setId(25l);
		p.setFirstName("Juan");
		p.setLastName("Perez");
		return p;
	}
	public List<Person> getAll() {
		return (ArrayList<Person>) personRepository.findAll();
	}
}
