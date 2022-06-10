package ua.edu.sumdu.j2se.litvinyuk.tasks;

import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>{
    protected int count;
     protected ListTypes.types type;

   public abstract Stream<Task> getStream() ;

    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract Task getTask(int index);
    public AbstractTaskList incoming(int from, int to) {

        if (from > to) {
            throw new IllegalArgumentException("Значення from повинно бути меншим за to!");
        }

        AbstractTaskList result = TaskListFactory.createTaskList(type);
        Stream<Task> stream = getStream();
        stream.filter(task -> task.nextTimeAfter(from) > from)
                .filter(task -> task.nextTimeAfter(to) < to)
                .forEach(result::add);
        return result;
    }
}


