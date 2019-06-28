package com.ms.icalrestapp.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomTimeTest {

    CustomTime customTime1 = new CustomTime("17", "55", "30");
    CustomTime customTime2 = new CustomTime();

    @Test
    public void getHour() {
        Assert.assertEquals("17", customTime1.getHour());
    }

    @Test
    public void setHour() {
        customTime2.setHour("19");
        Assert.assertEquals("19", customTime2.getHour());
    }

    @Test
    public void getMinute() {
        Assert.assertEquals("55", customTime1.getMinute());
    }

    @Test
    public void setMinute() {
        customTime2.setMinute("35");
        Assert.assertEquals("35", customTime2.getMinute());
    }

    @Test
    public void getSecond() {
        Assert.assertEquals("30", customTime1.getSecond());
    }

    @Test
    public void setSecond() {
        customTime2.setSecond("25");
        Assert.assertEquals("25", customTime2.getSecond());
    }
}