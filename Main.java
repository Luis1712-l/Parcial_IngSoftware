import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el nombre del jugador 1 (Guerrero con Espada): ");
        String n1 = scanner.nextLine();
        
        System.out.print("Introduce el nombre del jugador 2 (Mago con Hechizo): ");
        String n2 = scanner.nextLine();

        JuegoLucha juego = new JuegoLucha(n1, n2);
        juego.iniciarPelea();
        
        scanner.close();
    }
}