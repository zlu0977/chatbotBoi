package groupFiles;

public class RouseBook implements Chatbot{

	private String[] keywords = {"book","books","novel","novels","manga",};
	private String response;
	private boolean inBookLoop;
	
	public void talk() {
		inBookLoop = true;
		print("Do you read?");
		response = ZhengMain.promptInput();
		if(ZhengMain.findKeyword(response, "yes", 0) >= 0){
			while(inBookLoop){
				
			}
		}else{
			inBookLoop = false;
			ZhengMain.promptForever();
		}
	}

	public boolean isTriggered(String userInput) {
		for(int i = 0; i < keywords.length; i++){
			if(ZhengMain.findKeyword(userInput, keywords[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}
	
	public void print(String s){
		System.out.println(s);
	}

}
