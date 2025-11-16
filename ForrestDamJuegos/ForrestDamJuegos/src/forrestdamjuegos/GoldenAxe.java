/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forrestdamjuegos;

import java.util.Scanner;

/**
 *
 * @author Rafae
 */
public class GoldenAxe {
    
    public  GoldenAxe(){
        Scanner scan=new Scanner(System.in);
        
        int numJugadores=0;
        String tipoJugador;
        while(numJugadores<1 || numJugadores >5){
        System.out.println("ELIGE EL NUMERO DE JUGADORES 1 A 5");
        numJugadores=scan.nextInt();
        }
        Jugador Jugadores[]= new Jugador[numJugadores];
        
        
            
        for(int i=0;i<numJugadores;i++){
            
          System.out.println("Selecciona el Jugador: ENANO, GUERRERO, AMAZONA");
            
            tipoJugador=scan.next();
            
            switch(tipoJugador.toUpperCase()){
                case "ENANO":
                    Jugadores[i]=new Enano();
                    Jugadores[i].setEstaVivo(true);
                    break;
                case "GUERRERO":
                    Jugadores[i]=new Guerrero();
                    Jugadores[i].setEstaVivo(true);
                    break;
                    
                case "AMAZONA":
                    Jugadores[i]=new Amazona();
                    Jugadores[i].setEstaVivo(true);
                    break;
                    
                default:
                    System.out.println("Tipo de jugador erroneo, por favor introduzcalo de nuevo: ");
                    i=i-1;
            }
            
        }
            comienzaElJuego(numJugadores,Jugadores);
    }
    
    public static void comienzaElJuego(int numJugadores,Jugador [] Jugadores){
        Scanner scan=new Scanner(System.in);
            Cthulhu enemigo= new Cthulhu(numJugadores);
            int turnos=8-numJugadores;
            int contadorTurno=0;
            boolean todosViven=true;
            int turnoJugador=0;
            int numRondas=1;
            String accion;
            Boolean accionValida=false;
            
            System.out.println("Que comience la lucha contra Cthulhu ↜(ˈ╰ •ω•)╯ψ ");
            
            while(enemigo.estaVivo==true && todosViven==true && numRondas<=turnos){
            if(turnoJugador>numJugadores-1){
                    turnoJugador=0;
                    numRondas=numRondas+1;
                }
            
            if(numRondas<=turnos){
            System.out.println("RONDA :"+numRondas);
            while(accionValida==false){
                System.out.println("TURNO: "+contadorTurno);
                
                System.out.println("Jugador numero "+turnoJugador+" "+Jugadores[turnoJugador].getNombre()+" que accíon quieres realizar: Luchar, CogerCarta, SumarVida");
                
                 accion=scan.nextLine();
            
            switch(accion.toUpperCase()){
                case "LUCHAR":
                     accionValida=true;
                   todosViven= lucharCthulhu(Jugadores[turnoJugador],enemigo, todosViven);
                    break;
                case "COGERCARTA":
                     accionValida=true;
                   cogerCarta(Jugadores[turnoJugador]);
                    break;
                    
                case "SUMARVIDA":
                     accionValida=true;
                   reponerVida(Jugadores[turnoJugador]);
                    break;
                    
                default:
                    System.out.println("Parece que esa acción no existe! por favor introducela de nuevo.");
                     accionValida=false;
                }
            }
            accionValida=false;
            turnoJugador=turnoJugador+1;
            contadorTurno=contadorTurno+1;
        }
            }
            
            if( numRondas>=turnos){
                System.out.println("Se te acabaron los turnos... el fin se acerca...  Cthulhu gana...");
            }
    }
    
    static public boolean lucharCthulhu(Jugador Jugadores,Cthulhu enemigo,  boolean todosViven){
        int valorDado;
        int total=0;
     
        for(int i=0;i<Jugadores.getFuerza();i++){
           valorDado=(int)(Math.random()*6+1);
            System.out.println("Tirada Dado "+i+": "+valorDado);
            total=total+valorDado;
        }
        
        System.out.println("Vida de Cthulhu es "+ enemigo.getVida());
        enemigo.setVida(enemigo.getVida()-total);
        System.out.println("Vida de Cthulhu es "+ enemigo.getVida());
        Jugadores.setVida(Jugadores.getVida()-1);
        System.out.println("Vida del Jugador ahora es: "+Jugadores.getVida());
        
        if(enemigo.getVida()<=0){
            enemigo.setEstaVivo(false);
            System.out.println("Cthulhu a sido derrotado! ganaste!");
        }else if(Jugadores.getVida()<=0){
            Jugadores.setEstaVivo(false);
            todosViven=false;
            System.out.println("Parece que uno de tus compañeros perecio... Cthulhu gana... ");
        }
        return todosViven;
    }
    static public void cogerCarta(Jugador Jugadores){
            int numCarta=(int)(Math.random()*5);

                    switch(Jugadores.getCarta(numCarta)){
                        case "Obtienes un punto de vida":
                             System.out.println("Obtienes un punto de vida");
                            Jugadores.setVida(Jugadores.getVida()+Jugadores.getVidaCarta(Jugadores.getCarta(numCarta)));
                            System.out.println("Vida total es : "+Jugadores.getVida());
                            break;
                        case "Te quitan un punto de vida":
                            System.out.println("Te quitan un punto de vida");
                            Jugadores.setVida(Jugadores.getVida()+Jugadores.getVidaCarta(Jugadores.getCarta(numCarta)));
                            System.out.println("Vida total es : "+Jugadores.getVida());
                            break;
                        case "Obtienes un punto de fuerza":
                            System.out.println("Obtienes un punto de fuerza");
                            Jugadores.setFuerza(Jugadores.getFuerza()+Jugadores.getFuerzaCarta(Jugadores.getCarta(numCarta)));
                            System.out.println("Fuerza total es : "+Jugadores.getFuerza());
                            break;
                        case "Te quitan un punto de fuerza":
                            System.out.println("Te quitan un punto de fuerza");
                            Jugadores.setFuerza(Jugadores.getFuerza()+Jugadores.getFuerzaCarta(Jugadores.getCarta(numCarta)));
                            System.out.println("Fuerza total es : "+Jugadores.getFuerza());
                            break;
                        case "Obtienes dos puntos de vida":
                            System.out.println("Obtienes dos puntos de vida");
                            Jugadores.setVida(Jugadores.getVida()+Jugadores.getVidaCarta(Jugadores.getCarta(numCarta)));
                            System.out.println("Vida total es : "+Jugadores.getVida());
                            break;
                                
                    }
                
         
            
    }
    static public void reponerVida(Jugador Jugadores){
        
        Jugadores.setVida(Jugadores.getVida()+1);
        System.out.println("Vida total es : "+Jugadores.getVida());
    }
    
}
