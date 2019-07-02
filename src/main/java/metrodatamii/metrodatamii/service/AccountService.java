/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.service;

import java.util.Optional;
import metrodatamii.metrodatamii.entities.Account;
import metrodatamii.metrodatamii.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WIN7
 */
@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountImplement;
    
    
    public Optional<Account> findById(String var){
        return accountImplement.findById(var);
    }
    
    public Iterable<Account> findAllAccount(){
        return accountImplement.findAll();
    }
}
