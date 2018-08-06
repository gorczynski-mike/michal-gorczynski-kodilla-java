package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Watcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(orderDto, userId) && target(theTarget)")
    public void logEvent(final OrderDto orderDto, final Long userId, final Object theTarget) {
        LOGGER.info("Porcess order method has been called.");
        LOGGER.info("class: " + theTarget.getClass().getName() + ", orderDto: " + orderDto + ", userId: " + userId);
    }

}
