package com.thewhitespark.icesender.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonView;
import com.thewhitespark.icesender.model.views.MessageView;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@XmlRootElement
@Table(name = "message", schema = "ice_sender")
public class MessageEntity implements Serializable {

    @Id
    @NotNull
    @JsonView(MessageView.Summary.class)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="uuid-char")
    @Column(name = "id_message")
    private UUID idMessage;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_user")
    private UserEntity user;

    @NotNull
    @JsonView(MessageView.Summary.class)
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @JsonView(MessageView.Summary.class)
    private String description;

    @NotNull
    @JsonView(MessageView.Summary.class)
    @Column(name = "color")
    private String color;

    @NotNull
    @JsonUnwrapped
    @JsonView(MessageView.Summary.class)
    @OneToOne(fetch=FetchType.EAGER)
    private MessageTypeEntity messageType;

    @Column(name = "message_title")
    @JsonView(MessageView.Details.class)
    private String messageTitle;

    @Column(name = "message_body")
    @JsonView(MessageView.Details.class)
    private String messageBody;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(MessageView.Summary.class)
    @Column(nullable = false, name="send_date")
    private Date sendDate;

    @NotNull
    @JsonView(MessageView.Details.class)
    @Column(name = "send_email_after", columnDefinition="tinyint(1) default 1")
    private byte sendEmailAfter;

    @NotNull
    @JsonView(MessageView.Details.class)
    @Column(name = "send_notification_after", columnDefinition="tinyint(1) default 1")
    private byte sendNotificationAfter;



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
        return sendDate != null ? sendDate.equals(that.sendDate) : that.sendDate == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
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

    public UUID getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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

    public MessageTypeEntity getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEntity messageType) {
        this.messageType = messageType;
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
}
