package com.thewhitespark.icesender.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "message_type", schema = "ice_sender", catalog = "")
public class MessageTypeEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message_type")
    private int idMessageType;

    @NotNull
    @Column(name = "type")
    private String type;

    public int getIdMessageType() {
        return idMessageType;
    }

    public void setIdMessageType(int idMessageType) {
        this.idMessageType = idMessageType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageTypeEntity that = (MessageTypeEntity) o;

        if (idMessageType != that.idMessageType) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessageType;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
