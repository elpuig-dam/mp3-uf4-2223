package setmana5.e15;

public class Textil extends Producte {
	private String composicio;

	public Textil(float preu, String nom, String codi, String compo) {
		super(preu, nom, codi);
		composicio = compo;
	}

	public String getComposicio() {
		return composicio;
	}

	public void setComposicio(String composicio) {
		this.composicio = composicio;
	}

	@Override
	public String toString() {
		return new String(getNom() + " " + getPreu());
	}


	@Override
	public float getPreu() {
		return super.preu;
	}
}
