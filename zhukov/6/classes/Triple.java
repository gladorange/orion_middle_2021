package classes;
import java.util.Objects;

public class Triple <F,S,T>{
    private F first ;
    private S second;
    private T third;

    public Triple(F first, S second, T third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public T getThird() {
        return third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return second.equals(triple.second) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

}
