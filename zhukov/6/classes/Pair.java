package classes;

import java.util.Objects;

public class Pair<T,N> {

    private T first;
    private N second;

    public Pair(T first, N second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public N getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(this.first, pair.first) && Objects.equals(this.second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.first, this.second);
    }
}

