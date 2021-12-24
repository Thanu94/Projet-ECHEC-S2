import java.util.Scanner;

public class Jouer extends Plateau {
	
	
	public static int conv_nb(String a2) {
	if (a2 == "A") 
	{
	  return 0;
	}	
	if (a2 == "B") 
	{
	  return 1;
	}
	if(a2 == "C")
	{
	  return 2;
	}
	if (a2 == "D") 
	{
	  return 3;
	}
	if (a2 == "E")
	{
	  return 4;
	}
	if (a2 == "F")
	{
	  return 5;
	}
	if (a2 == "G") {
	  return 6;
	}
	if (a2 == "H") 
	{
	  return 7;
	}
	return 0;		
}
	
	public static void main(String[]args){
		
		Plateau c = new Plateau();
		Case c2 = new Case(1,1);
				
		//dmd a l'utillisateur la case de depart et la case d'arrivee
		// si le deplacemet est possible on deplace la piece et affiche l'echiquier		
		
		try ( Scanner scanner = new Scanner( System.in ) ) {
			
	        System.out.print( "Entrez uniquement des chiffre ! \n\r");
			System.out.print( "Veuillez saisir la ligne de la case de départ : " );
			int a = scanner.nextInt();															// a = ligne_dep
			System.out.print( "OK \n\r");
			System.out.print( "Veuillez saisir la colonne de la case de départ : " );			// a2 = collone_d
			String a2 = scanner.nextLine();
			System.out.print( "OK \n\r");
			System.out.print(conv_nb(a2));
			System.out.print( "OK \n\r");()
			
			System.out.print( "Veuillez saisir la ligne de la case d'arrivée : " );
			int b = scanner.nextInt();															// b = ligne_arrivé
			System.out.print( "OK \n\r");
			System.out.print( "Veuillez saisir la colonne de la case d'arrivée : " );			// b2 = colonnn_arrivé
			String b2 = scanner.nextLine();
			System.out.print("OK \n\r");
			conv_nb(b2);
			
			System.out.println("valeur reçus : \n\r");
			System.out.println("________ \n\r");
			System.out.println("Case de départ :");
			System.out.println(a);
			System.out.println(a2 + "\n\r");
			System.out.println("________ \n\r");
			System.out.println("Case d'arrivé : \n\r");
			System.out.println(b);
			System.out.println(b2);
			System.out.println("________ \n\r");
			
		}
		
		
	}

}
