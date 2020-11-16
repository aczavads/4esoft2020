package aula20201116;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.boot.web.embedded.netty.NettyRouteProvider;


public class App extends JDialog {
    private JobQueue jobs = new JobQueue();
    private List<JobConsumer> consumers = new ArrayList<>();
    private List<JobProducer> producers = new ArrayList<>();


    public static void main(String[] args) {        
        App app = new App();
        app.setSize(400,250);
        app.setVisible(true);
    }

    public App() {
        super();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.add(createPanel());
        // this.jobs.queueJob(20);
        // this.jobs.queueJob(15);
        // this.jobs.queueJob(30);
        // this.jobs.queueJob(5);
    }


    private JPanel createPanel() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createRaisedBevelBorder());

        final JPanel firstRowPanel = new JPanel();
        firstRowPanel.setLayout(new BoxLayout(firstRowPanel, BoxLayout.X_AXIS));
        firstRowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);        
        firstRowPanel.add(new JLabel("Producers:   "));        
        final JTextField fieldProducerCount = new JTextField(20);
        final JButton btnAddProducer = new JButton(" + ");
        btnAddProducer.addActionListener(e -> {            
            JobProducer newProducer = new JobProducer(jobs);
            producers.add(newProducer);
            fieldProducerCount.setText(String.valueOf(producers.size()));
            newProducer.start();
        });
        fieldProducerCount.setEnabled(false);
        fieldProducerCount.setMaximumSize(fieldProducerCount.getPreferredSize());
        btnAddProducer.setMaximumSize(btnAddProducer.getPreferredSize());
        firstRowPanel.add(fieldProducerCount);
        firstRowPanel.add(btnAddProducer);
        firstRowPanel.add(Box.createHorizontalGlue());
        
        final JPanel secondRowPanel = new JPanel();
        secondRowPanel.setLayout(new BoxLayout(secondRowPanel, BoxLayout.X_AXIS));
        secondRowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);        
        secondRowPanel.add(new JLabel("Consumers: "));        
        final JTextField fieldConsumerCount = new JTextField(20);
        final JButton btnAddConsumer = new JButton(" + ");
        btnAddConsumer.addActionListener(e -> {            
            JobConsumer newConsumer = new JobConsumer(jobs);
            consumers.add(newConsumer);
            fieldConsumerCount.setText(String.valueOf(consumers.size()));
            newConsumer.start();
        });
        fieldConsumerCount.setEnabled(false);
        fieldConsumerCount.setMaximumSize(fieldConsumerCount.getPreferredSize());
        btnAddConsumer.setMaximumSize(btnAddConsumer.getPreferredSize());
        secondRowPanel.add(fieldConsumerCount);
        secondRowPanel.add(btnAddConsumer);
        secondRowPanel.add(Box.createHorizontalGlue());

        
        final JPanel thirdRowPanel = new JPanel();
        thirdRowPanel.setLayout(new BoxLayout(thirdRowPanel, BoxLayout.X_AXIS));
        thirdRowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);        
        thirdRowPanel.add(new JLabel("Job count:    "));        
        final JTextField fieldJobCount = new JTextField(20);
        fieldJobCount.setEnabled(false);
        fieldJobCount.setMaximumSize(fieldJobCount.getPreferredSize());
        thirdRowPanel.add(fieldJobCount);
        thirdRowPanel.add(Box.createHorizontalGlue());

        //Registrando o listener de nosso padrão Observer para atualizar a UI quando o tamanho da 
        //fila de jobs mudar (tanto para mais quanto para menos).
        this.jobs.addJobQueueListener(jobCount -> {
           fieldJobCount.setText(String.valueOf(jobCount)); 
        });


        panel.add(firstRowPanel);
        panel.add(secondRowPanel);
        panel.add(thirdRowPanel);
        return panel;
    }

}
