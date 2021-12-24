	
public class Case {
	
	private Piece piece;
	private int ligne;
	private int colonne;
	
	public Case() {}
	
	public Case(int ligne,int colonne)
	{
		this.ligne = ligne;
		this.colonne = colonne;
		this.piece = null ;
	}
	
	public Case(int ligne,int colonne,Piece pi)
	{
		this.ligne = ligne;
		this.colonne = colonne;
		this.piece = pi ;
	}
	
	public Piece getPiece()
	{
		return this.piece;
	}
	
	public int getLigne() 
	{
		return this.ligne;
	}
	
	public int getColonne() 
	{
		return this.colonne;
	}
	
	public void setLigne(int nvl_ligne)
	{
		this.ligne = nvl_ligne;
	}

	public void setColonne(int nvl_colonne)
	{
		this.ligne = nvl_colonne;
	}
	
	public void setPiece(Piece p)
	{
		this.piece = p;
	}
	
	public boolean estVide() 
	{
		if (this.getPiece() == null) 
		{
			return true;
		}
		return false; 
	}
	public boolean estOccupe() 
	{
		if (this.getPiece() != null)
		{
			return true;
		}
		return false; 
	}
	
	public String getNomColonne()
	{
		switch (this.colonne)
		{
			case 0 : return "A";
			case 1 : return "B";
			case 2 : return "C";
			case 3 : return "D";
			case 4 : return "E";
			case 5 : return "F";
			case 6 : return "G";
			case 7 : return "H";
			default: return "?";
	
		}		
	}
	
	public String toString()
	{
		String c = "";
		if (this.getPiece() == null) 
		{
			c += "Il n'y a pas de piece dans cette case";
		}
		else 
		{
			c += "Piece : "     + this.piece.toString();
		}
		c += " / Ligne = " + this.getLigne();
		c += " / Colonne = "  + this.getNomColonne();
		return c;
	}
	
	public boolean isPromotion(){
    	if(this.getPiece().getCouleur() == "noir" && this.getPiece().getNom() == "Pion" && this.getLigne() == 7){
    		return true;
    	}
    	if(this.getPiece().getCouleur() == "blanc" && this.getPiece().getNom() == "Pion" && this.getLigne() ==0){
    		return true;
    	}
    	else return false;
    }
	
}
