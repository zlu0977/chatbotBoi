package groupFiles;
	

public class WendyPolitics implements Chatbot {
	
	private String politicResponse;
	private boolean inPoliticsLoop;
	String[] responses = {"No, we don't talk about poltics here","I don't like politics. Let's not talk about it", "Nope, talk to the hand"};

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inPoliticsLoop = true;
		politicResponse = ZhengMain.response;
		while (inPoliticsLoop)
		{
			printResponse();
			if(!isTriggered(politicResponse))
			{
				inPoliticsLoop = false;
				ZhengMain.promptForever();
			} 
		}
	} 

	private void printResponse() {
		// TODO Auto-generated method stub
		int math = (int) (Math.random() * responses.length);
		ZhengMain.syso(responses[math]);
	}

	@Override
	public boolean isTriggered(String userInput) {
		// TODO Auto-generated method stub
		String[] trigger = {"Hilary","Clinton","Donald","Trump","Election","Vote","President","Barack","Obama","Politics"};
		for(int i = 0; i< trigger.length; i++)
		{
			if (ZhengMain.findKeyword(userInput, trigger[i], 0) > 0)
			{
				return true;
			}
		}
		return false;
	} 
  
}
