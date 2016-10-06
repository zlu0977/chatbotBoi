package groupFiles;

public class RouseBook implements Chatbot{

	private String[] keywords = {"book","books","novel","novels","manga"};
	private String bookResponse;
	private boolean inBookLoop;
	private String[] books = {"Flight", "The Dresden Files","dresden","files"};
	private int repeat = 0;
	
	public void talk() {// the beginning.
		inBookLoop = true;
		ZhengMain.syso("Do you read?");
		bookResponse = ZhengMain.promptInput();
		if(ZhengMain.wordMatch(bookResponse, new String[] {"yes","yeah","yea","sure","okay","ok"})){
			while(inBookLoop){
				if(repeat < 1){
					ZhengMain.syso("Great! Let's talk about either the Dresden Files or Flight.");
				}else{
					ZhengMain.syso("Let's talk about either the Dresden Files or Flight.");
				}
				bookResponse = ZhengMain.promptInput();
				printResponse();
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
	
	public void printResponse(){//decides to complain or talk about books
		if(ZhengMain.wordMatch(bookResponse, books))
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

	public void talkBad(int irritationLevel) {//gives different responses for repetion
		String[] negatives = {"I don't want to talk about that.", "I would prefer to talk about something else.", "Let's change the conversation.", "LET'S. TALK. ABOUT. BOOKS.", "I'm on strike now."};
		if(irritationLevel > negatives.length){
			ZhengMain.syso(negatives[negatives.length-1]);
		}else{
			ZhengMain.syso(negatives[irritationLevel-1]);
		}
	}

	public void talkBook() {//decides which book to talk about
		if(ZhengMain.findKeyword(bookResponse, "Flight", 0) >= 0){
			ZhengMain.syso("Flight it is! Have you heard of it?");
			bookResponse = ZhengMain.promptInput();
			if(ZhengMain.wordMatch(bookResponse, new String[] {"yes","yeah","yea","sure","okay","ok"})){
				ZhengMain.syso("Isn't it so beautiful?");
				if(ZhengMain.wordMatch(bookResponse, new String[] {"yes","yeah","yea","sure","okay","ok"})){
					ZhengMain.syso("... I don't have much else to say");
					inBookLoop = false;
					ZhengMain.promptForever();
				}else{
					ZhengMain.syso("Well, I think it's cool...");
					inBookLoop = false;
					ZhengMain.promptForever();
				}
			}else{
				ZhengMain.syso("It's a collection of books, each with a collection of short graphic novels. Some continue from one book to another, some are one shots. How cool is that!");
				inBookLoop = false;
				ZhengMain.promptForever();
			}
		}else{
			ZhengMain.syso("The Dresden Files it is! Have you heard of it?");
			bookResponse = ZhengMain.promptInput();
			if(ZhengMain.wordMatch(bookResponse, new String[] {"yes","yeah","yea","sure","okay","ok"})){
				ZhengMain.syso("Isn't it so awesome?");
				if(ZhengMain.wordMatch(bookResponse, new String[] {"yes","yeah","yea","sure","okay","ok"})){
					ZhengMain.syso("... I don't have much else to say");
					inBookLoop = false;
					ZhengMain.promptForever();
				}else{
					ZhengMain.syso("Well, I think it's cool...");
					inBookLoop = false;
					ZhengMain.promptForever();
				}
			}else{
				ZhengMain.syso("It's a series of books, and it's basically mystery + urban fantasy + explosions. How cool is that?!");
				inBookLoop = false;
				ZhengMain.promptForever();
			}
		}
	}
}
