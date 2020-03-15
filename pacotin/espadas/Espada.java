package pacotin.espadas;
public abstract class Espada {
    protected String nome;
    protected String descricao;
    protected int ataque;
    protected boolean duasMaos;
    protected int precoCompra;
    protected int precoVenda;
    
    public String getNome(){
        return nome;
    }
    
    public String getDescricao(){
        return descricao;
    }

    public int getAtaque(){
        return ataque;
    }

    public boolean getDuasMaos(){
        return duasMaos;
    }
    
    public int getPrecoCompra(){
        return precoCompra;
    }

    public int getPrecoVenda(){
        return precoVenda;
    }
}
