package groupFiles;

public class WendyMovies implements Chatbot{
	
	private String movieTalk;
	private boolean inMovieLoop;
	
	String[] movies = {"Finding Dory", "Secret Life of Pets", "Ice Age", "The Huntsmen:Winter's War", "Captain America", "Batman vs. Superman"};

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inMovieLoop = true;
		
		while(inMovieLoop)
		{
			printResponse();
			
			if(!isTriggered(movieTalk))
			{
				inMovieLoop = false;
				ZhengMain.promptForever();
			}
		}
		 
	}

	private void printResponse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		// TODO Auto-generated method stub
		String[] trigger = {"movie"};
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
