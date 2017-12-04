package chat.view;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

import chat.controller.ChatController;

public class ChatPanel extends JPanel 
{
	private ChatController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;

	public ChatPanel(ChatController appController) 
	{
		super();
		this.appController = appController;

		// initialize GUI data members
		infoLabel = new JLabel("Type to chat with the chatbot");
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		chatScrollPane = new JScrollPane();

		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}

	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	private void setupPanel() 
	{
		this.add(infoLabel);
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(inputField);
		this.add(chatScrollPane);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}

	private void setupLayout() 
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 174, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 34, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -39, SpringLayout.SOUTH, this);
	}

	private void setupListeners() 
	{
		chatButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click) 
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
	}
}