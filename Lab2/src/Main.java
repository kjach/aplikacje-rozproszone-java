import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Zad 1
//        Napisz program, wykorzystujący obsługę gniazd, który łączy się z portalami;
//        www.wp.pl, www.ug.edu.pl, www.onet.pl, www.interia.pl, www.helion.pl na porcie 80
//        i wyświetla adres ip strony internetowej, numer portu i portu lokalnego. Kolejność losowa.

        Socket socket = null;
        String[] pages = {"www.wp.pl", "www.ug.edu.pl", "www.onet.pl", "www.interia.pl", "www.helion.pl"};
        Random random = new Random();
        int num = random.nextInt(pages.length);

        try {
            socket = new Socket(pages[num], 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (socket != null) {
            System.out.println(socket);
        }

//        Zad 2
//        Napisz program  wypisujący adres ip  i nazwę komputera lokalnego.
//        Wykorzystaj obiekt INetAdress.

        InetAddress inetAddress = null;
        String getHostName = null;

        try {
            inetAddress = InetAddress.getLocalHost();
            getHostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e ) {
            e.printStackTrace();
            System.exit(0);
        }
        String ip = inetAddress.getHostAddress();
        System.out.println("Adres IP: " + ip);
        System.out.println("Nazwa komputera: " + getHostName);

//        Zad 3
        InetAddress[] ips;
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
            ips = InetAddress.getAllByName(hostName);

            for (InetAddress address : ips) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}