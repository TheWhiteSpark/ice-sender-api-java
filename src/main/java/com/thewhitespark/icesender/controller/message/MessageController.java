package com.thewhitespark.icesender.controller.message;

import com.fasterxml.jackson.annotation.JsonView;
import com.thewhitespark.icesender.model.MessageEntity;
import com.thewhitespark.icesender.model.views.MessageView;
import com.thewhitespark.icesender.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.Message;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @ModelAttribute("get")
    MessageForm defaultMessageForm() {
        return new MessageForm(0, 10, MessageType.ACTIVE, MessageOrder.DUE_DATE_ASC);
    }

    @GetMapping("/messages")
    @JsonView(MessageView.Summary.class)
    public List<MessageEntity> getAllNotes(@Valid @ModelAttribute("get") MessageForm messageForm) {
        return messageRepository.findAll();
    }

    @RequestMapping("/messages/{id}")
    @JsonView(MessageView.Details.class)
    public MessageEntity getNote(@PathVariable UUID id) {
        return messageRepository.getOne(id);
    }

    // Create a new Note
    @PostMapping("/messages")
    public MessageEntity createNote(@Valid @RequestBody MessageEntity note) {
        int a = 3;
        return messageRepository.save(note);
    }
    // Get a Single messages

    // Update a messages

    // Delete a messages

}


