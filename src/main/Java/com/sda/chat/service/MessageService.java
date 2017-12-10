package com.sda.chat.service;

import com.sda.chat.hibernate.model.Messages;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MessageService {

    private static MessageService _instance;
    private List<Messages> messagesList;

    private MessageService() {
        messagesList = new LinkedList<Messages>();
    }

    public static MessageService getInstance() {
        if (_instance == null) {
            _instance = new MessageService();
        }
        return _instance;
    }

    public void addMessage(Messages message) {
        messagesList.add(message);
    }

    public List<Messages> getMessagesList() {
        return Collections.unmodifiableList(messagesList);
    }
}