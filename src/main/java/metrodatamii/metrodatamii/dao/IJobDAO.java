/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.dao;

import metrodatamii.metrodatamii.entities.Job;

/**
 *
 * @author ASUS
 */
public interface IJobDAO {
    Iterable<Job> findAll();
    Job saveJob(Job job);
    Job findById(String id);
    void deleteRegionById(String id);
}
