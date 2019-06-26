package com.ms.icalrestapp.service;

import com.ms.icalrestapp.model.CustomDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateService {

    public DateService() {
    }

    //access for these methods are package-only as intended
    CustomDate today() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dateParser(date);
    }

    CustomDate nextWeek() {
        String date = LocalDate.now().plusWeeks(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dateParser(date);
    }

    CustomDate nextMonth() {
        String date = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dateParser(date);
    }

    CustomDate dateParser(String date) {
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6, 10);
        return new CustomDate(year, month, day);
    }
}