package ua.edu.sumdu.j2se.litvinyuk.tasks;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements Cloneable{


    private String title;
    private LocalDateTime time;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int repeatInterval;
    private boolean active;


        public Task(String title, LocalDateTime time){
            this.title=title;
            this.time=time;
        }
    /**
     * Данный конструктор создает неактивную задачу, которая выполняется один раз.
     *
     * @param title название задачи.
     *
     */
    public Task(String title, LocalDateTime start, LocalDateTime end, int interval) {
        this.title = title;
        this.startTime = start;
        this.endTime = end;
        this.repeatInterval = interval;
    }


    /**
     * Данный конструктор создает неактивную задачу, которая выполняется
     * в заданном промежутке времени с заданным интервалом.
     *
     * @param title    вазвание задачи.
     * @param start    время начала выполнения задачи.
     * @param end      время окончания выполнения задачи.
     * @param interval интервал времени, с которым выполняется задача.
     */


    /**
     * Метод возвращает название задачи.
     *
     * @return название задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод устанавливает название задачи.
     *
     * @param title значение не должно быть пустым или null.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Метод определяет является ли задача активной.
     *
     * @return true - задача активна.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Метод изменяет статус активности задачи.
     *
     * @param active true - задача активна. false - задача неактивна.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Метод возвращает время выполнения задачи.
     *
     * @return в случае если задача повторяемая, возвращается время начала выполнения задачи.
     */
    public LocalDateTime getTime() {
        if (isRepeated()) {
            return startTime;
        } else {
            return time;
        }
    }

    /**
     * Метод устанавливает время выполнения неповторяемой задачи. Если задача была повторяемой
     * метод делает ее неповторяемой.
     *
     * @param time значение должно быть больше 0.
     */
    public void setTime(LocalDateTime time) {
        if (isRepeated()) {
            this.startTime = time;
            this.endTime = time;
            this.repeatInterval = 0;
        }
        this.time = time;
    }

    /**
     * Метод возвращает время начала выполнения повторяемой задачи.
     *
     * @return если задача неповторяемая, возвращается время выполения задачи.
     */
    public LocalDateTime getStartTime() {
        if (isRepeated()) {
            return startTime;
        } else {
            return time;
        }
    }

    /**
     * Метод возвращает время окончания выполения повторяемой задачи.
     *
     * @return если задача неповторяемая, возвращается время выполения задачи.
     */
    public LocalDateTime getEndTime() {
        if (isRepeated()) {
            return endTime;
        } else {
            return time;
        }
    }

    /**
     * Метод возвращает интервал выполнения повторяемой задачи.
     *
     * @return если задача неповторяемая, возвращается 0.
     */
    public int getRepeatInterval() {
        return repeatInterval;
    }

    /**
     * Метод устанавливает время и интервал выполнения повторяемой задачи.
     * Если задача была неповторяемой метод делает ее повторяемой.
     *
     * @param start    значение должно быть больше 0.
     * @param end      значение должно быть больше 0.
     * @param interval значение должно быть больше или равно 1.
     */
    public void setTime(LocalDateTime start, LocalDateTime end, int interval) {
        if (!isRepeated()) {
            this.time = start;
        }
        this.startTime = start;
        this.endTime = end;
        this.repeatInterval = interval;
    }

    /**
     * Метод определяет является ли задача повторяемой.
     *
     * @return true - задача повторяемая.
     */
    public boolean isRepeated() {
        return repeatInterval != 0;
    }

    /**
     * Метод возвращает время выполнения задачи относительно текущего момента времени.
     *
     * @param current текущее время.
     * @return если задача неактивна или завершена возвращается -1.
     */
    public LocalDateTime nextTimeAfter(LocalDateTime current) {
        if (!isActive()) {
            return null;
        }
        if (isRepeated()) {
            if (startTime.isAfter(current)) {
                return startTime;
            } else if (endTime.isBefore(current)) {
                return null;
            } else {
                LocalDateTime nextTaskTime = startTime;
                while (nextTaskTime.isBefore(endTime) || nextTaskTime.isEqual(endTime)) {
                    nextTaskTime = nextTaskTime.plusSeconds(repeatInterval);

                    if (nextTaskTime.isAfter(current) && (nextTaskTime.isBefore(endTime)
                            || nextTaskTime.isEqual(endTime))) {
                        return nextTaskTime;
                    }
                }
                return null;
            }
        } else if (time.isAfter(current)) {
            return time;
        } else {
            return null;
        }
    }


    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", repeatInterval=" + repeatInterval +
                ", active=" + active +
                '}';
    }

    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if (this== o){
            return true;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        Task task = (Task) o;
        return repeatInterval == task.repeatInterval && startTime==task.startTime
                && endTime == task.endTime
                && endTime== task.endTime &&
                time==task.time
                && title==task.title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, startTime, endTime, repeatInterval, active );
    }

    @Override
    public Task clone() {
        try {
            Task clone = (Task) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

