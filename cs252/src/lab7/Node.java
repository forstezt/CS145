package lab7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Node {

	public static void main(String[] args) {
		
		
		try {
			
			long startTime = System.currentTimeMillis();
			
			Scanner in = new Scanner(System.in);
			
			System.out.println("Enter a port number...");
			int portNumber = in.nextInt();
			
			ServerSocket ss = new ServerSocket(portNumber);
			Socket reciever = ss.accept();
			
			ObjectInputStream ois = new ObjectInputStream(reciever.getInputStream());
			
			int min = (Integer)ois.readObject();
			int max = (Integer)ois.readObject();
			
			ois.close();
			ss.close();
			reciever.close();
			
			int primeCount = 0;
			ArrayList primes = new ArrayList();

			int j;
			boolean isPrime;
			for (int i = min; i < max; i+=5) {
				
				j = 2;
				isPrime = true;
				while ((j < Math.sqrt(i)) && isPrime) {
					
					if ((i % j) == 0) {
						isPrime = false;
					}
					
					j++;
					
				}
				
				if (isPrime) {
					primes.add(i);
					primeCount++;
				}
								
			}
			
			Socket sender = new Socket("localhost", 7000);
			
			ObjectOutputStream oos = new ObjectOutputStream(sender.getOutputStream());
			oos.writeObject(primes);
			
			oos.close();
			sender.close();
			
			System.out.println("primes = " + primeCount);
			System.out.println("Time in node = " + (System.currentTimeMillis() - startTime));
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
