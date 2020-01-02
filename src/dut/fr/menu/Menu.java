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

import dut.fr.pokemon.Pokedex;
import dut.fr.pokemon.Pokemon;
 
public class Menu extends JFrame implements ActionListener{
	JButton bouton = new JButton("Pokedex");
	JButton bouton2 = new JButton("Combat");
	JButton bouton3 = new JButton("Ligue");
    JButton bouton4 = new JButton("Quitter");
    ArrayList<JButton> listBoutons = new ArrayList<JButton>();
    ArrayList<JLabel> listimg = new ArrayList<JLabel>();
    JPanel panel = new JPanel();
    int c=1;
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
			JPanel pokepanel = new JPanel();
			pokepanel.setPreferredSize(new Dimension(300, 480));
			pokepanel.setLayout(new FlowLayout());

			JButton precedent = new JButton("Précédent");
			System.out.println(c);
			precedent.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			    	  while(listimg.size()>0) {   // s'il y a des bouton on supprime
			    		  	pokepanel.remove(listimg.get(listimg.size()-1));
			                listimg.remove(listimg.size()-1);
			                pokepanel.repaint();
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
						pokepanel.add(labelpicture);
						pokepanel.revalidate();
						pokepanel.repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JLabel idpoke = new JLabel("id: "+c);
					listimg.add(idpoke);
					pokepanel.add(idpoke);
					JLabel namepoke = new JLabel("nom: "+a.getName());
					listimg.add(namepoke);
					pokepanel.add(namepoke);
					JLabel heightpoke = new JLabel("taille: "+a.getHeight()+" cm");
					listimg.add(heightpoke);
					pokepanel.add(heightpoke);
					JLabel weightpoke = new JLabel("poids: "+a.getWeight()+" kg");
					listimg.add(weightpoke);
					pokepanel.add(weightpoke);
			      }  
			    });
			JButton suivant = new JButton("Suivant");
			suivant.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			    	  while(listimg.size()>0) {   // s'il y a des bouton on supprime
			    		  	pokepanel.remove(listimg.get(listimg.size()-1));
			                listimg.remove(listimg.size()-1);
			                pokepanel.repaint();
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
						pokepanel.add(labelpicture);
						pokepanel.revalidate();
						pokepanel.repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JLabel idpoke = new JLabel("id: "+c);
					listimg.add(idpoke);
					pokepanel.add(idpoke);
					JLabel namepoke = new JLabel("nom: "+a.getName());
					listimg.add(namepoke);
					pokepanel.add(namepoke);
					JLabel heightpoke = new JLabel("taille: "+a.getHeight()+" cm");
					listimg.add(heightpoke);
					pokepanel.add(heightpoke);
					JLabel weightpoke = new JLabel("poids: "+a.getWeight()+" kg");
					listimg.add(weightpoke);
					pokepanel.add(weightpoke);
					
			      }  
			    });
			JButton retourmenu = new JButton("Retour Menu");
			retourmenu.addActionListener(new ActionListener(){  
			      public void actionPerformed(ActionEvent ae){  
			        System.exit(0);  
			      }  
			    });
			
            
			pokepanel.add(precedent);
			pokepanel.add(suivant);
			pokepanel.add(retourmenu);
			JLabel idsearch = new JLabel("id: ");
			pokepanel.add(idsearch);
			JTextField textfield = new JTextField();
			textfield.setColumns(20); //On lui donne un nombre de colonnes à afficher
			pokepanel.add(textfield);
			textfield.addActionListener(new ActionListener(){
				        public void actionPerformed(ActionEvent e){
				            while(listimg.size()>0) {   // s'il y a des bouton on supprime
				    		  	pokepanel.remove(listimg.get(listimg.size()-1));
				                listimg.remove(listimg.size()-1);
				                pokepanel.repaint();
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
							pokepanel.add(idwrong);
				            c=1;
				            }
				            Pokemon a =Pokedex.getPokemon(c);
							System.out.println(a);
					        Image picture;
							try {
								picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+a.getImgPath()));
								JLabel labelpicture = new JLabel(new ImageIcon(picture));
								listimg.add(labelpicture);
								pokepanel.add(labelpicture);
								pokepanel.revalidate();
								pokepanel.repaint();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							JLabel idpoke = new JLabel("id: "+c);
							listimg.add(idpoke);
							pokepanel.add(idpoke);
							JLabel namepoke = new JLabel("nom: "+a.getName());
							listimg.add(namepoke);
							pokepanel.add(namepoke);
							JLabel heightpoke = new JLabel("taille: "+a.getHeight()+" cm");
							listimg.add(heightpoke);
							pokepanel.add(heightpoke);
							JLabel weightpoke = new JLabel("poids: "+a.getWeight()+" kg");
							listimg.add(weightpoke);
							pokepanel.add(weightpoke);
				            pokepanel.revalidate();
				            pokepanel.repaint();
				        }
				    }
				);
			
			
			Image picture;
			try {
				picture = ImageIO.read(new File("RessourcesPokemon-20191205/"+a.getImgPath()));
				JLabel labelpicture = new JLabel(new ImageIcon(picture));
				listimg.add(labelpicture);
				pokepanel.add(labelpicture);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JLabel idpoke = new JLabel("id: "+c);
			listimg.add(idpoke);
			pokepanel.add(idpoke);
			JLabel namepoke = new JLabel("nom: "+a.getName());
			listimg.add(namepoke);
			pokepanel.add(namepoke);
			JLabel heightpoke = new JLabel("taille: "+a.getHeight()+" cm");
			listimg.add(heightpoke);
			pokepanel.add(heightpoke);
			JLabel weightpoke = new JLabel("poids: "+a.getWeight()+" kg");
			listimg.add(weightpoke);
			pokepanel.add(weightpoke);
			
			
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
    }
    
    public  static void main(String args[])
    {
        new Menu();
    }
}
   