package ua.edu.sumdu.j2se.litvinyuk.tasks;

import java.io.Serializable;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>, Serializable {
     protected int count;
     protected ListTypes.types type;

   public abstract Stream<Task> getStream() ;

    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract Task getTask(int index);

}


