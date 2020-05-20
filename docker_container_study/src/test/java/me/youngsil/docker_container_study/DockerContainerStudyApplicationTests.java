package me.youngsil.docker_container_study;

import me.youngsil.docker_container_study.study.StudyRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
class DockerContainerStudyApplicationTests {

    @Autowired
    StudyRepository studyRepository;

    /*
    static을 쓰지 않으면 모든 테스트마다 컨테이너가 하나씩 만들어진다.
    static시 여러 테스트에서 공유
     */
    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer()
            .withDatabaseName("studytest");


    @BeforeAll
    static void beforeAll() {
        postgreSQLContainer.start();
        System.out.println("postgreSQLContainer = " + postgreSQLContainer.getJdbcUrl());
    }

    @BeforeEach
    void beforeEach() {
        studyRepository.deleteAll();
    }


    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }

    @Test
    void contextLoads() {
    }

}
