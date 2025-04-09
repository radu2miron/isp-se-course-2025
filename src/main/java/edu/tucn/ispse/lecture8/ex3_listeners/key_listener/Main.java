package edu.tucn.ispse.lecture8.ex3_listeners.key_listener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static final int NUM_OF_ENEMIES = 3;

    public static void main(String[] args) {
        List<Enemy> enemies = new ArrayList<>();

        for (int i = 0; i < NUM_OF_ENEMIES; i++) {
            enemies.add(new Enemy());
        }

        new Win(enemies);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

        // game engine
        for (int i = 0; i < 50; i++) {
            enemies.forEach(enemy ->
                    SwingUtilities.invokeLater(() -> {
                        enemy.setLocation(enemy.getX(), enemy.getY() + 5);
                        enemy.repaint();
                    }));

            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore) {
            }
        }


        //TODO:
        // Move the enemies with a different speed; use Thread.sleep() to pause between movements.
        // Use your imagination to create a little game: keep the score; different levels; pause/restart; etc
    }
}
