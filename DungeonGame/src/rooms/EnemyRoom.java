package rooms;

import characters.Alice;
import characters.Enemy;

public class EnemyRoom implements Room {
    private final Enemy enemy;
    private boolean defeated = false;

    public EnemyRoom(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void enter(Alice alice) {
        displayRoomHeader();
        if (defeated) {
            System.out.println("Los restos de " + enemy.getName() + " yacen en el suelo");
            return;
        }

        System.out.println("¡" + enemy.getName() + " aparece ante ti!");
        System.out.println(enemy.getAttackMessage());
        alice.takeDamage(enemy.getDamage());

        if (alice.isAlive()) {
            System.out.println("¡Lograste sobrevivir al ataque!");
            defeated = true;
        } else {
            System.out.println(enemy.getDeathMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Sala de " + enemy.getName() + (defeated ? " (derrotado)" : "");
    }

    @Override
    public String getRoomIcon() {
        return defeated ? "☠️" : enemy.getIcon();
    }
}