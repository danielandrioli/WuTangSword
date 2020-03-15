package pacotin.espadas;

public final class ListaEspadas {
    private static final int numeroDeEscudos = 4; //TROCAR O NUMERO TOTAL ASSIM QUE UMA NOVA ESPADA FOR CRIADA
    private static Espada lista[];
    
    private ListaEspadas(){
    }

    public static Espada[] acessarLista(){
        if(lista == null){
            lista = new Espada[numeroDeEscudos]; 
            lista[0] = new EspadaMadeira();
            lista[1]= new EspadaAdaga();
            lista[2] = new EspadaMachete();
            lista[3] = new EspadaDuasMaos();
            return lista;
        }else{
            return lista;
        }
    }
    
    public static int getNumeroDeEscudos(){
        return numeroDeEscudos;
    }
}
