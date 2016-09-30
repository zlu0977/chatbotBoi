package groupFiles;

public class ZhengMusic implements Chatbot {

	public void talk() {
		

	}
  
	public boolean isTriggered(String userInput) {
		String[] triggers = {"music", "lyric", "lyrics", "song", "songs"};
		
		for(int i = 0; i < triggers.length; i ++)
			if(ZhengMain.findKeyword(userInput, triggers[i], 0) >= 0)
				return true;
		
		return false;
	}

}
