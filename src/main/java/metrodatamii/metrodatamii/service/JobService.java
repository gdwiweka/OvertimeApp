/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.service;

import java.util.Optional;
import metrodatamii.metrodatamii.dao.IJobDAO;
import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN7
 */
//@Service
//public class JobService {
//    
//    @Autowired
//    private JobRepository jobImplement;
//    
//    
//    public Optional<Job> findById(String var){
//        return jobImplement.findById(var);
//    }
//    
//    public Iterable<Job> findAllJob(){
//        return jobImplement.findAll();
//    }
//}

@Service
public class JobService{
    @Autowired
    JobRepository jobRepository;
    
//    @Override
//    public Iterable<Job> findAll() {
//        return jobRepository.findAll();
//    }
//
//    @Override
//    public Job saveJob(Job job) {
//        return jobRepository.save(job);
//    }
//
//    @Override
//    public Job findById(String id) {
//        return jobRepository.findById(id);
//    }
//
//    @Override
//    public void deleteRegionById(String id) {
//        jobRepository.deleteById(id);
//    }
    
}
