package ua.edu.sumdu.j2se.Litvinyuk.tasks;

public class LinkedTaskList {
    private Node head;
    private int size;

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

        // int sizebefore = size();


        if (task == null) {
            throw new NullPointerException();
        }

        Node temp = head;
        if(task == head.getNodetask()){
            head = head.getNext();
            size--;
            return true; //true;
        }

        while (temp !=null){
            if(temp.getNext().getNodetask() == task){
                temp.setNext(temp.getNext().getNext()); //[1]->[2]->[3]->[4]
                size--;
                return true;
            } else {
                temp = temp.getNext();

            }
        }
        return  false; //sizebefore == size ? false : true;
    }

    public int size() {return size;}

    public Task getTask(int index) {

        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
            int current = 0;
            Node temp = head;
        while(temp!= null){
            if(current == index){
                break;
            }
            current++;
            temp = temp.getNext();
        }
        return temp.getNodetask();
    }

    public LinkedTaskList incoming(int from, int to) {

        if (from > to) {
            throw new IllegalArgumentException("Значення from повинно бути меншим за to!");
        }
        LinkedTaskList result = new LinkedTaskList();
        for (int i = 0; i < size(); i++) {
            if (getTask(i).nextTimeAfter(from) > from && getTask(i).nextTimeAfter(to) < to) {
                result.add(getTask(i));
            }
        }
        return result;
    }


    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    private static class Node {

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
}
