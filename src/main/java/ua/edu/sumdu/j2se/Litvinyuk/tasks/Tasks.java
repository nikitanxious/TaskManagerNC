package ua.edu.sumdu.j2se.litvinyuk.tasks;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Tasks {
     static ListTypes.types type;

    public static Iterable<Task> incoming(
            Iterable<Task> tasks, LocalDateTime start, LocalDateTime end) {

        AbstractTaskList tempListTask = TaskListFactory.createTaskList(type);
        LocalDateTime dateOfTask;

        for (Task smth : tasks) {
            dateOfTask = smth.nextTimeAfter(start);
            if ((dateOfTask != null) && (dateOfTask.compareTo(end) <= 0)) {
                tempListTask.add(smth);
            }
        }
        return tempListTask;
    }
    public static SortedMap<LocalDateTime, Set<Task>> calendar(
            Iterable<Task> tasks, LocalDateTime start, LocalDateTime end) {

        SortedMap<LocalDateTime, Set<Task>> sortedMap = new TreeMap<>();
        Set<Task> set;
        LocalDateTime current;
        for (Task task:tasks) {
            current = task.nextTimeAfter(start);
            while (current != null && !current.isAfter(end)) {
                if (sortedMap.containsKey(current)) {
                    sortedMap.get(current).add(task);
                }
                else {
                    set = new HashSet<>();
                    set.add(task);
                    sortedMap.put(current, set);
                }
                current = task.nextTimeAfter(current);
            }
        }
        return sortedMap;
    }
    }

