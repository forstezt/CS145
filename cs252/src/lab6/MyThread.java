package lab6;

public class MyThread implements Runnable{

	private UWECImage in;
	private Mask m;
	private UWECImage out;
	private ImagePanel outPanel;
	private int i;
	public Thread t;
	private int numThreads;
		
	public MyThread(UWECImage in, Mask m, UWECImage out, ImagePanel outPanel, int i, int numThreads) {
		
		this.in = in;
		this.m = m;
		this.out = out;
		this.outPanel = outPanel;
		this.i = i;
		this.numThreads = numThreads;
		t = new Thread(this);
		t.start();
		
	}
	
	@Override
	public void run() {
		
		// Convolve the original image with the mask
		Convolution.convolve(in, m, out, outPanel, i, numThreads);	
		
	}

}
