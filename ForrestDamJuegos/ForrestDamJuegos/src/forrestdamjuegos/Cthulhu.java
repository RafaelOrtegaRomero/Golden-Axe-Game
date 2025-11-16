/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forrestdamjuegos;

/**
 *
 * @author Rafae
 */
public class Cthulhu {
    protected int vida,fuerza;
    protected  boolean estaVivo;

    public Cthulhu(int jugadores) {
        this.fuerza=1;
        this.vida=20+2*jugadores;
        this.estaVivo=true;
        
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

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }
    
    
}
