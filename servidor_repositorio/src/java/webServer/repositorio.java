package webServer;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import model.Musica;

@WebService(serviceName = "repositorio")
@Stateless()
public class repositorio {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "buscarMusicaPorNome")
    public Musica buscarMusicaPorNome(@WebParam(name = "nomeMusica") String nomeMusica) {
        //TODO write your implementation code here:
        return null;
    }
}
