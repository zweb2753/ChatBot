package chat.model;

import chat.controller.ChatController;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.ResponseList;
import twitter4j.Paging;
import twitter4j.QueryResult;
import twitter4j.Query;
import twitter4j.Paging;
import twitter4j.GeoLocation;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.HashMap;

public class CTECTwitter 
{
	private ChatController appController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	private long totalWordCount;
	private HashMap<String, Integer> wordsAndCount;
	
	public CTECTwitter(ChatController appController)
	{
		this.appController = appController;
		this.searchedTweets = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.wordsAndCount = new HashMap<String, Integer>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		this.totalWordCount = 0;
		
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			chatbotTwitter.updateStatus(textToTweet + " @ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			appController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			
			appController.handleErrors(otherError);
		}
	}
	
	public String getMostCommonWord(String username)
	{
		String mostCommon = "";
		
		collectTweets(username);
		turnStatusesToWords();
		totalWordCount = tweetedWords.size();
		String [] boring = createIgnoreWordArray();
		trimTheBoringWords(boring);
		
		ArrayList>Map.Entry<String, Integer, V>> sorted = sortHashMap();
		
		String mostCommomWord = sorted.get(0).getKey();
		
		int maxWord = 0;
		
		maxWord = sorted.get(0).getValue();
		
		mostCommon = "the most common word in " + username + "'s"+ searchedTweets.size()+ " tweets is " +
		mostCommonWord + ", and it was used " + maxWord + " times.\nThis is " +
		(DecimalFormat.getPercentInstance().format(((double) maxWord)/totalWordCount)) +
		" of total words; " + totalWordCount + " and is " +
		(DecimalFormat.getPercentInstance().format(((double) maxWord)/wordsAndCount.size())) +
		" of the unique words: " + wordsAndCount.size();
		
		mostCommon += "\n\n" + sortedWords();
		
		return mostCommon;
	}
	
	private void trimTheBoringWords(String [] boringWords)
	{
		for (int index = tweetedWords.size() - 1; index >= 0; index--)
		{
			for (int boringIndex = 0; boringIndex < boringWords.length; boringIndex++))
			{
				if (tweetedWords.get(index).equals(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					boringIndex = Integer.MAX_VALUE;
				}
			}
		}
	}
	
	private void collectTweets(String username)
	{
		searchedTweets.clear();
		tweetedWords.clear();
		
		Paging statusPage = new Paging(1,100);
		int page = 1;
		long lastID = Long.MAX_VALUE;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			try
			{
				ResponseList<Status> listedTweets = chatBotTwitter.getUserTimeline(username, statusPage);
				for(Status current : listedTweets)
				{
					if(current.getID() < lastID)
					{
						searchedTweets.add(current);
						lastID = current.getId();
					}
				}
			}
			catch(TwitterException searchTweetError)
			{
				appController.handleErrors(searchTweetError);
			}
			page++;
		}
	}
	
	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchedTweets)
		{
			String tweetText = currentStatus.getText();
			tweetText = tweetText.replace("\n", " ");
			String [] tweetWords = tweetText.split(" ");
			for(int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]).trim());
			}
		}
	}
	
	private void removeBlanks()
	{
		for (int index = tweetedWords.size() - 1; index >= 0; index--)
		{
			if (tweetedWords.get(index).trim().length() == 0)
			{
				tweetedWords.remove(index);
			}
		}
	}
	private void generateWordCount()
	{
		for (String word : tweetedWords)
		{
			if (!wordsAndCount.containsKey(word.toLowerCase())) 
			{
				wordsAndCount.put(word.toLowerCase(), 1);
			}
			else
			{
				wordsAndCount.replace(word.toLowerCase(), wordsAndCount.get(word.toLowerCase()) + 1);
			}
		}
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"() {}^[]<>-";
		String newLine = "\n";
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	private String [] createIgnoreWordArray()
	{
		String [] boringWords;
		String fileText = IOController.loadFromFile(appController, "commonWords.txt");
		int wordCount = 0;
		
		Scanner wordScanner = new Scanner(fileText);
		
		while(wordScanner.hasNextLine()) 
		{
			wordScanner.nextLine();
			wordCount++;
		}
		
		boringWords = new String [wordCount];
		wordScanner.close();
		
		wordScanner = new Scanner(this.getClass().getResourceAsStream("data/commonWords.txt"));
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = wordScanner.nextLine();
		}
		
		wordScanner.close();
		return boringWords;
		
	}
	
	private ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(wordsAndCount.entrySet());
	entries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getvalue()));
	
	return entries;
}

private String sortedWords()
{
	String allWords = "";
	String[] words = new String [wordsAndCount.size()];
	ArrayList<String> wordList = new ArrayList<String>(wordsAndCount.keySet());
	for(int index = 0; index < wordsAndCount.size(); index++)
	{
		words[index] = wordList.get(index);
	}
		for (int inner = index + 1; inner < words.length; inner++)
		{
			if (words[inner].compareTo(words[maxIndex]) > 0)
			{
				maxIndex = inner;
			}
		}
		
		String tempMax = words[maxIndex];
		words[maxIndex] = words[index];
		words[index] = tempMax;
	}
	
	for (String word : words)
	{
		allWords += word + ",";
	}
	
	return allWords;
}
