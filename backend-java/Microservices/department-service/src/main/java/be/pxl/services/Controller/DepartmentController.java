package be.pxl.services.Controller;

import be.pxl.services.Controller.Request.DepartmentRequest;
import be.pxl.services.Controller.Response.DepartmentDTO;
import be.pxl.services.Service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final IDepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<Void> addDepartment(@RequestBody DepartmentRequest request){
        departmentService.addDepartment(request);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id){
        return new ResponseEntity<DepartmentDTO>(departmentService.findDepartmentById(id), HttpStatus.FOUND);
    }
    @GetMapping("/")
    public ResponseEntity<List<DepartmentDTO>> findAllDepartments(){
        return new ResponseEntity<>(departmentService.findAllDepartments(), HttpStatus.FOUND);
    }
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<DepartmentDTO>> findDepartmentByOrganization(@PathVariable Long organizationId){
        return new ResponseEntity<List<DepartmentDTO>>(departmentService.findDepartmentByOrganizationId(organizationId), HttpStatus.FOUND);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<List<DepartmentDTO>> findByOrganizationWithEmployees(@PathVariable Long organizationId){
        return new ResponseEntity<List<DepartmentDTO>>(departmentService.findDepartmentByOrganizationIdWithEmployees(organizationId), HttpStatus.FOUND);
    }

}
