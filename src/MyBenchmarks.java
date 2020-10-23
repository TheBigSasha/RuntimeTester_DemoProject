import RuntimeTester.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MyBenchmarks{
    public static void main(String args[]){
        MainWindow.launchGrapher(MyBenchmarks.class);   //the class passed to launchGrapher() is the class which it gets extra test methods from.
    }

    //This method does nothing, let it be your canvas :)
    @benchmark(name = "hello world")                      //The @benchmark annotation has a required property "name", all others are optional
    public static long testMethod(long input){            //All benchmark methods must be public, take long, return long
        //My-code-here
        return 0L;
    }

    /**
     * This method gives you the estimated theoretical speed of an O(N^2) sorting algorithm
     *
     * The theoretical = true annotation means that the return of this method will not be used to adjust computation speed
     * The expectedEfficiency tag lets the GUI display the expected speed
     * The category field tells the GUI which category to put this method in.
     *
     * @param size      The amount of stuff in the dataset
     * @return          How long the method took to run
     */
    @benchmark(name = "Nsquared Demo", expectedEfficiency = "o(n^2)", category = "Math demos", theoretical = true)
    public static long nSquared(long size) {          //There is no restriction on method name
        return Math.round(Math.pow(size , 2));        //The x axis plots size and the y axis plots what is returned
    }

    /**
     * This method calculates the time complexity of the built in sort method for ArrayList in java.
     * It randomly generates a dataset outside of time computation, then sorts the ArrayList and
     * computes the runtime.
     *
     * @param size      How big the array is
     * @return          How long it takes to sort
     */
    @benchmark(name = "ArrayList.sort", expectedEfficiency = "O(n log(n))", category = "Java Builtin")
    public static long arraysSort(long size) {
        ArrayList<Date> dataset = new ArrayList<>();
        for (long i = 0; i < size; i++) {
            dataset.add(nextDate());              //nextDate() is a method which randonly generates Java.Util.Date
            //objects, for which you can find source code in the demonstration
            //repository for this library (link below)
        }
        long startTime = System.nanoTime();       //This indicates when the timer on the method starts
        dataset.sort(Date::compareTo);
        long endTime = System.nanoTime();         //This indicates where the timer on the method ends
        return endTime - startTime;
    }

    /**
     * Generates a date matching the format in the teacher supplied debugger
     *
     * @return a date
     */
    private static String nextDateString() {
        Random rand = new Random();
        int year = 2009 + rand.nextInt(11);
        int month = 1 + rand.nextInt(11);
        int day = 1 + rand.nextInt(27);
        int hour = rand.nextInt(23);
        int minute = rand.nextInt(59);
        int second = rand.nextInt(59);
        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append("-");
        if (month < 10) {
            sb.append("0" + month);
        } else {
            sb.append(month);
        }
        sb.append("-");
        if (day < 10) {
            sb.append("0" + day);
        } else {
            sb.append(day);
        }
        sb.append(" ");
        if (hour < 10) {
            sb.append("0" + hour);
        } else {
            sb.append(hour);
        }
        sb.append(":");
        if (minute < 10) {
            sb.append("0" + minute);
        } else {
            sb.append(minute);
        }
        sb.append(":");
        if (second < 10) {
            sb.append("0" + second);
        } else {
            sb.append(second);
        }
        return sb.toString();
    }

    /**
     * Gets the next random date
     * @return a date
     */
    private static Date nextDate(){
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(nextDateString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}