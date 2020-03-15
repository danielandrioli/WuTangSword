package pacotin;

import pacotin.escudos.*;
import pacotin.espadas.*;
import pacotin.loja.PocaoVida;

public class Inventario {
    private Escudo escudo;
    private Espada espada;
    private PocaoVida pocaoVida;
    private int dinheiro;
    private static Inventario inventario;
    
    private Inventario(){
        this.escudo = new EscudoMadeira(); //Escudo inicial
        this.espada = new EspadaMadeira(); //Espada inicial
        this.dinheiro = 100;
    }
    
    public static Inventario getInventario(){
        if(inventario == null){
            inventario = new Inventario();
            return inventario;
        }
        return inventario;
    }
    
    public void ganharDinheiro(int dinheiro){
        this.dinheiro += dinheiro;
    }
    
    public void gastarDinheiro(int gasto){
        this.dinheiro -= gasto;
    }
    
    public int getDinheiro(){
        return dinheiro;
    }
    
    public Escudo getEscudo(){
        return escudo;
    }
    
    public Espada getEspada(){
        return espada;
    }
    
    public PocaoVida getPocoes(){
        return pocaoVida;
    }
    
    public void setPocao(PocaoVida pocao){
        pocaoVida = pocao;
    }
    
    public void trocarEscudo(Escudo novoEscudo){
        this.escudo = novoEscudo;
    }
    
    public void trocarEspada(Espada novaEspada){
        this.espada = novaEspada;
    }
}
