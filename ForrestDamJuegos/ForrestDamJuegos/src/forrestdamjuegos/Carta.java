/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forrestdamjuegos;

/**
 *
 * @author Rafae
 */
public class Carta {
    
    protected String fraseCarta;
    protected int vida;
    protected int fuerza;

    public Carta(String fraseCarta, int vida, int fuerza) {
        this.fraseCarta = fraseCarta;
        this.vida = vida;
        this.fuerza = fuerza;
    }

    public String getFraseCarta() {
        return fraseCarta;
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }
    
    
    
    
}
