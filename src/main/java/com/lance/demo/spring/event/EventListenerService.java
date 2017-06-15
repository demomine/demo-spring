package com.lance.demo.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by perdonare on 2017/6/15.
 */
@Service@Slf4j
public class EventListenerService {

    @EventListener
    @Async
    public void listen(EventModel eventModel) throws InterruptedException {
        log.info("===========================   EventListenerService " + eventModel);
        Thread.sleep(new Random().nextInt(10000));
        Thread.sleep(10000);
    }
}
