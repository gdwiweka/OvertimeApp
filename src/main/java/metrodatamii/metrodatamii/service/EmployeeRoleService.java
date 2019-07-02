/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.service;

import java.util.Optional;
import metrodatamii.metrodatamii.entities.EmployeeRole;
import metrodatamii.metrodatamii.repository.EmployeeRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN7
 */
@Service
public class EmployeeRoleService {
    
    @Autowired
    private EmployeeRoleRepository employeeRoleImplement;
    
    
    public Optional<EmployeeRole> findById(String var){
        return employeeRoleImplement.findById(Integer.parseInt(var));
    }
    
    public Iterable<EmployeeRole> findAllEmployeeRole(){
        return employeeRoleImplement.findAll();
    }
}
