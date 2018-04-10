package com.thewhitespark.iceSender.rest;

import com.thewhitespark.iceSender.model.Test;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
@Path("/tests")
public class TestEndpoint {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    @GET
    @Produces({"application/json"})
    public List<Test> getAll() {
        TypedQuery<Test> query = em.createQuery(
                "SELECT t from Test t", Test.class
        );

        List<Test> testList = query.getResultList();
        return testList;
    }
}
