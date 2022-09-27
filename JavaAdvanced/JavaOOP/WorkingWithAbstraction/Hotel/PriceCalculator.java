package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.Hotel;

import JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.Hotel.Season;

public class PriceCalculator {
    private double priceDay;
    private int days;
    private Season season;
    private Discount1 discount;

    public PriceCalculator(double priceDay, int days, Season season, Discount1 discount) {
        this.priceDay = priceDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice() {
        return (this.priceDay * this.season.getMultiplier()) * this.days * (1 - this.discount.getPercentage());
    }
}
