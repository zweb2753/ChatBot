package chat.controller;
import chat.view.ChatDisplay;

public class ChatRunner 
{
	public static void main(String [ ] args)
	{
		ChatDisplay sample = new ChatDisplay();
		sample.displayText("asd");
		sample.collectResponse("asdsds");
		ChatController app = new ChatController();
	}
	
}
