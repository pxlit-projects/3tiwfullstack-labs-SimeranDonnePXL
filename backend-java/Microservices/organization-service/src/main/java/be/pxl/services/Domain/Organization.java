package be.pxl.services.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "organization")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;

    @Transient
    List<Employee> employees;

    @Transient
    List<Department> departments;
}
