package com.thewhitespark.icesender.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "attachment", schema = "ice_sender", catalog = "")
public class AttachmentEntity implements Serializable {

    @Id
    @NotNull
    @Column(name = "id_attachment")
    private int idAttachment;

    @NotNull
    @Column(name = "file")
    private byte[] file;

    public int getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(int idAttachment) {
        this.idAttachment = idAttachment;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachmentEntity that = (AttachmentEntity) o;

        if (idAttachment != that.idAttachment) return false;
        if (!Arrays.equals(file, that.file)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAttachment;
        result = 31 * result + Arrays.hashCode(file);
        return result;
    }
}
