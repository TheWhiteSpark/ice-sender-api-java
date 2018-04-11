package com.thewhitespark.icesender.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

@Entity
@XmlRootElement
@Table(name = "message_type", schema = "ice_sender", catalog = "")
public class MessageTypeEntity implements Serializable {

    @Id
    @NotNull
    @JsonIgnore
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="uuid-char")
    @Column(name = "id_message_type")
    private UUID idMessageType;

    @NotNull
    @Column(name = "type")
    private String type;

    public UUID getIdMessageType() {
        return idMessageType;
    }

    public void setIdMessageType(UUID idMessageType) {
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
        int result = 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
