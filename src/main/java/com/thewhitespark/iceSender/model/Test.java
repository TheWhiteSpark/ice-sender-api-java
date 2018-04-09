package com.thewhitespark.iceSender.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Test {

    @XmlElement
    public String value;
}
