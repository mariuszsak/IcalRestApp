package com.ms.icalrestapp.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomDateTest {

    CustomDate customDate1 = new CustomDate("2019", "11", "23");
    CustomDate customDate2 = new CustomDate();


    @Test
    public void getYear() {
        Assert.assertEquals("2019", customDate1.getYear());
    }

    @Test
    public void setYear() {
        customDate2.setYear("2019");
        Assert.assertNotNull(customDate2.getYear());
    }

    @Test
    public void getMonth() {
        Assert.assertEquals("11", customDate1.getMonth());
    }

    @Test
    public void setMonth() {
        customDate2.setMonth("11");
        Assert.assertNotNull(customDate2.getMonth());
    }

    @Test
    public void getDay() {
        Assert.assertEquals("23", customDate1.getDay());
    }

    @Test
    public void setDay() {
        customDate2.setDay("23");
        Assert.assertNotNull(customDate2.getDay());
    }

    @Test
    public void toString1() {
        Assert.assertEquals("CustomDate{year='2019', month='11', day='23'}", customDate1.toString());
    }
}