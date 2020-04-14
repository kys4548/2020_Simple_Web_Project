package com.example.springdata05.Comment;

import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {

    String getComment();

    int getUp();

    int getDown();

    default String getVotes() {
        return getUp() + " " + getDown();
    }
}
