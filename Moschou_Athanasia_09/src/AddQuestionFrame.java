import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class AddQuestionFrame extends JFrame{

	
	//dhmiourgia label
	JLabel questionlbl;
	
	//dhmioyrgia buttons 
	JButton makeQButton;
	JButton saveQButton;
	
	//dhmiourgia textfields
	JTextField questionTextField;
	JTextField ans1TextField;
	JTextField ans2TextField;
	JTextField ans3TextField;
	JTextField ans4TextField;
	
	//dhmiourgia panel
	JPanel addQuestionPanel;
	
	//dhmiourgia radio buttons
	JRadioButton ans1rb;
	JRadioButton ans2rb;
	JRadioButton ans3rb;
	JRadioButton ans4rb;
	String path;
	
	//ArrayList gia na mpainoun ta question pou ftiaxnw
	private ArrayList<Questions> questions = new ArrayList<Questions>();
	
	//kataskeyasths
	public AddQuestionFrame(){
		
		questions=new ArrayList<Questions>();
		//trabaei thn apothikeymenh lista
		ArrayList<Questions> questionsFromFile=deserializing();
		
		
		
		//dhmiourgia merous erwthshs
		questionlbl=new JLabel("Question: ");		
		questionTextField=new JTextField();
		
		//dhmiourgia textfield apanthsewn
		ans1TextField=new JTextField();
		ans2TextField=new JTextField();
		ans3TextField=new JTextField();
		ans4TextField=new JTextField();
		
		//dhmiourgia koympiwn
		makeQButton=new JButton("Make Question");
		saveQButton=new JButton("Save Question To File");
		
		//dhmiourgia kai onomasia radio buttons
		ans1rb=new JRadioButton("Answer1: ");
		ans2rb=new JRadioButton("Answer2: ");
		ans3rb=new JRadioButton("Answer3: ");
		ans4rb=new JRadioButton("Answer4: ");
		
		//dhmiourgia group kai prosthiki radio buttons
		 ButtonGroup group = new ButtonGroup();
		    group.add(ans1rb);
		    group.add(ans2rb);
		    group.add(ans3rb);
		    group.add(ans4rb);
		 
		    myButtonListener makeSaveListener=new myButtonListener();
		    
		    makeQButton.addActionListener(makeSaveListener);
		    saveQButton.addActionListener(makeSaveListener);
		    
		    JPanel answersPanel=new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
		// addQuestionPanel=new JPanel(new GridLayout(5,2,1,1));
		 
			//prosthiki stoixeiwn gia tis apanthseis epanw sto panel
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 0;
			answersPanel.add(questionlbl,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 10;
			c.ipadx = 10; 
			c.gridx =1;
			c.gridy = 0;
			c.gridwidth=MAXIMIZED_VERT;
			answersPanel.add(questionTextField,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 1;
			answersPanel.add(ans1rb,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 10;
			c.ipadx = 10; 
			c.gridx =1;
			c.gridy = 1;
			c.gridwidth=MAXIMIZED_VERT;
			answersPanel.add(ans1TextField,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 2;
			answersPanel.add(ans2rb,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 10;
			c.ipadx = 10; 
			c.gridx =1;
			c.gridy = 2;
			c.gridwidth=MAXIMIZED_VERT;
			answersPanel.add(ans2TextField,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 3;
			answersPanel.add(ans3rb,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 10;
			c.ipadx = 10; 
			c.gridx =1;
			c.gridy = 3;
			c.gridwidth=MAXIMIZED_VERT;
			answersPanel.add(ans3TextField,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 4;
			answersPanel.add(ans4rb,c);
			
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 10;
			c.ipadx = 10; 
			c.gridx =1;
			c.gridy = 4;
			c.gridwidth=MAXIMIZED_VERT;
			answersPanel.add(ans4TextField,c);
			
			//prosthiki koumpiwn sto panel den xreiazetai layout gia na bgoun opws sto paradeigma
			JPanel buttonPanel=new JPanel();
			
			buttonPanel.add(makeQButton);
			buttonPanel.add(saveQButton);
			
		//bazw kai ta dyo panel panw se ena kentriko gia na anebei sto parathiro
		 JPanel masterPanel=new JPanel(new BorderLayout());
		 masterPanel.add(answersPanel,BorderLayout.NORTH);
		 masterPanel.add(buttonPanel,BorderLayout.SOUTH);
		 
		 //idiothtes parathyrou
		 this.setContentPane(masterPanel);
		 
		 	this.setTitle("Add Question");
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(500,200); 
	}
	
	public void serializing() {
		try {
			File Game_Play=new File("Questions");
			path=Game_Play.getAbsolutePath();
			System.out.println("Path "+path);
			FileOutputStream fileOut = new FileOutputStream(new File(path));
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(questions);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		finally {
			System.out.println("Serialization Attempted...");
		}
		
	}
	
	public ArrayList<Questions> deserializing() {
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			questions= (ArrayList<Questions>) in.readObject();
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
		
	public class myButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean exists=false;
			if(e.getSource()==makeQButton){
				
					for(Questions q:questions){
						if(!q.getQuestion().equals(questionTextField.getText()))
							exists=false;
						else{
							exists=true;
							JOptionPane.showMessageDialog(null, "Question Allready Excists");
						}
					}
					if (!exists){
						if ((questionTextField.getText().length()!=0)&&(ans1TextField.getText().length()!=0)&&(ans2TextField.getText().length()!=0)&&(ans3TextField.getText().length()!=0)&&(ans4TextField.getText().length()!=0)){
							int correct=0;
							
							//elegxos gia to poio radiobutton einai checked
							if(ans1rb.isSelected())
								correct=1;
							else if (ans2rb.isSelected())
								correct=2;
							else if (ans3rb.isSelected())
								correct=3;
							else if (ans4rb.isSelected())
								correct=4;
							else 
								JOptionPane.showMessageDialog(null, "You Must Choose The Correct Answer");
							
							questions.add(new Questions(questionTextField.getText(),ans1TextField.getText(),ans2TextField.getText(),ans3TextField.getText(),ans4TextField.getText(),correct));
				
					
							questionTextField.setText(" ");
							ans1TextField.setText(" ");
							ans2TextField.setText(" ");
							ans3TextField.setText(" ");
							ans4TextField.setText(" ");
					
							//apoepilogh olwn twn radiobutton
							ans1rb.setSelected(false);
							ans2rb.setSelected(false);
							ans3rb.setSelected(false);
							ans4rb.setSelected(false);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "You Must Fill All The Fields");
						}
				}
					
			}
			else{				
				serializing();
			}
		}
	}
}
