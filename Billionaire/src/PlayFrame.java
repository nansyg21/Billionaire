import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;

import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;




public class PlayFrame extends JFrame{
	int j=0;
	int k=0;
	Questions randomQuestion;
	Random r;
	
private ArrayList<Questions> questions = new ArrayList<Questions>();
private ArrayList<Questions> used=new ArrayList<Questions>();

private BackgroundPanel back;
private Image background;

JPanel masterPanel;
	
JLabel Qlbl;
JLabel Questionlbl;

JRadioButton ans1rb;
JRadioButton ans2rb;
JRadioButton ans3rb;
JRadioButton ans4rb;

JButton comitButton;

JLabel Corrlbl;
JLabel Wronglbl;
String path;

public PlayFrame(){
	
	
	questions=deserializing();
	
	try
	{
		background = ImageIO.read(new File("Game_Play\\background2.png"));
	}
	catch (IOException e)
	{
			e.printStackTrace();
	}
	
	back = new BackgroundPanel(background);
	setContentPane(back);
	back.setLayout(new BorderLayout(5,5));
	
	Qlbl=new JLabel("");
	//na prosthesw apo pou tha pairnei thn erwthsh
	Questionlbl=new JLabel();

	Questionlbl.setFont(Questionlbl.getFont().deriveFont(24.0f));
	
	//na orisw apo pou tha pairnoun times
	ans1rb=new JRadioButton();
	ans1rb.setFont(ans1rb.getFont().deriveFont(24.0f));
	ans1rb.setOpaque(false);
	ans2rb=new JRadioButton();
	ans2rb.setFont(ans2rb.getFont().deriveFont(24.0f));
	ans2rb.setOpaque(false);
	ans3rb=new JRadioButton();
	ans3rb.setFont(ans3rb.getFont().deriveFont(24.0f));
	ans3rb.setOpaque(false);
	ans4rb=new JRadioButton();
	ans4rb.setFont(ans4rb.getFont().deriveFont(24.0f));
	ans4rb.setOpaque(false);
	
	//dhmiourgia group kai prosthiki radio buttons
	 ButtonGroup group = new ButtonGroup();
	    group.add(ans1rb);
	    group.add(ans2rb);
	    group.add(ans3rb);
	    group.add(ans4rb);
	
	 //o arithmos pou prostithetai sto alfarithmitiko tha allazei meta tha einai metablhth i
	 Corrlbl=new JLabel("Correct Answers: "+j);
	 Corrlbl.setFont(new Font("Arial",Font.BOLD,15));
	 Corrlbl.setForeground(Color.RED);
	 Wronglbl=new JLabel("Wrong Answers: "+k);
	 Wronglbl.setFont(new Font("Arial",Font.BOLD,15));
	 Wronglbl.setForeground(Color.BLUE);
	 
	 JPanel question=new JPanel();
	 question.setOpaque(false);
	 question.add(Qlbl);
	 question.add(Questionlbl);
	 
	 JPanel radioButtons=new JPanel();
	 GridLayout gl=new GridLayout(2,2);
	 radioButtons.setLayout(gl);
	 radioButtons.setOpaque(false);
	 radioButtons.add(ans1rb);
	 radioButtons.add(ans2rb);
	 radioButtons.add(ans3rb);
	 radioButtons.add(ans4rb);
	 
	 
	 
	 comitButton=new JButton("Comit");
	 
	 myButtonListener comitListener=new myButtonListener();
	 comitButton.addActionListener(comitListener);
	 
	 JPanel button=new JPanel();
	 button.setOpaque(false);
	 button.add(comitButton);
	 
	 
	 
	 JPanel answerScore=new JPanel();
	 answerScore.setOpaque(false);
	 answerScore.add(Corrlbl);
	 answerScore.add(Wronglbl);
	 
	 question.setBounds(10, 10, 480, 100);
	 radioButtons.setBounds(10,130,480,100);
	 button.setBounds(170,300,100,40);
	 answerScore.setBounds(10, 450, 480, 40);
	 
//	 back.add(question);
//	 back.add(radioButtons);
//	 back.add(button);
//	 back.add(answerScore);
	 
	masterPanel=new JPanel(new GridLayout(4,1));
//	masterPanel=new JPanel();
	masterPanel.add(question);
	masterPanel.add(radioButtons);
	masterPanel.add(button);
	masterPanel.add(answerScore);
	back.add(masterPanel);
	 
	

	

	 
	
//	 this.setContentPane(masterPanel);
	 this.setTitle("Add Question");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		//dhmiourgia tyxaias mhtras arithmwn
		r=new Random(System.currentTimeMillis());
		//kaleitai edw gia na exoume mia arxiki erwthsh
		
		chooseQuestion();
	
}



public void chooseQuestion(){
	//methodos tyxaias epiloghs erwthsewn
	
		
	int random=r.nextInt(questions.size());
	randomQuestion=questions.get(random);
	
	
	while (used.contains(randomQuestion)){
		if (used.size()==questions.size()){
			//JOptionPane.showMessageDialog(null, "You Have Ansewered All The Questions");
			JOptionPane.showConfirmDialog(null,"You Have Ansewered All The Questions \n Your Score is: \n Correct Answers:"+j+"  Wrong Answers: "+k+"\n Do you want to play again?" );
			if(JOptionPane.YES_OPTION==0){
				j=0;
				k=0;
				used.clear();
			}
			
			
		}
		random=r.nextInt(questions.size());
		randomQuestion=questions.get(random);
	}
	
	/*for(Questions q:used){
		if (q.getQuestion().equals(randomQuestion.getQuestion())){
			System.out.println("A");
			random=r.nextInt(questions.size());
			randomQuestion=questions.get(random);
			//used.add(randomQuestion);
		}
	}*/
	used.add(randomQuestion);
	
	

	


Questionlbl.setText(randomQuestion.getQuestion());
ans1rb.setLabel(randomQuestion.getAns1());
ans2rb.setLabel(randomQuestion.getAns2());
ans3rb.setLabel(randomQuestion.getAns3());
ans4rb.setLabel(randomQuestion.getAns4());
	
}


public class myButtonListener implements ActionListener{
	Random r=new Random(System.currentTimeMillis());
	public void actionPerformed(ActionEvent e) {
		
		if(((randomQuestion.getCorr()==1)&&(ans1rb.isSelected()))||
				((randomQuestion.getCorr()==2)&&(ans2rb.isSelected()))||
				((randomQuestion.getCorr()==3)&&(ans3rb.isSelected()))||
				((randomQuestion.getCorr()==4)&&(ans4rb.isSelected()))){
			j++;
			Corrlbl.setText("Correct Answers: "+j);
			JOptionPane.showMessageDialog(null, "Answer Correct!!!","Correct!!!",JOptionPane.INFORMATION_MESSAGE);	
			}
		else{
			k++;
			Wronglbl.setText("Wrong Answers: "+k);
			JOptionPane.showMessageDialog(null, "Sorry! Wrong Answer \n Correct Answer Is: "+randomQuestion.getCorr(), "Wrong!",JOptionPane.ERROR_MESSAGE);

		}
		chooseQuestion();	
	}
}
	
public ArrayList<Questions> deserializing() {
	try {
		File quest=new File("Questions");
		path=quest.getAbsolutePath();
		System.out.println("Path "+path);
		FileInputStream fileIn = new FileInputStream(path);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		questions= (ArrayList<Questions>) in.readObject();
		System.out.println("Size: "+questions.size());
		in.close();
		fileIn.close();		
	}
	catch(IOException i) {
		FileOutputStream fileOut = new FileOutputStream(path);
		fileOut.close();
		i.printStackTrace();
	}
	catch(ClassNotFoundException c) {
		c.printStackTrace();
	}
	finally {
		System.out.println("De-Serialization Attempted...");
		return questions;
		
	}	
	
	
}


}
