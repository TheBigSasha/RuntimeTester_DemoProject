import RuntimeTester.*;
public class MyBenchmarks {
    public static void main(String args[]){
        MainWindow.launchGrapher(MyBenchmarks.class);
    }

    @benchmark(name="Hello from my own code")
    public static long demoTest(long size){
        return size * 2;
    }

    //To add your own stuff to the graph:
    //Add a method which is: public, static, returns long, takes long as a parameter
    //Add an annotation right above "@benchmark(name = "...")"
    //Profit

    //To add to your arsenal of tools, you can set additional parameters for any method:

    //TODO: Add tests for whatever you want :)
}
