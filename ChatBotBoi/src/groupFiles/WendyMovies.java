package groupFiles;

public class WendyMovies implements Chatbot{
	
	private String movieTalk;
	private boolean inMovieLoop;
	private boolean inIceAgeTalk = false;
	private boolean talk;
	
	String[] movies = {"Ice Age"};
	String[] badResponses = {"I hate that movie","I don't want to talk about that movie"};
	String[] badCharacters = {"Nope","Not my favorite, so let's not talk about it","Who likes him anyway?"};
	int timesAsk;

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inMovieLoop = true; 
		movieTalk = ZhengMain.response;
		while(inMovieLoop)
		{
			printResponse(movieTalk);
			movieTalk = ZhengMain.promptInput();
			if(!isTriggered(movieTalk))
			{
				inMovieLoop = false;
				ZhengMain.promptForever();
			}
		}
		 
	}

	private void printResponse(String userInput) 
	{
		timesAsk = 1;
		String[] good = {"love","like","favorite"};
		
		if(ZhengMain.findKeyword(userInput, "movies", 0) >= 0 || ZhengMain.findKeyword(userInput, "movie", 0) >= 0)
		{
			ZhengMain.syso("What is your favorite movie?");
		}
		else if(ZhengMain.findKeyword(userInput, "ice age", 0) >= 0 || inIceAgeTalk)
		{
			inIceAgeTalk = true;
			talkIceAge(userInput);
		}
		else
		{	
			timesAsk++;
			talkBad();
		}	 

	}

	private void talkIceAge(String userInput) {
		// TODO Auto-generated method stub
		ZhengMain.syso("Really? That's my number " + timesAsk + " favorite movie too!");
		String[] iceAgeChars = {"Manny","Sid","Diego"};
		ZhengMain.syso("Who's your favorite characters?");
 

		if(ZhengMain.findKeyword(userInput, "Manny", 0) >= 0)
		{
			talkManny();
		}
		else if(ZhengMain.findKeyword(userInput, "Sid", 0) >= 0)
		{
			talkSid();
		}
		else if(ZhengMain.findKeyword(userInput, "Diego", 0) >= 0)
		{
			talkDiego();
		}
		else 
		{
			talkBadChar();
		}
		
	}


	private void talkManny() {
		// TODO Auto-generated method stub
		String[] mannyResponses = {"Did you know he's a wooly mammoth?","Isn't he poofy?"};
		int num = (int) (Math.random() * mannyResponses.length);
		ZhengMain.syso(mannyResponses[num]);
		
	}

	private void talkSid() {
		// TODO Auto-generated method stub
		String[] sidResponses = {"Did you know he is a ground sloth?","Sid's hillarious"};
		int num = (int) (Math.random() * sidResponses.length);
		ZhengMain.syso(sidResponses[num]);
		
	}

	private void talkDiego() {
		// TODO Auto-generated method stub
		String[] diegoResponses = {"Did you know he's a saber toothed cat?"};
		int num = (int) (Math.random() * diegoResponses.length);
		ZhengMain.syso(diegoResponses[num]);
	}

	private void talkBadChar() {
		// TODO Auto-generated method stub
		int num = (int) (Math.random() * badCharacters.length);
		ZhengMain.syso(badCharacters[num]);
		ZhengMain.syso("Who's your next favorite?");
	}

	private void talkBad() {
		// TODO Auto-generated method stub
		int num = (int) (Math.random() * badResponses.length);
		ZhengMain.syso(badResponses[num]);
		ZhengMain.syso("What's your number " + timesAsk + " favorite movie?");
	}

	@Override
	public boolean isTriggered(String userInput) {
		// TODO Auto-generated method stub
		String[] trigger = {"movie","Ice Age","Manny","Sid","diego","continental","drift","Ellie","peaches","Granny","movies"};
		for (int i = 0; i<trigger.length; i++)
		{
			if(ZhengMain.findKeyword(userInput, trigger[i], 0) >= 0)
			{
				return true;
			}
		}
		return false;
	}

}
