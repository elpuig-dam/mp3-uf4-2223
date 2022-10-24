package setmana5.e15;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MenuSuper {
    private Scanner sc = new Scanner(System.in);
    Compra compra;

    public MenuSuper(Compra compra) {
        this.compra = compra;
    }

    public void mainMenu() {
        int op,opP;
        do {
            op = menuPrincipal();
            switch(op) {
                case 1:
                    do {
                        opP =  menuProducte();
                        switch(opP) {
                            case 1:
                                System.out.println("Afegir aliment");
                                newAlimentacio();
                                break;
                            case 2:
                                System.out.println("Afegir tèxtil");
                                newTextil();
                                break;
                            case 3:
                                System.out.println("Afegir electrònica");
                                newElectronica();
                                break;
                            default: break;
                        }
                    }while(opP!=0);
                    break;
                case 2: compra.passarCaixa(); break;
                case 3:
                    System.out.println("Carret");
                    compra.printCarret();
                    break;
                case 0:	System.out.println("Gràcies per la seva visita"); break;
                default: break;
            }

        }while(op!=0);
    }
    public int menuPrincipal() {
        int op;
        System.out.println("------------");
        System.out.println("-- INICI ---");
        System.out.println("------------");
        System.out.println("1) Introduit producte");
        System.out.println("2) Passar per caixa");
        System.out.println("3) Mostar carret de compra");
        System.out.println("0) Acabar");

        op = Integer.parseInt(sc.nextLine());
        return op;
    }

    public int menuProducte() {
        int op;
        System.out.println("---------------");
        System.out.println("-- PRODUCTE ---");
        System.out.println("---------------");
        System.out.println("1) Alimentació");
        System.out.println("2) Tèxtil");
        System.out.println("3) Electrònica");
        System.out.println("0) Tornar");

        op = Integer.parseInt(sc.nextLine());
        return op;
    }

    public void newElectronica() {
        String nom,codi;
        float preu;
        int garantia;

        System.out.print("Nom producte:\t");
        nom = sc.nextLine();
        System.out.print("preu:\t");
        preu = Float.parseFloat(sc.nextLine());
        System.out.print("Garantia (dies):\t");
        garantia = Integer.parseInt(sc.nextLine());
        System.out.print("Codi de barres:\t");
        codi = sc.nextLine();
        compra.addElectronica(new Electronica(preu,nom,codi,garantia));
    }

    public void newTextil() {
        String nom, compo, codi;
        float preu;
        System.out.print("Nom producte:\t");
        nom = sc.nextLine();
        System.out.print("preu:\t");
        preu = Float.parseFloat(sc.nextLine());
        System.out.print("Composició:\t");
        compo = sc.nextLine();
        System.out.print("Codi de barres:\t");
        codi = sc.nextLine();
        compra.addTextil(new Textil(preu,nom,codi,compo));
    }

   public void newAlimentacio() {
       String nom, codi;
       float preu;
       Calendar datac = new GregorianCalendar();
       String dateFormat = "dd/MM/yyyy";

       System.out.print("Nom producte:\t");
       nom = sc.nextLine();
       System.out.print("preu:\t");
       preu = Float.parseFloat(sc.nextLine());
       System.out.print("Codi de barres:\t");
       codi = sc.nextLine();
       System.out.print("Data de caducitat (dd/mm/aaaa):\t");
       LocalDate ld = readDate();
       compra.addAliment(new Aliment(preu,nom,codi,ld));
   }

    private LocalDate readDate() {
        LocalDate d = null;
        boolean dateOK = false;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyy");
        while(!dateOK) {
            try {
                d = LocalDate.parse(sc.nextLine(), format);
                dateOK = true;
            } catch (DateTimeException e) {
                System.out.print("Torna a entrar la data: ");
                dateOK = false;
            }
        }
        return d;
    }




}
