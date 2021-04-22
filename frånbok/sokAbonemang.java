package frånbok;

import java.util.*;
import java.io.*;


public class sokAbonemang {


    static class Abonemang{
        int pris;
        int Gb;
        String namn;

        void init(int p, int g, String n){
            pris = p;
            Gb =g;
            namn = n;
        }

        @Override
        public String toString() {
            return namn + ", " + pris + " kr/mån, "+ Gb + "Gb";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        var a = new Abonemang[7];
        Scanner fil =  new Scanner(new File("abonemang.txt"));
        int n = 0;
        while (fil.hasNext() && n <7) {

            a[n] = new Abonemang();
            a[n++].init(fil.nextInt(), fil.nextInt()
                    , fil.nextLine().trim());

        }
        var scan = new Scanner(System.in);
        while (true){
            System.out.println("Vilket abonemang söker du ?");
            if(!scan.hasNextLine()){
                break;
            }
            String sökt = scan.nextLine();
            int i = 0;
            for (; i<n; i++)
                if(String.valueOf(a[i]).contains(sökt.toLowerCase())){
                    break;
                }
            if(i<n){
                System.out.println(a[i]);
            }else{
                System.out.println(sökt + " finns inte i listan, lägg gärna till");

            }

        }
    }
}
