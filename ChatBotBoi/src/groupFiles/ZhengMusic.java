package groupFiles;

public class ZhengMusic implements Chatbot {
	private String musicResponse;
	private boolean inMusicLoop;
	private boolean inSingLoop = false;
	private int stopCount;
	private int musicLayer;
	
	private String[] preferedMusic = {"classic", "classical", "techno", "jpop", "salsa"};
	private String[] dislikedMusic = {"jazz", "bachata", "metal", "rap"};
	
	public void talk() {
		inMusicLoop = true;
		musicResponse = ZhengMain.response;
		musicLayer = 0;
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
		String[] triggers = {"music", "lyric", "lyrics", "song", "songs", "sing", "classical", "classic", "pop", "rock", "jazz", "kpop", "jpop", "salsa", "bachata", "metal", "techno", "hip hop", "rap"};
		
		for(int i = 0; i < triggers.length; i ++)
			if(ZhengMain.findKeyword(userInput, triggers[i], 0) >= 0)
				return true;
		
		return false;
	}
	
	private void printResponse()
	{
		if(musicLayer == 0)
		{
			if(ZhengMain.findKeyword(musicResponse, "sing", 0) >= 0)
			{
				sing();
				musicLayer ++;
			}
			else if(ZhengMain.wordMatch(musicResponse, new String[] {"music", "lytic", "lyrics", "song", "songs"}))
			{
				ZhengMain.syso("What kind of music do you like?");
				musicLayer ++;
			}
			else
			{
				if(ZhengMain.wordMatch(musicResponse, preferedMusic))
					ZhengMain.syso("I like that type of music too!");
				else if(ZhengMain.wordMatch(musicResponse, dislikedMusic))
					ZhengMain.syso("I do not like that type of music...");
				else
					ZhengMain.syso("I never heard of " + musicResponse + ".");
					
				
				musicLayer = 2;
			}
		}
		else if(musicLayer == 1)
		{
			if(ZhengMain.wordMatch(musicResponse, preferedMusic))
				ZhengMain.syso("I like that type of music too!");
			else if(ZhengMain.wordMatch(musicResponse, dislikedMusic))
				ZhengMain.syso("I do not like that type of music...");
			else
				ZhengMain.syso("I never heard of " + musicResponse + ".");
		}
		else if(musicLayer == 8)
		{
			ZhengMain.syso("Want to hear me sing?");
			musicLayer ++;
		}
		else if(musicLayer == 9)
		{
			if(ZhengMain.findKeyword(musicResponse, "yes", 0) >= 0)
			{
				sing();
				musicLayer ++;
			}
			else if(ZhengMain.findKeyword(musicResponse, "no", 0) >= 0)
			{
				ZhengMain.syso("Aw. You're missing out.");
				musicLayer = 11;
			}
			else
			{
				ZhengMain.syso("I will take that as a yes...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sing();
				musicLayer ++;
			}
		}
		
	}
	
	private void sing()
	{
		inSingLoop = true;
		stopCount = 0;
		int lyricNum = 0;
		String stopResponse;
		String[] lyrics = {"Oh whoa \nOh whoa \nOh whoa", "You know you love me, I know you care", "Just shout whenever and I’ll be there", "You are my love, you are my heart", "And we will never ever ever be apart", "Are we an item? Girl, quit playing", "We’re just friends, what are you saying?", "Said There’s another, and looked right in my eyes", "My first love broke my heart for the first time and I was like", "Baby, baby, baby oh", "Like baby, baby, baby no", "Like baby, baby, baby no oh"};
		
		while(inSingLoop)
		{			
			ZhengMain.syso(lyrics[lyricNum]);
			lyricNum ++;
			
			if(lyricNum >= lyrics.length)
				lyricNum = lyrics.length - 3;
			
			stopResponse = ZhengMain.promptInput();
			if(ZhengMain.findKeyword(stopResponse, "stop", 0) >= 0)
			{
				stopCount ++;
				
				if(stopCount >= 3)
				{
					inSingLoop = false;
					ZhengMain.syso("Ok fine.... How was my singing?");
				}
			}
		}
	}
}
