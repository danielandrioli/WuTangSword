package pacotin;
public class Personagem {
    private final String nome;
    private int habilidade;
    private int evolucaoHabilidade;
    private int nivel;
    private int vida;
    private int vidaTotal;
    private int criaturasMortas;
    private final int upVida = 10; //up de vida total a cada subida de nível
    private final Inventario inventario;
    private static Personagem perso;
    
    private Personagem(String nome){
        this.nome = nome;
        this.habilidade = 1;
        this.nivel = 1;
        this.vidaTotal = 50;
        this.vida = vidaTotal;
        this.criaturasMortas = 0;
        inventario = Inventario.getInventario();
    }
    public static Personagem getPersonagem(String nome){
        if(perso == null){
            perso = new Personagem(nome);
            return perso;
        }
        return perso;
    }
    
    private void verificaSubidaNivel(){
        if(criaturasMortas == 2 * nivel){
            criaturasMortas = 0;
            nivel++;
            vidaTotal =+ upVida;
            vida =+ upVida;
            System.out.println("Parabéns! Você subiu para o nível " + nivel);
        }
    }
    
    public void matouCriatura(){ //Sempre apos matar uma criatura
        criaturasMortas++;
        verificaSubidaNivel();
    }
    
    public void getStatus(){
        System.out.println("Nome: " + nome + " - " + vida + "/" + vidaTotal);
        System.out.println("Habilidade com espadas: " + habilidade + "\nNível de experiencia: " + nivel);
        System.out.println("Espada: " + (inventario.getEspada() != null?inventario.getEspada().getNome():"nenhuma."));
        System.out.println("Escudo: " + (inventario.getEscudo() != null?inventario.getEscudo().getNome():"nenhum."
                + "\nPoções de vida: " + inventario.getPocoes().getQuantidade()));
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getVida(){
        return vida;
    }
    
    public int getVidaTotal(){
        return vidaTotal;
    }
    
    public void curaVida(int cura){
        if(vida + cura > vidaTotal){
            System.out.println("Você recuperou " + (vidaTotal - vida) + " pontos de vida!");
            vida = vidaTotal;
        }else{
            System.out.println("Você recuperou " + cura + " pontos de vida!");
            vida += cura;
        }
    }
    
    public void perdeVida(int perda){
        vida -= perda;
    }
    
    public int getHabilidade(){
        return habilidade;
    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public int atacar(){
        int ataque;
        ataque = (inventario.getEspada().getAtaque() * ((int) (Math.random()* 5)))  
                + ((int)(Math.random() * 6) * this.habilidade);
        evoluiHabilidade(); //A cada ataque evolui um pouco de habilidade
        return ataque;
    }
    
    private void evoluiHabilidade(){
        evolucaoHabilidade++;
        if(evolucaoHabilidade >= 5 * habilidade){
            habilidade++;
            System.out.println("Parabéns! Você evoluiu para a habilidade " + habilidade + " em espadas!");
            evolucaoHabilidade = 0;
        }
    }
}
