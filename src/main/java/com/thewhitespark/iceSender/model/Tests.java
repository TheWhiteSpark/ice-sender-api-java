package com.thewhitespark.iceSender.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tests {

    @Id
    private int id_tests;

    private String value;

}
