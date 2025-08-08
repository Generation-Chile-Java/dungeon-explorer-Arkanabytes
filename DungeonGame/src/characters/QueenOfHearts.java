package characters;

/**
 * Implementación de la temible Reina de Corazones como jefa final
 * Características especiales:
 * - Alto daño con ataques aleatorios
 * - Frases icónicas del personaje
 * - Mecánica especial de ejecución
 */
public class QueenOfHearts implements Enemy {
    private int executionCount = 0;
    private boolean isEnraged = false;

    @Override
    public String getName() {
        return "👑 Reina de Corazones";
    }

    @Override
    public String getAttackMessage() {
        if (isEnraged) {
            return "'¡OFF WITH THEIR HEAD! 🔪 (¡QUE LE CORTEN LA CABEZA!)' - grita en un frenesí sangriento";
        }
        return "'¡Que le corten la cabeza! 🔪' - ordena con voz helada";
    }

    @Override
    public int getDamage() {
        // Daño base 25-40, aumenta si está enfurecida
        int baseDamage = 25 + (int)(Math.random() * 16);
        return isEnraged ? baseDamage + 15 : baseDamage;
    }

    @Override
    public String getDeathMessage() {
        return "¡La Reina cae de su trono gritando! Los naipes soldados huyen en desbandada...";
    }

    @Override
    public String getIcon() {
        return "👑";
    }

    /**
     * Mecánica especial: Intento de ejecución
     * @return true si la ejecución es exitosa (daño crítico)
     */
    public boolean attemptExecution() {
        executionCount++;
        // Cada 3 turnos intenta ejecución
        if (executionCount % 3 == 0) {
            System.out.println("¡La Reina señala con su cetro y grita '¡EJECUCIÓN INMEDIATA!'");
            return true;
        }
        return false;
    }

    /**
     * Activa el modo enfurecido después de recibir cierto daño
     */
    public void enrage() {
        isEnraged = true;
        System.out.println("¡La Reina entra en furia! Sus ojos brillan con locura sanguinaria");
    }

    /**
     * Grito característico de la Reina
     */
    public String royalDecree() {
        String[] decrees = {
                "¡Todos son culpables hasta que yo diga lo contrario!",
                "¡Mi palabra es ley!",
                "¡El rojo es el único color permitido en mi reino!",
                "¡Cortadles la cabeza a todos! ¡Sí, a todos!",
                "¡Las rosas blancas serán pintadas de rojo con la sangre de los traidores!"
        };
        return decrees[(int)(Math.random() * decrees.length)];
    }
}