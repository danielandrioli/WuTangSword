package pacotin.loja;
import pacotin.Personagem;
import pacotin.VerificacaoDeInput;
import pacotin.escudos.*;
import pacotin.espadas.*;

public class LojaVendas {
    private static LojaVendas lojaVendas;
    private final Personagem personagem;
    private final Escudo listaEscudosLoja[];
    private final Espada listaEspadasLoja[];
    
    private LojaVendas(Personagem personagem, Escudo listaEscudos[], Espada listaEspadas[]){
        this.personagem = personagem;
        this.listaEscudosLoja = listaEscudos;
        this.listaEspadasLoja = listaEspadas;
    }
    
    public static LojaVendas getVendas(Personagem personagem, Escudo listaEscudos[], Espada listaEspadas[]){
        if(lojaVendas == null){
            lojaVendas = new LojaVendas(personagem, listaEscudos, listaEspadas);
        }
        return lojaVendas;
    }
    
    public void vender(){
        int opcao;
        do{
            System.out.println("\nMenu de vendas: [1] Escudos - [2] Espadas - [3] Voltar.");
            opcao = VerificacaoDeInput.verificarEntreLimites(1, 3);
            switch(opcao){
                case 1:
                    venderEscudos();
                    break;
                case 2:
                    venderEspadas();
                    break;
                case 3:
                    break;
            }
        }while(opcao != 3);
    }
    
    private void venderEscudos(){
        int opcao;
        int c;
        for(c = 0; c < listaEscudosLoja.length; c++){
            System.out.println("[" + (c + 1) + "] " + listaEscudosLoja[c].getNome() + " (" + listaEscudosLoja[c].getDefesa() 
            + " def) -  Preço de venda: $ " + listaEscudosLoja[c].getPrecoVenda());
        }
        System.out.println("[" + (c + 1) + "] Sair.");
        opcao = VerificacaoDeInput.verificarEntreLimites(1, listaEscudosLoja.length + 1); //+1 pq o vetor começa em 0
        if(opcao != c + 1){ //c + 1 é a saída
            if(personagem.getInventario().getEscudo() == null || !personagem.getInventario().getEscudo().getClass().equals(listaEscudosLoja[opcao - 1].getClass())){ //Ficou estranha essa logica, testar com mais escudos 
                System.out.println("Você não tem o " + listaEscudosLoja[opcao - 1].getNome() + "!");
            }else{
                personagem.getInventario().trocarEscudo(null);
                personagem.getInventario().ganharDinheiro(listaEscudosLoja[opcao - 1].getPrecoVenda()); 
                System.out.println("Você vendeu o " + listaEscudosLoja[opcao - 1].getNome() + " e ganhou "
                        + "$" + listaEscudosLoja[opcao - 1].getPrecoVenda()
                        + ". Agora você tem $" + personagem.getInventario().getDinheiro());
            }
        }
    }
    
    private void venderEspadas(){
        int opcao;
        int c;
        for(c = 0; c < listaEspadasLoja.length; c++){
            System.out.println("[" + (c + 1) + "] " + listaEspadasLoja[c].getNome() + " (" + listaEspadasLoja[c].getAtaque() 
            + " atk) -  Preço de venda: $ " + listaEspadasLoja[c].getPrecoVenda());
        }
        System.out.println("[" + (c + 1) + "] Sair.");
        opcao = VerificacaoDeInput.verificarEntreLimites(1, listaEspadasLoja.length + 1); //+1 pq o vetor começa em 0
        
        if(opcao != c + 1){ //c + 1 é a saída
            if(personagem.getInventario().getEspada() == null || !personagem.getInventario().getEspada().getClass().equals(listaEspadasLoja[opcao - 1].getClass())){
                System.out.println("Você não tem a " + listaEspadasLoja[opcao - 1].getNome() + "!");
            }else{
                personagem.getInventario().trocarEspada(null);
                personagem.getInventario().ganharDinheiro(listaEspadasLoja[opcao - 1].getPrecoVenda());
                System.out.println("Você vendeu o " + listaEspadasLoja[opcao - 1].getNome() + " e ganhou "
                        + "$" + listaEspadasLoja[opcao - 1].getPrecoVenda()
                        + ". Agora você tem $" + personagem.getInventario().getDinheiro());
            }
        }
    }
}
