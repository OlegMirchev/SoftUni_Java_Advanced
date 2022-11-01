package JavaAdvanced2021.JavaOPP.Exam.ViceCity.src.main.java.viceCity.models.guns;

public interface Gun {
    String getName();

    int getBulletsPerBarrel();

    boolean canFire();

    int getTotalBullets();

    int fire();
}
