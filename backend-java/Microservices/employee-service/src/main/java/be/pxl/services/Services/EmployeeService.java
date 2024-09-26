package be.pxl.services.Services;

import be.pxl.services.Controller.Request.EmployeeRequest;
import be.pxl.services.Controller.Response.EmployeeDTO;
import be.pxl.services.Domain.Employee;
import be.pxl.services.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::mapToEmployeeDTO).toList();
    }

    @Override
    public void addEmployee(EmployeeRequest request) {
        Employee employee = Employee.builder()
                .organizationId(request.getOrganizationId())
                .departmentId(request.getDepartmentId())
                .name(request.getName())
                .age(request.getAge())
                .position(request.getPosition())
                .build();

        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty()){
            return null;
        }

        Employee foundEmployee = employee.get();

        return mapToEmployeeDTO(foundEmployee);
    }

    @Override
    public List<EmployeeDTO> findEmployeeByDepartmentId(Long id) {
        List<Employee> employees = employeeRepository.findAll()
                .stream()
                .filter(e -> e.getDepartmentId().equals(id))
                .toList();

        return employees.stream().map(this::mapToEmployeeDTO).toList();
    }

    @Override
    public List<EmployeeDTO> findEmployeeByOrganizationId(Long id) {
        List<Employee> employees = employeeRepository.findAll()
                .stream()
                .filter(e -> e.getDepartmentId().equals(id))
                .toList();

        return employees.stream().map(this::mapToEmployeeDTO).toList();    }

    private EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .organizationId(employee.getOrganizationId())
                .departmentId(employee.getDepartmentId())
                .name(employee.getName())
                .age(employee.getAge())
                .position(employee.getPosition())
                .build();
    }
}
