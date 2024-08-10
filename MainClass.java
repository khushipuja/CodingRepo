package ProducerConsumerProblem;

public class MainClass {

    public static void main(String args[]){
        SharedQueue sharedQueue = new SharedQueue(3);

        Thread producerThread = new Thread(() -> {
            sharedQueue.add("Item 1");
            sharedQueue.add("Item 2");
            sharedQueue.add("Item 3");
            sharedQueue.add("Item 4");
            sharedQueue.add("Item 5");
        });

        Thread consumerThread = new Thread(() -> {
            sharedQueue.removeItem();
            sharedQueue.removeItem();
            sharedQueue.removeItem();
            sharedQueue.removeItem();
            sharedQueue.removeItem();
        });

        producerThread.start();
        consumerThread.start();
    }
}
