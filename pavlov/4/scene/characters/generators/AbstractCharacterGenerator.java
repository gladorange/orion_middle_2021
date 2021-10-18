package scene.characters.generators;

import scene.characters.generators.ICharacterGenerator;
import scene.characters.generators.IGenerator;

import java.util.Random;

public abstract class AbstractCharacterGenerator implements ICharacterGenerator {
    private IGenerator<Integer> healthGenerator;
    private IGenerator<String> nameGenerator;

    public AbstractCharacterGenerator(IGenerator<Integer> healthGenerator, IGenerator<String> nameGenerator) {
        this.healthGenerator = healthGenerator;
        this.nameGenerator = nameGenerator;
    }

    private static abstract class RandomFieldGenerator<T> implements IGenerator<T> {
        private Random random;

        protected RandomFieldGenerator(Random random) {
            this.random = random;
        }

        public Random getRandom() {
            return random;
        }
    }

    public IGenerator<Integer> getHealthGenerator() {
        return healthGenerator;
    }

    public IGenerator<String> getNameGenerator() {
        return nameGenerator;
    }

    public static final class RangeIntGenerator extends RandomFieldGenerator<Integer> {
        private int min;
        private int max;

        public RangeIntGenerator(Random random, int min, int max) {
            super(random);
            this.min = min;
            this.max = max;
        }

        @Override
        public Integer make() {
            return getRandom().nextInt(max - min) + min;
        }
    }

    public static final class ElementFromArrayGenerator<T> extends RandomFieldGenerator<T> {
        private T[] array;

        public ElementFromArrayGenerator(Random random, T[] array) {
            super(random);
            this.array = array;
        }

        @Override
        public T make() {
            return array[getRandom().nextInt(array.length)];
        }
    }
}
