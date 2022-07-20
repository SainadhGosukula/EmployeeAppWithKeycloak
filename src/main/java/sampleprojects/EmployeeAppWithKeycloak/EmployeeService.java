package sampleprojects.EmployeeAppWithKeycloak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    List<Employee> employeeList=new ArrayList<>();
    @Autowired
    private EmployeeRepo repo;
    @PostConstruct
    public List<Employee> saveAllEmployees(){
        employeeList.add(new Employee(1,"sainadh",75000.0));
        employeeList.add(new Employee(2,"sainsam",100000.00));
        employeeList.add(new Employee(3,"sunny",70000.00));
        return repo.saveAll(employeeList);
    }

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id){
        return repo.findById(id);
    }
}
