package ua.edu.sumdu.j2se.litvinyuk.tasks.model;



import java.util.*;
import java.util.stream.Stream;

public class LinkedTaskList extends AbstractTaskList implements Cloneable {
    private Node head;
    private int size;

    @Override
    public Stream<Task> getStream() {
        return Stream.of(listToArray());
    }

    public void add(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Задача не должна быть null");
        }
        if (head == null) {
            head = new Node(task);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(task));
        }
        size++;
    }

    public boolean remove(Task task) {


        if (task == null) {
            throw new NullPointerException();
        }

        Node temp = head;
        if (task == head.getNodetask()) {
            head = head.getNext();
            size--;
            return true;
        }

        while (temp != null) {
            if (temp.getNext().getNodetask() == task) {
                temp.setNext(temp.getNext().getNext()); //[1]->[3]->[4]
                size--;
                return true;
            } else {
                temp = temp.getNext();

            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Task getTask(int index) {

        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
        int current = 0;
        Node temp = head;
        while (temp != null) {
            if (current == index) {
                break;
            }
            current++;
            temp = temp.getNext();
        }
        return temp.getNodetask();
    }


    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }


        @Override
        public Iterator<Task> iterator() {
            return new Iterator<Task>() {
                private Node current = head;
                private Node lastReturned;
                private int nextIndex;

                @Override
                public boolean hasNext() {
                    return nextIndex < size;
                }

                @Override
                public Task next() {
                    if (!hasNext())
                        throw new NoSuchElementException();

                    lastReturned = current;
                    current = current.next;
                    nextIndex++;
                    return lastReturned.nodetask;
                }

                @Override
                public void remove() {
                    if (lastReturned == null)
                        throw new IllegalStateException();

                    Node lastNext = lastReturned.next;
                    LinkedTaskList.this.remove(lastReturned.nodetask);
                    if (current.equals(lastReturned))
                        current = lastNext;
                    else
                        nextIndex--;
                    lastReturned = null;
                }



        };
    }
    private LinkedTaskList superClone() {
        try {
            return (LinkedTaskList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
    @Override
    public LinkedTaskList clone()  {
        LinkedTaskList clone = (LinkedTaskList) superClone();
        // Put clone into "virgin" state
          clone.head  = null;
          clone.size = 0;


        // Initialize clone with our elements
        for (Node x = head; x != null; x = x.next)
            clone.add(x.nodetask);

        return clone;
    }

    private class Node {

        Task nodetask;
        Node next;

        public Node(Task nodetask) {
            this.nodetask = nodetask;
        }

        public Node getNext() {
            return next;
        }

        public void setNodetask(Task nodetask) {
            this.nodetask = nodetask;
        }

        public Task getNodetask() {
            return nodetask;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "nodetask=" + nodetask +
                    ", next=" + next +
                    '}';
        }

    }

    public Task[] listToArray() {
        Task[] arr = new Task[size];
        for (int i = 0; i < size; i++) {
            arr[i] = getTask(i);
        }
        return arr;
    }

    @Override
    public int hashCode() {
        Task[] arr = listToArray();
        return Arrays.hashCode(arr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkedTaskList)) {
            return false;
        }
        LinkedTaskList list = (LinkedTaskList) o;

        Task[] arr1 = listToArray();
        Task[] arr2 = list.listToArray();

        return Arrays.equals(arr1, arr2);
    }
}
