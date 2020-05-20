package me.youngsil.inflearnthejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

//    Memberservice memberservice = mock(Memberservice.class);
//    StudyRepository studyRepository = mock(StudyRepository.class);


    @Mock
    Memberservice memberservice;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService() {
        StudyService studyService = new StudyService(memberservice, studyRepository);

        Member member = new Member();
        member.setId(5);
        member.setName("youngsil");

        Optional<Member> optional = memberservice.findById(1L);
        assertEquals(Optional.empty(), optional);


        when(memberservice.findById(any()))
                .thenReturn(Optional.of(member));

        Optional<Member> findMember = memberservice.findById(1L);

        System.out.println("findMember = " + findMember);

        Study study = new Study(10, "java");

        when(studyRepository.save(any()))
                .thenReturn(study);

        Study newStudy = studyService.createNewStudy(1L, study);
        System.out.println(newStudy);

        verify(memberservice, times(3)).findById((any()));
        verify(studyRepository,times(1)).save(study);
        verify(memberservice, never()).validate(any());

        InOrder inOrder = inOrder(studyRepository);

        verifyNoMoreInteractions(memberservice);
    }


    @Test
    @DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
    void openStudy() {
        //given

        StudyService studyService = new StudyService(memberservice, studyRepository);
        Study study = new Study(10, "자바, 테스트");

        when(studyRepository.save(study)).thenReturn(study);

        //when
        studyService.openStudy(study);

        //then
        assertEquals(StudyStatus.STARTED, study.getStatus());
        assertNotEquals(null, study.getOpendDateTime());
        verify(memberservice, times(1)).note();
    }

}