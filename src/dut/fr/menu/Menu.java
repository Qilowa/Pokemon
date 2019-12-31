package dut.fr.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Menu extends JFrame implements ActionListener{
	private JButton bouton;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;
	public Menu(){
	    /*this.setTitle("Bouton");
	    this.setSize(700, 700);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    //On définit le layout à utiliser sur le content pane
	    //Trois lignes sur deux colonnes
	    this.setLayout();
	    //On ajoute le bouton au content pane de la JFrame
	    this.getContentPane().add(new JButton("Pokédex"));
	    this.getContentPane().add(new JButton("Combat"));
	    this.getContentPane().add(new JButton("3"));
	    this.getContentPane().add(new JButton("4"));
	    this.setVisible(true);*/
		//titre de la fenetre
        
        //panel
        /*JPanel  pan=new JPanel();
        pan.setPreferredSize(new Dimension(640, 480));
        pan.setLayout(new GridLayout(2, 2));
        
        //bouton ici
        JButton but1=new JButton("Pokédex");
        JButton but2=new JButton("Combat");
        JButton but3=new JButton("Ligue");
        JButton but4=new JButton("4");
        
        //ajoute un listener : ici le listener est cette classe
        but1.addActionListener(this);
        but2.addActionListener(this);
        but3.addActionListener(this);
        but4.addActionListener(this);
        
        //ajoute le boutton dans le panel
        pan.add(but1);
        pan.add(but2);
        pan.add(but3);
        pan.add(but4);
        
        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pan);
        pack(); //permet de mettre une bonne dimension a la fenetre
        setVisible(true);*/
		

			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(640, 480));
	        panel.setLayout(new GridLayout(2, 2));
	 
			JButton bouton = new JButton(new IciAction("Cliquez ici !"));
			panel.add(bouton);
	 
			JButton bouton2 = new JButton(new LaAction("Ou là"));
			panel.add(bouton2);
			
			JButton bouton3 = new JButton(new LaaAction("a"));
			panel.add(bouton3);
			
			JButton bouton4 = new JButton(new LabAction("b"));
			panel.add(bouton4);
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setContentPane(panel);
	        pack(); //permet de mettre une bonne dimension a la fenetre
	        setVisible(true);
	}
	public  void actionPerformed(ActionEvent e)
    {
		Object source = e.getSource();
		if(source == bouton){
			System.out.println("Vous avez cliqué ici.");
		}
		if(source == bouton2){
			System.out.println("Vous avez cliqué là.");	
		}
		if(source == bouton3){
			System.out.println("Voa.");	
		}
		if(source == bouton4){
			System.out.println("Vob là.");	
		}
    }
    
    public  static  void    main(String args[])
    {
        new Menu();
    }
}
   