package pacotin.escudos;
public abstract class Escudo {
    protected String nome;
    protected String descricao;
    protected int defesa;
    protected int precoCompra;
    protected int precoVenda;

    public String getNome(){
        return nome;
    }
    
    public String getDescricao(){
        return descricao;
    }

    public int getDefesa(){
        return defesa;
    }

    public int getPrecoCompra(){
        return precoCompra;
    }

    public int getPrecoVenda(){
        return precoVenda;
    }
}
