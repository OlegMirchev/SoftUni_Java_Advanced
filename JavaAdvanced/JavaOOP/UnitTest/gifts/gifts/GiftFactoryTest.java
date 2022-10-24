package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class GiftFactoryTest {

    private GiftFactory giftFactory;
    private Gift gift;

    @Before
    public void SetUp() {
        this.giftFactory = new GiftFactory();
        this.gift = new Gift("Wizzard", 10.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodCreateGiftIfGiftNameAlreadyExistThrowsException() {
        this.giftFactory.createGift(this.gift);
        this.giftFactory.createGift(this.gift);
    }

    @Test
    public void testMethodCreateGiftSuccessfully() {
        this.giftFactory.createGift(this.gift);
        Gift present = this.giftFactory.getPresent(this.gift.getType());

        assertEquals(this.gift.getType(), present.getType());
    }

    @Test(expected = NullPointerException.class)
    public void testMethodRemoveGiftIfGiftNameEqualsNullThrowsException() {
        this.giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void testMethodRemoveGiftIfGiftNameEqualsWhitespaceThrowsException() {
        this.giftFactory.removeGift("  ");
    }

    @Test
    public void testMethodRemoveGiftSuccessTrue() {
        this.giftFactory.createGift(this.gift);
        Gift present = this.giftFactory.getPresent(this.gift.getType());
        boolean removeGift = this.giftFactory.removeGift(present.getType());

        assertTrue(removeGift);
    }

    @Test
    public void testMethodRemoveGiftFalse() {
        this.giftFactory.createGift(this.gift);
        boolean removeGift = this.giftFactory.removeGift("Elf");

        assertFalse(removeGift);
    }

    @Test
    public void testMethodGetPresentWithLeastMagicSuccess() {
        this.giftFactory.createGift(this.gift);
        Gift gift1 = new Gift("Knight", 5.00);
        this.giftFactory.createGift(gift1);

        Gift minMagic = this.giftFactory.getPresentWithLeastMagic();
        double actual = minMagic.getMagic();
        double expect = gift1.getMagic();

        Assert.assertEquals(String.valueOf(expect), String.valueOf(actual));
    }

    @Test
    public void testMethodGetCount() {
        this.giftFactory.createGift(this.gift);
        int actual = this.giftFactory.getCount();

        Assert.assertEquals(1, actual);
    }

    @Test
    public void testMethodGetPresentsUnmodifiableCollection() {
        this.giftFactory.createGift(this.gift);
        Collection<Gift> actual = this.giftFactory.getPresents();

        for (Gift g : actual) {
            Assert.assertEquals(this.gift.getType(), g.getType());
        }
    }
}