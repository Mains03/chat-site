package com.mains03.chatsite;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message message(Principal principal, Message message) {
        return new Message(principal.getName() + ": " + message.getContent());
    }
}
