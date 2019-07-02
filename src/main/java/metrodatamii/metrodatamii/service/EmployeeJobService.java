/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.service;

import java.util.Optional;
import metrodatamii.metrodatamii.entities.EmployeeJob;
import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.repository.EmployeeJobRepository;
import metrodatamii.metrodatamii.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN7
 */
@Service
public class EmployeeJobService {
    
    @Autowired
    private EmployeeJobRepository employeeJobImplement;
    
    
    public Optional<EmployeeJob> findById(String var){
        return employeeJobImplement.findById(Integer.parseInt(var));
    }
    
    public Iterable<EmployeeJob> findAllEmployeeJob(){
        return employeeJobImplement.findAll();
    }
}
