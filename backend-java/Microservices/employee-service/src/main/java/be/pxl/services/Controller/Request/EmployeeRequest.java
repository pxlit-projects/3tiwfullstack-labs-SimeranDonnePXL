package be.pxl.services.Controller.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    private Long organizationId;
    private Long departmentId;
    private  String name;
    private int age;
    private String position;
}
