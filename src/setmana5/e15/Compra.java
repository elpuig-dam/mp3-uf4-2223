package setmana5.e15;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Compra {
	public static final String NOM_SUPERMERCAT = "PUIGMERCAT";

	private List<Aliment> llista_ali;
	private List<Electronica> llista_elec;
	private List<Textil> llista_textil;
	
	public Compra() {
		llista_ali = new ArrayList<Aliment>();
		llista_elec = new ArrayList<Electronica>();
		llista_textil = new ArrayList<Textil>();
	}
	
	public static void main(String... args) {

		Compra compra = new Compra();
		System.out.println("BENVINNGUT AL " + Compra.NOM_SUPERMERCAT);
		MenuSuper menuSuper = new MenuSuper(compra);
		menuSuper.mainMenu();

				
	}
	//Afegir aliment a la llista d'aliments
	public void addAliment(Aliment aliment) {
		llista_ali.add(aliment);
	}

	//Afegir textil a la llista de productes tèxtils
	public void addTextil(Textil textil) {

		llista_textil.add(textil);
	}

	//Afegir textil a la llista de productes tèxtils
	public void addElectronica(Electronica electronica) {
		llista_elec.add(electronica);
	}

	//Llistar les tres llistes
	public void printCarret() {
		Map<String,Integer> llista = new HashMap<>();

		//busquem els productes d'alimentació amb el mateix codi de barres
		for(Aliment a : llista_ali) {
			if(!llista.containsKey(a.getCodibarres())) 	llista.put(a.getCodibarres(),1);
			else llista.put(a.getCodibarres(),llista.get(a.getCodibarres()) + 1);
		}
		llista.forEach((k,v)-> System.out.println(getNomProducte(k) + " -> " + (Integer) v));
		llista.clear(); //netejar map perquè es fa servir en la següent cerca

		//busquem els productes tèxtils amb el mateix codi de barres
		for(Textil a : llista_textil) {
			if(!llista.containsKey(a.getCodibarres())) llista.put(a.getCodibarres(),1);
			else llista.put(a.getCodibarres(),llista.get(a.getCodibarres()) + 1);
		}
		llista.forEach((k,v)-> System.out.println(getNomProducte(k) + " -> " + (Integer) v));
		llista.clear(); //netejar map perquè es fa servir en la següent cerca

		//busquem els productes d'electrònica amb el mateix codi de barres
		for(Electronica a : llista_elec) {
			if(!llista.containsKey(a.getCodibarres())) llista.put(a.getCodibarres(),1);
			else llista.put(a.getCodibarres(),llista.get(a.getCodibarres()) + 1);
		}
		llista.forEach((k,v)-> System.out.println(getNomProducte(k) + " -> " + (Integer) v));

		//Recorregut del Map sense usar lambda expression
		/*for(Map.Entry entry : llista.entrySet()) {
			System.out.println(getNomProducte((String) entry.getKey()) + "-" + entry.getValue());
		}*/

	}

	public void passarCaixa() {
		double total = 0;
		Set<Aliment> ali_uniq = new HashSet<Aliment>(llista_ali);
		Set<Producte> elec_uniq = new HashSet<Producte>(llista_elec);
		Set<Producte> textil_uniq = new HashSet<Producte>(llista_textil);
		int freq=0;

		LocalDate data = LocalDate.now();
		System.out.println("-----------------------------");
		System.out.println(Compra.NOM_SUPERMERCAT);
		System.out.println("-----------------------------");
		System.out.println("Data: " + data.toString());
		System.out.println("-----------------------------");

		//Productes iguals -> igual codi de barres i preu
		for(Aliment a : ali_uniq)  {
			freq = Collections.frequency(llista_ali, a);
			System.out.printf("%s \t\t %d %.3f \t %.3f%n",a.getNom(),freq,a.getPreu(),a.getPreu() * freq);
			total += a.getPreu()*freq;
		}

		for(Producte e: elec_uniq) {
			freq = Collections.frequency(llista_elec, e);
			System.out.println(e.getNom() + "\t\t" + freq + " " + e.getPreu() + "\t" + e.getPreu() * freq);
			total += e.getPreu()*freq;
		}

		for(Producte t: textil_uniq) {
			freq = Collections.frequency(llista_textil, t);
			System.out.println(t.getNom() + "\t\t" + freq + " " + t.getPreu() + "\t" + t.getPreu() * freq);
			total += t.getPreu()*freq;
		}
		System.out.println("-----------------------------");
		System.out.format("Total: %.3f%n%n", total);

		//buidar llistes
		llista_ali.clear();
		llista_elec.clear();
		llista_textil.clear();
	}



	/* Busca el nom d'un producte a partir del codi de barres */
	private String getNomProducte(String codib) {
		//Mirem a les tres llistes
		List<Producte> list = llista_ali.stream().filter(o -> o.getCodibarres().equals(codib)).distinct().collect(Collectors.toList());
		if(list.size()==0) list = llista_textil.stream().filter(o -> o.getCodibarres().equals(codib)).distinct().collect(Collectors.toList());
		if(list.size()==0) list = llista_elec.stream().filter(o -> o.getCodibarres().equals(codib)).distinct().collect(Collectors.toList());
		return list.get(0).getNom();
	}
	


}
