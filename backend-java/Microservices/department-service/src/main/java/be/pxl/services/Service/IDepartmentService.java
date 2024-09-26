package be.pxl.services.Service;

import be.pxl.services.Controller.Request.DepartmentRequest;
import be.pxl.services.Controller.Response.DepartmentDTO;

import java.util.List;

public interface IDepartmentService {
    public void addDepartment(DepartmentRequest request);
    public DepartmentDTO findDepartmentById(Long id);
    public List<DepartmentDTO> findAllDepartments();
    public List<DepartmentDTO> findDepartmentByOrganizationId(Long id);
    public List<DepartmentDTO> findDepartmentByOrganizationIdWithEmployees(Long id);
}
