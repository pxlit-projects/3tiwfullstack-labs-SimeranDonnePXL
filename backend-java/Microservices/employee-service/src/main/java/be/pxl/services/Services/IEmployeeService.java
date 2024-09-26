package be.pxl.services.Services;

import be.pxl.services.Controller.Request.EmployeeRequest;
import be.pxl.services.Controller.Response.EmployeeDTO;
import be.pxl.services.Domain.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> getAllEmployees();

    void addEmployee(EmployeeRequest request);

    EmployeeDTO findEmployeeById(Long id);
    List<EmployeeDTO> findEmployeeByDepartmentId(Long id);
    List<EmployeeDTO> findEmployeeByOrganizationId(Long id);

}
