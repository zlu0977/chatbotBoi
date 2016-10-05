package groupFiles;

public class RouseBook implements Chatbot{

	private String[] keywords = {"book","books","novel","novels","manga"};
	private String bookResponse;
	private boolean inBookLoop;
	private String[] books = {"Flight", "The Dresden Files"};
	
	public void talk() {
		inBookLoop = true;
		ZhengMain.syso("Do you read?");
		bookResponse = ZhengMain.promptInput();
		if(ZhengMain.findKeyword(bookResponse, "yes", 0) >= 0){
			while(inBookLoop){
				bookResponse = ZhengMain.promptInput();
			}
		}else{
			inBookLoop = false;
			ZhengMain.syso("Oh... and here I thought we had something I common.");
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
	
	public void printResponse(String userIn){
		int repeat = 1;
		for(int i = 0; i < books.length; i++){
			
			if(ZhengMain.findKeyword(userIn, books[i], 0) >= 0)
			{
				talkBook();
				return;
			}
			else 
			{	
				repeat++;
				talkBad(repeat);
			}	
			
		}
	}

	private void talkBad(int irritationLevel) {
		String[] negatives = {"I don't want to talk about that.", "I would prefer to talk about something else.", "Let's change the conversation.", "LET'S. TALK. ABOUT. BOOKS.", "I'm on strike now."};
		if(irritationLevel > negatives.length){
			ZhengMain.syso(negatives[irritationLevel-1]);
		}else{
			ZhengMain.syso(negatives[negatives.length-1]);
		}
	}

	private void talkBook() {
		ZhengMain.syso("Do you want to talk about Flight or the Dresden Files?");
		bookResponse = ZhengMain.promptInput();
		if(ZhengMain.findKeyword(bookResponse, "Flight", 0) >= 0){
			flightTalk();
		}else if(ZhengMain.findKeyword(bookResponse, "the Dresden Files", 0) >= 0){
			dresTalk();
		}else{
			"";
		}
	}

}
