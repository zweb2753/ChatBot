package chat.controller;

import chat.model.Chatbot;

public class ChatController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Zane Weber");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while (Chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}
	
	public String interactWitChatbot(String input)
	
	private String popupChat(String chat) 
	{
		//assigns a valid value to a variable that will be returned for the method.
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	public Chatbot getChatbot()
	
	public PopupDisplay getDisplay()
	
	public ChatFrame getChatFrame()
	
	
	
	
}
