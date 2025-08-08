package characters;

/**
 * Interfaz que define el comportamiento base para todos los enemigos del juego
 */
public interface Enemy {
    /**
     * Obtiene el nombre del enemigo
     * @return String con el nombre
     */
    String getName();

    /**
     * Mensaje que muestra al atacar
     * @return String con el mensaje de ataque
     */
    String getAttackMessage();

    /**
     * Cantidad de daño que inflige
     * @return Entero con el daño
     */
    int getDamage();

    /**
     * Mensaje que muestra al ser derrotado
     * @return String con el mensaje de derrota
     */
    String getDeathMessage();

    /**
     * Obtiene el emoji representativo
     * @return String con el emoji
     */
    default String getIcon() {
        return "👹"; // Emoji por defecto
    }
}