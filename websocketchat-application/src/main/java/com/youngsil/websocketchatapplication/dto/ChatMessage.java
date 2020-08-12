package com.youngsil.websocketchatapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {

    private String roomId;
    private String sender;
    private MessageType messageType;
    private String message;
}
