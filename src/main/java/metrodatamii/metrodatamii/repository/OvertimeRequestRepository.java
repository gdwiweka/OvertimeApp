/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.repository;

import java.util.List;
import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.entities.OvertimeRequest;
import metrodatamii.metrodatamii.entities.OvertimeType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WIN7
 */
@Repository
public interface OvertimeRequestRepository extends CrudRepository<OvertimeRequest, String> {
    @Query(value = "SELECT * FROM overtime_request WHERE status = 'S-0001'", nativeQuery = true)
    List<OvertimeRequest> getAll();
}
