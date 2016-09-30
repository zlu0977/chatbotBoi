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
			if(isQuestion(musicResponse) >= 0)
				ZhengMain.syso("this is a question about music");
			else
				ZhengMain.syso("this is not a question");
	}
	
	private int isQuestion(String userInput)
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

}
