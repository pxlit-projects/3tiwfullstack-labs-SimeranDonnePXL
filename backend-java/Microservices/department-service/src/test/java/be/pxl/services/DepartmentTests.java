package be.pxl.services;

import be.pxl.services.Domain.Department;
import be.pxl.services.Domain.Employee;
import be.pxl.services.Repository.DepartmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static junit.framework.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class DepartmentTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DepartmentRepository repository;

    @Container
    private static MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:5.7.37");

    @DynamicPropertySource
    private static void registerMySqlProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    public void testCreateDepartment() throws Exception {
        Department department = Department.builder()
                .organizationId(1L)
                .name("Administration")
                .position("Secretary")
                .build();

        String derpartmentString = objectMapper.writeValueAsString(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/departments/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(derpartmentString))
                .andExpect(status().isCreated());

        assertEquals(1, repository.findAll().size());
    }

    @Test
    public void testGetDepartmentById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    public void testFindAllDepartments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    public void testFindDepartmentByOrganization() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/organization/{organizationId}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    public void testFindByOrganizationWithEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/departments/organization/{organizationId}/with-employees", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }
}
