package com.thewhitespark.icesender.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "message2recipient_to", schema = "ice_sender")
public class Message2RecipientToEntity implements Serializable {

    @Id
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_message")
    private MessageEntity message;

    @Id
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_recipient")
    private RecipientEntity recipient;

    public MessageEntity getMessage() {
        return message;
    }

    public void setIdMessage(MessageEntity message) {
        this.message = message;
    }

    public RecipientEntity getIdRecipient() {
        return recipient;
    }

    public void setIdRecipient(RecipientEntity recipient) {
        this.recipient = recipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message2RecipientToEntity that = (Message2RecipientToEntity) o;

        if (message != that.message) return false;
        return recipient == that.recipient;
    }
}
