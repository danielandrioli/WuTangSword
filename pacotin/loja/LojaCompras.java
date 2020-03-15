package pacotin.loja;
import pacotin.Personagem;
import pacotin.VerificacaoDeInput;
import pacotin.escudos.*;
import pacotin.espadas.*;

public class LojaCompras {
    private static LojaCompras lojaCompras;
    private final Personagem personagem;
    private final Escudo listaEscudosLoja[];
    private final Espada listaEspadasLoja[];
    private final PocaoVida pocaoVida;
    
    private LojaCompras(Personagem personagem, Escudo listaEscudos[], Espada listaEspadas[]){
        this.personagem = personagem;
        this.listaEscudosLoja = listaEscudos;
        this.listaEspadasLoja = listaEspadas;
        pocaoVida = new PocaoVida();//Ainda estou estudando se esse é o meio mais viável...
        personagem.getInventario().setPocao(pocaoVida);
    }
    
    public static LojaCompras getCompras(Personagem personagem, Escudo listaEscudos[], Espada listaEspadas[]){
        if(lojaCompras == null){
            lojaCompras = new LojaCompras(personagem, listaEscudos, listaEspadas);
        }
        return lojaCompras;
    }
    
    public void comprar(){
        int opcao;
        do{
            System.out.println("\nMenu de compras: [1] Escudos - [2] Espadas - [3] Poções de vida - "
                    + "[4] Super-poderes - [5] Voltar.\nDinheiro disponível: $ " + personagem.getInventario().getDinheiro()); 
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
        }while(opcao != 5);
    }
    
    private void comprarEscudos(){
        int opcao;
        int c;
        for(c = 0; c < listaEscudosLoja.length; c++){
            System.out.println("[" + (c + 1) + "] " + listaEscudosLoja[c].getNome() + " (" + listaEscudosLoja[c].getDefesa() 
            + " def) -  $ " + listaEscudosLoja[c].getPrecoCompra());
        }
        System.out.println("[" + (c + 1) + "] Voltar.");
        opcao = VerificacaoDeInput.verificarEntreLimites(1, listaEscudosLoja.length + 1); //+1 pq o vetor começa em 0
        
        if(opcao != c + 1){ //c + 1 é a saída
            if(listaEscudosLoja[opcao - 1].getPrecoCompra() > personagem.getInventario().getDinheiro()){
                System.out.println("Você não tem dinheiro suficiente!");
            }else if(personagem.getInventario().getEscudo() != null){
                System.out.println("Você já tem um escudo! Venda ele primeiro!");
            }else if(personagem.getInventario().getEspada().getDuasMaos()){
                System.out.println("Você tem uma espada de duas mãos! Não há como carregar um escudo junto!");
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
            System.out.println("[" + (c + 1) + "] " + listaEspadasLoja[c].getNome() + " (" + listaEspadasLoja[c].getAtaque()
            + " atk) -  $ " + listaEspadasLoja[c].getPrecoCompra());
        }
        System.out.println("[" + (c + 1) + "] Voltar.");
        opcao = VerificacaoDeInput.verificarEntreLimites(1, listaEspadasLoja.length + 1); //+1 pq o vetor começa em 0 
        
        if(opcao != c + 1){ //c + 1 é a saída
            if(listaEspadasLoja[opcao - 1].getPrecoCompra() > personagem.getInventario().getDinheiro()){
                System.out.println("Você não tem dinheiro suficiente!");
            }else if(personagem.getInventario().getEspada() != null){
                System.out.println("Você já tem uma espada! Venda ela primeiro!");
            }else if(listaEspadasLoja[opcao - 1].getDuasMaos() && personagem.getInventario().getEscudo() != null){
                System.out.println("Você está tentando comprar uma espada de duas mãos e primeiro deve se desfazer do escudo!");
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
            personagem.getInventario().gastarDinheiro(opcao * pocaoVida.getPreco());
            System.out.println(opcao + " poções compradas! Seu dinheiro atual: " + personagem.getInventario().getDinheiro());
        } else{
            System.out.println("Você não tem dinheiro suficiente!");
        }
            
    }
    
    
}
