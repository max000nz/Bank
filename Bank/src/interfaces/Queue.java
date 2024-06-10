package interfaces;

import bank_classes.UserRequest;

public interface Queue {
    /**
     * isEmpty - checks if the queue is empty or not.
     * 
     * @return true if the queue is empty
     */
    public boolean isEmpty();

    /**
     * dequeue - removes an object from the head of the queue.
     * (FIFO order)
     * 
     * @return the next object in the queue.
     */
    public Object dequeue();

    /**
     * enqueue - inserts an object into the queue.
     * 
     * @param o the object to be enqueued.
     */
    public void enqueue(UserRequest o);
}
