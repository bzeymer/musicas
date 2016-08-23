package webServer;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import webServer.controller.ServidorRepositorio;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;
import webServer.model.Biblioteca;
import webServer.model.Musica;

@WebService(serviceName = "repositorio")

public class repositorio {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "baixarMusica")
    public AudioInputStream baixarMusica(@WebParam(name = "id") Integer id) {

        System.out.println("Começou:" + (new Date().getTime()));
       
        try {
            
            return ServidorRepositorio.baixarMusica(id);
        
        } catch (UnsupportedAudioFileException | IOException ex) {
            
            Logger.getLogger(repositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
