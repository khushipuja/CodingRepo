package ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.List;

public class SharedQueue {

    int maxSize;
    List<String> queue = new ArrayList<>();

    public SharedQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void add(String item){

      System.out.println("Producer thread started ");
        while(queue.size() == maxSize){
            try {

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(item);

        System.out.println("Item added to queue: " + item);
        notifyAll();
    }

    public synchronized void removeItem(){

        while(queue.isEmpty()){
            try{
                // wait releases monitor lock
                // but in stop no monitor lock is released which may cause deadlock
                wait();
                System.out.println("Queue is empty Waiting");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        String item = queue.remove(0);
        System.out.println("Item removed from queue: " + item);
        notifyAll();
    }


}
