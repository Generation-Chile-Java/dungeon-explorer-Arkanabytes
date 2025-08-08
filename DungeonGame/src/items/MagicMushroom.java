package items;

import characters.Alice;

/**
 * Implementación del icónico hongo mágico que altera el tamaño de Alicia
 * Patrón de diseño: State (cambia el estado del personaje)
 */
public class MagicMushroom implements GameObject {
    // Efectos posibles del hongo
    private enum MushroomEffect {
        GROW("¡Creces dramáticamente!", 5),
        SHRINK("¡Te encoges peligrosamente!", -4),
        RANDOM("¡Efecto impredecible!", 0);

        final String message;
        final int sizeChange;

        MushroomEffect(String message, int sizeChange) {
            this.message = message;
            this.sizeChange = sizeChange;
        }
    }

    private boolean consumed = false;

    @Override
    public String getName() {
        return "🍄 Hongo Mágico";
    }

    @Override
    public String getDescription() {
        return "Un hongo peculiar que altera tu tamaño de formas misteriosas";
    }

    @Override
    public void interact(Alice alice) {
        if (consumed) {
            System.out.println("El hongo ya fue consumido");
            return;
        }

        MushroomEffect effect = getRandomEffect();
        int actualChange = effect.sizeChange;

        // Si es efecto aleatorio
        if (effect == MushroomEffect.RANDOM) {
            actualChange = (int)(Math.random() * 7) - 3; // -3 a +3
        }

        System.out.println("\n" + effect.message);
        System.out.println("El hongo brilla con un aura misteriosa...");
        alice.changeSize(actualChange);

        if (isConsumable()) {
            consumed = true;
        }
    }

    @Override
    public boolean isConsumable() {
        return true;
    }

    @Override
    public String getIcon() {
        return "🍄";
    }

    private MushroomEffect getRandomEffect() {
        double chance = Math.random();
        if (chance < 0.4) return MushroomEffect.GROW;
        if (chance < 0.8) return MushroomEffect.SHRINK;
        return MushroomEffect.RANDOM;
    }

    /**
     * Versión alternativa del hongo con efectos específicos
     * @param side 'left' para reducir tamaño, 'right' para aumentar
     */
    public void interact(Alice alice, String side) {
        int change = side.equalsIgnoreCase("left") ? -2 : 3;
        System.out.println("\n¡El hongo " + (change > 0 ? "te agranda!" : "te encoge!"));
        alice.changeSize(change);
        consumed = true;
    }
}