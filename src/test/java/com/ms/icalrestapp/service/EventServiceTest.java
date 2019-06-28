package com.ms.icalrestapp.service;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.ms.icalrestapp.model.CustomDate;
import com.ms.icalrestapp.model.CustomTime;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataMongoTest
public class EventServiceTest {

    private MongodExecutable mongodExecutable;
    private MongoTemplate mongoTemplate;

    @After
    public void clean() {
        mongodExecutable.stop();
    }

    @Before
    public void setup() throws Exception {
        String ip = "localhost";
        int port = 27018;

        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
                .net(new Net(ip, port, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
        mongoTemplate = new MongoTemplate(new MongoClient(ip, port), "eventsdb");
        mongoTemplate.dropCollection("collection");
    }


    @Test
    public void shouldCreateNewEventFromScratch() throws Exception {
        // given
        CustomDate eventStartDate = new CustomDate("2019", "11", "11");
        CustomDate eventEndDate = new CustomDate("2019", "11", "12");
        CustomTime eventStartTime = new CustomTime("12", "30", "00");
        CustomTime eventEndTime = new CustomTime("22", "30", "00");
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add("eventName", "Test Event 1")
                .add("eventLocation", "Test Event 1 Location")
                .add("eventDescription", "Test Event 1 Description")
                .add("eventStartDate", eventStartDate)
                .add("eventEndDate", eventEndDate)
                .add("eventStartTime", eventStartTime)
                .add("eventEndTime", eventEndTime)
                .get();
//
        // when
        mongoTemplate.save(objectToSave, "collection");

        // then
        Assertions.assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("eventName")
                .containsOnly("Test Event 1");
    }
}