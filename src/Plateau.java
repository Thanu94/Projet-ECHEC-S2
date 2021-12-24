import java.util.Scanner;


public class Plateau {
	

	private Case[][] plateau;
	
	public Plateau() 
	{
		this.plateau = new Case[8][8];
	}
	
	// Initialisation de l'échiquier 
	
	public String initialisation()
	{
		for(int i = 0; i < this.plateau.length; i++){
			for(int j = 0; j < this.plateau.length; j++){
				this.plateau[i][j] = new Case(i,j);
			}
		}
		
		this.setCase(0,4,new Roi(true));
		this.setCase(0,3,new Reine(true));
		this.setCase(0,0,new Tour(true));
		this.setCase(0,7,new Tour(true));
		this.setCase(0,2,new Fou(true));
		this.setCase(0,5,new Fou(true));
		this.setCase(0,1,new Cavalier(true));
		this.setCase(0,6,new Cavalier(true));
		
		for(int i =0;i<8;i++) 
		{
			this.setCase(1,i,new Pion(true));
		}
		
		this.setCase(7,4,new Roi(false));
		this.setCase(7,3,new Reine(false));
		this.setCase(7,0,new Tour(false));
		this.setCase(7,7,new Tour(false));
		this.setCase(7,2,new Fou(false));
		this.setCase(7,5,new Fou(false));
		this.setCase(7,1,new Cavalier(false));
		this.setCase(7,6,new Cavalier(false));
		
		for(int i =0;i<8;i++) 
		{
			this.setCase(6,i,new Pion(false));
		}
		
		return "Le plateau est initialisée";
		
	}
	
	public void setCase(int abs, int ord, Piece pi)
	{
		this.plateau[abs][ord] = new Case(abs,ord,pi);
	}
	
	public String toString()
	{
		String c = "";
		for(int i = 0; i < this.plateau.length; i++){
			for(int j = 0; j < this.plateau.length; j++){
				c += this.plateau[i][j].toString()+"\n";
			}
		}
		return c;
	}
	
	public void affiche(){

        for(int i = plateau.length-1; i >= 0; i--){
            System.out.print((i+1));
            System.out.print(" | ");
            for(int j=0; j<plateau[i].length; j++){
                if(plateau[i][j].getPiece()!= null){
                    if(plateau[i][j].getPiece().getCouleur() == "blanc"){
                        if(plateau[i][j].getPiece().getNom() == "Reine"){
                            System.out.print("Dn | ");
                        }else{
                            System.out.print(  plateau[i][j].getPiece().getNom().charAt(0)+"n | ");
                        }
                    }else{
                        if(plateau[i][j].getPiece().getNom() == "Reine"){
                            System.out.print("Db | ");
                        }else{
                            System.out.print( plateau[i][j].getPiece().getNom().charAt(0)+"b | ");
                        }
                    }
                }
                else{
                    System.out.print("   | ");
                }
            }
            System.out.println(" ");
        }
        System.out.println("    A    B    C    D    E    F    G    H");
    }
	
	public Case[][] getPlateau()  //tab ou ps uml 
	{
		return this.plateau;
	}
	
	// Verifie si chaque piece ne passe pas au dessus d'une autre dans son deplacement (aide d'internet réadapté au programme)
	
	public boolean depla_pion(Case c1,Case c2) 
	{

		if(c1.getPiece().getNom() == "Pion" && c1.getPiece().getCouleur() == "blanc") 
		{
			for(int i = c1.getLigne();i<=c2.getLigne();i++) 
			{
				if(this.getPlateau()[i+1][c1.getColonne()].estOccupe())
				{
					System.out.println("Vous ne pouvez pas faire ce deplacement car vous passez au dessus d'une piece");
					return false;
				}
			}
		}
		
		if(c1.getPiece().getNom() == "Pion" && c1.getPiece().getCouleur() == "noir") 
		{
			for(int i = c2.getLigne();i<=c1.getLigne();i++) 
			{
				if(this.getPlateau()[i+1][c1.getColonne()].estOccupe())
				{
					System.out.println("Vous ne pouvez pas faire ce deplacement car vous passez au dessus d'une piece");
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean depla_tour(int a,int b) 
	{
		if(a.getLigne() != b.getLigne() && a.getColonne() ==b.getColonne()){
	    	if(a.getLigne() > b.getLigne()){ // droite vers gauche
	    		for(int i=a.getLigne()-1;i>b.getLigne();i--){
	
	    			if(this.getPlateau()[i][b.getColonne()].estOccupe()){
	    				return false;
	    			}
	    		}
	    		return true;
	    	}
	    	if(a.getLigne() < b.getLigne()){ // droite vers gauche
	    		for(int i=a.getLigne()+1;i<b.getLigne();i++){
	
	    			if(this.getPlateau()[i][b.getColonne()].estOccupe()){
	    				return false;
	    			}
	    		}
	    		return true;
	    	}
	    }
		
	    if(a.getColonne() != b.getColonne() && a.getLigne() == b.getLigne()){
	    	if(a.getColonne() > b.getColonne()){ // bas vers haut
	    		for(int i=a.getColonne()-1;i>b.getColonne();i--){
	
	    			if(this.getPlateau()[b.getLigne()][i].estOccupe()){
	    				return false;
	    			}
	    		}
	    		return true;
	    	}
	    	if(a.getColonne() < b.getColonne()){ // haut vers bas
	    		for(int i=a.getColonne()+1;i<b.getColonne();i++){
	
	    			if(this.getPlateau()[b.getLigne()][i].estOccupe()){
	    				return false;
	    			}
	    		}
	    	return true;
	    	}
	    }
	    return false;
	}
	
	public boolean depla_fou(Case c1,Case c2) 
	{
		int a =c1.getLigne();
		int b =c1.getColonne();
		int c =c2.getLigne();
		int d =c2.getColonne();
				
		if(c>a && d>b){
    		while(a != c-1 && b != d-1){
    			
    			if(this.getPlateau()[c-1][d-1].estOccupe()){
    				return false;
    			}
    			c--;
    			d--;
    		}
    		return true;
    	}
    	//Si va vers le haut droit
    	if(d<a && d>b){
    		while(a != c+1 && b != d-1){
    			
    			if(this.getPlateau()[c+1][d-1].estOccupe()){
    				return false;
    			}
    			c++;
    			d--;
    		}
    		return true;
    	}
    	//Vers le bas a gauche
    	
    	if(c>a && d<b){
    		while(a != c-1 && b != d+1){
    			
    			if(this.getPlateau()[c-1][d+1].estOccupe()){
    				return false;
    			}
    			c--;
    			d++;
    		}
    		return true;
    	}
    	//Vers le bas a droite
    	if(c2.getLigne()<a && d<b){
    		while(a != c+1 && b != d+1){
    			
    			if(this.getPlateau()[c+1][c2.getColonne()+1].estOccupe()){
    				return false;
    			}
    			c++;
    			d++;
    		}
    		return true;
    	}
        return false;
	}
	
	public boolean depla_reine(Case c1,Case c2)
	{
		if((!(this.depla_fou(c1, c2))) && (!(this.depla_tour(c1, c2)))) 
		{
			return false;
		}
		return true;
	}
	
	public boolean met_en_echec()
	{
		
		return false;
	}
	
	/// Deplacement et promotion 
	
	public boolean deplacement_piece(Case c1, Case c2) {
		String retour = "";
		String fait = "La pièce a été deplacée ";
		if (c1.getColonne()>8 || c1.getLigne()>8 || c2.getLigne()>8 || c2.getColonne()>8)
		{
			System.out.println("Les coordonnées ne sont pas valides");
			return false;
		}
		if (c1.estVide())
		{
			System.out.println("La case de départ est vide");
			return false;
		}
		if(c2.estOccupe() && c2.getPiece().getCouleur() == c1.getPiece().getCouleur())
		{
			System.out.println("La case d'arrivee est occupee par une piece de la meme couleur");
			return false;
		}

		Piece p = this.getPlateau()[c1.getLigne()][c1.getColonne()].getPiece();
		
		if (p.getNom() == "Pion")
		{
			if (!(this.depla_pion(c1, c2))) 
			{
				System.out.println("Vous ne pouvez pas faire ce deplacement car vous passez au dessus d'un piece");
				return false;
			}
				
		}
		if (p.getNom() == "Tour")
		{
			if ((this.depla_tour(c1, c2))) 
			{				
				System.out.println("Vous ne pouvez pas faire ce deplacement car vous passez au dessus d'un piece");
				return false;
}
				
		}
		if (p.getNom() == "Fou")
		{
			if (!(this.depla_fou(c1, c2))) 
			{
				System.out.println("Vous ne pouvez pas faire ce deplacement car vous passez au dessus d'un piece");
				return false;
			}
				
		}
		if (p.getNom() == "Reine")
		{
			if (!(this.depla_reine(c1, c2))) 
			{
				System.out.println("Vous ne pouvez pas faire ce deplacement car vous passez au dessus d'un pion");
				return false;
			}
				
		}
		
		if(p.getNom() == "Roi") 
		{
			if(this.met_en_echec())
			{
				System.out.println("Ce deplacement met le roi en echec");
				return false;
			}
		}
		
		if (p.deplacement(c1, c2) == true) {
			c2.setPiece(c1.getPiece());
			c1.setPiece(null);
		}
		else 
		{
			System.out.println( "Ce deplacement est impossible pour cette pièce");
			return false;
		}
		
		if(c2.isPromotion())
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Vous pouvez promouvoir votre pion en position " + c2.getLigne() +", "+ c2.getColonne() + " en quoi souhaitez vous le promouvoir ?(Fou(1) ou Cavalier(2) ou Reine(3) ou Tour(4)");
			int choix = sc.nextInt();
			while (choix != 1 && choix != 2 && choix != 3 && choix != 4) 
			{
				System.out.println("Veuillez entrer un numero de piece valide(Fou(1) ou Cavalier(2) ou Reine(3) ou Tour(4))");
				choix = sc.nextInt();
			}
			String choix1;
			if 		(choix == 1) {choix1 = "Fou";}
			else if (choix == 2) {choix1 = "Cavalier";}
			else if (choix == 3) {choix1 = "Reine";}
			else 	{choix1 = "Tour";}
			this.setCase(c2.getLigne(), c2.getColonne(), new Piece(p.getBCouleur(), choix1));
			sc.close();
			retour = "Votre pion a bien été changé en " + choix1 ;
		}
		System.out.println(fait + "\n" + retour);
		return true;
	}
	
	/// Localisation roi
	
	public Case roi_noir() 
	{
		Case roi_noir = new Case();
		for(int i = 0; i < this.plateau.length; i++){
    		for(int j = 0; j < this.plateau[i].length; j++){
    			if(this.plateau[i][j].getPiece() != null && this.plateau[i][j].getPiece().getNom() == "Roi"){
    				if(this.plateau[i][j].getPiece().getCouleur() == "noir"){
    					roi_noir = new Case(i,j,new Roi(true));
    				}
    			}
    		}
		}
		return roi_noir;
	}
			
    public Case roi_blanc() 
    {
    	Case roi_blanc = new Case();
		for(int i = 0; i < this.plateau.length; i++){
    		for(int j = 0; j < this.plateau[i].length; j++){
    			if(this.plateau[i][j].getPiece() != null && this.plateau[i][j].getPiece().getNom() == "Roi"){
    				if(this.plateau[i][j].getPiece().getCouleur() == "blanc"){
    					roi_blanc = new Case(i,j,new Roi(false));
    				}
    			}
    		}
		}
		return roi_blanc;
    }
    
	/// Echec 
	
	public boolean en_echec() 
	{
		Case RB_case = this.roi_blanc();
		Case RN_case = this.roi_noir();
		
		
		Case[][] tab = this.getPlateau();
		for (int i=0;i<7;i++) {
			for (int j=0;j<7;j++) {
				if (!(tab[i][j].estVide()))
				{
					if(tab[i][j].getPiece().getCouleur() == "noir" && this.deplacement_piece(tab[i][j], RB_case) == true) 
					{
						System.out.println("La piece en "+i +" / " + j + " met le roi blanc en echec");
						return true;
					}
					else if(tab[i][j].getPiece().getCouleur() == "blanc" && this.deplacement_piece(tab[i][j], RN_case) == true)
					{
						System.out.println("La piece en "+i +" / " + j +" met le roi noir en echec");
						return true;
					}
				}
			}
		}
		System.out.println("Aucun roi n'est en échec");
		return false;
	}
	
	/*public boolean en_mat() 
	{
		
		
		
	}
	*/
}