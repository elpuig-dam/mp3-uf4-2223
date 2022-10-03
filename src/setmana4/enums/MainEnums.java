package setmana4.enums;

import java.util.*;

public class MainEnums {

    public static void main(String[] args) {
        Alumne alumne = new Alumne("Eric", Alumne.Genere.HOME,"09929288PUIG");
        Alumne alumne2 = new Alumne("Anna", Alumne.Genere.DONA,"03429288PUIG");
        UF mp3uf4 = new UF("003004","Introducció a la POO");
        UF mp3uf5 = new UF("003005","POO avançada");

        alumne.addNota(mp3uf4,Qualifier.EXCELLENT);
        alumne.addNota(mp3uf5,Qualifier.SATISFACTORI);
        alumne2.addNota(mp3uf4,Qualifier.NOTABLE);
        alumne2.addNota(mp3uf5,Qualifier.SATISFACTORI);

        List<Alumne> alumneList = new ArrayList<>();
        alumneList.add(alumne);
        alumneList.add(alumne2);


        for(Qualifier q: Qualifier.values()) {
            System.out.printf("%s, %d, %d %n", q.name(), q.ordinal(), q.getValor());
        }

        for (Map.Entry entry : alumne.getNotes().entrySet()) {
            Qualifier qf = (Qualifier) entry.getValue();
            System.out.println(entry.getKey() + " : " + qf.getCode());
        }

        //Llistat de notes de cada un dels alumnes
        for(Alumne a : alumneList) {
            System.out.println(a.getNom());
            System.out.println("-------------");
            a.getNotes().forEach((k,v) -> System.out.printf("%s -> %s%n",k,v));
            System.out.println("-------------");
        }

        //Nota mitja dels alumnes i llistat en ordre alfabètic
        //El TreeMap ordena per la clau
        Map<String,Float> notesMitges = new TreeMap<>();
        for(Alumne a : alumneList) {
            float notaM=0;
            for (Map.Entry entry : a.getNotes().entrySet()) {
                Qualifier qf = (Qualifier) entry.getValue();
                notaM += qf.getValor();
            }
            notaM = notaM / a.getNotes().size();
            System.out.printf("Nota mitja de %s és %f%n",a.getNom(), notaM);
            notesMitges.put(a.getNom(),notaM);
        }

        notesMitges.forEach((k,v)-> System.out.println(k + "->" + v));
    }
}
