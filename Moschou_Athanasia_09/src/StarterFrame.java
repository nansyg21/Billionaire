import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




public class StarterFrame extends JFrame{
	
	JButton playButton;
	JButton addButton;
	JPanel starterPanel;
	
	public StarterFrame(){
		
		playButton=new JButton("Play!!");
		addButton=new JButton("Add Question");
		playButton.setFont(new Font("Jokerman",Font.BOLD,40));
		addButton.setFont(new Font("Jokerman",Font.BOLD,40));
		
		starterPanel=new JPanel(new GridLayout(2,1));
		
		starterPanel.add(playButton);
		starterPanel.add(addButton);
		
		myButtonListener functionListener=new myButtonListener();
		
		playButton.addActionListener(functionListener);
		addButton.addActionListener(functionListener);
		
		this.setTitle("Who Wants To Be A Billionaire!!");
		this.setContentPane(starterPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,200);
		
	}
	
	public class myButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==playButton)
				new PlayFrame();
			else 
				new AddQuestionFrame();
			
			
		}
		
	}

}
