package project;
import acm.util.*;
import java.util.*;
import acm.graphics.*;
public class Hangman extends HangmanLexicon{
	/*instance Variable*/
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private String word;
	private String input;
	private int choices=8;
	private int key;
	private ArrayList<Integer> location = new ArrayList<Integer>();
	private String a;
	private Hangmancanvas canvas;
	
	public void init(){
		canvas = new Hangmancanvas();
		add(canvas);
		canvas.run();
	}
	
	public void run()
	{
	println("WELCOME TO HANGMAN!");
	
	/* randomly selecting a word from file*/
	int random = rgen.nextInt(1,10); 
	
	word = getWord(random);
    //println(word);
    dashing();
   
    println("the word now looks like this:"+input);
    while(choices>0)
    {
    	if(word.equals(input))
    	{
    		println("you gussed right");
    		break;
    	}
    println("you have "+ choices + " left");
    location.add(checkinput());
    key=location.get(location.size()-1);
    //println(location);
    updating();
    duplicate();
    canvas.remove_parts(choices);
    println("The word now looks like this: "+input);
	}
    if(choices==0)
    {
    	println("you got stuck");
    }
	}
	
	private void dashing()
	{
		String dash="-";
		input = "";
		for(int i=0;i<word.length();i++)
		{
			input=dash+input;
		}
	}
	
	private int checkinput()
	{
		char ch;
		a = readLine("your guess:");
		a=a.toUpperCase();
		ch=a.charAt(0);
		int i = word.indexOf(ch);
		//println(i);
		
		//println(key);
		if(i==-1)
			{
				choices--;
				return i;
			}
		if(location.contains(i))
			{
				rearrange(ch);
				//println(key);
			if(key==-1 && i==-1)
				{
					choices--;
				}
			return key;
			}
		return(i);
	}
	
	private void updating(){
		int i=location.size();
		int j=location.get(i-1);
		String result="";
		if(j!=-1){
		for(int k=0;k<word.length();k++){
			if(k==j)
			{
				result=result+a.charAt(0);
			}
			else{
				result = result + input.charAt(k);
			}
		}
		input=result;
	}
	}
	private void rearrange(char temp){
		//println(key);
		String sub = word.substring(key+1);
		//println(sub);
		key= sub.indexOf(temp)+key+1;
		//println(key);
	}
	
	private void duplicate()
	{
		if(location.size()>2)
		{
			if(location.get(location.size()-1)==location.get(location.size()-2))
				{
					choices--;
				}
		}
	}
	
}