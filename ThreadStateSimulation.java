class ThreadLifeCycle extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is now in the RUNNING state.");
        
        try {
            System.out.println("Thread is entering a WAITING state (using sleep).");
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        synchronized (this) {
            System.out.println("Thread is in a BLOCKED state (within synchronized block).");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread is now in the TERMINATED state.");
    } 
}     

public class ThreadStateSimulation {
    public static void main(String[] args) {
        System.out.println("Thread is in the NEW state (Thread object created).");
        
        ThreadLifeCycle thread = new ThreadLifeCycle();

        System.out.println("Thread is in the RUNNABLE state (Thread is started).");
        thread.start(); 

        try {
            
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
}