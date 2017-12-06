package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = LocalTime.now();
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];

		buildVerbs();
		buildShoppingList();
		buildTopics();
		buildFollowUps();
		buildQuestions();
		buildMovieList();
	}

	private void buildTopics()
	{
		
	}
	
	private void buildFollowUps()
	{
		
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildMovieList()
	{
		movieList.add(new Movie("Spiderman"));
		
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("fruits");
		shoppingList.add("donuts");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("floofer");
		cuteAnimalMemes.add("Kittie");
	    cuteAnimalMemes.add("Otter");
	}
	/**
	 * list of questions
	 */
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "Whats your favorite color?";
	    questions[2] = "Whats your favorite sport?";
	    questions[3] = "Whats your favorite movie?";
	    questions[4] = "Whats your favorite animal?";
	    questions[5] = "Whats your favorite class?";
	    questions[6] = "Whats your favorite store?";
	    questions[7] = "Whats your favorite type of music to listen too?";
	    questions[8] = "How old are you?";
	    questions[9] = "What country do you live in?";
	    		
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	/**
	 * takes the usr inpit and processes it as a string
	 * @return
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		
		return response;
	}
	/**
	 * checks the lenght to make sure its not null and greater than 2	
	 * @param input
	 * @return
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
				validLength = true;
		}
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		boolean containshtml = false;
		if (input == null || !input.contains("<"))
		{
			return containshtml;
		}
	int firstOpen = input.indexOf("<");
	int firstClose = input.indexOf(">",firstOpen);
	int secondOpen = -9;
	int secondClose = -9;
	String tagText = "";
	
	
	if (input.contains("<>") || input.indexOf("< >") > -1)
	{
		
		containshtml = false;
	}
	
	if (input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
	{
		containshtml = true;
	}
	
//	else if (firstClose > firstOpen)
//	{
		
	}

	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		if (shoppingItem.contains("protein") || shoppingItem.contains("veggies") || shoppingItem.contains("snacks")
				|| shoppingItem.contains("donuts") || shoppingItem.contains("fruits"));
		{
			return true;
		}
		
	}
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
