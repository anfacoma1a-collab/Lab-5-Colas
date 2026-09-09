public class Queue implements QueueInterface{

    QueueNode head;
    QueueNode tail;
    int size = 0;
    boolean isPriorityQueue;

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object extract() {
        return null;
    }

    @Override
    public boolean insert(Object object) {
        return false;
    }

    @Override
    public boolean insert(Object object, int prioridad) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean search(Object object) {
        return false;
    }
}
