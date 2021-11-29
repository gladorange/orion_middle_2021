package animals.cli.commands;

import animals.cli.AnimalView;

import java.util.List;

public class ShowDogByNameCommand extends Command {
    public ShowDogByNameCommand(List<String> args) {
        super(args);
    }

    @Override
    public void run(AnimalView animalView) {
        animalView.showDogByName(args.get(0));
    }
}
