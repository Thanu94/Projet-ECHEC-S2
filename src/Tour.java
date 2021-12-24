
public class Tour extends Piece{
	
	public Tour(boolean couleur)
	{
		super(couleur,"Tour");
	}
	
	public boolean deplacement(Case case_dep, Case case_arv){
		for (int t=1;t<7;t++){
			if		(case_dep.getLigne() + t == case_arv.getLigne() && case_dep.getColonne()==case_arv.getColonne())   {return true;}
			else if (case_dep.getLigne() - t == case_arv.getLigne() && case_dep.getColonne()==case_arv.getColonne())   {return true;}
			}
		
		for (int p=1;p<7;p++){
			if 		(case_dep.getColonne() + p ==  case_arv.getColonne() && case_dep.getLigne() == case_arv.getLigne()){return true;}
			else if (case_dep.getColonne() - p ==  case_arv.getColonne() && case_dep.getLigne() == case_arv.getLigne()){return true;}
			}
		return false ;
	}

}
