/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forrestdamjuegos;

/**
 *
 * @author Rafae
 */
public class Jugador {
    
    protected int vida, fuerza;
    protected boolean estaVivo;
    protected String nombre;
    protected Carta[]carta=new Carta[5];

    public Jugador() {

        carta[0] = new Carta("Obtienes un punto de vida",1,0);
        carta[1] = new Carta("Te quitan un punto de vida",-1,0);
        carta[2] = new Carta("Obtienes un punto de fuerza",0,1);
        carta[3] = new Carta("Te quitan un punto de fuerza",0,-1);
        carta[4] = new Carta("Obtienes dos puntos de vida",2,0);
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarta(int numCarta) {
        return carta[numCarta].getFraseCarta();
    }
    
    public int getVidaCarta(String frase){
        int vidaCarta=0;
        
        for(int i=0;i<carta.length;i++){
        if(frase.equals (carta[i].getFraseCarta())){
                vidaCarta=carta[i].getVida();
            }
        }
        
        return vidaCarta;
    }
    
     public int getFuerzaCarta(String frase){
        int fuerzaCarta=0;
        
        for(int i=0;i<carta.length;i++){
        if(frase.equals (carta[i].getFraseCarta())){
                fuerzaCarta=carta[i].getFuerza();
            }
        }
        
        return fuerzaCarta;
    }

 
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
}
