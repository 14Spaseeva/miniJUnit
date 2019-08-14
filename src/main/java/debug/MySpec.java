package debug;

import env.Assert;
import env.Test;

public class MySpec {

    @Test
    public void test1() {
        Assert.assertFalse(false);
        System.out.println("(test1)");
    }

    @Test
    public void test2() {
        Assert.assertFalse(false);
        System.out.println("(test2)");
    }

    @Test
    public void test3() {
        Assert.assertTrue(false);
        System.out.println("(test3)");
    }

    @Test
    public void test4() {
        Assert.assertTrue(true);
        System.out.println("(test4)");
    }
}
