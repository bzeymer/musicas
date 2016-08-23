package webServer;

import webServer.controller.ServidorRepositorio;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import webServer.model.Biblioteca;
import webServer.model.Musica;

@WebService(serviceName = "repositorio")

public class repositorio {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "baixarMusica")
    public String baixarMusica(@WebParam(name = "id") Integer id) {

     
        return ServidorRepositorio.baixarMusica(id);
    }
}
