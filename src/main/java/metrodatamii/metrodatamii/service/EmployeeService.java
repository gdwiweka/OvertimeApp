/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.service;

import java.util.Optional;
import metrodatamii.metrodatamii.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import metrodatamii.metrodatamii.repository.EmployeeRepository;

/**
 *
 * @author WIN7
 */
@Service
public class EmployeeService {
    
    
    @Autowired
    private EmployeeRepository employeeImplement;
    
    
    public Optional<Employee> findById(String var){
        return employeeImplement.findById(var);
    }
    
    public Iterable<Employee> findAllEmployee(){
        return employeeImplement.findAll();
    }
    
}
