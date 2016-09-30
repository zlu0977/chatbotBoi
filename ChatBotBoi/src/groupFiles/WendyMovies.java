package groupFiles;

public class WendyMovies implements Chatbot{
	
	private String movieTalk;
	private boolean inMovieLoop;
	
	String[] movies = {"Finding Dory","Ice Age"};
	String[] badResponses = {"I hate that movie","I don't want to talk about that movie"};
	int timesAsk;

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inMovieLoop = true;
		while(inMovieLoop)
		{
			printResponse(movieTalk);
			
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
		
		if (ZhengMain.findKeyword(userInput, movies[0], 0) > 0)
		{
			talkDory(userInput);
		}
		else if(ZhengMain.findKeyword(userInput, movies[1], 0) > 0)
		{
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
		ZhengMain.syso("Reallyy? That's my number " + timesAsk + "favorite movie too!");
		
	}

	private void talkDory(String userInput) {
		// TODO Auto-generated method stub
		ZhengMain.syso("Reallyy? That's my number " + timesAsk + "favorite movie too!");
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
		String[] trigger = {"movie","Finding Dory", "Ice Age", "Dory", "Nemo",};
		for (int i = 0; i<trigger.length; i++)
		{
			if(ZhengMain.findKeyword(userInput, trigger[i], 0) > 0)
			{
				return true;
			}
		}
		return false;
	}

}
