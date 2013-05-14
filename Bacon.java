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
		/* since class Bacon extends from JFrame, i'm using the method "SUPER" to access the
		JFrame constructor. That constructor's parameter is the title of the window.
		*/
		
		adressbar = new JTextField("Enter a URL!");
		adressbar.addActionListener(
			//make a listener for the adressbar, and make an anonymous inner class.
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						loadHTML(event.getActionCommand());
						//this is when he presses enter.
						//see function "loadHTML" later on in the file.
					}
				}
		);
		add(adressbar, BorderLayout.NORTH);
		//adress bar added, on the NORTH area of the page
		display = new JEditorPane();
		display.setEditable(false);
		//pages are not editable.. ;)
		display.addHyperlinkListener(
			//hyperlink listeners are when you click links.
				new HyperlinkListener() {
					@Override
					public void hyperlinkUpdate(HyperlinkEvent event) {
						if (event.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
							loadHTML(event.getURL().toString());
							//again, see function "loadHTML" later in the file.
						}
					}
				}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500,300);
		//size to 500,300 by default
		setVisible(true);
		//visible
	}
	
	private void loadHTML(String userText) {
		//function loadHTML
		try {
			//try this code, and if it fails (someone puts a retarded URL), go catch it.
			if (userText.startsWith("http://") && !userText.startsWith("http://www.")) {
				display.setPage("www."+userText);
				//checking if the URL inputted contains http://www. or http:// at all.
			} else if (userText.startsWith("http://www.")) {
				display.setPage(userText);
			} else {
				display.setPage("http://www."+userText);
			}
			adressbar.setText(userText);
		} catch (Exception e) {
			//this is the catch if someone puts a retarded url
			System.out.println("Crap!");
		}
	}
}

