package groupFiles;

public class ZhengMusic implements Chatbot {
	private boolean inMusicLoop;
	
	public void talk() {
		inMusicLoop = true;
		while(inMusicLoop)
		{
			printResponse();
			helloResponse = ZhengMain.promptInput();
			
			if(!isTriggered(helloResponse))
			{
				inMusicLoop = false;
				ZhengMain.promptForever();
			}
		}

	}
  
	public boolean isTriggered(String userInput) {
		String[] triggers = {"music", "lyric", "lyrics", "song", "songs"};
		
		for(int i = 0; i < triggers.length; i ++)
			if(ZhengMain.findKeyword(userInput, triggers[i], 0) >= 0)
				return true;
		
		return false;
	}
	
	private void printResponse()
	{
		ZhengMain.syso("I like music too");
	}

}
