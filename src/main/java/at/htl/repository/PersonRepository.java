package at.htl.repository;

import at.htl.model.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


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
