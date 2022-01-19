package TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;


public class TCPClient {
  public static void main(String argv[]) throws Exception
  {
      String sentence;
      String modifiedSentence;
      
      Scanner in = new Scanner(System.in);
      
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      
      InetAddress host = InetAddress.getLocalHost();
      
      Socket clientSocket = new Socket(host, 6789);
      
      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
      
      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      
      System.out.println("Contiue or not (Y/N)");
      
      String s = in.next();
      
      //int numLines = 0;
      
      while(s.equals("Y")||s.equals("y"))
      {
          //numLines++;
          System.out.println("Please input your message....");
          sentence = inFromUser.readLine();
          System.out.println("This is the information sent: " + sentence);
          outToServer.writeBytes(sentence + '\n');
          modifiedSentence = inFromServer.readLine();
          
          System.out.println("From server :" + modifiedSentence);
          System.out.println("Contiue or not (Y/N)");
    }
      System.out.println("I am done now!");
      clientSocket.close();
      in.close();
   }
}
  
