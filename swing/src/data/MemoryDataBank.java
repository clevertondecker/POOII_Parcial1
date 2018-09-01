/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.Programador;

/**
 *
 * @author crfranco
 */
public class MemoryDataBank implements IDao<Programador>{
    
    private List<Programador> memoryDataBank = new ArrayList<>(); 

    @Override
    public void save(Programador t) {
            memoryDataBank.add(t);
    }

    @Override
    public Programador getOne(int id) {
        
        Programador programador = new Programador(id);
        
		if(memoryDataBank.contains(programador)) {
			for(Programador p: memoryDataBank) {
				if(p.equals(programador)) {
					return p;
				}
			}
		}
		return null;		
    }

    @Override
    public List<Programador> list() {
        return memoryDataBank;
    }

    @Override
    public void update(int id, Programador t) {
       memoryDataBank.add(id,t);
    }

    @Override
    public void delete(int id) {
        if(memoryDataBank.contains(id)) {
            memoryDataBank.remove(id);
        }
    }
}
