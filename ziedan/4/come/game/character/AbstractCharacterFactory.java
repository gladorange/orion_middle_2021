package come.game.character;

public abstract class AbstractCharacterFactory {

    abstract static class Character {
        protected String name;
        protected int health = 100;

        public void setCurrentPosition(int currentPosition) {
            this.currentPosition = currentPosition;
        }

        protected int currentPosition;

        public Character(String name) {
            this.name = name;
        }

        public abstract void attack(Character character);

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

        public int getCurrentPosition() {
            return currentPosition;
        }
    }

    public abstract Character makeCharacter(String name);
}
