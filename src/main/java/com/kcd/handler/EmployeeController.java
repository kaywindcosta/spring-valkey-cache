package com.kcd.handler;

import com.kcd.model.Employee;
import com.kcd.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all")
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/count")
    public long getEmployeeCount() {
        return employeeRepository.count();
    }
    @GetMapping("/exists/{id}")
    public boolean employeeExists(@PathVariable("id") String id) {
        return employeeRepository.existsById(id);
    }

    @GetMapping("/deleteAll")
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
    @GetMapping("/deleteById/{id}")
    public void deleteEmployeeById(@PathVariable("id") String id) {
        employeeRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
