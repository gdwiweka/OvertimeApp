/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.repository;

import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.entities.OvertimeType;
import metrodatamii.metrodatamii.entities.TimeSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WIN7
 */
@Repository
public interface TimeSheetRepository extends CrudRepository<TimeSheet, Integer> {
    
}
