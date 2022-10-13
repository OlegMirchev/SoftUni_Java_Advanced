package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.SayHello;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();


        persons.add(new Bulgarian("Peter"));
        persons.add(new European("Peter"));
        persons.add(new Chinese("Peter"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());

    }
}
