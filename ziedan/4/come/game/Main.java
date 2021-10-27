package come.game;



import come.game.scene.SceneFactory;


public class Main {


    public static void main(String[] args) {
        SceneFactory sceneFactory = new SceneFactory();
        SceneFactory.Scene scene = sceneFactory.makeScene();

        Simulator simulator = new Simulator(scene);

        while (!simulator.isGameOver()) {
            simulator.simulateRandomAttack();
        }

    }
}
