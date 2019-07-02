/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.service;

import java.util.Optional;
import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.entities.OvertimeRequest;
import metrodatamii.metrodatamii.entities.OvertimeType;
import metrodatamii.metrodatamii.repository.JobRepository;
import metrodatamii.metrodatamii.repository.OvertimeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import metrodatamii.metrodatamii.repository.OvertimeTypeRepository;

/**
 *
 * @author WIN7
 */
@Service
public class OvertimeRequestService {
    
    @Autowired
    private OvertimeRequestRepository overtimeRequestImplement;
    
    
    public Optional<OvertimeRequest> findById(String var){
        return overtimeRequestImplement.findById(var);
    }
    
    public Iterable<OvertimeRequest> findAllOvertimeType(){
        return overtimeRequestImplement.findAll();
    }
}
