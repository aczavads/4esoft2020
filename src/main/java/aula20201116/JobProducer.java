package aula20201116;

import java.util.Random;

public class JobProducer extends Thread {
    private final JobQueue jobs;

    public JobProducer(JobQueue jobs) {
        this.jobs = jobs;
    }

    @Override
    public void run() {
        final Random r = new Random();
        while (true) {
            try {
                sleep(2000);
                int newJob = (int) (60 * r.nextDouble());
                newJob = newJob == 0 ? 5 : newJob; 
                System.out.println("Creating a new job: size " + newJob + ". " + System.currentTimeMillis() + ", " + this );
                this.jobs.queueJob(newJob);             
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
