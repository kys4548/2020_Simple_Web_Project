package com.example.springdata04.post;

import com.example.springdata04.MyRepository2;

import java.io.Serializable;

//모든 Repository에 몇몇 기능이 추가된 Repository를 사용할 때 MyRepository가 JpaRepository를 상속하고 있음.
public interface PostRepository5<T, ID extends Serializable> extends MyRepository2<T, ID> {
}
