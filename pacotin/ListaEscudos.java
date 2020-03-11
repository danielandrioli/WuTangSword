package pacotin;
import pacotin.escudos.*;

public final class ListaEscudos {
    private static final int numeroDeEscudos = 1; //TROCAR O NUMERO TOTAL ASSIM QUE UM NOVO ESCUDO FOR CRIADO
    
    private ListaEscudos(){
    }
    
    public static Escudo[] acessarLista(){
        Escudo lista[] = new Escudo[numeroDeEscudos]; 
        lista[0] = new EscudoMadeira();
        return lista;
    }
    
    public static int getNumeroDeEscudos(){
        return numeroDeEscudos;
    }
}
