package main.java.mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PeekingIterator<T> implements Iterator<T> {

   List<T> values = new ArrayList<>();
    Iterator<T> iterator;
    T peekValue= null;

    public PeekingIterator(Iterator<T> iterator) {
        this.iterator = iterator;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        if(peekValue == null) {
            if (!iterator.hasNext())  throw new NoSuchElementException();
        }
        peekValue = iterator.next();
        return peekValue;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        if (peekValue !=null) {
            T tempPeekValue = peekValue;
            peekValue = null;
            return tempPeekValue;
        } else {
            //Pickvalue null

            return iterator.next();

        }


    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }


}
