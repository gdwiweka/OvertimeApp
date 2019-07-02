/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.service;

import java.util.Optional;
import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.entities.OvertimeType;
import metrodatamii.metrodatamii.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import metrodatamii.metrodatamii.repository.OvertimeTypeRepository;

/**
 *
 * @author WIN7
 */
@Service
public class OvertimeTypeService {
    
    @Autowired
    private OvertimeTypeRepository overtimeTypeImplement;
    
    
    public Optional<OvertimeType> findById(String var){
        return overtimeTypeImplement.findById(var);
    }
    
    public Iterable<OvertimeType> findAllOvertimeType(){
        return overtimeTypeImplement.findAll();
    }
}
