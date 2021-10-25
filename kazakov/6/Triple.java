import java.util.Objects;

public class Triple<T, G, D > {
    T first;
    G second;
    D third;

    Triple(T first, G second, D third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    T getFirst() {
        return first;
    }

    G getSecond() {
        return second;
    }

    D getThird() {
        return third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return first.equals(triple.first) &&
                second.equals(triple.second) &&
                third.equals(triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return  "\"" + first + "\"" +
                "; кол-во оценок: " + second +
                "; рейтинг: " + third;
    }
}
