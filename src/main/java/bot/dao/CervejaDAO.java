/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot.dao;

import bot.Cerveja;
import bot.CervejaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ra21550273
 */
@Service
public class CervejaDAO {
     
    private ApplicationContext context;
    
    private CervejaRepository cervejaRepository;
    
    
    public CervejaDAO(ApplicationContext context){
         this.context = context;
     }
    
    public List<String> recuperaOpcoesCervejas() {
        
        cervejaRepository = context.getBean(CervejaRepository.class);
        
        Iterable<Cerveja> cervejas = cervejaRepository.findAll();
    
        List<String> result = new ArrayList<>();
        
        for(Cerveja cerva : cervejas){
            result.add(cerva.getNome() + "(" + cerva.getValor() + ")");
        }
    
        return result;
    }
    
}
