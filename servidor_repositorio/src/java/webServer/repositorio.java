package webServer;

import webServer.controller.ServidorRepositorio;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "repositorio")

public class repositorio {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "listarMusicas")
    public String listarMusicas() {
        
        return ServidorRepositorio.listarMusicas();
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "buscarMusica")
    public String buscarMusica(@WebParam(name = "nomeMusica") String nomeMusica) {
        
        return ServidorRepositorio.baixarMusica(nomeMusica);
    }

}
