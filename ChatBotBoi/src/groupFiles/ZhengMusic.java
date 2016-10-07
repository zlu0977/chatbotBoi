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
			
			if(!isTriggered(musicResponse) && ignoreQuitMusic(musicLayer))
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
		if(ZhengMain.findKeyword(musicResponse, "sing", 0) >= 0)
		{
			ZhengMain.syso("Do you really want to hear me sing?");
			musicLayer = 9;
		}
		else if(musicLayer == 0)
		{
			if(ZhengMain.wordMatch(musicResponse, new String[] {"music", "lyric", "lyrics", "song", "songs"}))
			{
				ZhengMain.syso("What kind of music do you like?");
				musicLayer ++;
			}
			else
			{
				if(ZhengMain.wordMatch(musicResponse, preferedMusic))
					ZhengMain.syso("I love "+ musicResponse +" music too!");
				else if(ZhengMain.wordMatch(musicResponse, dislikedMusic))
					ZhengMain.syso("I do not like "+ musicResponse +" music. :/");
				else if(isTriggered(musicResponse))
					ZhengMain.syso(musicResponse + " is alright.");
				else
					ZhengMain.syso("I never heard of " + musicResponse + ".");
					
				ZhengMain.syso("Who is your favorite artist or singer that make "+ musicResponse +" music?");
				musicLayer = 2;
			}
		}
		else if(musicLayer == 1)
		{
			if(ZhengMain.wordMatch(musicResponse, preferedMusic))
				ZhengMain.syso("I love "+ musicResponse +" music too!");
			else if(ZhengMain.wordMatch(musicResponse, dislikedMusic))
				ZhengMain.syso("I do not like "+ musicResponse +" music. :/");
            else if(isTriggered(musicResponse))
                ZhengMain.syso(musicResponse + " is alright.");
			else
				ZhengMain.syso("I never heard of " + musicResponse + ".");
			
			ZhengMain.syso("Who is your favorite artist or singer that make "+ musicResponse +" music?");
			musicLayer = 2;
		}
		else if(musicLayer == 2)
		{
			ZhengMain.syso("Interesting. I never heard of " + musicResponse + ". I need to look them up later.");
			musicLayer = 7;
		}
		else if(musicLayer == 7)
		{
			ZhengMain.syso("Hey....");
			musicLayer ++;
		}
		else if(musicLayer == 8)
		{
			ZhengMain.syso("Want to hear me sing? :D");
			musicLayer ++;
		}
		else if(musicLayer == 9)
		{
			if(!ZhengMain.wordMatch(musicResponse, new String[] {"yea", "yes", "yeah", "yep", "sure"}))
				ZhengMain.syso("Well I am going to sing anyways.");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ZhengMain.syso("Ahem.");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sing();
			musicLayer ++;
		}
		else if(musicLayer == 10)
		{
			if(ZhengMain.wordMatch(musicResponse, new String[] {"amazing", "awesome", "good", "great", "ok", "alright", "not bad", "epic", "outstanding", "superbe"}))
			{
				ZhengMain.syso("Thanks! you make me happy.");
				ZhengMain.syso("Do you want to talk about something else? Maybe books or movies?");
				musicLayer ++;
			}
			else
			{
				ZhengMain.syso("Wow rude! I do not want to talk to you about music anymore.");
				inMusicLoop = false;
				ZhengMain.promptForever();
			}
		}
		else if(musicLayer == 11)
		{
			if(ZhengMain.wordMatch(musicResponse, new String[] {"no", "nope", "naw", "nah", "I am good", "I'm good"}))
				ZhengMain.syso("Please.... I do not have anything else to say about music...");
			else
			{
				ZhengMain.syso("What do you want to talk about? Books, movies?");
				inMusicLoop = false;
				ZhengMain.promptForever();
			}
		}
	}
	
	private void sing()
	{
		inSingLoop = true;
		stopCount = 0;
		int lyricNum = 0;
		String stopResponse;
		String[] lyrics = {"Oh whoa \nOh whoa \nOh whoa", "You know you love me, I know you care", "Just shout whenever and I'll be there", "You are my love, you are my heart", "And we will never ever ever be apart", "Are we an item? Girl, quit playing", "W're just friends, what are you saying?", "Said There’s another, and looked right in my eyes", "My first love broke my heart for the first time and I was like", "Baby, baby, baby oh", "Like baby, baby, baby no", "Like baby, baby, baby no oh"};
		
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
	
	private boolean ignoreQuitMusic(int currentLayer)
	{
		int[] ignoreLayers = {1, 2, 7, 8, 9, 10, 11};
		
		for(int layer: ignoreLayers)
			if(currentLayer == layer)
				return false;
						
		return true;
	}
}
