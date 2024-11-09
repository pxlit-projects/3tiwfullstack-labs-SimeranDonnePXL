package be.pxl.services;

import be.pxl.services.Repository.OrganizationRepository;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class OrganizationTest {
    @Autowired
    MockMvc mockMvc;

    @Container
    private static MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:5.7.37");

    @DynamicPropertySource
    private static void registerMySqlProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    public void testFindOrganizationById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/organization/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    public void testFindOrganizationByIdWithDepartments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/organization/{id}/with-departments", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    public void testFindOrganizationByIdWithDepartmentsAndEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/organization/{id}/with-departments-and-employees", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    public void testFindOrganizationByIdWithEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/organization/{id}/with-employees", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }
}
