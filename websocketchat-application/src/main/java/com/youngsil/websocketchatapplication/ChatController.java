package com.youngsil.websocketchatapplication;

import com.youngsil.websocketchatapplication.dto.ChatMessage;
import com.youngsil.websocketchatapplication.dto.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if(MessageType.JOIN.equals(message.getMessageType())) {
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
        messagingTemplate.convertAndSend("sub/chat/room/"+message.getRoomId(), message);
    }
}
