package com.example.adam.habittracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This is a simple class that holds the name of a day of the week, and a integer representation
 * of that day. Habit's hold an ArrayList of these that show which days of the week te particular
 * habt occurs on. Equals and hashcode once again overridden, as every instance of Monday should be
 * equivalent.
 * Created by Adam on 9/21/2016.
 */
public class Day
{
    private Integer dayNumber;
    private String fullName;

    public Day(Integer dayOfWeek)
    {
        if(dayOfWeek > 0 && dayOfWeek < 8)
        {
            this.dayNumber = dayOfWeek;
            switch (dayOfWeek)
            {
                case Calendar.SUNDAY:
                    fullName = "Sunday";
                    break;
                case Calendar.MONDAY:
                    fullName = "Monday";
                    break;
                case Calendar.TUESDAY:
                    fullName = "Tuesday";
                    break;
                case Calendar.WEDNESDAY:
                    fullName = "Wednesday";
                    break;
                case Calendar.THURSDAY:
                    fullName = "Thursday";
                    break;
                case Calendar.FRIDAY:
                    fullName = "Friday";
                    break;
                case Calendar.SATURDAY:
                    fullName = "Saturday";
                    break;
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public Integer getDayNumber()
    {
        return dayNumber;
    }

    public static ArrayList<Day> getMultipleDays(ArrayList<Integer> daysOfWeek)
    {
        ArrayList<Day> days = new ArrayList<Day>();
        for(int day : daysOfWeek)
        {
            days.add(new Day(day));
        }

        return days;
    }

    public String getFullName()
    {
        return fullName;
    }

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

        Day day = (Day) o;

        if (dayNumber != day.dayNumber)
        {
            return false;
        }
        return fullName != null ? fullName.equals(day.fullName) : day.fullName == null;

    }

    @Override
    public int hashCode()
    {
        int result = dayNumber;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }
}
