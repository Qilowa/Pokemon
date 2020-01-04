package dut.fr.pokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * PokemonTeam this is a container of pokemon
 * 
 */
public class PokemonTeam implements Serializable{
	private static final long serialVersionUID = 1698139518706136991L;
	
	private final ArrayList<FightingPokemon> array;
	private static final int MAX_SIZE=6;
	private int size;
	
	
	public PokemonTeam() {
		this.array = new ArrayList<FightingPokemon>();
		size = 0;
	}
	
	/**
	 * Add a pokemon to the team
	 * @param p FightingPokemon you want to add
	 */
	public void add(FightingPokemon p) {
		
		if (this.size >= MAX_SIZE) {
			throw new IllegalStateException("Your team is already full");
		}
		array.add(p);
		size++;
	}
	
	@Override
	public String toString() {
		return array.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PokemonTeam)) {
			return false;
		}
		PokemonTeam team = (PokemonTeam) o;
		return team.size == this.size && this.array.equals(team.array);
	}
	/**
     * hashcode
     */
	@Override
	public int hashCode() {
		return Objects.hash(array, size);
	}
	/**
     * createTeam of pokemon
     * @param p Pokedex the pokemon you can choose
     * @return int if the teal is create
     */
	public int createTeam(Pokedex p) {
		//reprendre ou continuer
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous reprendre votre partie ou recommencer une nouvelle ? (0 for resume and 1 for load) :");
	    int game = sc.nextInt();
	    while(game!=0 && game!=1) {
			System.out.println("incorrect réessayer");
		    int cptest = sc.nextInt();
		    if (cptest==0||cptest==1) {
		    	game=cptest;
				break;
			}
	    }
	    if (game==1) {
			System.out.println("load");
			return 1;
		}
	    else {
		System.out.println("Combien de Pokémon voulez-vous ? (max : 6) ");
	    int nb = sc.nextInt();
	    while(nb > 6 || nb < 1) {
			System.out.println("incorrect réessayer");
			System.out.println("Combien de Pokémon voulez-vous ? (max 6) ");
		    int nb1 = sc.nextInt();
		    if (nb1<=6 && nb1>=1) {
				nb=nb1;
				break;
			}
		}
		for (int i = 0; i <nb; i++) {
			while (true) {
			System.out.println(p);
		    System.out.println("Choissisez un Pokémon (id) : ");
		    int pk = sc.nextInt();
		    while(pk > (p.getSize()) || pk<1) {
				System.out.println("incorrect réessayer");
			    int cptest = sc.nextInt();
			    if (cptest < (p.getSize()+1) && cptest > 0) {
			    	pk=cptest;
					break;
				}
		    }
		    
		    System.out.println("Vous avez saisi le Pokémon : " + p.getPokemon(pk));
		    FightingPokemon pokemon = FightingPokemon.createFightingPokemon(pk);
		    System.out.println(pokemon);
		    ArrayList<Capacity> capacitylist=Capacitylist.capacitychoice(p.getPokemon(pk).getTypes());//pk.gettype()
			for(int y = 0; y < capacitylist.size(); y++){
		      System.out.println("id: " + y +" " + capacitylist.get(y));
		    }
		    System.out.println("Choissisez votre 1ére capacité (id) : ");
		    int cp1 = sc.nextInt();
		    while(cp1 > (capacitylist.size()-1) || cp1 < -1) {
				System.out.println("incorrect réessayer");
				System.out.println("Choissisez votre 1ére capacité (id) : ");
			    int cptest = sc.nextInt();
			    if (cptest < capacitylist.size() && cptest > -1) {
			    	cp1=cptest;
					break;
				}
		    }
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist.get(cp1));
		    pokemon.addCapacity(capacitylist.get(cp1));
		    //pokemon.addpacity(capacity[cp1]);
		    
		    System.out.println("Choissisez votre 2éme capacité (id) (-1 pour ne plus en choisir) : ");
		    int cp2 = sc.nextInt();
		    //bug meme capacité
		    while(cp2 > (capacitylist.size()-1) || cp2 < -1 || pokemon.getCapacities()[0]==capacitylist.get(cp2)) {
				System.out.println("incorrect réessayer");
				System.out.println("Choissisez votre 2éme capacité (id) (-1 pour ne plus en choisir) : ");
			    int cptest = sc.nextInt();
			    if (cptest < capacitylist.size() && cptest > -1 && pokemon.getCapacities()[0]!=capacitylist.get(cptest)) {
			    	cp2=cptest;
					break;
				}
			    if (cptest==-1) {
			    	cp2=cptest;
			    	break;
				}
			}
		    if (cp2==-1) {
		    	this.add(pokemon);
		    	break;
			}
		    
		    System.out.println("Vous avez saisi la Capacite : " + capacitylist.get(cp2));
		    pokemon.addCapacity(capacitylist.get(cp2));
		    //pokemon.addpacity(capacity[cp2]);
		    
		    System.out.println("Choissisez votre 3eme capacite (id) (-1 pour ne plus en choisir) : ");
		    int cp3 = sc.nextInt();
		    while(cp3 > (capacitylist.size()-1) || cp3 < -1 || pokemon.getCapacities()[0]==capacitylist.get(cp3) || pokemon.getCapacities()[1]==capacitylist.get(cp3)) {
				System.out.println("incorrect réessayer");
				System.out.println("Choissisez votre 3éme capacité (id) (-1 pour ne plus en choisir) : ");
			    int cptest = sc.nextInt();
			    if (cptest < capacitylist.size() && cptest > -1 && pokemon.getCapacities()[0]!=capacitylist.get(cptest) && pokemon.getCapacities()[1]!=capacitylist.get(cptest)) {
			    	cp3=cptest;
					break;
				}
			    if (cptest==-1) {
			    	cp3=cptest;
			    	break;
				}
			}
		    if (cp3==-1) {
		    	this.add(pokemon);
		    	break;
			}
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist.get(cp3));
		    pokemon.addCapacity(capacitylist.get(cp3));
		    //pokemon.addpacity(capacity[cp3]);
		    
		    
		    System.out.println("Choissisez votre 4éme capacité (id) (-1 pour ne plus en choisir) : ");
		    int cp4 = sc.nextInt();
		    while(cp4 > (capacitylist.size()-1) || cp4 < -1 || pokemon.getCapacities()[0]==capacitylist.get(cp4) || pokemon.getCapacities()[1]==capacitylist.get(cp4) || pokemon.getCapacities()[2]==capacitylist.get(cp4)) {
				System.out.println("incorrect réessayer");
				System.out.println("Choissisez votre 4éme capacité (id) (-1 pour ne plus en choisir) : ");
			    int cptest = sc.nextInt();
			    if (cptest < capacitylist.size() && cptest > -1 && pokemon.getCapacities()[0]!=capacitylist.get(cptest) && pokemon.getCapacities()[1]!=capacitylist.get(cptest) && pokemon.getCapacities()[2]!=capacitylist.get(cptest)) {
			    	cp4=cptest;
					break;
				}
			    if (cptest==-1) {
			    	cp4=cptest;
			    	break;
				}
			}
		    if (cp4==-1) {
		    	this.add(pokemon);
		    	break;
			}
		    System.out.println("Vous avez saisi la Capacité : " + capacitylist.get(cp4));
		    pokemon.addCapacity(capacitylist.get(cp4));
		    //pokemon.addpacity(capacity[cp4]);
		    
		    
		    this.add(pokemon);
		    break;
			}
		    
	    }
		
	    System.out.println("Voici vos pokémons : ");
	    System.out.println(array);
	    return 0;
	    }
	}
	
	private boolean isEmpty() {
		if (array.size() <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Return a boolean to specify if the pokemons' team are all KO
	 * @return true if they are all ko, false otherwise
	 */
	public boolean haveLost() {
		if (this.isEmpty()) {
			throw new IllegalStateException("Please add pokemon to your team");
		}
		for (int i=0; i<array.size(); i++) {
			FightingPokemon p = array.get(i);
			if (!p.isKO()) {
				return false;
			}
		}
		return true;
		
	}
	
	public FightingPokemon get(int index) {
		if (index > array.size() || index < 0) {
			return null;
		}
		return array.get(index);
	}
	/**
     * Size this is to get the size of the pokemonTeam
     * 
     * @return int represent the size
     */
	public int size() {
		return array.size();
	}

}
