package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testMethodSort() {
        int[] except = {1, 2, 3, 4};
        int[] arr = {4, 2, 1, 3};
        Bubble.sort(arr);

        Assert.assertArrayEquals(except, arr);
    }
}