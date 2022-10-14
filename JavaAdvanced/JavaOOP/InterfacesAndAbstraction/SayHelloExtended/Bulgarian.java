package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionLAB0511.SayHelloExtended;

public class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);

    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
