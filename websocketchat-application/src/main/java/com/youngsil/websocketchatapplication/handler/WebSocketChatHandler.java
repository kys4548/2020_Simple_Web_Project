package com.youngsil.websocketchatapplication.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngsil.websocketchatapplication.dto.ChatMessage;
import com.youngsil.websocketchatapplication.dto.ChatRoom;
import com.youngsil.websocketchatapplication.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {},", payload);
//        TextMessage textMessage = new TextMessage("Welcome chatting server");
//        session.sendMessage(textMessage);

        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom chatRoom = chatService.findRoomById(chatMessage.getRoomId());
        chatRoom.handleActions(session, chatMessage, chatService);
    }
}
