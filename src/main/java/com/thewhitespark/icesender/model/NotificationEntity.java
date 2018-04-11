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
@Table(name = "notification", schema = "ice_sender")
public class NotificationEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="uuid-char")
    @Column(name = "id_notification")
    private UUID idNotification;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_message")
    private MessageEntity message;

    @NotNull
    @Column(name = "value")
    private int value;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_notification_unit")
    private NotificationUnitEntity notificationUnit;

    public UUID getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(UUID idNotification) {
        this.idNotification = idNotification;
    }

    public MessageEntity getMessage() {
        return message;
    }

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NotificationUnitEntity getNotificationUnit() {
        return notificationUnit;
    }

    public void setNotificationUnit(NotificationUnitEntity value) {
        this.notificationUnit = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotificationEntity that = (NotificationEntity) o;

        if (idNotification != that.idNotification) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + value;
        return result;
    }
}
