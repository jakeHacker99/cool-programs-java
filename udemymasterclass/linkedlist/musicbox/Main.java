package udemymasterclass.linkedlist.musicbox;

import javax.imageio.spi.ImageReaderWriterSpi;
import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("No hasta manana 2", "på riktigt");

        album.addSong("akta mannen", 3.2);
        album.addSong("snabb", 2.2);
        album.addSong("capoera", 1);
        album.addSong("mangolassi", 5);
        album.addSong("chickana", 1.5);

        albums.add(album);

        album = new Album("för grabbarna", "Mowgli");
        album.addSong("kvar 1", 3.2);
        album.addSong("kvar 2", 2.2);
        album.addSong("mademoiselles", 2.1);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("akta mannen", playList);
        albums.get(1).addToPlayList("kvar 1", playList);
        albums.get(1).addToPlayList("kvar 2", playList);


        play(playList);


    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;


        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("no songs in playlist");
            return;
        } else {
            System.out.println("now playing" + listIterator.next().toString());
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("at end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("at start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("now playing " + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("at start of list");
                        }

                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("now replaying " + listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("at end of list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+ listIterator.next());
                        }else{
                            System.out.println("now playing "+ listIterator.previous());
                        }
                    }
                    break;

            }

        }



    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===============");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===============");




    }


    private static void printMenu() {
        System.out.println("available actions:\npress");
        System.out.println("0 - to quit\n"+
                "1 - play next song\n"+
                "2 - play previous song\n"+
                "3 - replay current song\n"+
                "4 - list playlist\n"+
                "5 - available actions."+
                "6 - delete song "


                );
    }

}
