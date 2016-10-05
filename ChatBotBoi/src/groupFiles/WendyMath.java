package groupFiles;

public class WendyMath implements Chatbot {
	
	private boolean inMathLoop;
	private String mathResponse;
	String[] responses = {"Sorry but I am not good with math","I failed algebra, sorry can't help you", "I can't even solve 1+1"};

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inMathLoop = true;
		mathResponse = ZhengMain.response;
		while (inMathLoop)
		{
			printResponses();
			
			if(!isTriggered(mathResponse))
			{
				inMathLoop = false;
				ZhengMain.promptForever();
			}
		} 
	}

	private void printResponses() {
		// TODO Auto-generated method stub
		int math = (int)(Math.random() * responses.length); 
		ZhengMain.syso(responses[math]);
	}

	@Override
	public boolean isTriggered(String userInput) {
		// TODO Auto-generated method stub
		String[] trigger = {"+","-","/","*"};
		for (int i = 0; i< trigger.length; i++)
		{
			if (ZhengMain.findKeyword(userInput, trigger[i], 0) > 0)
			{
				return true;
			}
		}
		return false;
	}

}
