package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.SayHelloExtended;

public abstract class BasePerson implements Person {
    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
