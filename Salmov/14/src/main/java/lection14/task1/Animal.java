package lection14.task1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Animal {
    private String name;
    private Integer volume;
    public abstract String getAnimalType();
    public abstract String getSoundType();

    @Override
    public String toString() {
        return "\n" + getAnimalType() + "{имя = " + name +
                ", громкость " + getSoundType() + " = " + volume + "}";
    }
}

