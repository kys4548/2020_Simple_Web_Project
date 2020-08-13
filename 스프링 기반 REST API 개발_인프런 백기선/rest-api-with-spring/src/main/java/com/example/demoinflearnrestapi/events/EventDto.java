package com.example.demoinflearnrestapi.events;

import com.example.demoinflearnrestapi.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data @SuperBuilder @NoArgsConstructor @AllArgsConstructor
public class EventDto extends BaseEntity {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    private String location; // (optional) 이게 없으면 온라인 모임
    @Min(value = 0)
    private int basePrice; // (optional)
    @Min(value = 0)
    private int maxPrice; // (optional)
    @Min(value = 0)
    private int limitOfEnrollment;
}
