package com.lance.demo.spring.event;

import com.lance.demo.spring.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by perdonare on 2017/6/15.
 */
public class EventPublisherTest extends TestBase{
    @Autowired
    private EventPublisher eventPublisher;
    @Test
    public void publish() throws Exception {
        for (int i = 0; i < 200; i++) {
            eventPublisher.publish(new EventModel(this,"lance",i));
        }
        Thread.sleep(100000l);

    }
}