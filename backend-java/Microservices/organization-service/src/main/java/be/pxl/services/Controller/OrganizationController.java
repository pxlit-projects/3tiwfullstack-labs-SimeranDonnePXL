package be.pxl.services.Controller;

import be.pxl.services.Controller.Response.OrganizationDTO;
import be.pxl.services.Service.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private  final IOrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> findById(@PathVariable Long id){
        return new ResponseEntity<OrganizationDTO>(organizationService.findByOrganizationId(id), HttpStatus.FOUND);
    }

    @GetMapping("/{id}/with-departments")
    public ResponseEntity<OrganizationDTO> findByIdWithDepartments(@PathVariable Long id){
        return new ResponseEntity<OrganizationDTO>(organizationService.findOrganizationByIdWithDepartments(id), HttpStatus.FOUND);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity<OrganizationDTO> findByIdWithDepartmentsAndEmployees(@PathVariable Long id){
        return new ResponseEntity<OrganizationDTO>(organizationService.findOrganizationByIdWithDepartmentsAndEmployees(id), HttpStatus.FOUND);
    }

    @GetMapping("/{id}/with-employees")
    public ResponseEntity<OrganizationDTO> findByIdWithEmployees(@PathVariable Long id){
        return new ResponseEntity<OrganizationDTO>(organizationService.findOrganizationByIdWithEmployees(id), HttpStatus.FOUND);
    }

}
