public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(String nombre1, String nombre2) {
        PersonajeFactory fGuerrero = new GuerreroFactory();
        this.jugador1 = fGuerrero.crearPersonaje(nombre1);
        this.jugador1.equiparArma(new Espada());

        PersonajeFactory fMago = new MagoFactory();
        this.jugador2 = fMago.crearPersonaje(nombre2);
        this.jugador2.equiparArma(new Hechizo());
    }

    public void iniciarPelea() {
        System.out.println("\n--- COMIENZA LA PELEA ---");
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }
        
        System.out.println("\n--- RESULTADO ---");
        if (jugador1.estaVivo()) System.out.println(jugador1.getNombre() + " HA GANADO LA PELEA.");
        else System.out.println(jugador2.getNombre() + " HA GANADO LA PELEA.");
    }

    private void turno(Personaje atacante, Personaje defensor) {
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " queda con " + defensor.getPuntosDeVida() + " puntos de vida.\n");
    }
}