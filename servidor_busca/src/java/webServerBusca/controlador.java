/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import webServerBusca.controller.Player;
import webServerBusca.controller.ServidorBusca;

/**
 *
 * @author Breno
 */
@WebService(serviceName = "controlador")
public class controlador {

    
    public static Player player = new Player();
    public static Thread tPlayer = new Thread(player);
    
    
    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "listarMusicas")
    public String listarMusicas() {
        
        return ServidorBusca.todasMusicas();
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "listarSalas")
    public String listarSalas() {
        
        return ServidorBusca.todasSalas();
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "conectar")
    public String conectar(@WebParam(name = "sala") String sala, @WebParam(name = "senha") String senha) {

        return ServidorBusca.conectar(sala, senha);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "adicionarMusica")
    public String adicionarMusica(@WebParam(name = "musica") String musica) {

        return ServidorBusca.addMusica(musica);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "play")
    public String play() {
        
        return ServidorBusca.play(tPlayer, player);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "stop")
    public String stop() {
        
        return ServidorBusca.stop(tPlayer, player);
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "adicionarSala")
    public String adicionarSala(@WebParam(name = "nomeSala") String nomeSala, @WebParam(name = "senha") String senha) {
        
        return ServidorBusca.addSala(nomeSala, senha);
    }
}
