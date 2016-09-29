package groupFiles;

public class WendyMath implements Chatbot {
	
	private boolean inMathLoop;
	private String mathResponse;

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inMathLoop = true;
		String[] responses = {"Sorry but I am not good with math","I failed algebra, sorry can't help you", "I can't even solve 1+1"};
		while (inMathLoop)
		{
			int math = (int)(Math.random() * responses.length); 
			ZhengMain.syso(responses[math]);
			
			if(!isTriggered(mathResponse))
			{
				inMathLoop = false;
				ZhengMain.promptForever();
			}
		}
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
