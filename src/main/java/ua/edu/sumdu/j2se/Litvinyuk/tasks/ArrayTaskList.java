package ua.edu.sumdu.j2se.litvinyuk.tasks;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList implements Cloneable {

    private Task[] tasklist;
    private int size;
    private int capacity =10;

    public ArrayTaskList() {
        tasklist= new Task[10];
    }
    public ArrayTaskList(int size){
        tasklist = new Task[size];
    }

    @Override
    public Stream<Task> getStream() {
        return Stream.of(tasklist);
    }

    public void add(Task task){
    if(capacity<size+1){
        capacity+=10;
        tasklist = Arrays.copyOf(tasklist,capacity);
    }
        tasklist[size] = task;
            size++;

    }

        public boolean remove(Task task) {

            for (int i = 0; i < size; i++) {
                if (tasklist[i].equals(task) && tasklist[i] == task) {

                    tasklist[i] = null;
                    for (int j = 0; j < size - 1; j++) {
                        if (tasklist[j] == null && tasklist[j + 1] != null) {
                            tasklist[j] = tasklist[j + 1];
                            tasklist[j + 1] = null;
                        }
                    }
                    size--;
                    return true;
                }
            }

            return false;
        }


    public int size(){
        return size;
    }
    public Task getTask(int index){
        return tasklist[index];
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "tasklist=" + Arrays.toString(tasklist) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList tasks = (ArrayTaskList) o;
        return size == tasks.size && capacity == tasks.capacity && Arrays.equals(tasklist, tasks.tasklist);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tasklist);
    }


    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            Task task;
            private int index;
            private int lastRemoved = -1;

            @Override
            public boolean hasNext() {
                return index<size();
            }

            @Override
            public Task next() {
                if (index == size)
                    throw new NoSuchElementException();
                    return tasklist[index++];

            }
            @Override
            public void remove() {
                if (index < 0 || task == null)
                    throw new IllegalStateException();
                ArrayTaskList.this.remove(task);
                index--;
            }


        };
    }

    @Override
    public ArrayTaskList clone() {
            try {
                ArrayTaskList v = (ArrayTaskList) super.clone();
                v.tasklist = Arrays.copyOf(tasklist, size);
                return v;
            } catch (CloneNotSupportedException e) {
                // this shouldn't happen, since we are Cloneable
                throw new InternalError(e);
            }
        }
}

