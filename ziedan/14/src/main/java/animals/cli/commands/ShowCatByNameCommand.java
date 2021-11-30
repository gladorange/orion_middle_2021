package animals.cli.commands;

import animals.cli.AnimalView;

import java.util.List;

public class ShowCatByNameCommand extends Command {
    public ShowCatByNameCommand(List<String> args) {
        super(args);
    }

    @Override
    public void run(AnimalView animalView) {
        animalView.showCatByName(args.get(0));
    }
}
