package pacotin.floresta;
import java.util.List;
import java.util.Random;
import pacotin.Personagem;
import pacotin.VerificacaoDeInput;
import pacotin.criaturas.*;

public class FlorestaBatalha {
    private static FlorestaBatalha florestaBatalha;
    private final Personagem personagem;
    private final List<Criatura> listaCriaturas;
    private Criatura criatura;
    private final Random aleatorio;
    
    private FlorestaBatalha(Personagem personagem){
        this.personagem = personagem;
        listaCriaturas = ListaCriaturas.getLista();
        aleatorio = new Random();
    }
    
    public static FlorestaBatalha getFlorestaBatalha(Personagem personagem){
        if(florestaBatalha == null){
            florestaBatalha = new FlorestaBatalha(personagem);
        }
        return florestaBatalha;
    }
    
    public int batalhar(){ 
        int opcao;
        System.out.println("Você está andando pela floresta e de repente... "
            + "Um " + getCriatura().getNome() + " (" + criatura.getVida() + "/" + criatura.getVidaTotal() 
            + ") aparece na sua frente!\n" + criatura.getNome() + ": " + criatura.getGrunhidos()
            + "\nO que deseja fazer?");
        do{
            System.out.println("Sua vida: " + personagem.getVida() + "/" + personagem.getVidaTotal());
            System.out.println("[1] Atacar - [2] Usar poção de poder - [3] Usar poção de vida - [4] Dar o fora!");
            opcao = VerificacaoDeInput.verificarEntreLimites(1, 4);
            switch(opcao){
                case 1:
                    voceAtacando();
                    if(criatura.getVida() > 0){
                        acaoDaCriatura();
                    }
                    break;
                case 2:
                    break;
                case 3:
                    personagem.getInventario().getPocoesVida().usarPocao(personagem);
                    break;
                case 4:
                    System.out.println("Corrrrreee diiisgraçaaa!");
                    acaoDaCriatura();
                    break;
            }
            if(criatura.getVida() <= 0){ //Se a criatura morreu...
                personagem.matouCriatura(criatura.darLoot());
                criatura.healPreBatalha(); //Volto a vida normal da criatura pq o objeto sempre é o mesmo.
                opcao = 4;   //variável opcao vira 4 para sair da florestaBatalha
            }else if(verificaSuaMorte() == 0){
                return 0; //Retornar 0 significa que você está morto
            }
            }while(opcao != 4);
            return 1; //Retornar 1 significa que você está vivo
    }
    
    private Criatura getCriatura(){      // 0 a 2 -> possibilidade de vir 3 criaturas diferentes, e a dificuldade vai subindo conforme o nível
        int numAleatorio = aleatorio.nextInt(3) + (personagem.getNivel() -1);  
        if(numAleatorio > listaCriaturas.size()){
            numAleatorio = listaCriaturas.size();
        }
        criatura = listaCriaturas.get(numAleatorio);
        criatura.healPreBatalha();
        return criatura;
    }
    
    private void acaoDaCriatura(){
        int ataque;
        if(personagem.getInventario().getEscudo() != null){
            ataque = criatura.atacar() - personagem.defender();
            if(ataque  < 0){
                ataque = 0;
            }
        }else{
            ataque = criatura.atacar();
        }
        
        System.out.println(criatura.getNome() + ": " + criatura.getGrunhidos());
        System.out.print(criatura.getNome() + " te atacou");
        System.out.println((ataque > 0)?" e você perdeu " + ataque + " pontos de vida!":" e você defendeu completamente!");
        personagem.perdeVida(ataque);
    }
    
    private int verificaSuaMorte(){
        int vivo;
        if(personagem.getVida() <= 0){
            System.out.println("Você morreu! Renascendo no templo...");
            return 0;
        }else{
            return 1;
        }
    }
    
    private void voceAtacando(){
        int ataque;
        if(personagem.getInventario().getEspada() == null){
            System.out.println("Você não tem espada!");
            ataque = 0;
        }else{
            ataque = personagem.atacar();
            if(ataque > criatura.getVida()){
                ataque = criatura.getVida();
            }
        }
        criatura.perdeVida(ataque);
        System.out.println("Você causou " + ataque + " de dano no " + criatura.getNome() + " - (" + criatura.getVida()
        + "/" + criatura.getVidaTotal() + ").");
    }
}
