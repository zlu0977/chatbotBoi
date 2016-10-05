package groupFiles;

public class ZhengMusic implements Chatbot {
	private String musicResponse;
	private boolean inMusicLoop;
	
	public void talk() {
		inMusicLoop = true;
		musicResponse = ZhengMain.response;
		while(inMusicLoop)
		{
			printResponse();
			musicResponse = ZhengMain.promptInput();
			
			if(!isTriggered(musicResponse))
			{
				inMusicLoop = false;
				ZhengMain.promptForever();
			}
		}

	}
  
	public boolean isTriggered(String userInput) {
		String[] triggers = {"music", "lyric", "lyrics", "song", "songs", "classical", "classic", "pop", "rock", "jazz", "kpop", "jpop", "salsa", "bachata", "metal", "techno", "hip hop", "rap"};
		
		for(int i = 0; i < triggers.length; i ++)
			if(ZhengMain.findKeyword(userInput, triggers[i], 0) >= 0)
				return true;
		
		return false;
	}
	
	private void printResponse()
	{
		if(ZhengMain.findKeyword(musicResponse, "music", 0) >= 0)
			if(ZhengMain.isQuestion(musicResponse) >= 0)
				ZhengMain.syso("this is a question about music");
			else
				ZhengMain.syso("this is not a question");
	}
}
