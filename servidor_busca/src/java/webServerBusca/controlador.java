/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import webServerBusca.controller.ServidorBusca;

/**
 *
 * @author Breno
 */
@WebService(serviceName = "controlador")
public class controlador {

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
        //TODO write your implementation code here:
        return null;
    }
}
