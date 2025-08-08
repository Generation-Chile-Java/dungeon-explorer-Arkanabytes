package rooms;

import characters.Alice;

public interface Room {
    void enter(Alice alice);
    String getDescription();
    default String getRoomIcon() {
        return "🚪"; // Icono por defecto
    }
    default void displayRoomHeader() {
        System.out.println("\n" + getRoomIcon() + "=== " + getDescription() + " ===" + getRoomIcon());
    }
}