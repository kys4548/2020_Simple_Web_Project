package me.youngsil.testclone;

public class Member {

    private int id;

    private String name;

    private int age;

    public Member() {

    }

    public Member(int id) {
        this.id = id;
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member(int id, String name, int age) {
        if(age < 0) {
            throw new IllegalArgumentException("나이는 0보다 작을 수 없습니다.");
        }
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
