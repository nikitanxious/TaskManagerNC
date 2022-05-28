package ua.edu.sumdu.j2se.litvinyuk.tasks;

public abstract class AbstractTaskList {

     protected ListTypes.types type;

    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract Task getTask(int index);
    public AbstractTaskList incoming(int from, int to) {

        if(from > to) {
            throw new IllegalArgumentException("Значення from повинно бути меншим за to!");
        }

        AbstractTaskList result = TaskListFactory.createTaskList(type);
        for (int i = 0; i < size(); i++) {
            if (getTask(i).nextTimeAfter(from) > from && getTask(i).nextTimeAfter(to) < to) {
                result.add(getTask(i));
            }
        }
        return result;

    }

}
