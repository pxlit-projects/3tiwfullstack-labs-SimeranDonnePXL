package be.pxl.services.Service;

import be.pxl.services.Controller.Request.DepartmentRequest;
import be.pxl.services.Controller.Response.DepartmentDTO;
import be.pxl.services.Domain.Department;
import be.pxl.services.Repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public void addDepartment(DepartmentRequest request) {
        Department department = Department.builder()
                .organizationId(request.getOrganizationId())
                .name(request.getName())
                .position(request.getPosition())
                .build();

        departmentRepository.save(department);
    }

    @Override
    public DepartmentDTO findDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);

        return department.map(this::mapToDepartmentDTO).orElse(null);

    }

    @Override
    public List<DepartmentDTO> findAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(this::mapToDepartmentDTO).toList();
    }

    @Override
    public List<DepartmentDTO> findDepartmentByOrganizationId(Long id) {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .filter(d -> d.getOrganizationId().equals(id))
                .map(this::mapToDepartmentDTO)
                .toList();
    }

    @Override
    public List<DepartmentDTO> findDepartmentByOrganizationIdWithEmployees(Long id) {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .filter(d -> d.getOrganizationId().equals(id))
                .map(d -> {
                    d.getEmployees();
                    return mapToDepartmentDTO(d);
                }).toList();
    }

    private DepartmentDTO mapToDepartmentDTO(Department department) {
        return DepartmentDTO.builder()
                .id(department.getId())
                .organizationId(department.getOrganizationId())
                .name(department.getName())
                .employees(department.getEmployees())
                .position(department.getPosition())
                .build();
    }
}
