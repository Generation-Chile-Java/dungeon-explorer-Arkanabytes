package rooms;

import characters.Alice;

public class EmptyRoom implements Room {
    @Override
    public void enter(Alice alice) {
        displayRoomHeader();
        System.out.println("Una habitación tranquila y vacía. Un respiro en este mundo loco...");
        System.out.println("Recuperas 10 puntos de salud");
        alice.takeDamage(-10); // Curación
    }

    @Override
    public String getDescription() {
        return "Habitación Vacía";
    }

    @Override
    public String getRoomIcon() {
        return "🌌";
    }
}