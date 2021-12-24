
public class Cavalier extends Piece{
	
	public Cavalier(boolean couleur)
	{
		super(couleur,"Cavalier");
	}
	
	public boolean deplacement(Case case_dep, Case case_arv){
		if 		(case_dep.getLigne() == case_arv.getLigne() +2 && case_dep.getColonne() == case_arv.getColonne()-1)	{return true ;}
		else if (case_dep.getLigne() == case_arv.getLigne() +2 && case_dep.getColonne() == case_arv.getColonne()+1) {return true ;}
		else if (case_dep.getLigne() == case_arv.getLigne() -2 && case_dep.getColonne() == case_arv.getColonne()-1) {return true ;}
		else if (case_dep.getLigne() == case_arv.getLigne() -2 && case_dep.getColonne() == case_arv.getColonne()+1) {return true ;}
		else if (case_dep.getLigne() == case_arv.getLigne() -1 && case_dep.getColonne() == case_arv.getColonne()-2) {return true;}
		else if (case_dep.getLigne() == case_arv.getLigne() -1 && case_dep.getColonne() == case_arv.getColonne()+2) {return true;}
		else if (case_dep.getLigne() == case_arv.getLigne() +1 && case_dep.getColonne() == case_arv.getColonne()-2) {return true;}
		else if (case_dep.getLigne() == case_arv.getLigne() +1 && case_dep.getColonne() == case_arv.getColonne()+2) {return true;}
		return false;
		
	}

}
