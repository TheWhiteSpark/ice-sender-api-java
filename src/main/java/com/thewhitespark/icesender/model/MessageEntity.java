package com.thewhitespark.icesender.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "message", schema = "ice_sender", catalog = "")
public class MessageEntity implements Serializable {

    @Id
    @NotNull
    @Column(name = "id_attachment")
    private int idMessage;

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "color")
    private String color;

    @Column(name = "message_title")
    private String messageTitle;

    @Column(name = "message_body")
    private String messageBody;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name="send_date")
    private Date sendDate;

    @Column(name = "send_email_after", columnDefinition="tinyint(1) default 1")
    private byte sendEmailAfter;

    @Column(name = "send_notification_after", columnDefinition="tinyint(1) default 1")
    private byte sendNotificationAfter;

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    public byte getSendEmailAfter() {
        return sendEmailAfter;
    }

    public void setSendEmailAfter(byte sendEmailAfter) {
        this.sendEmailAfter = sendEmailAfter;
    }

    public byte getSendNotificationAfter() {
        return sendNotificationAfter;
    }

    public void setSendNotificationAfter(byte sendNotificationAfter) {
        this.sendNotificationAfter = sendNotificationAfter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (idMessage != that.idMessage) return false;
        if (sendEmailAfter != that.sendEmailAfter) return false;
        if (sendNotificationAfter != that.sendNotificationAfter) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (messageTitle != null ? !messageTitle.equals(that.messageTitle) : that.messageTitle != null) return false;
        if (messageBody != null ? !messageBody.equals(that.messageBody) : that.messageBody != null) return false;
        if (sendDate != null ? !sendDate.equals(that.sendDate) : that.sendDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessage;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (messageTitle != null ? messageTitle.hashCode() : 0);
        result = 31 * result + (messageBody != null ? messageBody.hashCode() : 0);
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        result = 31 * result + (int) sendEmailAfter;
        result = 31 * result + (int) sendNotificationAfter;
        return result;
    }
}
