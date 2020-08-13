package com.example.demoinflearnrestapi.events;

import com.example.demoinflearnrestapi.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id", callSuper = false)
@ToString(callSuper = true)
@Entity
public class Event extends BaseEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String location; // (optional) 이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;
}
