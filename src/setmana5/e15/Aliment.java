package setmana5.e15;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aliment extends Producte {
	Logger logAliment = Logger.getLogger(getClass().getName());
	
	private LocalDate dataCaducitat;

	public Aliment(float preu, String nom, String codi, LocalDate datac) {
		super(preu, nom, codi);
		dataCaducitat = datac;
	}


	@Override
	public float getPreu() {
		double preu = super.preu;
		long dif;
		dif = ChronoUnit.DAYS.between(dataCaducitat,LocalDate.now());
		//preu = preu - (preu*(1/(dif+1)) + (preu*(0.1)));
		//s'ha canviat la formula del calcul del preu per visualitzar les diferències de preu.
		preu = preu - preu*dif;
		//System.out.println("preu:" + preu);
		logAliment.log(Level.INFO, String.valueOf(preu) + " datadiff:" + dif);
		return (float) preu;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Aliment aliment = (Aliment) o;

		return dataCaducitat.equals(aliment.dataCaducitat);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + dataCaducitat.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return new String(getNom() + " " + getPreu());
	}
	


}
