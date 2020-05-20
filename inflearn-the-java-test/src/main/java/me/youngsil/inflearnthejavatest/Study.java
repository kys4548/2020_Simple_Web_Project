package me.youngsil.inflearnthejavatest;

import java.time.LocalDateTime;

public class Study {

    private StudyStatus studyStatus = StudyStatus.DRAFT;

    private int limit;

    private String name;

    private LocalDateTime opendDateTime;

    public StudyStatus getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(StudyStatus studyStatus) {
        this.studyStatus = studyStatus;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getOpendDateTime() {
        return opendDateTime;
    }

    public void setOpendDateTime(LocalDateTime opendDateTime) {
        this.opendDateTime = opendDateTime;
    }

    public StudyStatus getStatus() {
        return studyStatus;
    }

    public int getLimit() {
        return limit;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야 한다.");
        }
        this.limit = limit;
    }

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Study{" +
                "limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }

    public Study() {

    }

    public void open() {
        studyStatus = StudyStatus.STARTED;
        opendDateTime = LocalDateTime.now();
    }
}
