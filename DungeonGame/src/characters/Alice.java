package characters;

import items.GameObject;
import java.util.ArrayList;
import java.util.List;

public class Alice {
    private final String name;
    private int health;
    private int size;
    private final List<GameObject> inventory;

    public Alice(String name) {
        this.name = name;
        this.health = 100;
        this.size = 10; // Tamaño normal
        this.inventory = new ArrayList<>();
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
        System.out.println("💔 ¡Perdiste " + damage + " puntos de salud!");
    }

    public void changeSize(int amount) {
        size += amount;
        System.out.println(amount > 0 ? "🌀 ¡Creces!" : "🌀 ¡Encojes!");
        System.out.println("Tamaño actual: " + size);
    }

    public void addItem(GameObject item) {
        inventory.add(item);
        System.out.println("🎁 Obtuviste: " + item.getName());
    }

    public void useItem(int index) {
        if (index >= 0 && index < inventory.size()) {
            GameObject item = inventory.get(index);
            System.out.println("Usas: " + item.getName());
            item.interact(this);  // Método correcto de la interfaz

            if (item.isConsumable()) {
                inventory.remove(index);
                System.out.println("El objeto se ha consumido");
            }
        } else {
            System.out.println("Índice de objeto inválido");
        }
    }

    public void showStatus() {
        System.out.println("\n👧=== " + name + " ===");
        System.out.println("❤️ Salud: " + health);
        System.out.println("📏 Tamaño: " + size);
        System.out.println("🎒 Inventario (" + inventory.size() + "):");

        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i+1) + ". " + inventory.get(i).getName());
        }
    }

    // Getters
    public boolean isAlive() { return health > 0; }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getSize() { return size; }
    public List<GameObject> getInventory() { return new ArrayList<>(inventory); }

    /**
     * Método para usar objeto por nombre (alternativa)
     */
    public void useItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().contains(itemName)) {
                useItem(i);
                return;
            }
        }
        System.out.println("No tienes " + itemName + " en tu inventario");
    }
}