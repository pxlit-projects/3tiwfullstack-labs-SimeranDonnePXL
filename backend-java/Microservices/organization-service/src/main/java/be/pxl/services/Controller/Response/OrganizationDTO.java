package be.pxl.services.Controller.Response;

import be.pxl.services.Domain.Department;
import be.pxl.services.Domain.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrganizationDTO {
    private Long id;
    private String name;
    private String address;
    List<Employee> employees;
    List<Department> departments;
}
