package com.thewhitespark.icesender.model;

import org.aspectj.bridge.Message;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "attachment", schema = "ice_sender")
public class AttachmentEntity implements Serializable {

    @Id
    @NotNull
    @Column(name = "id_attachment")
    private Long idAttachment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_message")
    private MessageEntity message;

    @NotNull
    @Column(name = "file")
    private byte[] file;

    public Long getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(Long idAttachment) {
        this.idAttachment = idAttachment;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(MessageEntity file) {
        this.message = file;
    }

    public MessageEntity getMessage() {
        return message;
    }

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachmentEntity that = (AttachmentEntity) o;

        if (!idAttachment.equals(that.idAttachment)) return false;
        return Arrays.equals(file, that.file);
    }

}
