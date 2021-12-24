
public class Fou extends Piece{
	
	public Fou(boolean couleur)
	{
		super(couleur,"Fou");
	}
	
	public boolean deplacement(Case case_dep, Case case_arv){
		if ( case_dep.getLigne() - case_arv.getLigne() == +(case_dep.getColonne() - case_arv.getColonne()))   {return true;}
		else if(case_dep.getLigne() - case_arv.getLigne() == -(case_dep.getColonne() - case_arv.getColonne())){return true;}
		return false;
	}
	

}
