package com.lance.demo.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * Created by perdonare on 2017/6/15.
 */
@Service@Slf4j
public class EventPublisher{
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(EventModel eventModel) {
        log.info("EventPublisher publish");
        applicationEventPublisher.publishEvent(eventModel);
    }
}
