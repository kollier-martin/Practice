package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UDPClient {
    final String sendStart = "I am sending to the server side: %s\n";
    final String isSending = "I am sending file %s for the %d" + "th time.\n";
    final String sendEnd = "I am finishing sending file %s for the %d" + "th time.\n";
    final String timeOfCurrent = "The time used in millisecond to send %s for %d" + "th time: %d \n\n";
    final String averageReceiveTime = "The average time to send file %s in millisecond is: %d \n";
    final String amDone = "I am done.\n";

    String currentPath = System.getProperty("user.dir");
    String fileName = currentPath + "\\fileToSend.txt";
    int sentCounter = 1;

    long t1;
    long t2;

    public UDPClient() {

    }

    public static void main(String[] args) throws Exception {
        UDPClient fileTransfer = new UDPClient();
        fileTransfer.SendAndListen();
    }

    public void SendAndListen() {
        byte[] sendData = new byte[1024];

        try {
            // Fetches IP to send over
            InetAddress homeIP = InetAddress.getLocalHost();

            // Creates a socket to send the file to the specified port of the specified host
            DatagramSocket clientSocket = new DatagramSocket(9875, InetAddress.getLocalHost());

            // Fetches file to send
            Path fileOut = Paths.get(fileName);

            // Reads the specific data path, in this case, the specific file. Then converts it to bytes and adds it to the array
            sendData = Files.readAllBytes(fileOut);
            DatagramPacket sndPacket = new DatagramPacket(sendData, sendData.length, homeIP, 6789);

            for (int i = 0; i < 101; i++) {
                // Begins sending files
                System.out.printf(sendStart, fileName.substring(47));
                System.out.printf(isSending, fileName.substring(47), sentCounter);

                // Current time at the beginning of sending current file
                t1 = System.currentTimeMillis();

                // The DatagramSocket sends the data packet to the Server
                clientSocket.send(sndPacket);

                // Current time at the end of sending current file
                t2 = System.currentTimeMillis();

                // Finishes sending file
                System.out.printf(sendEnd, fileName.substring(47), sentCounter);

                // Time to send
                System.out.printf(timeOfCurrent, fileName.substring(47), sentCounter, t2 - t1);

                sentCounter++;

                // Stores the sending times
                long[] sendTimes = new long[100];
                for (int t = 0; t < 100; t++) {
                    sendTimes[t] = t2 - t1;
                }

                // Relays average packet receival time
                if (sentCounter == 101) {
                    System.out.printf(averageReceiveTime, fileName.substring(47), average(sendTimes));
                    System.out.println(amDone);
                    clientSocket.close();
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR - " + e);
        }
    }

    // Calculate the average of a given long array
    private long average(long[] longArray) {
        int sum = 0;
        int n = longArray.length;

        for (int i = 0; i < n; i++) {
            sum += longArray[i];
        }

        return sum / n;
    }
}
