package com.ms.icalrestapp.service;

import com.ms.icalrestapp.model.CustomDate;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;


public class DateServiceTest {
    CustomDate cd = new CustomDate("2020", "10", "10");


    String date = "10/10/2020";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.parse(date, formatter);

    @Test
    public void today() {
        System.out.println(localDate.toString());
        Assert.assertThat(cd, samePropertyValuesAs(new CustomDate("2020", "10", "10")));
    }

    @Test
    public void dateParser() {
        String date = "10/10/2020";
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6, 10);
        System.out.println(new CustomDate(cd.getYear(), cd.getMonth(), cd.getDay()));
        assertThat(new CustomDate(year, month, day)).isEqualToComparingFieldByField(cd);
    }
}