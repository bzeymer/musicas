/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca.controller;

import com.sun.media.sound.JavaSoundAudioClip;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import webServerBusca.model.Musica;
import webServerBusca.model.Sala;

/**
 *
 * @author Breno
 */
public class Player implements Runnable {
    public void run(){
        
        Boolean continua = true;
        Sala sala = ServidorBusca.lobby.getSalaAtiva();
        String audio = sala.getMusicaAtual().getAudio();
        
        while (audio != null && continua) {
            
            String frases[] = audio.split("\n");
             
            for (String frase : frases) {
                System.out.println(frase);
                try {
                    Thread.sleep(750);
                } catch (InterruptedException ex) {
                    continua = false;
                    break;
                }
            }
            
            sala.nextTrack();
            audio = sala.getMusicaAtual().getAudio();
        }    
        
    }
    
}
