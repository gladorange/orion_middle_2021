package task4.scene;

import task4.entity.Entity;

import java.util.List;

public class Scene {
    private List<Entity> scene;

    public Scene(List<Entity> scene) {
        this.scene = scene;
    }

    public List<Entity> getScene() {
        return scene;
    }

    public void setScene(List<Entity> scene) {
        this.scene = scene;
    }

    public void addToScene(Entity entity, int position) {
        if(this.getScene().get(position) == null ) {
            System.out.println("Welcome to scene " + entity.getName());
            this.getScene().set(position, entity);
            System.out.println(this.getScene().get(position).getName() + " is on position " + position);
        } else {
            System.out.print("Can't add " + entity.getName() + ".");
            System.out.println("\tPosition is taken, try different one");
        }
    }

    public static void healthCheck(List<Entity> scene) {

        scene.removeIf(entity -> entity != null && entity.getHealthPoints() < 1);

        if(numberOfPlayersCheck(scene) < 2) {
            System.out.println("Game is over");
            System.exit(0);
        }


    }

    public static int numberOfPlayersCheck(List<Entity> scene){
        int count = 0;

        for (Entity entity : scene) {
            if (entity != null) {
                count += 1;
            }
        }
    return count;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "scene=" + scene +
                '}';
    }
}
