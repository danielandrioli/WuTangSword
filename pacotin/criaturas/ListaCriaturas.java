package pacotin.criaturas;
import java.util.ArrayList;
import java.util.List;

public class ListaCriaturas {//Vou fazer essa lista de uma maneira diferente das listas de escudos e espadas
    private static ListaCriaturas listaCriaturas;
    private static List<Criatura> lista;
    
    private ListaCriaturas(){
        lista = new ArrayList<>();
        lista.add(new Rato());
        lista.add(new Troll());
        lista.add(new Orc());
        lista.add(new Dwarf());
        lista.add(new WildPauloKogos());
        lista.add(new Cuck());
        lista.add(new GadoFurioso());
    }
    
    public ListaCriaturas getLista(){
        if(listaCriaturas == null){
            listaCriaturas = new ListaCriaturas();
            return listaCriaturas;
        }else{
            return listaCriaturas;
        }
    }
}
