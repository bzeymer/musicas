/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientenative;

import java.util.Scanner;

/**
 *
 * @author Breno
 */
public class ClienteNative {

    public static void main(String[] args) {
        
         menuInicial();
         return;
    }
    
    public static void menuInicial() {
        
        Scanner leitor = new Scanner(System.in);
        System.out.println(Menu.INICIAL);
        int opcao = Integer.parseInt(leitor.nextLine());
        
        String nomeSala = "";
        String senha = "";
        String response = "";
        switch(opcao) {
            
            case 1: System.out.println("Insira o nome da sala:");
                    nomeSala = leitor.nextLine();
                    System.out.println("Insira a senha da sala:");
                    senha = leitor.nextLine();
                    response = adicionarSala(nomeSala, senha);
                    System.out.println(response);
                    menuPrincipal();
                    break;
                    
            case 2: System.out.println("Insira o nome da sala:");
                    nomeSala = leitor.nextLine();
                    System.out.println("Insira a senha da sala:");
                    senha = leitor.nextLine();
                    response = conectar(nomeSala, senha);
                    System.out.println(response);
                    menuPrincipal();
                    break;
                    
            case 3: response = listarSalas();
                    System.out.println(response);
                    menuInicial();
                    break;
                    
            case 4: return;
                    
        }   
    }
    
    public static void menuPrincipal() {
        
        Scanner leitor = new Scanner(System.in);
        System.out.println(Menu.PRINCIPAL);
        int opcao = Integer.parseInt(leitor.nextLine());
        
        String nomeMusica = "";
        String response = "";
        switch(opcao) {
            
            case 1: response = mostrarPlaylist();
                    System.out.println(response);
                    menuPlaylist();
                    break;
                    
            case 2: response = listarMusicas();
                    System.out.println(response);
                    menuPrincipal();
                    break;
                    
            case 3: 
                    System.out.println("Insira o nome da musica:");
                    nomeMusica = leitor.nextLine();
                    response = adicionarMusica(nomeMusica);
                    System.out.println(response);
                    menuPrincipal();
                    break;
                    
            case 4: 
                    System.out.println("Insira o nome da musica:");
                    nomeMusica = leitor.nextLine();
                    response = teste(nomeMusica);
                    System.out.println(response);
                    menuPrincipal();
                    break;
                    
            case 0: menuInicial();
                    break;
                    
            default: menuPrincipal();
                    
        }   
    }
    
    public static void menuPlaylist() {
        
        Scanner leitor = new Scanner(System.in);
        System.out.println(Menu.COMANDOS_PLAYLIST);
        int opcao = Integer.parseInt(leitor.nextLine());
        
        String response = "";
        switch(opcao) {
            
            case 1: response = play();
                    System.out.println(response);
                    menuPlaylist();
                    break;
                    
            case 2: response = stop();
                    System.out.println(response);
                    menuPlaylist();
                    break;
                    
            case 0: menuPrincipal();
                    break;
                    
            default: menuPlaylist();
                    
        }   
    }

    private static String adicionarMusica(java.lang.String musica) {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.adicionarMusica(musica);
    }

    private static String adicionarSala(java.lang.String nomeSala, java.lang.String senha) {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.adicionarSala(nomeSala, senha);
    }

    private static String conectar(java.lang.String sala, java.lang.String senha) {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.conectar(sala, senha);
    }

    private static String listarMusicas() {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.listarMusicas();
    }

    private static String listarSalas() {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.listarSalas();
    }

    private static String mostrarPlaylist() {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.mostrarPlaylist();
    }

    private static String play() {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.play();
    }

    private static String stop() {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.stop();
    }

    private static String teste(java.lang.String nomeMusica) {
        webserverbusca.Controlador_Service service = new webserverbusca.Controlador_Service();
        webserverbusca.Controlador port = service.getControladorPort();
        return port.teste(nomeMusica);
    }
    
}
