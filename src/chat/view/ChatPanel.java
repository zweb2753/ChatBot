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
import javax.swing.JLabel;
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
		chatButton = new JButton("chat");
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 6, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -7, SpringLayout.SOUTH, this);
		chatArea = new JTextArea(10, 25);
		chatScrollPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);

		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}

	private void setupScrollPane()
	{
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatScrollPane.setViewportView(chatArea);
		
				// initialize GUI data members
				infoLabel = new JLabel("Type to chat with the chatbot");
				chatScrollPane.setColumnHeaderView(infoLabel);
				appLayout.putConstraint(SpringLayout.NORTH, infoLabel, 6, SpringLayout.SOUTH, inputField);
				appLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, chatScrollPane);
	}
	private void setupPanel() 
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(chatButton);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}

	private void setupLayout() 
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 34, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -130, SpringLayout.SOUTH, this);
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