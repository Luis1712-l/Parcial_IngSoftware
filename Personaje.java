import java.util.Random;

public abstract class Personaje {
    protected String nombre;
    protected int puntosDeVida;
    protected final int MAX_DANO = 30;
    protected final int MIN_DANO = 10;
    
    // EL PUENTE (Bridge): El personaje compone su comportamiento usando la interfaz Arma
    protected Arma arma; 
    protected Random rand = new Random();

    public Personaje(String nombre, int puntosDeVida) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
    }

    public void equiparArma(Arma arma) {
        this.arma = arma;
    }

    public void atacar(Personaje oponente) {
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        
        // Delega la acción a la implementación del puente (si tiene arma)
        if (this.arma != null) {
            dano += this.arma.usar(); 
        }
        
        System.out.println(this.getNombre() + " ataca causando " + dano + " puntos de daño.");
        oponente.recibirDano(dano);
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) this.puntosDeVida = 0;
    }

    public boolean estaVivo() { return this.puntosDeVida > 0; }
    public String getNombre() { return this.nombre; }
    public int getPuntosDeVida() { return this.puntosDeVida; }
}