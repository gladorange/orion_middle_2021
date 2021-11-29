package animals.cli.commands;


import animals.cli.AnimalView;

public class ShowCatsCommand extends Command {
    public ShowCatsCommand() {
        super(null);
    }

    @Override
    public void run(AnimalView animalView) {
        animalView.showAllCats();
    }
}
