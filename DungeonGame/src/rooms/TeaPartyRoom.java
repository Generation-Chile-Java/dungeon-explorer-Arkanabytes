package rooms;

import characters.Alice;
import items.DrinkMePotion;

public class TeaPartyRoom implements Room {
    private boolean visited = false;

    @Override
    public void enter(Alice alice) {
        displayRoomHeader();
        System.out.println("El Sombrerero Loco y la Liebre de Marzo celebran su fiesta de té eterna");

        if (!visited) {
            System.out.println("Te ofrecen una poción 'Bébeme'");
            alice.addItem(new DrinkMePotion());
            visited = true;
        } else {
            System.out.println("Siguen tomando té como si el tiempo no pasara...");
        }
    }

    @Override
    public String getDescription() {
        return "Fiesta de Té del Sombrerero Loco";
    }

    @Override
    public String getRoomIcon() {
        return "🍵";
    }
}