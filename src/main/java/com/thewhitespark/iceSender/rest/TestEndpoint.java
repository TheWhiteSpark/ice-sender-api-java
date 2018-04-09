package com.thewhitespark.iceSender.rest;

import com.thewhitespark.iceSender.model.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/tests")
public class TestEndpoint {

    @GET
    @Produces({"application/json"})
    public List<Test> getAll() {

        List<Test> testList = new ArrayList<Test>();
        testList.add(new Test());
        testList.add(new Test());
        testList.add(new Test());

        for (Test item : testList) {
            item.value = "testVal";
        }

        return testList;
    }
}
