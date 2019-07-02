/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.repository;

import metrodatamii.metrodatamii.entities.Job;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WIN7
 */
@Repository
public interface JobRepository extends CrudRepository<Job, String> {
    @Query(value = "SELECT * FROM job where id=?1", nativeQuery = true)
    public Job findJobById(String id);
    
    @Modifying
    @Query(value = "DELETE FROM job where id=?1", nativeQuery = true)
    public void deleteById(String id);
    
    
}
