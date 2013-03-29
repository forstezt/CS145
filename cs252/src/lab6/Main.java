package lab6;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		// Get the original image

		UWECImage in = null;
		try {
			in = new UWECImage("mandrill.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Display the original image in a Panel
		ImagePanel inPanel = new ImagePanel(in);

		// Make a mask
		Mask m = new Mask();

		// Make a new blank image the same size as the input image
		// to place the convolved image into
		UWECImage out = new UWECImage(in.getWidth(), in.getHeight());

		// Display the resulting image as it is created in a second panel
		ImagePanel outPanel = new ImagePanel(out);

		
		
		
		int numThreads = 20;	
		List<MyThread> threads = new ArrayList<MyThread>();
		
		
		
		
		//creates threads and adds them to the arraylist
		for (int i = 0; i < numThreads; i++) {
			MyThread mt = new MyThread(in, m, out, outPanel, i, numThreads);
			threads.add(mt);
		}
		
		//joins every thread
		for (int i = 0; i < numThreads; i++) {	
			try {
				threads.get(i).t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		
		
		
		out.write("mandrillConvolve.png");
	}
}