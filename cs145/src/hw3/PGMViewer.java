package hw3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

public class PGMViewer {
	  /**
	   * Prompt the user to choose a PGM file and display it.
	   * 
	   * @param args
	   * Ignored.
	   * @throws FileNotFoundException
	   */
	  public static void main(String[] args) throws FileNotFoundException {
	    JFileChooser chooser = new JFileChooser();
	    chooser.setFileFilter(new PPMFilter());

	    int result = chooser.showOpenDialog(null);
	    if (result == JFileChooser.APPROVE_OPTION) {
	      int[][] pixels = hw3.Graymap.readFromFile(chooser.getSelectedFile().getAbsolutePath());
	      show(pixels);
	    }
	  }

	  /**
	   * Display an image.
	   * 
	   * @param img
	   * Image to display.
	   */
	  public static void show(int[][] img) {
	    int width = img[0].length;
	    int height = img.length;
	    
	    BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	    for (int r = 0; r < height; ++r) {
	      for (int c = 0; c < width; ++c) {
	        bimage.setRGB(c, r, new Color(img[r][c], img[r][c], img[r][c]).getRGB());
	      }
	    }

	    JFrame frame = new JFrame();
	    frame.getContentPane().add(new JLabel(new ImageIcon(bimage)));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(bimage.getWidth(), bimage.getHeight());
	    frame.setVisible(true);
	  }

	  /**
	   * Filter out directories and PPM image files, according to files' extensions.
	   */
	  static class PPMFilter extends FileFilter {
	    @Override
	    public boolean accept(File file) {
	      return file.isDirectory() || file.getAbsolutePath().toLowerCase().endsWith(".pgm");
	    }

	    @Override
	    public String getDescription() {
	      return "PGM Files";
	    }
	  }
	}