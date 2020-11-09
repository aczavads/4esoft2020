package aula20201109;

public class Worker extends Thread {
    private Job currentJob = new Job(0);
    private int workDone;


    public synchronized void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }

    @Override
    public void run() {
        System.out.println("Começando a trabalhar...");
        while (true) {            
            try {
                synchronized (this) {
                    while (workDone == currentJob.getSize()) {
                        this.wait();
                    }
                }                   
                this.sleep(1000); 
                workDone++;
                System.out.println(this.toString() + "==>" + workDone);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
