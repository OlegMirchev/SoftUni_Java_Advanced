package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private Axe axe;
    private Dummy dummy;

    @Before
    public void SetUp() {
        this.axe = new Axe(100, 100);
        this.dummy = new Dummy(200, 200);
    }

    @Test(expected = IllegalStateException.class)
    public void testBrokenAxeAttackDummy() {
        this.axe = new Axe(100, 1);
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }

    @Test
    public void testAxeAttackDummySuccess() {
        this.axe.attack(this.dummy);

        Assert.assertEquals(99, this.axe.getDurabilityPoints());
    }

}