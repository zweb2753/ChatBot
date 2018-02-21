package chat.controller;

import chat.model.CTECTwitter;
import chat.model.Chatbot;
import chat.view.ChatDisplay;
import chat.view.ChatFrame;
import chat.model.Chatbot;
public class ChatController 
{
	private Chatbot chatbot;
	private ChatDisplay display;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	/**
	 * assigns values
	 */
	public ChatController()
	{
		chatbot = new Chatbot("Zane Weber");
		myTwitter = new CTECTwitter(this);
		display = new ChatDisplay();
		appFrame = new ChatFrame(this);
	}
	/**
	 * gets the response and displays the message
	 */
	public void start()
	{
		display.displayText("Welcome to chatbot");
	}
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("goodbye");
		System.exit(0);
	}
	
	private String popupChat(String chat) 
	{
		//assigns a valid value to a variable that will be returned for the method.
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
}
