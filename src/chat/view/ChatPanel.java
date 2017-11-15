package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private JButton chatutton;
	private JTextField inputField;
	private JTextArea hatArea;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		
		//initialize GUI data members
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	
	private void stupLayout()
	
	private void setupListeners()
	
}
