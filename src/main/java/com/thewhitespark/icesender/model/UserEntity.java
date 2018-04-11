package com.thewhitespark.icesender.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.thewhitespark.icesender.model.views.MessageView;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@XmlRootElement
@Table(name = "user", schema = "ice_sender", catalog = "")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="uuid-char")
    @Column(name = "id_user")
    private UUID idUser;

    @NotNull
    @Column(name = "name")
    @JsonView(MessageView.Details.class)
    private String name;

    @NotNull
    @Column(name = "email")
    @JsonView(MessageView.Details.class)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonView(MessageView.Details.class)
    @Column(nullable = false, updatable = false, name = "register_tmestamp")
    private Date registerTimestamp;

    @Column(name = "active", columnDefinition = "tinyint(1) default 1")
    @JsonView(MessageView.Details.class)
    private byte active;

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterTimestamp() {
        return registerTimestamp;
    }

    public void setRegisterTimestamp(Timestamp registerTimestamp) {
        this.registerTimestamp = registerTimestamp;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (idUser != that.idUser) return false;
        if (active != that.active) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (registerTimestamp != null ? !registerTimestamp.equals(that.registerTimestamp) : that.registerTimestamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (registerTimestamp != null ? registerTimestamp.hashCode() : 0);
        result = 31 * result + (int) active;
        return result;
    }
}
