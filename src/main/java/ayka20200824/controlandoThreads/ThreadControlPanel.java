package ayka20200824.controlandoThreads;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ThreadControlPanel extends JPanel {
	private Thread thread = createThread();
	private JProgressBar progressBar = new JProgressBar(0);
	private JButton button = new JButton("Start");
	private ThreadStatus status = ThreadStatus.NEW; 
	
	public ThreadControlPanel() {
		button.addActionListener((e) -> {
			changeThreadStatus();
		});
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxLayout);
		this.add(Box.createHorizontalGlue());
		this.add(Box.createVerticalGlue());		
		this.add(new JLabel("Progress "));
		this.add(progressBar);
		this.add(button);
	}
	
	private void changeThreadStatus() {
		switch (status) {
		case NEW:
			this.button.setText("Pause");
			this.status = ThreadStatus.RUNNING;
			this.thread.start();
			break;
		case PAUSED:
			this.button.setText("Pause");
			this.status = ThreadStatus.RUNNING;
			synchronized (thread) {
				this.thread.notify();
			}
			break;
		case RUNNING:
			this.button.setText("Restart");
			this.status = ThreadStatus.PAUSED;
			break;
		default:
			break;
		}
		this.revalidate();
		
	}

	private Thread createThread() {
		return new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					try {
						synchronized (thread) {
							while (status == ThreadStatus.PAUSED) {
								this.wait();
							}
						}
						Thread.sleep(100);
						progressBar.setValue(i);
						progressBar.revalidate();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	private static enum ThreadStatus {
		RUNNING, PAUSED, NEW
	}

}
