package pacotin.escudos;

public final class ListaEscudos {
    private static final int numeroDeEscudos = 3; //TROCAR O NUMERO TOTAL ASSIM QUE UM NOVO ESCUDO FOR CRIADO
    private static Escudo lista[];
    
    private ListaEscudos(){
    }
    
    public static Escudo[] acessarLista(){
        if(lista == null){
            lista = new Escudo[numeroDeEscudos]; 
            lista[0] = new EscudoMadeira();
            lista[1] = new EscudoLatao();
            lista[2] = new EscudoCobre();
            return lista;
        }else{
            return lista;
        }
    }
    
    public static int getNumeroDeEscudos(){
        return numeroDeEscudos;
    }
}
