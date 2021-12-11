package lambdaexp;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Exercise {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("Susmitha", "Vutturi", 29),
                new Person("Nandan", "B", 5),
                new Person("Atchyuth", "B", 31),
                new Person("New","Born", 100));

        //sort list by lastname



        //create a method to print all elements



        //create a method having lastname starting with B

    }
}


class Person {
    private String firstName;
    private String lastName;
    private int age;

    Person(String fName, String lName, int age) {
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
