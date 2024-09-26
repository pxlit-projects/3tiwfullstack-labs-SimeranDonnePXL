package be.pxl.services.Controller.Response;

import be.pxl.services.Domain.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {
    private Long id;
    private Long organizationId;
    private String name;
    private List<Employee> employees;
    private String position;
}
