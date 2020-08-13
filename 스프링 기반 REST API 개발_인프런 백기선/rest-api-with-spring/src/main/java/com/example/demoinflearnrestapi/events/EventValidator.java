package com.example.demoinflearnrestapi.events;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto) {
        if(eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            throw new EventWrongValidationException("basePrice is bigger than maxPrice");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if(endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime()) ||
        endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
        endEventDateTime.isBefore(eventDto.getBeginEventDateTime())) {
            throw new EventWrongValidationException("endEventDateTime이 너무크다.");
        }


    }
}
