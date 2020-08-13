package com.example.demoinflearnrestapi.events;

import com.example.demoinflearnrestapi.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data @SuperBuilder @NoArgsConstructor @AllArgsConstructor
public class EventDto extends BaseEntity {
    private String name;
    private String description;
    private String location; // (optional) 이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;
}
