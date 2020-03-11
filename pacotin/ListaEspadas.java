package pacotin;
import pacotin.espadas.*;

public final class ListaEspadas {
    private static final int numeroDeEscudos = 1; //TROCAR O NUMERO TOTAL ASSIM QUE UMA NOVA ESPADA FOR CRIADA
    
    private ListaEspadas(){
    }
    
    public static Espada[] acessarLista(){
        Espada lista[] = new Espada[numeroDeEscudos]; 
        lista[0] = new EspadaMadeira();
        return lista;
    }
    
    public static int getNumeroDeEscudos(){
        return numeroDeEscudos;
    }
}
