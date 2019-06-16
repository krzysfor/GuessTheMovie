import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessTheMovie {

    public static void main(String [] args) throws Exception {

    File file = new File("listaFilmow.txt");
    Scanner scanner = new Scanner(file);
    Scanner scannerLitera = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> convertList = new ArrayList<String>();
    ArrayList<String> userList = new ArrayList<String>();
    ArrayList<String> letterList = new ArrayList<String>();


    // utworzenie listy filow pobranych z pliku
    while (scanner.hasNextLine()) {
        list.add(scanner.nextLine());
    }


    //Stworzenie 2 list wypelnionych kresami o rozmiarze jak lista filmow (1 do wyswietlenia poczatkowego  2 do podmian)
        int rozmiarListy = list.size();
    for(int i = 0; i < rozmiarListy; i++) {

        String elementListy = list.get(i);
        String elementListyKreski = elementListy.replaceAll("[a-zA-Z]", "-");

        convertList.add(elementListyKreski);
        userList.add(elementListyKreski);

    }

    // losowanie filmu z listy
        int randomNumber = (int) (Math.random() * rozmiarListy);

        String wylosowanyTytulFilmu = list.get(randomNumber);
        String podmienianyTytulFilmu = convertList.get(randomNumber);

        int licznikKresekFilmu = podmienianyTytulFilmu.length();
        int licznikTrafionychLiter = 0;
        int licznikNieTrafionychLiter = 0;
        boolean czykoniec = false;


        System.out.println("Twoim zadaniem jest zgadnac tytul filmu. ") ;
        System.out.println("Wylosowano film o tytule: " + podmienianyTytulFilmu ) ;


        while (licznikKresekFilmu > 0) {

            //pobranie litery od uzytkownika
            System.out.println("Pozostalo: " +licznikKresekFilmu+ " prob." + "\n");
            System.out.println("Wpisz litere: ");

            char literaUzytkownika = scannerLitera.next().charAt(0);

            // dodanie do listy wszystkich wpsanych przez uzytkownika liter
            String wpisanaLitera = Character.toString(literaUzytkownika);
            letterList.add(wpisanaLitera);


            // dodanie odgadnietej litery do zakreskowanego tytulu
            String wylosowanyTytulFilmuTmp = list.get(randomNumber);
            String podmienianyTytulFilmuTmp = convertList.get(randomNumber);
            char[] wylosowanyTytulFilmuTmpTablica = wylosowanyTytulFilmuTmp.toCharArray();
            char[] podmienianyTytulFilmuTmpTablica = podmienianyTytulFilmuTmp.toCharArray();

            for (int i = 0; i < wylosowanyTytulFilmu.length(); i++) {
                if (wylosowanyTytulFilmuTmpTablica[i] == literaUzytkownika) {
                    podmienianyTytulFilmuTmpTablica[i] = literaUzytkownika;
                    licznikTrafionychLiter++;

                }

            }

            System.out.println("Trafiles : "+ licznikTrafionychLiter);
            System.out.println("Twoje litery : " +letterList);
            podmienianyTytulFilmuTmp = String.valueOf(podmienianyTytulFilmuTmpTablica);
            System.out.println(podmienianyTytulFilmuTmp);
            convertList.set(randomNumber, podmienianyTytulFilmuTmp);


            licznikKresekFilmu--;

            if (podmienianyTytulFilmuTmp.contains("-")) {
                czykoniec = false;
            } else {
                czykoniec = true;
                System.out.println("WYGRALES");
                break;

            }


        }
        System.out.println("Szukany tytul filmu to : "+ wylosowanyTytulFilmu);
    }
}
