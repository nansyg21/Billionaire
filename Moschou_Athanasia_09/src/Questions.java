import java.io.*;
import java.util.ArrayList;


public class Questions implements Serializable{
	
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	//tha antiproswpeyei to radio button pou einai to swsto
	private int corr;
	
	//san parametroi ston kataskeyasth pou tha kaleitai sthn addQuestionFrame tha mpainoun ta textfields
	public Questions(String question, String ans1, String ans2, String ans3,
			String ans4,int corr) {
		super();
		this.question = question;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
		this.corr=corr;
	}
	
	
	
	

	//na balw methodous pou tha anoigoun tha kleinoun to arxeio
	//na elegxw an yparxei otan pataw to koumpi kai an yparxei na kalw prwta thn deserializable kai meta thn serializable
	//na kanw elegxo me thn equals kai getQuestion otan bazw mia erwthsh na dw an yparxei
	
	
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}





	public int getCorr() {
		return corr;
	}


	public void setCorr(int corr) {
		this.corr = corr;
	}
	
	
	
	

}
