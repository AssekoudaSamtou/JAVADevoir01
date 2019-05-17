package exercice02;

public class Test {

	public static void main(String[] args) {
		String[] noms = {"Isabelle", "Frederic", "Patricia", "Vlad", "Irène", "Dimitri", "Rober", "Zack", "Alex"};
		Arbre monArbre = new Arbre(noms);
		
//		System.out.println(Arbre.hauteur(monArbre));
//		Arbre.inserer(monArbre, "samtou");
		System.out.println(Arbre.rechercher(monArbre, "samtou"));
		System.out.println(Arbre.max(monArbre).getNom());
		System.out.println(Arbre.min(monArbre).getNom());
		System.out.println(Arbre.estABR(monArbre));
		System.out.println(Arbre.supprimerMax(monArbre));
		System.out.println(Arbre.supprimer(monArbre, "alex").getNom());
		Arbre.afficher(monArbre);
	}
}
