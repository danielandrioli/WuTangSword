package pacotin;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class VerificacaoDeInput {
    static Scanner teclado = new Scanner(System.in);
    
    private VerificacaoDeInput(){
    }
    
    public static int verificarEntreLimites(int limite1, int limite2){
        int numero;
        do{
            try{
                System.out.println("Escolha uma opção (" + limite1 + "~" + limite2 +"):");
                numero = teclado.nextInt();
                if(numero < limite1 || numero > limite2){
                    System.out.println("Opção inválida!");
                }
            }catch(InputMismatchException erro){
                System.out.println("Dígito inválido!");
                teclado.next(); //Linha necessária para evitar um bug em loop
                numero = limite1 -1;
            }
        }while(numero < limite1 || numero > limite2);
        return numero;
    }
    
    public static char verificarSimOuNao(){
        char resposta;
        do{
            try{
                System.out.println("Escolha uma opção [S / N]:");
                resposta = teclado.next().charAt(0);
                if(resposta != 's' && resposta != 'S' && resposta != 'n' && resposta != 'N'){
                    System.out.println("Resposta inválida!");
                }
            }catch(InputMismatchException erro){
                System.out.println("Digito inválido!");
                resposta = 'f';
            }
        }while(resposta != 's' && resposta != 'S' && resposta != 'n' && resposta != 'N');
        return resposta;
    }
    
    public static int verificarValorInteiroPositivo(){
        int valor;
        do{
            try{
               valor = teclado.nextInt();
               if(valor < 0){
                   System.out.println("Opção inválida!");
               }
            }catch(InputMismatchException erro){
                System.out.println("Dígito inválido! Responda novamente: ");
                teclado.next(); //Linha necessária para evitar um bug em loop
                valor = -1;
            }
        }while(valor < 0);
        return valor;
    }
}
