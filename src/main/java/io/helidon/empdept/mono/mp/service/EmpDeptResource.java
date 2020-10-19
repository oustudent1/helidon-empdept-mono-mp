package io.helidon.empdept.mono.mp.service;

import io.helidon.empdept.mono.mp.persistence.EmpDeptManager;
import io.helidon.empdept.mono.mp.persistence.Employee;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RequestScoped
@Path("/")
public class EmpDeptResource {

    private  JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    private EmpDeptManager edMgr = new EmpDeptManager();

    @Path("employee/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> employees() {
        List<Employee> emps = edMgr.getAllEmployees();
        if (emps.size() > 0) {
            return emps;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
/*        return JSON.createObjectBuilder()
                .add("Employees", "all")
                .build();*/
    }

    @Path("employee/{lastName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getByLastName(@PathParam("lastName") String lastName) {
        return JSON.createObjectBuilder()
                .add("Last Name", lastName)
                .build();
    }

    @Path("employee/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getEmployeeById(@PathParam("id") String id) {
        return JSON.createObjectBuilder()
                .add("Id", id)
                .build();
    }

    @Path("employee")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject save(String request) {
        return JSON.createObjectBuilder()
                .add("Save", request)
                .build();
    }

    @Path("employee")
    @PUT
    public JsonObject update(String request) {
        return JSON.createObjectBuilder()
                .add("Update", request)
                .build();
    }

    @Path("/mployee/{id}")
    @DELETE
    public JsonObject delete(@PathParam("id") String id) {
        return JSON.createObjectBuilder()
                .add("Delete", id)
                .build();
    }

    // Department API handlers

    @Path("/department/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getDepartments() {
        return JSON.createObjectBuilder()
                .add("Departments", "all")
                .build();
    }

    @Path("/department/{deptId}/employees")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getByDepartment(@PathParam("deptId") String dept) {
        return JSON.createObjectBuilder()
                .add("Department Employees ", dept)
                .build();
    }

    @Path("/department/{deptId}/salary")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getDepartmentSalary(@PathParam("deptId") String deptId) {
        return JSON.createObjectBuilder()
                .add("Department Salary", deptId)
                .build();
    }


}

