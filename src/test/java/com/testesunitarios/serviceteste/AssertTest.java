package com.testesunitarios.serviceteste;

import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void test(){
        Assert.assertEquals("Test passed! They are the same!",1, 1);
        Assert.assertEquals("Test passed with margin of error!",Math.PI, 3.14, 0.01);
        Assert.assertNotEquals("Test passed with margin of error!",Math.PI, 3.14);
        Assert.assertTrue("Test passed!",true);

        try {
            Assert.assertTrue("Generates error!",false);
        } catch (AssertionError e) {
            System.out.println("Test passed!");
        }



    }
}
