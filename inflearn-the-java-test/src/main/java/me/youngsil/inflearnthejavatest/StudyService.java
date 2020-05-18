package me.youngsil.inflearnthejavatest;

import java.util.Optional;

public class StudyService {

    private Memberservice memberservice;

    private StudyRepository repository;

    public StudyService(Memberservice memberservice, StudyRepository repository) {
        assert memberservice != null;
        assert repository != null;

        this.memberservice = memberservice;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberservice.findById(memberId);
        return repository.save(study);
    }

    public Memberservice getMemberservice() {
        return memberservice;
    }

    public void setMemberservice(Memberservice memberservice) {
        this.memberservice = memberservice;
    }

    public StudyRepository getRepository() {
        return repository;
    }

    public void setRepository(StudyRepository repository) {
        this.repository = repository;
    }
}
