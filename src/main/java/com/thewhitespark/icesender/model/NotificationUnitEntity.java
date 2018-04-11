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
@Table(name = "notification_unit", schema = "ice_sender", catalog = "")
public class NotificationUnitEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="uuid-char")
    @Column(name = "id_notification_unit")
    private UUID idNotificationUnit;

    @NotNull
    @Column(name = "unit")
    private String unit;

    public UUID getIdNotificationUnit() {
        return idNotificationUnit;
    }

    public void setIdNotificationUnit(UUID idNotificationUnit) {
        this.idNotificationUnit = idNotificationUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotificationUnitEntity that = (NotificationUnitEntity) o;

        if (idNotificationUnit != that.idNotificationUnit) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
