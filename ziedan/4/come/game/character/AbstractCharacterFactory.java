package come.game.character;

import come.game.scene.SceneFactory;

public abstract class AbstractCharacterFactory {

    public abstract static class Character {
        protected String name;
        protected int health = 100;
        protected int position;

        public Character(String name) {
            this.name = name;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public abstract void attack(SceneFactory.Scene scene);

        public void getAttackedBy(int damage) {
            this.health -= damage;
            if (this.isDead()) {
                System.out.printf("%s убит%n", this.name);
            }
        }

        public void getHealedBy(int health) {
            this.health += health;

            if (this.health > 100) {
                this.health = 100;
            }
            System.out.printf("%s исцелен на %s. Теперь у него %s здоровья", name, health, this.health);
        }

        public boolean isDead() {
            return health < 0;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public int getPosition() {
            return position;
        }
    }

    public abstract Character makeCharacter();
}
