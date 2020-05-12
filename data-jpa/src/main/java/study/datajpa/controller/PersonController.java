package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.entity.Person;
import study.datajpa.repository.PersonRepository;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/persons/{id}")
    public void findPerson(@PathVariable("id") Long id) {
        personRepository.findById(id);
    }

    @GetMapping("/persons/custom/{id}")
    public Person findCustomPerson(@PathVariable("id") Long id) throws InterruptedException {
        Person person = personRepository.findPersonById(id);
        Thread.sleep(5000);

        return person;
    }


    @PostConstruct
    public void init() {
        personRepository.save(new Person("person1"));
    }
}
