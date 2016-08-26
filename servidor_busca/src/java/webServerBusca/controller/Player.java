/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca.controller;

import webServerBusca.model.Musica;
import webServerBusca.model.Sala;

/**
 *
 * @author Breno
 */
public class Player implements Runnable {

    public void run() {

        Sala sala = ServidorBusca.lobby.getSalaAtiva();
        sala.nextTrack();
        Musica musica = sala.getMusicaAtual();
        String audio = musica.getAudio();
        try {
            while (musica != null) {

                String frases[] = audio.split("\n");

                for (String frase : frases) {
                    System.out.println(frase);

                    Thread.sleep(500);
                }

                sala.nextTrack();
                musica = sala.getMusicaAtual();
                audio = musica.getAudio();
            }
            
            return;
        } catch (InterruptedException ex) {
            return;
        }

    }

}
