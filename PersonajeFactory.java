// Interfaz base de la fábrica
public interface PersonajeFactory {
    Personaje crearPersonaje(String nombre);
}

// Fábrica específica para Guerreros
class GuerreroFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Guerrero(nombre);
    }
}

// Fábrica específica para Magos
class MagoFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Mago(nombre);
    }
}