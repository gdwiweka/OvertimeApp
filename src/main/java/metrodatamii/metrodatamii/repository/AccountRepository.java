/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.repository;

import java.util.List;
import javax.transaction.Transactional;
import metrodatamii.metrodatamii.entities.Account;
import metrodatamii.metrodatamii.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author WIN7
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    @Query(value = "SELECT e.email FROM employee e INNER JOIN account a ON e.id=a.id WHERE is_active='false' AND a.token= :token LIMIT 1", nativeQuery = true)
    List getEmailByToken(@Param("token") String token);
  
    @Query(value = "SELECT * FROM employee WHERE is_delete ='false' AND email= :email", nativeQuery = true)
    Employee getIdByEmail(@Param("email") String email);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET `password` = :password WHERE username= :username", nativeQuery = true)
    void updatePassword(@Param("username") String username,@Param("password") String password);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE account SET `is_active` = :is_active WHERE `token` = :token", nativeQuery = true)
    void updateToken(@Param("token") String token,@Param("is_active") String is_active);
}
