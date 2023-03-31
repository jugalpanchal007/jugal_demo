package com.croods.ecommerce.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.croods.ecommerce.dto.demo.TextMessageDTO;

@RestController
public class WebSocketTextController {

	@Autowired
	SimpMessagingTemplate template;

	@PostMapping("/websocket/send")
	public ResponseEntity<Void> sendMessage(@RequestBody Map<String,String> settingsMap) {
		template.convertAndSend("/topic/message", settingsMap);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@MessageMapping("/websocket/sendMessage")
	public void receiveMessage(@Payload TextMessageDTO textMessageDTO) {
		// receive message from client
	}

	@SendTo("/websocket/topic/message")
	public TextMessageDTO broadcastMessage(@Payload TextMessageDTO textMessageDTO) {
		return textMessageDTO;
	}
}