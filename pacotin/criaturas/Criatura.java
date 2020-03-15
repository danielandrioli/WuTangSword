package pacotin.criaturas;

public abstract class Criatura {
    private int vida;
    private final int vidaTotal;
    private final String nome;
    private final int poder;
    private final String grunhidos[] = new String[3]; //Cada criatura tem 3 grunhidos
    private int lootGold; 
    private final int experiencia;
    private final int numCriatura; //USAR??
    
    public Criatura(String nome,int vidaTotal,int poder,int numCriatura, String g1, String g2, String g3){
        this.nome = nome;
        this.vida = vidaTotal;
        this.vidaTotal = vidaTotal;
        this.poder = poder;
        this.numCriatura = numCriatura;//usar?
        this.grunhidos[0] = g1;
        this.grunhidos[1] = g2;
        this.grunhidos[2] = g3;
        this.experiencia = 4 * this.poder; //VERIFICAR SE ESSA FORMULA É OK...
    }
    
    public int atacar(){
        return (int)(this.poder * (float)Math.random()); //VERIFICAR SE ESSA FORMULA É OK...
    }
    
    public void perdeVida(int perda){
        this.vida -= perda;
    }
    
    public int getVida(){
        return vida;
    }
    
    public int getVidaTotal(){
        return vidaTotal;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int darLoot(){
        return (int)(this.poder * (float)Math.random()); //VERIFICAR SE ESSA FORMULA É OK...
    }
    
    public int getExp(){
        return experiencia;
    }
    
    public final String getGrunhidos() {
        float rando;
        rando = (float) (10 * Math.random());
        if(rando <=4){
            return grunhidos[0];
        } else if(rando <= 8){
            return grunhidos[1];
        }else{
            return grunhidos[2];
        }
    }
}
