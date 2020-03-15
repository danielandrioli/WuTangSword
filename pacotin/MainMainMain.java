package pacotin;
import pacotin.loja.Loja;
import java.util.Scanner;

public class MainMainMain {
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcao;
        String nome;
        System.out.println("Bem-Vindo! Digite seu nome: ");
        nome = teclado.nextLine();
        Personagem personagem = Personagem.getPersonagem(nome);
        Loja loja = Loja.getLoja(personagem);
        
        do{
        System.out.println("\nMENU:\n[1] Ir para a floresta;\n[2] Acessar a loja;\n[3] Verificar status;"
                + "\n[4] Sair do jogo.");
           opcao = VerificacaoDeInput.verificarEntreLimites(1, 4); 
           switch(opcao){
               case 1:
                   break;
               case 2:
                   loja.acessarLoja();
                   break;
               case 3:
                   personagem.getStatus();
                   break;
               case 4:
                   char resposta;
                   System.out.println("Tem certeza que deseja sair?");
                   resposta = VerificacaoDeInput.verificarSimOuNao();
                   if(resposta == 's' || resposta == 'S'){
                       System.out.println("Até logo!");
                   }else{
                       opcao = 1;
                   }
                   break;
           }
        }while(opcao != 4);
    }
}
