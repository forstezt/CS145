package lab7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Master {

	public static void main(String[] args) {

		int min = 1000;
		int max = 100000;
		int numNodes = 5;
		int rangeMin;
		int rangeMax;

		String[] nodeNames = { "localhost", "localhost", "localhost",
				"localhost", "localhost"};
		int[] nodePorts = { 11000, 12000, 13000, 14000, 15000 };
		ArrayList primes = new ArrayList();

		int count = 0;

		try {
			ServerSocket ss = new ServerSocket(7000);

			while (count < numNodes) {

				//rangeMin = min + (((max - min) / numNodes) * count);
				//rangeMax = rangeMin + (((max - min) / numNodes)) - 1;
				
				rangeMin = min + count;
				rangeMax = max;
							
				Socket sender = new Socket(nodeNames[count], nodePorts[count]);

				ObjectOutputStream oos = new ObjectOutputStream(
						sender.getOutputStream());
				oos.writeObject(new Integer(rangeMin));
				oos.writeObject(new Integer(rangeMax));

				oos.close();
				sender.close();

				Socket reciever = ss.accept();

				ObjectInputStream ois = new ObjectInputStream(
						reciever.getInputStream());
				primes.addAll((ArrayList)ois.readObject());
				
				ois.close();
				reciever.close();
				
				count++;
			}
			ss.close();

			
			System.out.println(primes.size());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
