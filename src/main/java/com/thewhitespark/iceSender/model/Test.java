package com.thewhitespark.iceSender.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name = "tests")
public class Test {

    @Id
    @XmlTransient
    public int id_tests;

    @XmlElement
    public String value;
}
