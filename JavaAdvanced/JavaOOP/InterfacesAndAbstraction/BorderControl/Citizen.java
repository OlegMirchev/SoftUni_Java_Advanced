package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.BorderControl;

import JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.BorderControl.Identifiable;

public class Citizen implements Identifiable {
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
