import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.*;

public class Case {
  public static void main(String[] args) throws Exception {
    File file = new File("plik.txt"); 
     Scanner wczytaj = new Scanner(System.in);
     int wybor ; 
    do {
      System.out.println("Wybierz opcję: 1-czy istnieje, 2- stworz, 3- zapisz text, 4- czy jest text, 5 - odczytaj dane, 6- usun dane, 7- usun plik, 8- wyszukaj text,  0- koniec");
      wybor = wczytaj.nextInt();      
      switch (wybor) {

      case 1://czy istnieje
      //File file = new File("plik.txt");
      boolean exists = file.exists();
      if (exists == true) {System.out.println(" Plik juz istnieje");}
      else {System.out.println(" Plik nie istnieje"); }
     // System.out.println(" Czy plik istnieje true=tak, false=nie " + exists);
     break; // bez break wykona po kolei
    
    case 2://stworz
      //File nowyPlik = new File("plik.txt");
      boolean istnieje = file.exists();
     if (istnieje == true) {System.out.println(" Plik istnieje");}
           
       else {file.createNewFile();
        System.out.println("Stworzono plik"); }

     break;

    case 3://zapisz text
    //File nowyP = new File("plik.txt");

      // FileWriter zapis = new FileWriter("plik.txt",true);
       System.out.println("Prosze wpisac text.");
      //       //zapis.println("ala ma3 kota");
       Scanner w = new Scanner(System.in);
       String text = w.nextLine( );
      // zapis.println(text);
     Writer output = new BufferedWriter(new FileWriter("plik.txt", true));  
           output.append(" "+ text);
            output.close();

            break;

    case 4:// czy zapisany
    //File plik = new File("plik.txt");
    if (file.length() == 0) {
    System.out.println("Plik jest pusty");
    } else System.out.println("W pliku sa dane");
    break;

         case 5:// odczytuje
      //File pliczek = new File("plik.txt");
      Scanner odczyt = new Scanner(file);
      //String zdanie = odczyt.nextLine(); po lini  hasNext = dopuki cos jest dalej
      if (odczyt.hasNext() )
            {
        String wszystko = odczyt.nextLine();
        System.out.println("W pliku znajduje sie text> "+ wszystko);}
        else {System.out.println ("Plik jest pusty");}
        break;
    
      
      case 6://usun dan
      PrintWriter usun = new PrintWriter("plik.txt");
      Scanner wy = new Scanner(System.in);
      String textU = wy.nextLine();
      System.out.println("Usunieto text");
      usun.println(textU);
      usun.close();
      break;

      case 7:// usun
      ///File pliczek = new File("plik.txt");
   
            //FileIOJava.DeleteFile("plik.txt");
            //File file2 = new File("plik.txt"); 
          
            if(file.delete()) 
            { 
              System.out.println("Plik usunieto");
            } 
            else
            { 
                System.out.println("Nie usunieto"); 
            } 
      break;

      case 8:// wyszukuje
      //https://www.it-swarm.net/pl/java/znajdz-ciag-lub-linie-w-tekscie-plik-java/1042567967/
    /*    //Scanner wyraz = new Scanner(System.in);
      Scanner szukany = new Scanner(System.in);
      System.out.println(" Proszę podac szukany wyraz");
     // String szukany = wyraz.next( );
      while (szukany.hasNext())
      String szukany = wyraz.next( );
      //while (szukany.hasNext())
      {
      if (szukany.equals(wyraz)) {
      System.out.println("W pliku znaleziono wyraz "+ szukany);
      } else System.out.println("Nie znaleziono wyrazu "+ szukany);
       szukany.close();
    } */
    Scanner kb = new Scanner(System.in);
    System.out.print("Prosze wprowadzic szukany wyraz> ");
    String name = kb.next();
    Scanner scanner;
    try { 
      boolean istnieje2 = file.exists();
      if (istnieje2 == true) {
        scanner = new Scanner(file).useDelimiter( "," );  // ustwia separator
        while (scanner.hasNext()) {
            final String lineFromFile = scanner.nextLine();
            if (lineFromFile.contains(name)) {
                 System.out.println("Znaleziono wyraz> " + name); }
                else { System.out.println("Nie znaleziono wyrazu> " + name); }
              // break;
            } }
            else { System.out.println("Plik nie istnieje");}
            
        
     }catch (IOException e) {
        System.out.println(" Nie znaleziono pliku " + file.toString());
    }
      break;

      case 0:
      System.out.println("Do widzenia");
      break;

      default: System.out.println("Niewłaściwy wybór");
        } 
    } while (wybor != 0);
    wczytaj.close();
    
  }
}
