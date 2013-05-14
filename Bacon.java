package leBrowser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Bacon extends JFrame {
  private JTextField adressbar;
	private JEditorPane display;
	
	public Bacon() {
		super("Le Browser");
		
		adressbar = new JTextField("Enter a URL!");
		adressbar.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						loadHTML(event.getActionCommand());
					}
				}
		);
		add(adressbar, BorderLayout.NORTH);
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener() {
					@Override
					public void hyperlinkUpdate(HyperlinkEvent event) {
						if (event.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
							loadHTML(event.getURL().toString());
						}
					}
				}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
	
	private void loadHTML(String userText) {
		try {
			if (userText.startsWith("http://") && !userText.startsWith("http://www.")) {
				display.setPage("www."+userText);
			} else if (userText.startsWith("http://www.")) {
				display.setPage(userText);
			} else {
				display.setPage("http://www."+userText);
			}
			adressbar.setText(userText);
		} catch (Exception e) {
			System.out.println("Crap!");
		}
	}
}

