package animals.cli.commands;

import animals.cli.AnimalView;

public class ShowQuietestCatsCommand extends Command {
    public ShowQuietestCatsCommand() {
        super(null);
    }

    @Override
    public void run(AnimalView animalView) {
        animalView.showQuietestCat();
    }
}
