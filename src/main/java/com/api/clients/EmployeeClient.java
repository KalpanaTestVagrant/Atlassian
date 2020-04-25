package com.api.clients;

import com.api.BaseClass;
import com.api.employee.create.CreateEmployeeRequestBuilder;
import com.api.employee.create.CreateEmployeeResponse;
import com.api.employee.retrieveEmployeeDetail.RetrieveEmployeeResponse;
import com.api.employee.retriveAllEmployeesDetails.RetrieveEmployeesResponse;
import com.api.employee.updateEmployee.UpdateEmployeeResponse;
import com.google.gson.Gson;
import io.restassured.response.Response;

import java.io.IOException;


public class EmployeeClient{

    Gson gson;
    EmployeeClient employeeClient;
    Response response;
    BaseClass baseClass = new BaseClass();

    public EmployeeClient() throws IOException {
        gson =  new Gson();
    }

    public CreateEmployeeResponse createEmployee(String url,String name, String age, String salary){
        CreateEmployeeRequestBuilder createEmployeeRequestBuilder = new CreateEmployeeRequestBuilder();
        String request = gson.toJson(createEmployeeRequestBuilder.employeeDetails(name,age,salary).build());
        response = baseClass.postRequest(request,url);

        return (CreateEmployeeResponse)gson.fromJson(response.asString(), CreateEmployeeResponse.class);
    }

    public RetrieveEmployeeResponse retrieveEmployeeDetails(String url,String employeeId){
        response = baseClass.getRequest(url+employeeId);
        return (RetrieveEmployeeResponse)gson.fromJson(response.asString(), RetrieveEmployeeResponse.class);
    }

    public RetrieveEmployeesResponse retrieveAllEmployeesDetails(String url){
        response = baseClass.getRequest(url);
        return (RetrieveEmployeesResponse)gson.fromJson(response.asString(), RetrieveEmployeesResponse.class);

    }

    public UpdateEmployeeResponse updateEmployee(String url,String id,String name, String age, String salary) {
        CreateEmployeeRequestBuilder createEmployeeRequestBuilder = new CreateEmployeeRequestBuilder();
        String request = gson.toJson(createEmployeeRequestBuilder.employeeDetails(name, age, salary).build());
        response = baseClass.putRequest(request, url+id);
        return (UpdateEmployeeResponse)gson.fromJson(response.asString(), UpdateEmployeeResponse.class);
    }
}
