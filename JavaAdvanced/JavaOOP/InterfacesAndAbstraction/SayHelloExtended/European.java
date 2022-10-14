package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.SayHelloExtended;

public class European extends BasePerson {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
