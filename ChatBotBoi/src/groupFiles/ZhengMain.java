package groupFiles;

import java.util.Scanner;

public class ZhengMain {
	static String response;
	static Scanner input = new Scanner(System.in);
	static String user;
	static boolean inMainLoop;
	
	//Add chatbots below
	//static Chatbot school = new ZhengSchool();
	static Chatbot politics = new WendyPolitics();
	static Chatbot music = new ZhengMusic();
	
	
	public static void main(String[] args) {
		politics.talk();
		music.talk();
		
		promptForever();
	}
	
	public static String promptInput()
	{
		String userInput = input.nextLine();
		return userInput;
	}
	
	public static void promptForever()
	{	
		inMainLoop = true;
		while(inMainLoop)
		{
			System.out.println("Hi, how are you?");
			response = promptInput();
			
			if(findKeyword(response, "good", 0) >= 0)
				System.out.println("Thats wonderful.");
			/*else if(school.isTriggered(response) >= 0)
			{
				System.out.println("school. is cool like a pool filled with drool");
				inMainLoop = false;
				school.talk();
			}
			else
				System.out.println("idk");*/
		}
	}
	
	public static int findKeyword(String searchString, String keyword, int startPosition) {
		
		searchString = searchString.trim().toLowerCase();
		keyword = keyword.toLowerCase();
		int psn = searchString.indexOf(keyword, startPosition);
		
		while(psn >= 0)
		{
			String before = " ";
			String after = " ";
			
			if(psn > 0)
				before = searchString.substring(psn - 1, psn);
			
			if(psn + keyword.length() < searchString.length())
				after = searchString.substring(psn + keyword.length(), psn + keyword.length() + 1);
			
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, psn))
				return psn;
			else
				psn = searchString.indexOf(keyword, psn + 1);
		}
		
		return -1;
	}
	
	private static boolean noNegations(String searchString, int psn) {
		String[] negationsList = {"no ", "not ", "never ", "n't "};
		
		for(int i = 0; i < negationsList.length; i ++)
		{
			int negationLength = negationsList[i].length();
			if(psn - negationLength >= 0 && searchString.substring(psn - negationLength, psn).equals(negationsList[i]))
				return false;
		}
		return true;
		
		/*if(psn - 3 >= 0 && searchString.substring(psn - 3, psn).equals("no "))
			return true;
		  if(psn - 4 >= 0 && searchString.substring(psn - 4, psn).equals("not "))
			return true;
		  if(psn - 6 >= 0 && searchString.substring(psn - 6, psn).equals("never "))
			return true;
		  if(psn - 4 >= 0 && searchString.substring(psn - 4, psn).equals("n't "))
			return true;
			
		return false;*/
		
	}

	public static void syso(String string)
	{
		System.out.println(string);
	}
}
