package ua.edu.sumdu.j2se.Litvinyuk.tasks;

import java.util.Arrays;

public class ArrayTaskList {

    private Task[] tasklist;
    private int size;

    public ArrayTaskList() {
        tasklist= new Task[10];
    }
    public ArrayTaskList(int size){
        tasklist = new Task[size];
    }

    public void add(Task task){

        if (task != null) {
            if (size == tasklist.length) {
                Task[] newTasksList = new Task[tasklist.length + 10];
                System.arraycopy(tasklist, 0, newTasksList, 0, size());
                tasklist = newTasksList;
            }
            tasklist[size] = task;
            size++;
        }
    }
    public boolean remove(Task task) {
        if (task != null) {
            for (int i = 0; i < size(); i++) {
                if (tasklist[i].getTitle().equals(task.getTitle())) {
                    System.arraycopy(tasklist, (i + 1), tasklist, i, size() - (i + 1));
                    tasklist[size - 1] = null;
                    size--;
                    return true;
                }
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
                '}';
    }
    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList result = new ArrayTaskList();
        for (int i = 0; i < size(); i++) {
            if (getTask(i).nextTimeAfter(from) > from && getTask(i).nextTimeAfter(to) < to) {
                result.add(getTask(i));
            }
        }
        return result;
    }


}
