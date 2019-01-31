package Thread;

import java.util.ArrayList;
import java.util.Random;

public class RunnableTest {
    public static void main(String args[]) throws InterruptedException{

        System.out.println("Start main method.");

        Runnable r = new ConcreteRunnable();
        ArrayList<Thread> threadList = new ArrayList<Thread>();

        for(int i = 0; i < 10; i++){

            Thread test = new Thread(r);

            test.start();
            threadList.add(test);
        }

        for(Thread t : threadList)
            t.join();

        System.out.println("End main method.");

    }
}



class ConcreteRunnable implements Runnable{

    private int index = 0;

    @Override
    public void run(){

        Random r = new Random(System.currentTimeMillis());

        long s = r.nextInt(3000);
        try{
            Thread.sleep(s);
        }catch (InterruptedException e){ e.printStackTrace();}
        addIndex();

    }


    synchronized void addIndex(){
        index++;
        System.out.println("current index value : " + index);
    }


}



