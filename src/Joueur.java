

public class Joueur {

	private boolean couleur;
	
	public Joueur(){
		
	}
	
	public Joueur(boolean c){
		this.couleur = c;
	}

	public String getCouleur(){
		if (couleur) {return "noir";}
		else return "blanc";
	}

}

