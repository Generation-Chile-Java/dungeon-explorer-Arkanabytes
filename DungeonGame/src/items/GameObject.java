package items;

import characters.Alice;

/**
 * Interfaz que define el comportamiento base para todos los objetos interactuables del juego
 * Implementa el patrón de diseño Strategy para permitir múltiples comportamientos
 */
public interface GameObject {

    /**
     * Obtiene el nombre del objeto incluyendo su emoji representativo
     * @return String con formato "emoji Nombre" (ej. "🍄 Hongo Mágico")
     */
    String getName();

    /**
     * Descripción detallada del objeto para mostrar en el inventario
     * @return String con la descripción del objeto
     */
    String getDescription();

    /**
     * Acción principal al interactuar con el objeto
     * @param alice Referencia al personaje principal para aplicar efectos
     */
    void interact(Alice alice);

    /**
     * Indica si el objeto se consume al usarse
     * @return true si el objeto desaparece después de usarse
     */
    boolean isConsumable();

    /**
     * Obtiene el emoji representativo del objeto
     * @return String con el emoji (valor por defecto "🛍️")
     */
    default String getIcon() {
        return "🛍️"; // Emoji genérico para objetos
    }

    /**
     * Método para mostrar información detallada del objeto
     * @return String formateado con nombre y descripción
     */
    default String getDetailedInfo() {
        return getIcon() + " " + getName() + ": " + getDescription();
    }
}