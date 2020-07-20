package com.example.springdata04.post;

import com.example.springdata04.MyRepository1;

import java.io.Serializable;

//2번 repository는 각각 Entity마다 지정해 주었다면 MyRepository는 모든 Entity에 적용가능
public interface PostRepository3<T, ID extends Serializable> extends MyRepository1<T, ID> {
}
