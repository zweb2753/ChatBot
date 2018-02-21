package chat.view;

import javax.swing.JPanel;
import javax.swing.*;
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
	private JButton tweetButton;
	private JButton tweetButton_1;
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton loadButton_1;
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
		loadButton_1 = new JButton("load");
		saveButton = new JButton("save");
		tweetButton_1 = new JButton("tweet");
		searchButton = new JButton("search");
		
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 6, SpringLayout.SOUTH, tweetButton_1);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton_1, 6, SpringLayout.SOUTH, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton_1, 7, SpringLayout.SOUTH, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton_1, 0, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 0, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -22, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -103, SpringLayout.SOUTH, this);
		chatArea = new JTextArea(10, 25);
		chatScrollPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, -3, SpringLayout.NORTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, inputField, 239, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);

		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
		
		chatButton = new JButton("chat", new ImageIcon(getClass().getResource("/chat/view/images/chat.png")));
		loadButton = new JButton("load", new ImageIcon(getClass().getResource("/chat/view/images/loadglasses.png")));
		saveButton = new JButton("save", new ImageIcon(getClass().getResource("/chat/view/images/save icon.png")));
		tweetButton = new JButton("tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweet icon.png")));
		searchButton = new JButton("search", new ImageIcon(getClass().getResource("/chat/view/images/search icon.png")));
		chatArea = new JTextArea(10, 25);

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
		this.add(loadButton_1);
		chatButton =  new JButton("chat");
		appLayout.putConstraint(SpringLayout.WEST, tweetButton_1, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, loadButton_1);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, loadButton_1);
		this.add(chatButton);
		this.add(saveButton);
		this.add(tweetButton_1);
		this.add(searchButton);
		
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
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
				
		loadButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
}