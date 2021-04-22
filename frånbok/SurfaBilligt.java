package frånbok;

import java.awt.*;
import java.util.*;
import java.io.*;


public class SurfaBilligt {
    public static void main(String[] args) throws FileNotFoundException {
        var pris = new int[100];
        var Gb = new int[100];
        var namn = new String[100];

        Scanner fil = new Scanner(new File("abonemang.txt"));
        int n = 0;

        while (fil.hasNextLine() && n <100){
            pris[n] = fil.nextInt();
            Gb[n] = fil.nextInt();
            namn[n] = fil.nextLine().trim();
            n++;
        }

        Scanner scan= new Scanner(System.in);

        while(true){
            System.out.println("Antal Gb per månad: ");


            if(!scan.hasNextInt()){
                Toolkit.getDefaultToolkit().beep();
                System.out.println("Fel Inmatning Programmet Avslutas ...");

                break;

            }
            int antalGb= scan.nextInt();
            int lägst = -1;
            for(int i =0; i<n; i++ )
                if(Gb[i] >= antalGb && (lägst< 0 || pris[i] <pris[lägst] ))
                    lägst=i;

            if(lägst>=0){
                System.out.println(namn[lägst].replaceAll("gb", "") + " är billigast" + " \n" +" pris: "+ pris[lägst] +  "kr/mån" + "\n ingår: " +  Gb[lägst]+ "Gb");
                break;
            }

            else{
                System.out.println("inget abongemang passar, lägg till fler abonemang i abonemang.txt ");
                break;
            }
        }
    }



}