package com.ms.icalrestapp;

import com.ms.icalrestapp.controllers.HtmlController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IcalrestappApplicationTests {

    @Autowired
    HtmlController htmlController;

    @Test
    public void contextLoads() {
        assertThat(htmlController).isNotNull();
    }


}
