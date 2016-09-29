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
		String[] Trigger = {"Hilary","Clinton","Donald","Trump","Election","Vote","President","Barack","Obama","Politics"};
		return false;
	}

}
