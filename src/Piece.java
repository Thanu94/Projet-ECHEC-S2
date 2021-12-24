
public class Piece 
{
	private boolean couleur ;
	private String nom;
	
	/// Constructeur
	public Piece() {
		
	}
	
	public Piece (boolean uneCouleur,String unNom) 
	{
		this.couleur = uneCouleur ;
		this.nom     = unNom;
	}
	/// Getters
	public boolean getBCouleur() {return couleur;}
	public String getCouleur() 
	{
		if (couleur) {return "noir";}
		else return "blanc";
	}
	
	public String getNom() 
	{
		return this.nom;
	}
	/// Setters
	public void setCouleur(boolean uneCouleur) 
	{
			this.couleur = uneCouleur;
	}
	
	public void setNom(String unNom)
	{
		this.nom = unNom;
	}
	
	public boolean deplacement(Case case_dep,Case case_arv) 
	{
		return true;
	}
	
	public String toString() 
	{
		return this.getCouleur()+" / "+this.getNom();
	}
	
}

