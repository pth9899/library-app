package com.group.libraryapp.dto.user.response;

public class UserCreateRequest {
    private Long id;

    private String name;

    private Integer age;

    public UserCreateRequest(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}