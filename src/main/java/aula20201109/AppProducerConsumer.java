package aula20201109;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class AppProducerConsumer extends JDialog {
    private JPanel panel = new JPanel();
    private List<Job> pendingJobs = new ArrayList<>();
    private List<Worker> workers = new ArrayList<>();

    protected void createNewJob(int size) {
        Job newJob = new Job(size);
        JobProgressPanel jobProgressPanel = new JobProgressPanel(newJob);
        this.panel.add(jobProgressPanel);
        this.panel.revalidate();
        this.revalidate();
    }

    public static void main(String[] args) {
        AppProducerConsumer app = new AppProducerConsumer();
        app.setVisible(true);
    }

    private static class JobProgressPanel extends JPanel {
        private Job job;
        private int wordDone = 0;
        private JProgressBar progressBar;

        public JobProgressPanel(Job job) {
            this.progressBar = new JProgressBar(job.getSize());
            this.job = job;
            BoxLayout boxLayout = new BoxLayout(this, BoxLayout.LINE_AXIS);
            this.setLayout(boxLayout);
            this.add(progressBar);
        }

    }

    private class ControlPanel extends JPanel {
        private JTextField jobSize = new JTextField(20);
        private JButton btnAddJob = new JButton("Add Job");
        private JLabel workerCount = new JLabel("0");
        private JButton btnAddWorker = new JButton("Add Worker");        

        public ControlPanel() {
            btnAddJob.addActionListener(e -> {
                int jobSizeAsInt = Integer.parseInt(jobSize.getText());
                System.out.println(jobSizeAsInt);
                createNewJob(jobSizeAsInt);
            });
            btnAddWorker.addActionListener(e -> {
                System.out.println("New worker created!");
                Worker newWorker = new Worker();
                workers.add(newWorker);
                newWorker.start();
            });
            BoxLayout boxLayout = new BoxLayout(this, BoxLayout.LINE_AXIS);            
            this.setLayout(boxLayout);
            this.add(jobSize);
            this.add(btnAddJob);
            this.add(workerCount);
            this.add(btnAddWorker);
        }
        
    }

    public AppProducerConsumer() {
        super();
        panel.setBackground(Color.LIGHT_GRAY);
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.add(new ControlPanel());
        this.add(panel);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
    }
    
}
