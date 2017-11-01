package chat.controller;

import chat.model.Chatbot;

public class ChatController 
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatbotController()
	{
		chatbot  new Chatbot("Zane Weber");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while (Chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response;)
		}
	}
	
	public String interactWitChatbot(String input)
	
	private String popupChat(String chat) {
		return null;
	}
}
