package com.thewhitespark.iceSender.rest;


import com.thewhitespark.iceSender.model.Test;
import com.thewhitespark.iceSender.model.Tests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/dbtests")

public class DbTestEndpoint {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    @GET
    @Produces({"application/json"})
    public List<Tests> getAll() {

        TypedQuery<Tests> query = em.createQuery(
                "SELECT t from Tests t", Tests.class
        );

        List<Tests> testList = query.getResultList();

        return testList;
    }

}
