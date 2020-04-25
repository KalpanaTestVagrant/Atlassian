package com.api.employee.retriveAllEmployeesDetails;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class RetrieveEmployeesResponse {
    String status;
    List<Data> data;

}
