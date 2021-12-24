
public class Partie {
	private int numero;  // numero de partie
	private String nom;  // nom de la partie
	
	
	public Partie(){	// constructeur 
		
	}
	
	public Partie(int unNumero, String unNom){
		this.numero = unNumero;
		this.nom = unNom;
	}
	
	public int getNumero(){
		 return this.numero;
	 }
	public String getNom() {
		return this.nom;
	}
	 
	 
	 public void setNumero(int unNumero) {			// réfléchir à changer de nom automatiquement avec un FOR si possible//
		 this.numero = unNumero;
	 }
	 
	 public void setNom(String unNom) { 		
		 this.nom = unNom; 
	 }
	 
	 public void afficher() {
		// String a = "BIENVENUE DANS ECHECS !";
		 System.out.println("	BIENVENUE !");
		 System.out.println("La partie '"+ this.getNom()+"' N°"+ this.getNumero()+ " est crée !");
		 
		 //return s;
	 }

}
