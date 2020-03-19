package pacotin.floresta;
import pacotin.Personagem;
import pacotin.VerificacaoDeInput;

public class Floresta {
    private static Floresta floresta;
    private final Personagem personagem;
    private final FlorestaBatalha florestaBatalha;
    
    private Floresta(Personagem personagem){
        this.personagem = personagem;
        this.florestaBatalha = FlorestaBatalha.getFlorestaBatalha(personagem);
    }
    
    public static Floresta getFloresta(Personagem personagem){
        if(floresta == null){
            floresta = new Floresta(personagem);
        }
        return floresta;
    }
    
    public void entrar(){
        int opcao;
        System.out.println("Bem-vindo à floresta, " + personagem.getNome() + "! Fique ligado...");
        do{
            System.out.println("Escolha o que fazer:\n[1] Andar pela floresta - [2] Usar poção de vida - "
                    + "[3] Consultar status - [4] Sair");
            opcao = VerificacaoDeInput.verificarEntreLimites(1, 4);
            switch(opcao){
                case 1: //batalha na floresta
                    if(florestaBatalha.batalhar() == 0){
                        opcao = 4; //Retornou 0 significa que morreu
                    }
                    break;
                case 2:
                    personagem.getInventario().getPocoesVida().usarPocao(personagem);
                    break;
                case 3:
                    personagem.getStatus();
                    break;
                case 4:
                    break;
            }
        }while(opcao != 4);
    }
}
