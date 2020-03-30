package com.example.restapiwithspring.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EventDto {

    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime; //이벤트 등록 일시
    private LocalDateTime closeEnrollmentDateTime; //이벤트 등록 종료 일시
    private LocalDateTime beginEventDateTime; //이벤트 시작 일시
    private LocalDateTime endEventDateTime; // 이벤트 종료 일시
    private String location; // (optional) 이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;

}
