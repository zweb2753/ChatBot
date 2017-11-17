package chat.view;

import chat.controller.ChatController;
import javax.swing.JFrame;
/**
 * sets up the frame
 * @author zweb2753
 *
 */
public class ChatFrame extends JFrame
{
	private ChatController appController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}
	/**
	 * all the details and specs of the frame
	 */
	private void setupFrame() 
	{
		this.setResizable(false);
		this.setContentPane(appPanel);
		this.setSize(500,500);
		this.setTitle("Chatbot 2017");
		this.setVisible(true);
	}
}
