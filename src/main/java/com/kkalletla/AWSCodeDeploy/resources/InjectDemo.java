package com.kkalletla.AWSCodeDeploy.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemo {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(){
        return "Test";
    }

}
