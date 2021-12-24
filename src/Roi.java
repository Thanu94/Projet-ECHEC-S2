
public class Roi extends Piece{
	
	public Roi(boolean couleur)
	{
		super(couleur,"Roi");
	}
	
	public boolean deplacement(Case case_dep, Case case_arv){
		if 	   (case_dep.getLigne() -1 == case_arv.getLigne()    && case_dep.getColonne()==case_arv.getColonne())      {return true;}
		else if(case_dep.getLigne() +1 == case_arv.getLigne()    && case_dep.getColonne()==case_arv.getColonne() ) 	{return true;}
		else if(case_dep.getColonne() +1 ==case_arv.getColonne() && case_dep.getLigne() == case_arv.getLigne() )     {return true;}
		else if(case_dep.getColonne() -1 ==case_arv.getColonne() && case_dep.getLigne() == case_arv.getLigne() )     {return true;}
		else if(case_dep.getColonne() -1 ==case_arv.getColonne() && case_dep.getLigne() -1 == case_arv.getLigne())  {return true;}
		else if(case_dep.getColonne() -1 ==case_arv.getColonne() && case_dep.getLigne() +1 == case_arv.getLigne())  {return true;}
		else if(case_dep.getColonne() +1 ==case_arv.getColonne() && case_dep.getLigne() -1 == case_arv.getLigne())  {return true;}
		else if(case_dep.getColonne() +1 ==case_arv.getColonne() && case_dep.getLigne() +1 == case_arv.getLigne())  {return true;}
		return false ;
		
	}
	
	public Case[] cases_atteignables(Case case_actuelle) 
	{
		Case[] possible = new Case[8];
		Plateau plateau = new Plateau();
		int l = 0;
		int longueur = plateau.getPlateau().length;
		for (int i=0;i<longueur;i++) {
			for (int j=0;j<longueur;j++) {
				if(this.deplacement(case_actuelle, plateau.getPlateau()[i][j])) 
				{
					possible[l] = (plateau.getPlateau()[i][j]);
					l +=1;
				}
				}
			}
		return possible;
	}
	
}
