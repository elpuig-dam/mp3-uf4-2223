package setmana5.e15;

public abstract class Producte {
	protected float preu;
	private String nom;
	private String codibarres;
	
	public Producte(float preu, String nom, String codi) {
		this.preu = preu;
		this.nom = nom;
		codibarres = codi;
	}


	abstract public float getPreu();

	public void setPreu(float preu) {
		this.preu = preu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCodibarres() {
		return codibarres;
	}
	public void setCodibarres(String codibarres) {
		this.codibarres = codibarres;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		else {
			Producte p = (Producte) obj;
			if (codibarres.equals(p.getCodibarres()) && getPreu() == p.getPreu()) return true;
			//if (codibarres.equals(p.getCodibarres())) return true;
			else return false;
		}
	}



	@Override
	public int hashCode() {
		return codibarres.hashCode() + String.valueOf(getPreu()).hashCode();
	}




}
