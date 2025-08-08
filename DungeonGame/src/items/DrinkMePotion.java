package items;

import characters.Alice;
import java.util.Random;

/**
 * Implementación de la famosa poción que hace encoger a Alicia
 * Patrón de diseño: Decorator (podría extenderse con efectos adicionales)
 */
public class DrinkMePotion implements GameObject {
    private boolean consumed = false;
    private int usesLeft = 3; // Permite usos múltiples
    private final Random random = new Random();

    @Override
    public String getName() {
        return "🧪 Poción 'Bébeme'";
    }

    @Override
    public String getDescription() {
        return "Una pequeña botella con la etiqueta 'BÉBEME'. Reduce tu tamaño";
    }

    @Override
    public void interact(Alice alice) {
        if (consumed) {
            System.out.println("La botella está vacía...");
            return;
        }

        System.out.println("\n¡Glup glup! Bebes la poción misteriosa...");

        // Efecto base de encogimiento
        int shrinkAmount = -2 + random.nextInt(3); // -2 a 0 (variación)
        alice.changeSize(shrinkAmount);

        // 20% de probabilidad de efecto secundario
        if (random.nextDouble() < 0.2) {
            applySideEffect(alice);
        }

        usesLeft--;
        if (usesLeft <= 0) {
            consumed = true;
            System.out.println("La botella se vacía por completo.");
        } else {
            System.out.println("La botella todavía tiene " + usesLeft + " usos.");
        }
    }

    @Override
    public boolean isConsumable() {
        return true; // Se consume después de varios usos
    }

    @Override
    public String getIcon() {
        return "🧪";
    }

    /**
     * Efectos secundarios aleatorios
     */
    private void applySideEffect(Alice alice) {
        int effect = random.nextInt(3);
        switch (effect) {
            case 0:
                System.out.println("¡Te sientes mareada! (Salud -5)");
                alice.takeDamage(5);
                break;
            case 1:
                System.out.println("¡Tu voz se vuelve aguda! (Efecto temporal)");
                // Podría implementarse un sistema de efectos temporales
                break;
            case 2:
                System.out.println("¡Ves el mundo al revés por un momento!");
                break;
        }
    }

    /**
     * Versión alternativa para uso forzado (sin efectos secundarios)
     */
    public void forcedUse(Alice alice) {
        System.out.println("\nBebes toda la poción de un trago!");
        alice.changeSize(-4); // Efecto fuerte
        consumed = true;
    }
}