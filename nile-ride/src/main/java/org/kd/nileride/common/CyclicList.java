package org.kd.nileride.common;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class CyclicList<T> extends ArrayList<T> {

    private final int capacity;

    @Override
    public boolean add(T t) {
        var success = super.add(t);
        if (this.size() > capacity)
            this.remove(0);
        return success;
    }

    @Override
    public T get(int index) {
        index %= capacity;

        if (index < 0)
            index = capacity + index;
        return super.get(index);
    }

    public CyclicList(int capacity) {
        this.capacity = capacity;
    }

    public void shiftLeft() {
        T stash;
        stash = get(0);

        IntStream.range(1, size()).forEach(i -> this.set(i - 1, this.get(i)));
        add(stash);
    }

    public void shiftRight() {
        T stash;
        stash = get(capacity - 1);

        IntStream.range(0, size() - 1)
                .map(i -> size() - 1 - i)
                .forEach(i -> this.set(i, this.get(i - 1)));
        this.set(0, stash);
    }

    public void shiftLeft(int times){
        while(times > 0){
            shiftLeft();
            times--;
        }
    }

    public void shiftRight(int times){
        while(times > 0){
            shiftLeft();
            times--;
        }
    }

}
