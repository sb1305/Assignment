package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private employeeService employeeService;

    @PostMapping("/generate")
    public UUID addEmployee(@RequestBody Employee employee) {
        // Generate a unique UUID for the employee (you can use java.util.UUID.randomUUID().toString())
        // Save the employee to the MongoDB database
        employee.setId(java.util.UUID.randomUUID());
        employeeRepository.save(employee);
        return employee.getId();
    }

//    @GetMapping("/getAll")
//    public List<Employee> getAllEmployees() {
//    	
//    	
//        return employeeRepository.findAll();
//    }

    
    @GetMapping("/getAll")
    public Page<Employee> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "employeeName,asc") String[] sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        return employeeRepository.findAll(pageable);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable UUID id) {
    	
        employeeRepository.deleteById(id);
        return "Success";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable UUID id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            
            // Update employee details based on the provided updatedEmployee data
            employee.setEmployeeName(updatedEmployee.getEmployeeName());
            employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setReportsTo(updatedEmployee.getReportsTo());
            employee.setProfileImage(updatedEmployee.getProfileImage());

            // Save the updated employee to the database
            employeeRepository.save(employee);
            return "Success";
        } else {
            return "Employee not found"; // Handle the case where the employee is not found
        }
    }
    
    
    
    @GetMapping("/getNthLevelManager")
    public Employee getNthLevelManager(@RequestParam("id") UUID id, @RequestParam("level") int level) {
        // Implement the logic to find the nth level manager of the employee
        return employeeService.findNthLevelManager(id, level);
    }

}
