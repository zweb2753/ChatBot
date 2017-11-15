package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatDisplay;
import chat.view.ChatFrame;

public class ChatController 
{
	private Chatbot chatbot;
	private ChatDisplay display;
	private ChatFrame appFrame;
	
	public ChatController()
	{
		chatbot = new Chatbot("Zane Weber");
		display = new ChatDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		//while (Chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		//{
		//	response = popupChat(response);
		//	response = display.collectResponse(response);
		//}
	}
	
	public String interactWithChatbot(String input)
	{
		return null;
	}
	
	private String popupChat(String chat) 
	{
		//assigns a valid value to a variable that will be returned for the method.
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	
	
}
