package interfaces;

import java.util.LinkedList;

import bank_classes.UserRequest;

public class QueueAsList implements Queue {
    private LinkedList<UserRequest> lst;

    public QueueAsList() {
        lst = new LinkedList<UserRequest>();
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }

    public Object dequeue() {
        return lst.removeFirst();
    }

    public void enqueue(UserRequest o) {
        lst.addLast(o);
    }
}
