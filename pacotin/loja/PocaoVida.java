package pacotin.loja;

import pacotin.Personagem;

public class PocaoVida {
    private int quantidade;
    private final int preco = 25;
    
    public void usarPocao(Personagem personagem){ //Recupera de 50% a 80% da vida total
        if(this.quantidade > 0){
            personagem.curaVida((int)((float)personagem.getVidaTotal() * (0.5 + (float) (Math.random() * (0.8 - 0.5)))));
            this.quantidade -= 1;
        }else{
            System.out.println("Você não tem poção de vida.");
        }
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public int getPreco(){
        return preco;
    }
    
    public void comprar(int quantidade){
        this.quantidade += quantidade;
    }
}
