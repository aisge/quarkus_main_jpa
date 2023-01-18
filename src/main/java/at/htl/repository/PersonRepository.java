package at.htl.repository;

import at.htl.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void addPerson(String firstname, String lastname) {
        Person p = new Person(firstname, lastname);
        em.persist(p);
    }

    @Transactional
    public Person findByLastname(String lastname) {
        return em.createQuery("select p from Person p where lastname = :lastname", Person.class)
                .setParameter("lastname", lastname)
                .getResultStream().findFirst().orElse(null);
    }
}
