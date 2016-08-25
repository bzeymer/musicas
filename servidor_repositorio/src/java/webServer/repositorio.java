package webServer;

import webServer.controller.ServidorRepositorio;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "repositorio")

public class repositorio {

    /**
     * Operação de Web service
     * @param id
     * @return AudioInputStream
     */
    @WebMethod(operationName = "baixarMusica")
    public String baixarMusica(@WebParam(name = "id") Integer id) {

        return ServidorRepositorio.baixarMusica(id);
        
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "listarMusicas")
    public String listarMusicas() {
        
        return ServidorRepositorio.listarMusicas();
        
    }

}
