package animals.cli.commands;


import animals.cli.AnimalView;

public class ShowDogsCommand extends Command {

    public ShowDogsCommand() {
        super(null);
    }

    @Override
    public void run(AnimalView animalView) {
        animalView.showAllDogs();
    }
}
