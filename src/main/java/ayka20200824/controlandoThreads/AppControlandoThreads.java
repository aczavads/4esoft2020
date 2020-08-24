package ayka20200824.controlandoThreads;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AppControlandoThreads extends JDialog {
	private JPanel panel = new JPanel();

	public static void main(String[] args) {
		AppControlandoThreads dialog = new AppControlandoThreads();
		dialog.setSize(300, 250);
		dialog.setVisible(true);
	}

	public AppControlandoThreads() {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JButton btnAddPanel = new JButton("Mew Thread Panel");
		btnAddPanel.addActionListener((e) -> {
			addPanel();
		});
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
		panel.setLayout(boxLayout);
		panel.add(btnAddPanel);
		this.add(panel);
	}

	private void addPanel() {
		ThreadControlPanel panel = new ThreadControlPanel();
		this.panel.add(panel);
		this.revalidate();
	}

}
