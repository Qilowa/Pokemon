package dut.fr.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dut.fr.pokemon.Capacitylist;
import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;
import dut.fr.pokemon.PokemonTeam;
import dut.fr.pokemon.Save;
import dut.test.CapacityTest;
 
public class Menu extends JFrame implements ActionListener{
	JButton bouton = new JButton("Pokedex");
	JButton bouton2 = new JButton("Combat");
	JButton bouton3 = new JButton("Ligue");
    JButton bouton4 = new JButton("Quitter");
    ArrayList<JButton> listBoutons = new ArrayList<JButton>();
    ArrayList<JLabel> listimg = new ArrayList<JLabel>();
    JPanel panel = new JPanel();
    int c=1;
    boolean c1=false;
	public Menu(){
		panel.setPreferredSize(new Dimension(720, 480));
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
			panel.setPreferredSize(new Dimension(275, 480));
			panel.setLayout(new FlowLayout());

			JButton precedent = new JButton("Précédent");
			System.out.println(c);
			precedent.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			    	  while(listimg.size()>0) {   // s'il y a des bouton on supprime
			    		  	panel.remove(listimg.get(listimg.size()-1));
			                listimg.remove(listimg.size()-1);
			                panel.repaint();
			           }
			        c--; 
			        if (c==0) {
						c=p.getSize();
					}
					Pokemon a =Pokedex.getPokemon(c);
					System.out.println(a);
			        Image picture;
					try {
						picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+a.getImgPath()));
						JLabel labelpicture = new JLabel(new ImageIcon(picture));
						listimg.add(labelpicture);
						panel.add(labelpicture);
						panel.revalidate();
						panel.repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JLabel idpoke = new JLabel("id: "+c);
					listimg.add(idpoke);
					panel.add(idpoke);
					JLabel namepoke = new JLabel("nom: "+a.getName());
					listimg.add(namepoke);
					panel.add(namepoke);
					JLabel heightpoke = new JLabel("taille: "+a.getHeight()+" cm");
					listimg.add(heightpoke);
					panel.add(heightpoke);
					JLabel weightpoke = new JLabel("poids: "+a.getWeight()+" kg");
					listimg.add(weightpoke);
					panel.add(weightpoke);
			      }  
			    });
			JButton suivant = new JButton("Suivant");
			suivant.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			    	  while(listimg.size()>0) {   // s'il y a des bouton on supprime
			    		  	panel.remove(listimg.get(listimg.size()-1));
			                listimg.remove(listimg.size()-1);
			                panel.repaint();
			           }
			        c++; 
			        if (c==p.getSize()+1) {
						c=1;
					}
					Pokemon a =Pokedex.getPokemon(c);
					System.out.println(a);
			        Image picture;
					try {
						picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+a.getImgPath()));
						JLabel labelpicture = new JLabel(new ImageIcon(picture));
						listimg.add(labelpicture);
						panel.add(labelpicture);
						panel.revalidate();
						panel.repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JLabel idpoke = new JLabel("id: "+c);
					listimg.add(idpoke);
					panel.add(idpoke);
					JLabel namepoke = new JLabel("nom: "+a.getName());
					listimg.add(namepoke);
					panel.add(namepoke);
					JLabel heightpoke = new JLabel("taille: "+a.getHeight()+" cm");
					listimg.add(heightpoke);
					panel.add(heightpoke);
					JLabel weightpoke = new JLabel("poids: "+a.getWeight()+" kg");
					listimg.add(weightpoke);
					panel.add(weightpoke);
					
			      }  
			    });
			JButton retourmenu = new JButton("Quitter");
			retourmenu.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			        System.exit(0);  
			      }  
			    });
			
            
			panel.add(precedent);
			panel.add(suivant);
			panel.add(retourmenu);
			JLabel idsearch = new JLabel("id: ");
			panel.add(idsearch);
			JTextField textfield = new JTextField();
			textfield.setColumns(20); //On lui donne un nombre de colonnes à afficher
			panel.add(textfield);
			textfield.addActionListener(new ActionListener(){
				        public void actionPerformed(ActionEvent e){
				            while(listimg.size()>0) {   // s'il y a des bouton on supprime
				    		  	panel.remove(listimg.get(listimg.size()-1));
				                listimg.remove(listimg.size()-1);
				                panel.repaint();
				           }
				            String text = textfield.getText();
				            try {
				                c = Integer.parseInt(text);
				                textfield.setText("");
				            } catch (NumberFormatException nfe) {
				            	textfield.setText("");
				                JOptionPane.showMessageDialog(null,
				                        "Valeur invalide , entrez un entier ", "Erreur",
				                        JOptionPane.ERROR_MESSAGE);
				            }
				            //int key = e.getKeyCode();
				            //System.out.println(key);
				            /* Restrict input to only integers */
				            //if (key < 96 && key > 105) e.consume(); 
				            
				        	
				        	//textfield.setText("");
				            if (c>=p.getSize()+1 || c<=0) {
				            JLabel idwrong = new JLabel("Mauvais id");
							listimg.add(idwrong);
							panel.add(idwrong);
				            c=1;
				            }
				            Pokemon a =Pokedex.getPokemon(c);
							System.out.println(a);
					        Image picture;
							try {
								picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+a.getImgPath()));
								JLabel labelpicture = new JLabel(new ImageIcon(picture));
								listimg.add(labelpicture);
								panel.add(labelpicture);
								panel.revalidate();
								panel.repaint();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							JLabel idpoke = new JLabel("id: "+c);
							listimg.add(idpoke);
							panel.add(idpoke);
							JLabel namepoke = new JLabel("nom: "+a.getName());
							listimg.add(namepoke);
							panel.add(namepoke);
							JLabel heightpoke = new JLabel("taille: "+a.getHeight()+" cm");
							listimg.add(heightpoke);
							panel.add(heightpoke);
							JLabel weightpoke = new JLabel("poids: "+a.getWeight()+" kg");
							listimg.add(weightpoke);
							panel.add(weightpoke);
				            panel.revalidate();
				            panel.repaint();
				        }
				    }
				);
			
			
			Image picture;
			try {
				picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+a.getImgPath()));
				JLabel labelpicture = new JLabel(new ImageIcon(picture));
				listimg.add(labelpicture);
				panel.add(labelpicture);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JLabel idpoke = new JLabel("id: "+c);
			listimg.add(idpoke);
			panel.add(idpoke);
			JLabel namepoke = new JLabel("nom: "+a.getName());
			listimg.add(namepoke);
			panel.add(namepoke);
			JLabel heightpoke = new JLabel("taille: "+a.getHeight()+" cm");
			listimg.add(heightpoke);
			panel.add(heightpoke);
			JLabel weightpoke = new JLabel("poids: "+a.getWeight()+" kg");
			listimg.add(weightpoke);
			panel.add(weightpoke);
			
			
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setContentPane(panel);
            pack(); //permet de mettre une bonne dimension a la fenetre
            setVisible(true);
        }
		if (e.getSource().equals(bouton2)) {
			while(listBoutons.size()>0) {   // s'il y a des bouton on supprime
                panel.remove(listBoutons.get(listBoutons.size()-1));
                listBoutons.remove(listBoutons.size()-1);
                panel.repaint();
            }
			panel.setPreferredSize(new Dimension(720, 480));
			panel.setLayout(new FlowLayout());
			JLabel okaytext = new JLabel("Vous avez choisis le combat, veuillez regarder la console");
			listimg.add(okaytext);
			panel.add(okaytext);
			JButton okay = new JButton("Start");
			listBoutons.add(okay);
			panel.add(okay);
			
			okay.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent e){ 
					c1=true; 
					
			    	System.out.println("Combat");
					if (c1) {
						String[] args = new String[0];
				        try {
							CapacityTest.main(args);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        System.exit(0);
					}
			      }  
			    });
			
			
			//mettre le programme
			
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setContentPane(panel);
	        pack(); //permet de mettre une bonne dimension a la fenetre
	        setVisible(true);
		}
		if (e.getSource().equals(bouton3)) {
			System.out.println("Ligue");
			while(listBoutons.size()>0) {   // s'il y a des bouton on supprime
                panel.remove(listBoutons.get(listBoutons.size()-1));
                listBoutons.remove(listBoutons.size()-1);
                panel.repaint();
            }
			panel.setPreferredSize(new Dimension(720, 480));
			panel.setLayout(new FlowLayout());
			JButton okay = new JButton("Okay");
			okay.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent e){  
			        System.exit(0);  
			        //mettre le programme
			      }  
			    });
			//mettre le programme
			JLabel okaytext = new JLabel("Vous avez choisis la ligue, veuillez regarder la console");
			listimg.add(okaytext);
			panel.add(okaytext);
			
			panel.add(okay);
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setContentPane(panel);
	        pack(); //permet de mettre une bonne dimension a la fenetre
	        setVisible(true);
		}
    }
    
    public  static void main(String args[])
    {
        new Menu();
    }
}
   