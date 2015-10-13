package my.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Aleksandr_Kolesov  on 26.09.2015.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public Deque()                           // construct an empty deque
    {
        size = 0;
        first = last = null;

    }

    public boolean isEmpty()                 // is the deque empty?
    {
        return size == 0;
    }

    public int size()                        // return the number of items on the deque
    {
        return size;
    }

    public void addFirst(Item item)          // add the item to the front
    {

        if (item == null)
            throw new NullPointerException();
        Node tmp = new Node();
        tmp.item = item;
        tmp.previous = null;
        tmp.next = first;
        if (first == null) {
            first = last = tmp;
        } else {
            first.previous = tmp;
            first = tmp;
        }
        size++;


    }

    public void addLast(Item item)           // add the item to the end
    {
        if (item == null)
            throw new NullPointerException();
        Node tmp = new Node();
        tmp.item = item;
        tmp.next = null;
        tmp.previous = last;
        if (last == null) {
            last = first = tmp;
        } else {
            last.next = tmp;
            last = tmp;
        }
        size++;


    }

    public Item removeFirst()                // remove and return the item from the front
    {
        if (size == 0)
            throw new NoSuchElementException();
        Node tmp = first;
        first = first.next;
        size--;
        return tmp.item;
    }

    public Item removeLast()                 // remove and return the item from the end
    {
        if (size == 0)
            throw new NoSuchElementException();
        Node tmp = last;
        last = last.previous;
        last.next = null;
        size--;

        return tmp.item;
    }


    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new Iterator<Item>() {
            private Node itr = first;

            @Override
            public boolean hasNext() {
                return itr != null;
            }

            @Override
            public Item next() {
                if (size == 0) throw new NoSuchElementException();
                Node tmp = itr;
                itr = itr.next;
                return tmp.item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args)   // unit testing
    {
        Deque<String> deque = new Deque<>();
        deque.addFirst("QQ");
        deque.addFirst("QQ2");
        deque.addLast("QQ3");
        deque.addLast("QQ4");

        
        Iterator<String> iterator = deque.iterator();
        for(;;){
            String str = iterator.next();


    }

//        deque.addLast(null);

//        for (String item : deque) {
//            System.out.println(item);
//        }

//        deque.removeFirst();
//        deque.removeLast();

//        System.out.println();
//        for (String item : deque) {
//            System.out.println(item);
//        }
//        deque.removeFirst();
//        deque.removeLast();
//        deque.removeFirst();


    }

}
