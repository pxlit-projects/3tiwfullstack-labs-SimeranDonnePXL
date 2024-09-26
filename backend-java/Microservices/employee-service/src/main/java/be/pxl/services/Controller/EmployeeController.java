package be.pxl.services.Controller;

import be.pxl.services.Controller.Request.EmployeeRequest;
import be.pxl.services.Controller.Response.EmployeeDTO;
import be.pxl.services.Services.EmployeeService;
import be.pxl.services.Services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        return  new ResponseEntity<List<EmployeeDTO>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable Long id){
        return new ResponseEntity<EmployeeDTO>(employeeService.findEmployeeById(id), HttpStatus.FOUND);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeDTO>> findEmployeeByDepartment(@PathVariable Long departmentId){
        return new ResponseEntity<List<EmployeeDTO>>(employeeService.findEmployeeByDepartmentId(departmentId), HttpStatus.FOUND);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<EmployeeDTO>> findEmployeeByOrganization(@PathVariable Long organizationId){
        return new ResponseEntity<List<EmployeeDTO>>(employeeService.findEmployeeByOrganizationId(organizationId), HttpStatus.FOUND);
    }

}
