package com.example.adam.habittracker;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Adam on 9/21/2016.
 */
public class Habit implements Serializable
{
    private Date creationDate;
    private String name;
    private ArrayList<Day> days;
    private ArrayList<HabitHistoryElement> history;
    private Boolean complete = false;

    public Habit(String name, ArrayList<Day> days)
    {
        this.days = days;
        this.name = name;
        this.creationDate = new Date();
        history = new ArrayList<HabitHistoryElement>();
    }

    public void complete()
    {
        Log.i("info", "completing habit " + this.name);
        this.complete = true;
        addToHistory();
    }

    private void addToHistory()
    {
        history.add(new HabitHistoryElement(this.complete, this.name));
    }

    public void removeFromHistory(HabitHistoryElement historyElement)
    {
        history.remove(historyElement);
    }

    public void unComplete()
    {
        Log.i("info", "uncompleting habit " + this.name);
        this.complete = false;
    }

    public Boolean isComplete()
    {
        return this.complete;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<HabitHistoryElement> getHistory()
    {
        return history;
    }

    public ArrayList<Day> getDays()
    {
        return days;
    }

    public String daysToString()
    {
        String daysString = new String();

        for(Day day : days)
        {
            daysString +=(day.getFullName() + ", ");
        }

        return daysString;
    }

    @Override
    public String toString()
    {
        String completedString = (complete) ? "Complete!" : "Not Complete...";
        return this.name + " \n " + completedString;
    }

    //TODO: Handle Multiples.
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Habit habit = (Habit) o;

        if (creationDate != null ? !creationDate.equals(habit.creationDate) : habit.creationDate != null)
        {
            return false;
        }
        if (name != null ? !name.equals(habit.name) : habit.name != null)
        {
            return false;
        }
        if (days != null ? !days.equals(habit.days) : habit.days != null)
        {
            return false;
        }
        if (history != null ? !history.equals(habit.history) : habit.history != null)
        {
            return false;
        }
        return complete != null ? complete.equals(habit.complete) : habit.complete == null;

    }

    @Override
    public int hashCode()
    {
        int result = creationDate != null ? creationDate.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (history != null ? history.hashCode() : 0);
        result = 31 * result + (complete != null ? complete.hashCode() : 0);
        return result;
    }
}
