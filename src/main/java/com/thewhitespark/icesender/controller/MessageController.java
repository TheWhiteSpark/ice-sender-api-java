package com.thewhitespark.icesender.controller;

import com.thewhitespark.icesender.model.MessageEntity;
import com.thewhitespark.icesender.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/messages")
    public List<MessageEntity> getAllNotes() {
        return messageRepository.findAll();
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
