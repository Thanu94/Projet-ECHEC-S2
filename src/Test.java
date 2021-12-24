
public class Test {
	
	public static void main (String[] args) 
	{
		System.out.println("Debut du programme");
		
		
		Plateau p = new Plateau();
		p.initialisation();
		p.setCase(6,4,new Reine(true));
	    Case[][] plat = p.getPlateau();
	    p.affiche();
	    
	    p.affiche();
	    p.en_echec();
	    System.out.println("Fin du programme");
	}

}
