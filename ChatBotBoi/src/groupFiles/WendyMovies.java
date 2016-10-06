package groupFiles;

public class WendyMovies implements Chatbot{
	
	private String movieTalk;
	private boolean inMovieLoop;
	private int timesAsk = 1;
	private int movieLayers;
	String[] good = {"love","like","favorite"};
	
	String[] movies = {"Ice Age"};
	String[] badResponses = {"I hate that movie","I don't want to talk about that movie","interesting taste, but sorry not my type","don't like it"};
	String[] badCharacters = {"Nope","Not my favorite, so let's not talk about it","Who likes him anyway?"};

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inMovieLoop = true; 
		movieTalk = ZhengMain.response;
		movieLayers = 1;
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
		
		if(ZhengMain.findKeyword(userInput, "movies", 0) >= 0 || ZhengMain.findKeyword(userInput, "movie", 0) >= 0 && movieLayers == 1)
		{
			ZhengMain.syso("What is your favorite movie?");
			movieLayers = 2;
		}
		else if(movieLayers == 2)
		{
			if(ZhengMain.findKeyword(userInput, "ice age", 0) >= 0 )
			{
				ZhengMain.syso("Really? That's my number " + timesAsk + " favorite movie too!");
				ZhengMain.syso("Who's your favorite characters?");
				movieLayers = 3;
			}
			else
			{
				movieLayers = 4;
				timesAsk = timesAsk + 1;
				talkBad();
			}
		}
		else if (movieLayers == 3)
		{
			
			if(ZhengMain.findKeyword(userInput, "Manny", 0) >= 0)
			{
					talkManny(userInput);	
			}
			else if(ZhengMain.findKeyword(userInput, "Sid", 0) >= 0)
			{
					talkSid(userInput);
			}
			else if(ZhengMain.findKeyword(userInput, "Diego", 0) >= 0)
			{
					talkDiego(userInput);
			}
			else 
			{
				movieLayers = 5;
				talkBadChar();
			}
		}

	}


	private void talkManny(String userInput) {
		// TODO Auto-generated method stub
		
		if(ZhengMain.wordMatch(userInput, good))
		{
			String[] mannyResponses = {"Did you know he's a wooly mammoth?","Isn't he poofy?"};
			int num = (int) (Math.random() * mannyResponses.length);
			ZhengMain.syso(mannyResponses[num]);
		}
		else
		{
			ZhengMain.syso("rude");
		}
		
		
	}

	private void talkSid(String userInput) {
		// TODO Auto-generated method stub
		if(ZhengMain.wordMatch(userInput, good))
		{
			String[] sidResponses = {"Did you know he is a ground sloth?","Sid's hillarious"};
			int num = (int) (Math.random() * sidResponses.length);
			ZhengMain.syso(sidResponses[num]);
		}
		else
		{
			ZhengMain.syso("rude");
		}
		
	}

	private void talkDiego(String userInput) {
		// TODO Auto-generated method stub
		if(ZhengMain.wordMatch(userInput, good))
		{
			String[] diegoResponses = {"Did you know he's a saber toothed cat?"};
			int num = (int) (Math.random() * diegoResponses.length);
			ZhengMain.syso(diegoResponses[num]);
		}
		else
		{
			ZhengMain.syso("rude");
		}
	}

	private void talkBadChar() {
		// TODO Auto-generated method stub
		if(movieLayers == 5)
		{
			int num = (int) (Math.random() * badCharacters.length);
			ZhengMain.syso(badCharacters[num]);
			ZhengMain.syso("Who's your next favorite?");
		}
	}

	private void talkBad() {
		// TODO Auto-generated method stub
		if(movieLayers == 4)
		{
			int num = (int) (Math.random() * badResponses.length);
			ZhengMain.syso(badResponses[num]);
			ZhengMain.syso("What's your number " + timesAsk + " favorite movie?");
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		// TODO Auto-generated method stub
		String[] trigger = {"movie","Ice Age","Manny","Sid","diego","continental","drift","Ellie","peaches","Granny","movies","batman","avengers","dory","nemo","superman","superhero","captain america","suicide squad","zootopia","ghostbusters","peculiar children","purge","kung fu panda","alice","looking glass","huntsmen","central intelligence"};
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
