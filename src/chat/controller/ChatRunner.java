package chat.controller;
import chat.view.ChatDisplay;
/**
 * starts the app
 * @author zweb2753
 *
 */
public class ChatRunner 
{
	public static void main(String [ ] args)
	{
		ChatController app = new ChatController();
		app.start();
	}
	
}
