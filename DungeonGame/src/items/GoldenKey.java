package items;

import characters.Alice;

/**
 * Implementación de la llave dorada que abre puertas especiales
 * Patrón de diseño: Singleton (solo debería haber una llave dorada)
 */
public class GoldenKey implements GameObject {
    private static GoldenKey instance;
    private boolean used = false;
    private final String uniqueId;

    private GoldenKey() {
        // Genera un ID único para cada llave
        this.uniqueId = "KEY-" + System.currentTimeMillis();
        System.out.println("¡Una llave dorada brilla con luz propia!");
    }

    public static GoldenKey getInstance() {
        if (instance == null) {
            instance = new GoldenKey();
        }
        return instance;
    }

    @Override
    public String getName() {
        return "🔑 Llave Dorada " + uniqueId.substring(0, 6);
    }

    @Override
    public String getDescription() {
        return "Una llave mágica que puede abrir cualquier puerta en el País de las Maravillas";
    }

    @Override
    public void interact(Alice alice) {
        if (used) {
            System.out.println("La llave ya fue usada y perdió su magia");
            return;
        }

        System.out.println("\n✨ La llave brilla intensamente!");
        System.out.println("Encuentras una puerta oculta que solo esta llave puede abrir");
        System.out.println("¡Obtienes acceso a una sala secreta!");

        // Efecto especial al usarla
        alice.changeSize(0); // Normaliza el tamaño
        alice.takeDamage(-20); // Cura 20 puntos de salud

        used = true;
    }

    @Override
    public boolean isConsumable() {
        return false; // No se consume, pero pierde su magia
    }

    @Override
    public String getIcon() {
        return used ? "🗝️" : "🔑"; // Cambia de icono al ser usada
    }

    /**
     * Método especial para reiniciar la llave
     */
    public void resetKey() {
        this.used = false;
        System.out.println("La llave recupera su brillo mágico");
    }

    /**
     * Verifica si la llave puede usarse
     */
    public boolean isUsable() {
        return !used;
    }
}