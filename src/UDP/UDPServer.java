package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UDPServer {
    // Stores statements that represent the current state of the server
    final String amReady = "I am ready for any client side request.\n";
    final String receiveStart = "I am starting receiving file %s for the %d" + "th time.\n";
    final String receiveEnd = "I am finishing receiving file %s for the %d" + "th time.\n";
    final String timeOfCurrent = "The time used in millisecond to receive %s for %d" + "th time.\n\n";
    final String averageReceiveTime = "The average time to receive file %s in millisecond is: %d \n";
    final String amDone = "I am done.\n";

    // Stores the original file in the server
    static String currentPath = System.getProperty("user.dir");
    String originalFile = currentPath + "\\fileToSend.txt";

    // Path for the files that the server creates
    static String newFile = currentPath + "\\Received Files\\serverCreatedText.txt";

    // Creates a Path variable of the original file
    Path original = Paths.get(originalFile);

    // Will be used to write to server file
    static Writer fileWriter;

    // For reading bytes
    ByteArrayInputStream BAIS = null;

    // String to hold converted data from the file
    String inFromClient = "";

    // String to used for checking the data from the file
    String inFromClientChecker = "";

    // Port to Listen at when not specified
    static int port = 6789;

    // Variables for counting the times the data is received from the Client, and if it is successful or not
    int receivedCounter = 0;
    int errorCounter = 0;

    // Places strings that specify when an error or success happened
    ArrayList<String> errorCatcher = new ArrayList<String>();
    ArrayList<String> successCatcher = new ArrayList<String>();

    // Array of all the times of file retrieval
    long[] receiveTimes = new long[100];

    public UDPServer() {

    }

    public static void main(String[] args) throws Exception {
        InetAddress homeIP = InetAddress.getLocalHost();

        UDPServer fileTransfer = new UDPServer();
        fileTransfer.CreateAndListen(homeIP, port);
    }

    public void CreateAndListen(InetAddress host, int port) {
        // The storage place of the received data
        byte[] receivedData = new byte[1024];

        try {
            // Creates a socket to listen at the specified port of the specified host
            DatagramSocket srvSocket = new DatagramSocket(port, host);

            // As the server waits for the client side to send data, it will wait here
            System.out.print(amReady);

            while (true) {
                receivedCounter++;

                // Creates Writer object to out to a file in UTF8 encoding
                fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("\\Received Files\\serverCreatedText" + receivedCounter + ".txt"), "UTF8"));

                // The DatagramSocket receives the incoming data packet from the Client (The data arrives in a byte buffer)
                System.out.printf(receiveStart, originalFile.substring(47, originalFile.length()), receivedCounter);

                // Current time at the beginning of receiving
                long t1 = System.currentTimeMillis();

                // The packet that receives the data from the specific IP on a specific port (Incoming Packet)
                DatagramPacket incomingPacket = new DatagramPacket(receivedData, receivedData.length, host, port);
                srvSocket.receive(incomingPacket);

                // Compares byte data
                errorChecker(receivedData, incomingPacket);

                // Time at the end of file receiving
                long t2 = System.currentTimeMillis();

                // Stores times for average calculation
                for (int i = 0; i < 100; i++) {
                    receiveTimes[i] = t2 - t1;
                }

                // Extracts the data from the incoming packet and casts it as a string
                inFromClient = new String(incomingPacket.getData());

                // Places client data into a new file
                appendFile(inFromClient);

                // Receiving complete
                System.out.printf(receiveEnd, originalFile.substring(47), receivedCounter);

                // Time to receive
                System.out.printf(timeOfCurrent, t2 - t1, receivedCounter);

                fileWriter.close();

                // Relays average packet receival time
                if (receivedCounter == 100) {
                    System.out.printf(averageReceiveTime, originalFile.substring(47), average(receiveTimes));
                    System.out.println(amDone);
					
					/* Optional Code to show errors and successes
					System.out.println("Total Errors: " + errorCatcher.size() + " , Total Success: " + successCatcher.size());
					*/

                    srvSocket.close();
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

    private void errorChecker(byte[] receivedData, DatagramPacket incomingPacket) {
        //Reads incoming data, Creates local file and Check integrity of file contents
        BAIS = new ByteArrayInputStream(receivedData);
        int n = BAIS.available();
        BAIS.read(incomingPacket.getData(), 0, n);
        inFromClientChecker = BAIS.toString();
        BAIS.reset();

        byte[] holderData = new byte[1024];

        try {
            holderData = Files.readAllBytes(original);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BAIS = new ByteArrayInputStream(holderData);
        n = BAIS.available();
        BAIS.read(holderData, 0, n);
        String inFromServerChecker = BAIS.toString();
        BAIS.reset();


        if (inFromClientChecker.compareTo(inFromServerChecker) == 0) {
            successCatcher.add("Succesful transfer on transaction " + receivedCounter);
        } else {
            errorCatcher.add("Error on transfer number " + errorCounter);
            errorCounter++;
        }
    }

    public void appendFile(String string) throws Exception {
        fileWriter.append(string + "\n");
    }
}