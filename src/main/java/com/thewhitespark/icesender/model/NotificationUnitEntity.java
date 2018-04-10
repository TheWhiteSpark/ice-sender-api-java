package com.thewhitespark.icesender.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "notification_unit", schema = "ice_sender", catalog = "")
public class NotificationUnitEntity implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification_unit")
    private int idNotificationUnit;

    @NotNull
    @Column(name = "unit")
    private String unit;

    public int getIdNotificationUnit() {
        return idNotificationUnit;
    }

    public void setIdNotificationUnit(int idNotificationUnit) {
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
        int result = idNotificationUnit;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
