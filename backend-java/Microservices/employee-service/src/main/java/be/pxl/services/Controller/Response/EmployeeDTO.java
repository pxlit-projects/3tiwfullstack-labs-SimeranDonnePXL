package be.pxl.services.Controller.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private Long organizationId;
    private Long departmentId;
    private  String name;
    private int age;
    private String position;
}
