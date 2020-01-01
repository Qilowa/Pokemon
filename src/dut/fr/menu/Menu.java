package dut.fr.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;
 
public class Menu extends JFrame implements ActionListener{
	/*private JButton bouton;
	private JButton bouton2;
	private JButton bouton3;
	private JButton bouton4;*/
	JButton bouton = new JButton("Pokedex");
	JButton bouton2 = new JButton("Combat");
	JButton bouton3 = new JButton("Ligue");
    JButton bouton4 = new JButton("Quitter");
    ArrayList<JButton> listBoutons = new ArrayList<JButton>();
    JPanel panel = new JPanel();
    int c=1;
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
		

			/*JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(640, 480));
	        panel.setLayout(new GridLayout(2, 2));
	 
			JButton bouton = new JButton("Pokedex");
			bouton.addActionListener(this);
			panel.add(bouton);
	 
			JButton bouton2 = new JButton(new CombatAction("Combat"));
			panel.add(bouton2);
			
			JButton bouton3 = new JButton(new LigueAction("Ligue"));
			panel.add(bouton3);
			
			JButton bouton4 = new JButton(new QuitterAction("Quitter"));
			panel.add(bouton4);
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setContentPane(panel);
	        pack(); //permet de mettre une bonne dimension a la fenetre
	        setVisible(true);
	        panel.repaint();*/
		panel.setPreferredSize(new Dimension(640, 480));
        panel.setLayout(new GridLayout(2, 2));
        bouton.addActionListener(this);
        bouton2.addActionListener(this);
        bouton3.addActionListener(this);
        bouton4.addActionListener(new ActionListener(){  
		      public void actionPerformed(ActionEvent ae){  
		        System.exit(0);  
		      }  
		    });
        listBoutons.add(bouton);
        listBoutons.add(bouton2);
        listBoutons.add(bouton3);
        listBoutons.add(bouton4);
        panel.add(bouton);
        panel.add(bouton2);
        panel.add(bouton3);
        panel.add(bouton4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack(); //permet de mettre une bonne dimension a la fenetre
        setVisible(true);
	}
	public  void actionPerformed(ActionEvent e)
    {
		if (e.getSource().equals(bouton)) {
			while(listBoutons.size()>0) {   // s'il y a des bouton on supprime
                panel.remove(listBoutons.get(listBoutons.size()-1));
                listBoutons.remove(listBoutons.size()-1);
                panel.repaint();
            }
			System.out.println("Pokedex");
			Pokedex p = Pokedex.getInstance();
			Pokemon a =Pokedex.getPokemon(c);
			
			JPanel pokepanel = new JPanel();
			
			Image picture;
			try {
				picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+a.getImgPath()));
				JLabel labelpicture = new JLabel(new ImageIcon(picture));
				pokepanel.add(labelpicture);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JButton precedent = new JButton("Précédent");
			System.out.println(c);
			precedent.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			        c--; 
			        System.out.println(c);
			      }  
			    });
			JButton suivant = new JButton("Suivant");
			suivant.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			    	
			        c++; 
			        System.out.println(c);
			        Pokemon a =Pokedex.getPokemon(c);
			        Image picture;
					try {
						picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+a.getImgPath()));
						JLabel labelpicture = new JLabel(new ImageIcon(picture));
						pokepanel.add(labelpicture);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					panel.revalidate();
			      }  
			    });
			JButton retourmenu = new JButton("Retour Menu");
			retourmenu.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			        System.exit(0);  
			      }  
			    });
			System.out.println(Pokedex.getPokemon(15));
            
            
			pokepanel.add(precedent);
			pokepanel.add(suivant);
			pokepanel.add(retourmenu);
			
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setContentPane(pokepanel);
            pack(); //permet de mettre une bonne dimension a la fenetre
            setVisible(true);
        }
		if (e.getSource().equals(bouton2)) {
			System.out.println("Combat");
		}
		if (e.getSource().equals(bouton3)) {
			System.out.println("Ligue");
		}
		/*Object source = e.getSource();
		if (e.getSource().equals(bouton)) {
            System.out.println("test");
        }
		if(source == bouton){
			new PokedexAction("Pokedex");
			System.out.println("Pokedex");
		}
		if(source == bouton2){
			System.out.println("Combat");	
		}
		if(source == bouton3){
			System.out.println("Ligue");	
		}
		if(source == bouton4){
			System.out.println("Quitter");	
		}*/
    }
    
    public  static void main(String args[])
    {
        new Menu();
    }
}
   