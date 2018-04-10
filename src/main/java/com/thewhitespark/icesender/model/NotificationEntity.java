package com.thewhitespark.icesender.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "notification", schema = "ice_sender")
public class NotificationEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private int idNotification;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_message")
    private MessageEntity message;

    @NotNull
    @Column(name = "value")
    private int value;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_notification_unit")
    private NotificationUnitEntity notificationUnit;

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
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
        int result = idNotification;
        result = 31 * result + value;
        return result;
    }
}
