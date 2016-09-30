package groupFiles;
	

public class WendyPolitics implements Chatbot {
	
	private String politicResponse;
	private boolean inPoliticsLoop;

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
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
