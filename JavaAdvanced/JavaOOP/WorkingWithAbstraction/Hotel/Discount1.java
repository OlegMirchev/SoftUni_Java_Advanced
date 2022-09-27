package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.Hotel;

public enum Discount1 {
    VIP(0.20),
    SECOND_VISIT(0.10),
    NONE(0);

    private double percentage;

    Discount1(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return this.percentage;
    }

    public static Discount1 getDiscount(String discount) {
        switch (discount) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Not Discount" + discount);
        }
    }
}
