package aula20201116;

public class JobConsumer extends Thread {
    private JobQueue jobs;
    private Integer assignedJob = null;

    public JobConsumer(JobQueue jobs) {
        this.jobs = jobs;
    }

    @Override
    public void run() {
        while (true) {
            if (assignedJob == null || assignedJob == 0) {
                try {
                    assignedJob = jobs.getNextJob();
                    if (assignedJob == null) {
                        System.out.println("Nothing to do... " + System.currentTimeMillis() + " " + this);
                        this.sleep(5000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                int workToDo = assignedJob;
                for (int i = assignedJob; i >= 0; i--) {
                    System.out.println("I'm working. Job size " + assignedJob + ", " + i + " left. " + System.currentTimeMillis() + ": " + this);                    
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                assignedJob = null;
            }

        }
    }

}
