package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatDisplay 
{
	private ImageIcon icon;
	private String windowTitle;
	
	public ChatDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/Chat bot picture.png"));
		windowTitle = "Chatbot says";
	}
public void displayText(String message)
{
	JOptionPane.showMessageDialog(null,  message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
}

public String collectResponse(String question)
{
	String answer = "";
	answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
	
	return answer;
   }
}
