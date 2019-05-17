package exercice02;


public class Arbre {

	private String nom;
	private Arbre gauche;
	private Arbre droite;
	
	public Arbre(String nom) {
		this.nom = nom;
	}
	
	public Arbre(String[] noms) {
		nom = noms[0];
		for(int i = 0; i < noms.length; i++) {
			inserer(this, noms[i]);
		}
	}

	public static int hauteur(Arbre a) {
		
		if (a == null)
			return 0;
		else
			return (1 + Math.max(hauteur(a.getGauche()), hauteur(a.getDroite())));
	}
	
	public static void inserer(Arbre a, String name) {
		if (a == null) 
			a = new Arbre(name);
		
		if (name.compareTo(a.getNom()) <= 0) {
			if (a.getGauche() != null)
				inserer(a.getGauche(), name);
			else
				a.setGauche(new Arbre(name));
		}else {
			if (a.getDroite() != null)
				inserer(a.getDroite(), name);
			else 
				a.setDroite(new Arbre(name));
		}
	}

	public static boolean rechercher(Arbre a, String name) {
		
		if ( name.equals(a.getNom()) )
			return true;
		
		if ((name.compareTo(a.getNom()) < 0 ) && (a.getGauche() != null))
			return rechercher(a.getGauche(), name);
		
		if ((name.compareTo(a.getNom()) > 0) && (a.getDroite() != null))
			return rechercher(a.getDroite(), name);
		
		return false;
	}

	public static Arbre monRechercher(Arbre a, String name) {
		
		if ( name.equals(a.getNom()) )
			return a;
		
		if ((name.compareTo(a.getNom()) < 0 ) && (a.getGauche() != null))
			return monRechercher(a.getGauche(), name);
		
		if ((name.compareTo(a.getNom()) < 0) && (a.getDroite() != null))
			return monRechercher(a.getDroite(), name);
		
		return null;
	}
	
	public static Arbre max(Arbre a) {
		if (a.getDroite() == null)
			return a;
		return max(a.getDroite());
	}

	public static Arbre min(Arbre a) {
		if (a.getGauche() == null)
			return a;
		return min(a.getGauche());
	}

	public static boolean estABR(Arbre a) {
		if (a == null)
			return true;

		if ((a.getGauche() != null) && (a.getGauche().getNom().compareTo(a.getNom()) > 0))
			return false;

		if ((a.getDroite() != null) && (a.getNom().compareTo(a.getDroite().getNom()) > 0))
			return false;

		return (estABR(a.getGauche()) && estABR(a.getDroite()));
	}

	public static String supprimerMax(Arbre a) {
		if (a == null)
			return "null";

		Arbre max = max(a);
		
		if (max.getGauche() == null) {
			String s = max.getNom();
			max = null;
			return s;
		}
		else{
			max = max.getGauche();
			String s = max.getNom();
			return s;
		}

		
	}

	public static Arbre supprimer(Arbre a, String name) {
		if (a == null)
			return a;

		if (name.equals(a.getNom()))
			return supprimerRacine(a);

		if (name.compareTo(a.getNom()) < 0)
			a.setGauche(supprimer(a.getGauche(), name));

		else 
			a.setDroite(supprimer(a.getDroite(), name));
		
		return a;
	}

	public static void afficher(Arbre a) {
		if (a.getGauche() != null)
			afficher(a.getGauche());
		
		System.out.print(a.getNom() + " ");
		
		if (a.getDroite() != null)
			afficher(a.getDroite());
	}

	static Arbre supprimerRacine(Arbre a) {
		if (a.getGauche() == null)
			return a.getDroite();

		if (a.getDroite() == null)
			return a.getGauche();

		Arbre f = dernierDescendant(a.getGauche());
		a.setNom(f.getNom());
		a.setGauche(supprimer(a.getGauche(), f.getNom()));
		
		return f;
	}

	static Arbre dernierDescendant(Arbre a) {
		if (a.getDroite() == null)
			return a;
		return dernierDescendant(a.getDroite());
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Arbre getGauche() {
		return gauche;
	}

	public void setGauche(Arbre gauche) {
		this.gauche = gauche;
	}

	public Arbre getDroite() {
		return droite;
	}

	public void setDroite(Arbre droite) {
		this.droite = droite;
	}
}
