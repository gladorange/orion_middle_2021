package task1.interfaces;

public interface CharacterFactory {

    abstract class Character {

        int health ;
        String name ;
        protected String personType ;

        public Character() {
            this.health = 100;
          }

        public void setName(String name) {
              this.name = name;
          }
        public String getPersonType() {
            return personType;
            }
        public int getHealth() {
              return health;
          }
        public String getName() {return name;}

        public void reduceHealth(int points){
            this.health -= points;
        }
        public void increaseHealth(int points){
              this.health += points;
              if(this.health > 100 ) {
                  this.health = 100;
              }
          }
        public void setHealth(int points){
            this.health = points;
        }

        public abstract void attack(Character[] characters );

      }

    public CharacterFactory.Character  createCharacter();


}
