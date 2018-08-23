package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import model.Person;

public interface PersonRepositoryInterface extends CrudRepository<Person, Long> {
 
	//Person findById(Long id);
	List<Person> findByAge(int age);	
	List<Person> findByFirstName(String firstName);
	
	
}
