package edu.tucn.ispse.lecture7.iostreams;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tucn.ispse.lecture5.ex0enum.Person;
import edu.tucn.ispse.lecture5.ex0enum.PersonType;

import java.io.File;
import java.io.IOException;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex5JsonSerializationJackson {
    public static void main(String[] args) throws IOException {
        // create a Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // write JSON to file
        objectMapper.writeValue(new File("testfiles/person.json"),
                                new Person("Mary", 34, PersonType.PROFESSOR));
        // write JSON to String
        String personJson = objectMapper.writeValueAsString(
                new Person("John", 23, PersonType.STUDENT));

        // read JSON from file
        Person person1 = objectMapper.readValue(new File("testfiles/person.json"), Person.class);
        System.out.println(person1);

        // read JSON from String
        Person person2 = objectMapper.readValue(personJson, Person.class);
        System.out.println(person2);
    }
}
