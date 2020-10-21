package com.example.inflearnrestapidemo.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class EventValidator {
    public void validate(EventDto eventDto, Errors errors) {
        if(eventDto.getMaxPrice() != 0 && eventDto.getBasePrice() > eventDto.getMaxPrice()) {
            errors.rejectValue("basePrice", "wrongValue");
            errors.rejectValue("maxPrice", "wrongValue");
        }
    }
}
