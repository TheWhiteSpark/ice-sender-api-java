package com.thewhitespark.icesender.model;

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
@Table(name = "recipient", schema = "ice_sender", catalog = "")
public class RecipientEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="uuid-char")
    @Column(name = "id_recipient")
    private UUID idRecipient;

    @NotNull
    @Column(name = "email")
    private String email;

    public UUID getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(UUID idRecipient) {
        this.idRecipient = idRecipient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipientEntity that = (RecipientEntity) o;

        if (idRecipient != that.idRecipient) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
