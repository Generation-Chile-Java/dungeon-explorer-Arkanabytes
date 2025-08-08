package rooms;

import characters.Alice;
import items.GameObject;

public class TreasureRoom implements Room {
    private final GameObject treasure;
    private boolean looted = false;

    public TreasureRoom(GameObject treasure) {
        this.treasure = treasure;
    }

    @Override
    public void enter(Alice alice) {
        displayRoomHeader();
        if (looted) {
            System.out.println("El cofre del tesoro ya está vacío...");
            return;
        }
        System.out.println("¡Has encontrado un tesoro brillante!");
        System.out.println("Contiene: " + treasure.getName());
        alice.addItem(treasure);
        looted = true;
    }

    @Override
    public String getDescription() {
        return "Sala del Tesoro (" + (looted ? "vacía" : treasure.getName()) + ")";
    }

    @Override
    public String getRoomIcon() {
        return looted ? "⚱️" : "💎";
    }
}