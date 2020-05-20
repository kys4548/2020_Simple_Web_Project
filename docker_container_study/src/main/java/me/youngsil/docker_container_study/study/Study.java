package me.youngsil.docker_container_study.study;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Study {

    @Id @GeneratedValue
    @Column(name = "study_id")
    private Long id;
}
