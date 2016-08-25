/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Breno
 */
public class Lobby {
    
    private List<Sala> salas = new ArrayList<Sala>();
    private Sala salaAtiva;
    
    public List<Sala> getSalas() {
        
        return salas;
    }

    public Sala getSalaAtiva() {
        return salaAtiva;
    }
    
    public void addSala(Sala sala) {
        
        this.salas.add(sala);
    }

    public Boolean autenticar(Sala salaEntrada) {
        
        for (Sala sala : this.salas) {
            
            if (sala.getId().equals(salaEntrada.getId())) {
                
                salaAtiva = sala;
                return true;
            }
        }
        
        salaAtiva = null;
        return false;
    }
    
    
}
