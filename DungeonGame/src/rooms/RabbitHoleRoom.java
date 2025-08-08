package rooms;

import characters.Alice;
import items.MagicMushroom;

public class RabbitHoleRoom implements Room {
    @Override
    public void enter(Alice alice) {
        displayRoomHeader();
        System.out.println("Caes por la madriguera del conejo...");
        System.out.println("Encuentras un hongo mágico flotando!");
        alice.addItem(new MagicMushroom());
        alice.changeSize(-2); // Alicia se hace más pequeña
    }

    @Override
    public String getDescription() {
        return "Madriguera del Conejo Blanco";
    }

    @Override
    public String getRoomIcon() {
        return "🕳️";
    }
}