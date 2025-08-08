import characters.Alice;
import characters.CheshireCat;
import characters.QueenOfHearts;
import items.*;
import rooms.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🐇✨ ¡Alicia en el País de las Maravillas! ✨🐇");
        System.out.print("📝 Ingresa tu nombre: ");
        Alice alice = new Alice(scanner.nextLine());

        // Configuración del mundo de juego
        Room[] wonderland = createWonderlandAdventure();

        System.out.println("\n🌠 ¡Comienza la aventura, " + alice.getName() + "! 🌠");

        exploreWonderland(alice, wonderland, scanner);
        showFinalResult(alice);

        scanner.close();
    }

    private static Room[] createWonderlandAdventure() {
        return new Room[] {
                new RabbitHoleRoom(),
                new EmptyRoom(),
                new TreasureRoom(new MagicMushroom()),
                new TeaPartyRoom(),
                new EnemyRoom(new CheshireCat()),
                new TreasureRoom(GoldenKey.getInstance()),
                new EnemyRoom(new QueenOfHearts())
        };
    }

    private static void exploreWonderland(Alice alice, Room[] wonderland, Scanner scanner) {
        for (int i = 0; i < wonderland.length && alice.isAlive(); i++) {
            Room currentRoom = wonderland[i];
            currentRoom.enter(alice);
            alice.showStatus();

            if (i < wonderland.length - 1 && alice.isAlive()) {
                System.out.print("\n⏎ Presiona Enter para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void showFinalResult(Alice alice) {
        System.out.println("\n🌈=== Fin del Viaje ===");
        if (alice.isAlive()) {
            System.out.println("🎉 ¡Lograste escapar del País de las Maravillas! 🎉");
            System.out.println("Inventario final:");
            alice.getInventory().forEach(item ->
                    System.out.println(" - " + item.getName()));
        } else {
            System.out.println("💀 ¡Has sido atrapada para siempre en este mundo loco! 💀");
        }
    }
}