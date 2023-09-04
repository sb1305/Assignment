package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

@Service
public class employeeService {

    @Resource
    EmployeeRepository employeeRepository;

    public Employee findNthLevelManager(UUID Id, int level) {
        Employee employee = employeeRepository.findById(Id).orElse(null);

        if (employee != null) {
            return findNthLevelManagerRecursive(employee, level);
        } else {
            return null; // Handle the case where the employee with the given ID doesn't exist
        }
    }

    private Employee findNthLevelManagerRecursive(Employee employee, int level) {
        if (level == 0 || employee.getReportsTo() == null) {
            return employee; // Reached the nth level or the employee has no manager
        }
        // Recursively find the (n-1)th level manager
        UUID managerId = UUID.fromString(employee.getReportsTo());
        Employee manager = employeeRepository.findById(managerId).orElse(null);

        return findNthLevelManagerRecursive(manager,level-1);
    }

       
}
