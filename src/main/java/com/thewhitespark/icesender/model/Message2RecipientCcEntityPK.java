package com.thewhitespark.icesender.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Message2RecipientCcEntityPK implements Serializable {

    @Id
    @NotNull
    @Column(name = "id_message")
    private int idMessage;

    @Id
    @NotNull
    @Column(name = "id_recipient")
    private int idRecipient;

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message2RecipientCcEntityPK that = (Message2RecipientCcEntityPK) o;

        if (idMessage != that.idMessage) return false;
        if (idRecipient != that.idRecipient) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessage;
        result = 31 * result + idRecipient;
        return result;
    }
}
