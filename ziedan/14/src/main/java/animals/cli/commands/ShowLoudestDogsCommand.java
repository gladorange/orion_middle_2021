package animals.cli.commands;

import animals.cli.AnimalView;

public class ShowLoudestDogsCommand extends Command {
    public ShowLoudestDogsCommand() {
        super(null);
    }

    @Override
    public void run(AnimalView animalView) {
        animalView.showLoudestDog();
    }
}
