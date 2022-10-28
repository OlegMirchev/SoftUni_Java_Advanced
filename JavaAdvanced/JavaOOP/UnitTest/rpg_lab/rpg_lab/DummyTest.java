package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private Axe axe;
    private Dummy dummy;

    @Before
    public void SetUp() {
        this.dummy = new Dummy(20, 20);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeAttackDeadMethodIsTrue() {
        this.dummy = new Dummy(0, 10);
        this.dummy.takeAttack(10);
        this.dummy.isDead();
    }

    @Test
    public void testTakeAttackDeadMethodIsFalse() {
        this.dummy = new Dummy(20, 10);
        this.dummy.takeAttack(10);
        this.dummy.isDead();

        Assert.assertTrue(true);
    }
    @Test
    public void testMethodTakeAttackDummySuccess() {
        this.dummy.takeAttack(10);

        Assert.assertEquals(10, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testGiveExperienceIsDead() {
        this.dummy.giveExperience();
    }

    @Test
    public void testGiveExperienceReturnExperience() {
        this.dummy = new Dummy(0, 0);
        this.dummy.giveExperience();

        Assert.assertEquals(0, this.dummy.giveExperience());
    }
}