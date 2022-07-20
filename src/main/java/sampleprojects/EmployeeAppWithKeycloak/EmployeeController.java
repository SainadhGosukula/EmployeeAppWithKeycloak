package sampleprojects.EmployeeAppWithKeycloak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //this is for users whose role is tagged as User
    @GetMapping("/{id}")
    @RolesAllowed("user")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    //this can be accessed by users whose role is tagged as Amdin
    @GetMapping("")
    @RolesAllowed("admin")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

}
