package JavaAdvanced2021.JavaOPP.InheritanceExercises0411.Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
       if (age < 0) {
           throw new IllegalArgumentException("Invalid input!");
       }
       this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(getClass().getSimpleName()).append(System.lineSeparator())
                .append(this.name).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator())
                .append(this.produceSound());
        return output.toString();
    }
}
