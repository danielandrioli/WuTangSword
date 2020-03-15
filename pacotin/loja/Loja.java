package pacotin.loja;
import pacotin.Personagem;
import pacotin.VerificacaoDeInput;
import pacotin.escudos.*;
import pacotin.espadas.*;

public class Loja {
    private static Loja loja;
    private final Personagem personagem;
    private final Escudo listaEscudosLoja[]; // =  ListaEscudos.acessarLista();
    private final Espada listaEspadasLoja[]; // = ListaEspadas.acessarLista(); SE DER ERRO, FAZER ASSIM
    private final LojaCompras secaoCompras;
    private final LojaVendas secaoVendas;
    
    private Loja(Personagem p1){
        this.listaEscudosLoja =  ListaEscudos.acessarLista();
        this.listaEspadasLoja = ListaEspadas.acessarLista();
        personagem = p1;
        secaoCompras = LojaCompras.getCompras(personagem, listaEscudosLoja, listaEspadasLoja);
        secaoVendas = LojaVendas.getVendas(personagem, listaEscudosLoja, listaEspadasLoja);
    }
    
    public static Loja getLoja(Personagem personagem){
        if(loja == null){
            loja = new Loja(personagem);
        }
        return loja;
    }
    
    public void acessarLoja(){
        int opcao;
        System.out.println("Bem-vindo à loja, " + personagem.getNome() + "!");
        do{
            System.out.println("[1] Comprar - [2] Vender - [3] Sair da loja.");
            opcao = VerificacaoDeInput.verificarEntreLimites(1, 3);
            switch(opcao){
                case 1:
                    secaoCompras.comprar();
                    //comprar();
                    break;
                case 2:
                    secaoVendas.vender();
                    //vender();
                    break;
                case 3:
                    System.out.println("Até logo!");
                    break;
            }
        }while(opcao != 3);
    }
 /*   
    private void comprar(){
        int opcao;
        do{
            System.out.println("\nMenu de compras: [1] Escudos - [2] Espadas - [3] Poções de vida - "
                    + "[4] Super-poderes - [5] Voltar."); 
            opcao = VerificacaoDeInput.verificarEntreLimites(1, 5);
            switch(opcao){
                case 1:
                    comprarEscudos();
                    break;
                case 2:
                    comprarEspadas();
                    break;
                case 3:
                    comprarPocoesVida();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }while(opcao != 3);
    }
    
    private void comprarEscudos(){
        int opcao;
        int c;
        for(c = 0; c < listaEscudosLoja.length; c++){
            System.out.println("[" + (c + 1) + "] " + listaEscudosLoja[c].getNome() + " - " + listaEscudosLoja[c].getDefesa() 
            + " def -  $ " + listaEscudosLoja[c].getPrecoCompra());
        }
        System.out.println("[" + (c + 1) + "] Sair.");
        opcao = VerificacaoDeInput.verificarEntreLimites(1, listaEscudosLoja.length + 1); //+1 pq o vetor começa em 0
        
        if(opcao != c + 1){ //c + 1 é a saída
            if(listaEscudosLoja[opcao - 1].getPrecoCompra() > personagem.getInventario().getDinheiro()){
                System.out.println("Você não tem dinheiro suficiente!");
            }else if(personagem.getInventario().getEscudo() != null){
                System.out.println("Você já tem um escudo! Venda ele primeiro!");
            }else{
                personagem.getInventario().trocarEscudo(listaEscudosLoja[opcao - 1]);
                personagem.getInventario().gastarDinheiro(listaEscudosLoja[opcao - 1].getPrecoCompra());
                System.out.println("Oh, um " + listaEscudosLoja[opcao - 1].getNome() + "! " + 
                        listaEscudosLoja[opcao - 1].getDescricao());
                System.out.println("Você gastou $" + listaEscudosLoja[opcao - 1].getPrecoCompra()
                        + " e agora tem $" + personagem.getInventario().getDinheiro());
            }
        }
    }//Da pra colocar um timer aqui?
    private void comprarEspadas(){
        int opcao;
        int c;
        for(c = 0; c < listaEspadasLoja.length; c++){
            System.out.println("[" + (c + 1) + "] " + listaEspadasLoja[c].getNome() + " - " + listaEspadasLoja[c].getAtaque()
            + " atk -  $ " + listaEspadasLoja[c].getPrecoCompra());
        }
        System.out.println("[" + (c + 1) + "] Sair.");
        opcao = VerificacaoDeInput.verificarEntreLimites(1, listaEspadasLoja.length + 1); //+1 pq o vetor começa em 0 
        
        if(opcao != c + 1){ //c + 1 é a saída
            if(listaEspadasLoja[opcao - 1].getPrecoCompra() > personagem.getInventario().getDinheiro()){
                System.out.println("Você não tem dinheiro suficiente!");
            }else if(personagem.getInventario().getEspada() != null){
                System.out.println("Você já tem uma espada! Venda ela primeiro!");
            }else{
                personagem.getInventario().trocarEspada(listaEspadasLoja[opcao - 1]);
                personagem.getInventario().gastarDinheiro(listaEspadasLoja[opcao - 1].getPrecoCompra());
                System.out.println("Oh, uma " + listaEspadasLoja[opcao - 1].getNome() + "! " + 
                        listaEspadasLoja[opcao - 1].getDescricao());
                System.out.println("Você gastou $" + listaEspadasLoja[opcao - 1].getPrecoCompra()
                        + " e agora tem $" + personagem.getInventario().getDinheiro());
            }
        }
    }
    
    private void comprarPocoesVida(){
        int opcao;
        System.out.println("Quantas poções mágicas você gostaria de comprar?");
        opcao = VerificacaoDeInput.verificarValorInteiroPositivo();
        if(opcao == 0){
            System.out.println("Humm... Nenhuma, então...");
        } else if(personagem.getInventario().getDinheiro() >= (opcao * pocaoVida.getPreco())){
            personagem.getInventario().getPocoes().comprar(opcao);
        } else{
            System.out.println("Você não tem dinheiro suficiente!");
        }
            
    }
*/    
/*    private void vender(){
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
*/
}
