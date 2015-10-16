package my.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by Aleksandr_Kolesov  on 26.09.2015.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int DEFAULT_ARRAY_LENGTH = 10;
    private int length = DEFAULT_ARRAY_LENGTH;
    private int i;
    Random random;

    int size;
    Object[] adresses;

    private class Node {

        Item itm;


    }


    public RandomizedQueue()                 // construct an empty randomized queue
    {

        size = 0;
        int i = 0;
        adresses = new Object[length];
        random = new Random();
    }

    public boolean isEmpty()                 // is the queue empty?
    {
        return size == 0;
    }

    public int size()                        // return the number of items on the queue
    {
        return size;
    }

    public void enqueue(Item item)           // add the item
    {

        if (item == null) throw new NullPointerException();
        adresses[i] = item;
        if (adresses.length < ++i) {
            length *= 2;
            Object[] tmp = new Object[length];
            for (int j = 0; j < i; j++) {
                if (adresses[j] != null) {


                }
            }
        }
    }

    public Item dequeue()                    // remove and return a random item
    {
        if (size == 0) throw new NoSuchElementException();
//        int min = Math.min(size, adresses.length);
        int index = randNotNull(adresses.length);
        Item item = (Item) adresses[index];
        adresses[index] = null;
        return item;
    }

    private int randNotNull(int lenth) {
        int index = random.nextInt(lenth);
        if (adresses[index] == null) {
            index = randNotNull(lenth);
        }
        return index;
    }

    public Item sample()                     // return (but do not remove) a random item
    {
        if (size == 0) throw new NoSuchElementException();
        int index = randNotNull(adresses.length);
        return (Item) adresses[index];
    }

    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {


        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return size != 0;
            }

            @Override
            public Item next() {
                if (size == 0) throw new NoSuchElementException();
                return (Item) adresses[randNotNull(adresses.length)];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();

            }
        };
    }

    public static void main(String[] args)   // unit testing
    {

    }
}
