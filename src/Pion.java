
public class Pion extends Piece{
	
	private boolean premierCoup;
	
	public Pion(boolean couleur)
	{
		super(couleur,"Pion");
		this.premierCoup = true;
	}
	
	public boolean getpremierCoup() {return this.premierCoup;}
	public void setpremierCoup() {this.premierCoup = false;}
	
	public boolean deplacement(Case case_dep, Case case_arv){
		if(this.getpremierCoup() == true)
		{
			if(this.getCouleur() == "noir" && (case_dep.getLigne()+2) == case_arv.getLigne() && case_dep.getColonne() == case_arv.getColonne()) 
			{
				return true;
			}
			else if(this.getCouleur() == "blanc" && (case_dep.getLigne()-2) == case_arv.getLigne() && case_dep.getColonne() == case_arv.getColonne()) 
			{
				return true;
			}
			this.setpremierCoup();
		}
		
		
		if(this.getCouleur() == "noir" && (case_dep.getLigne()+1) == case_arv.getLigne() && case_dep.getColonne() == case_arv.getColonne()) 
		{
			return true;
		}
		else if(this.getCouleur() == "blanc" && (case_dep.getLigne()-1) == case_arv.getLigne() && case_dep.getColonne() == case_arv.getColonne()) 
		{
			return true;
		}
		
		if (case_arv.estOccupe() == true && case_arv.getPiece().getCouleur() != case_dep.getPiece().getCouleur()) 
		{
			if 	   (case_dep.getLigne() - case_arv.getLigne() ==  1 && case_dep.getColonne() - case_arv.getColonne() == 1) {return true;}
			else if(case_dep.getLigne() - case_arv.getLigne() == -1 && case_dep.getColonne() - case_arv.getColonne() == -1){return true;}
		}
		return false;
		
	}
	
}
