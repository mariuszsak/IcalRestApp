package com.ms.icalrestapp.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class EventModelTest {

    CustomTime customTime1 = new CustomTime("17", "55", "30");
    CustomTime customTime2 = new CustomTime("18", "45", "00");

    CustomDate customDate1 = new CustomDate("2019", "11", "23");
    CustomDate customDate2 = new CustomDate("2019", "11", "25");

    EventModel eventModel1 = new EventModel(
            "1234567",
            "Test Event 100",
            customDate1,
            customTime1,
            customDate2,
            customTime2,
            "Test Event 100 Location",
            "Test Event 100 Description"
    );
    EventModel eventModel2 = new EventModel();

    @Test
    public void get_id() {
        Assert.assertEquals("1234567", eventModel1.get_id());
    }

    @Test
    public void set_id() {
        eventModel2.set_id("54321");
        Assert.assertEquals("54321", eventModel2.get_id());
    }

    @Test
    public void getEventName() {
        Assert.assertEquals("Test Event 100", eventModel1.getEventName());
    }

    @Test
    public void setEventName() {
        eventModel2.setEventName("Test Event 100");
        Assert.assertEquals("Test Event 100", eventModel2.getEventName());
    }

    @Test
    public void getEventStartDate() {
        Assert.assertEquals(customDate1, eventModel1.getEventStartDate());
    }

    @Test
    public void setEventStartDate() {
        eventModel2.setEventStartDate(customDate1);
        Assert.assertEquals(customDate1, eventModel2.getEventStartDate());
    }

    @Test
    public void getEventStartTime() {
        Assert.assertEquals(customTime1, eventModel1.getEventStartTime());
    }

    @Test
    public void setEventStartTime() {
        eventModel2.setEventStartTime(customTime1);
        Assert.assertEquals(customTime1, eventModel2.getEventStartTime());
    }

    @Test
    public void getEventEndDate() {
        Assert.assertEquals(customDate2, eventModel1.getEventEndDate());
    }

    @Test
    public void setEventEndDate() {
        eventModel2.setEventEndDate(customDate2);
        Assert.assertEquals(customDate2, eventModel2.getEventEndDate());
    }

    @Test
    public void getEventEndTime() {
        Assert.assertEquals(customTime2, eventModel1.getEventEndTime());
    }

    @Test
    public void setEventEndTime() {
        eventModel2.setEventEndTime(customTime2);
        Assert.assertEquals(customTime2, eventModel2.getEventEndTime());
    }

    @Test
    public void getEventLocation() {
        Assert.assertEquals("Test Event 100 Location", eventModel1.getEventLocation());
    }

    @Test
    public void setEventLocation() {
        eventModel2.setEventLocation("Test Event 100 Location");
        Assert.assertEquals("Test Event 100 Location", eventModel2.getEventLocation());
    }

    @Test
    public void getEventDescription() {
        Assert.assertEquals("Test Event 100 Description", eventModel1.getEventDescription());
    }

    @Test
    public void setEventDescription() {
        eventModel2.setEventDescription("Test Event 100 Description");
        Assert.assertEquals("Test Event 100 Description", eventModel2.getEventDescription());
    }

    @Test
    public void toString1() {
        Assert.assertEquals("EventModel{" +
                "_id='"+eventModel1.get_id()+"', " +
                "eventName='" +eventModel1.getEventName()+"', " +
                "eventStartDate=" +customDate1+", " +
                "eventStartTime=" +customTime1+", " +
                "eventEndDate=" +customDate2+ ", " +
                "eventEndTime=" +customTime2+ ", " +
                "eventLocation='" +eventModel1.getEventLocation()+"', " +
                "eventDescription='"+eventModel1.getEventDescription()+"'}", eventModel1.toString());
    }
}