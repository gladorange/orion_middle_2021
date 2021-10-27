package lection6.tuples;

import java.util.Objects;

public class Triple <T, V, U> extends Pair<T,V>{
    private final U third;

    public Triple(T first, V second, U third) {
        super(first,second);
        this.third = third;
    }

    public U getThird() {
        return third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triple)) return false;
        if (!super.equals(o)) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return getThird().equals(triple.getThird());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getThird());
    }
}
