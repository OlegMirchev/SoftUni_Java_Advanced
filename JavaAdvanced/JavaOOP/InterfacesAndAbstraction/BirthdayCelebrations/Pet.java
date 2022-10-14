package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionExercises0811.BirthdayCelebrations;

public class Pet implements Birthable, Name {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
}
