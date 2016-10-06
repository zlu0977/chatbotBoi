package groupFiles;

import java.util.Scanner;

public class ZhengMain {
	static String response;
	static Scanner input;
	static String user;
	static boolean inMainLoop;
	
	//Add chatbots below
	static Chatbot movies;
	static Chatbot music;
	static Chatbot books;
	
	static Chatbot math;
	static Chatbot politics;
	
	public static void main(String[] args) {
		createFields();
		initialize();
		promptForever();
	}
	
	public static void createFields()
	{	
		input = new Scanner(System.in);
		movies = new WendyMovies();
		music = new ZhengMusic();
		books = new RouseBook();
		
		math = new WendyMath();
		politics = new WendyPolitics();
	}
	
	public static String promptInput()
	{
		return input.nextLine();

	}
	
	public static void initialize()
	{
		syso("Hi, what is your name?");
		user = promptInput();
		syso("Hi " + user + ". How are you?");
	}
	
	public static void promptForever()
	{	
		inMainLoop = true;
		while(inMainLoop)
		{
			response = promptInput();
			
			if(findKeyword(response, "good", 0) >= 0)
			{
				syso("Thats wonderful.");
				syso("What do you want to talk about? Books, movies or music?");
			}
			else if(music.isTriggered(response))
			{
				syso("I like music too.");
				inMainLoop = false;
				music.talk();
			}
			else if(movies.isTriggered(response))
			{
				syso("I like movies too.");
				inMainLoop = false;
				movies.talk();
			}
			else if(books.isTriggered(response))
			{
				inMainLoop = false;
				books.talk();
			}
			/*else if(math.isTriggered(response))
			{
				inMainLoop = false;
				math.talk();
			}
			else if(politics.isTriggered(response))
			{
				inMainLoop = false;
				politics.talk();
			}*/
			else
				syso(getLastResponse()); 
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
	
	public static boolean wordMatch(String searchString, String[] keywords)
	{
		for(String keyword : keywords)
			if(findKeyword(searchString, keyword, 0) >= 0)
				return true;

		return false;
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
	}
	
	public static int isQuestion(String userInput)
	{
		String[] questionList = {"what", "where", "when", "why", "which", "how", "is", "should", "could", "would", "can", "will", "do", "does", "shall", "was"};
		
		for(int i = 0; i < questionList.length; i ++)
		{
			int questionLength = questionList[i].length();
			if(userInput.substring(0, questionLength).equals(questionList[i]))
				return i;
		}
		return -1;
	}
	
	public static String getLastResponse()
	{
		String[] responses = {"I see...", "Wow. I never knew.", "Thats nice.", "I dont get it."};
		return responses[(int) (Math.random() * responses.length)];
	}

        public static String getRandomResponse()
        {
                String[] questions = {"Give me a math problem.", ""};
                return questions[(int) (Math.random() * questions.length)];
        }

	public static void syso(String string)
	{
		System.out.println(string);
	}
}
