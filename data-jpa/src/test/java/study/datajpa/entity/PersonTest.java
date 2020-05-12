package study.datajpa.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class PersonTest {

    @Autowired
    PersonRepository personRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void test1() {
        Person person = new Person("person1");
        personRepository.save(person);

        em.flush();
        em.clear();

        Person findPerson = personRepository.findById(person.getId()).get();


    }

}