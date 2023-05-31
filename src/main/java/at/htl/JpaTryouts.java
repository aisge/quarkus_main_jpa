package at.htl;

import at.htl.model.Person;
import at.htl.repository.PersonRepository;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;

public class JpaTryouts implements QuarkusApplication {

    @Inject
    PersonRepository personRepository;

    @Override
    public int run(String... args) throws Exception {
        personRepository.addPerson("Max", "Muster");

        Person p = personRepository.findByLastname("Muster");
        System.out.println(p);

        Quarkus.asyncExit();
        return 0;
    }

}
