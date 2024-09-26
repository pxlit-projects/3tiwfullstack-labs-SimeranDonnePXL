package be.pxl.services.Service;

import be.pxl.services.Controller.Request.OrganizationRequest;
import be.pxl.services.Controller.Response.OrganizationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrganizationService {
    OrganizationDTO findByOrganizationId(Long id);
    OrganizationDTO findOrganizationByIdWithDepartments(Long id);
    OrganizationDTO findOrganizationByIdWithDepartmentsAndEmployees(Long id);
    OrganizationDTO findOrganizationByIdWithEmployees(Long id);

}
