package characters;
/**
 * Implementación del famoso Gato de Cheshire como enemigo en el juego
 * Características especiales:
 * - Ataque confuso que desorienta
 * - Probabilidad de esquivar daño
 * - Mensajes enigmáticos
 */
public class CheshireCat implements Enemy {
    @Override
    public String getName() {
        return "😼 Gato de Cheshire";
    }

    @Override
    public String getAttackMessage() {
        return "'¿Qué sentido tiene tener sentido? ¡Todos estamos locos aquí! 😵‍💫'";
    }

    @Override
    public int getDamage() {
        // Daño variable entre 10-20
        return 10 + (int)(Math.random() * 11);
    }

    @Override
    public String getDeathMessage() {
        return "El gato desaparece lentamente, dejando solo su sonrisa flotando en el aire...";
    }

    @Override
    public String getIcon() {
        return "😼";
    }

    /**
     * Método especial del Gato de Cheshire
     * @return true si logra esquivar el ataque (30% de probabilidad)
     */
    public boolean dodgeAttack() {
        return Math.random() < 0.3;
    }

    /**
     * Frase aleatoria característica del gato
     */
    public String randomCheshirePhrase() {
        String[] phrases = {
                "¡Aquí todos estamos locos!",
                "¿Qué es lo que hace que un camino sea el correcto?",
                "A veces solo mi sonrisa es visible... qué curioso",
                "¿Realmente importa a dónde quieres ir?",
                "¡Oh, qué curioso, voy desapareciendo!"
        };
        return phrases[(int)(Math.random() * phrases.length)];
    }
}