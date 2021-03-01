// Joel Lawore

package arrays2d;
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class PhotoshopFiller extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    
    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        
        // nested loop that goes through each pixel
        for (int i = 0; i < pixels.length; i++) {
        	for (int j = 0; j < pixels[i].length; j++) {
        		
        		// increases the RGB values of the pixel by the given amount
        		Color c = pixels[i][j];
        		int r = c.getRed() + amount;
        		int g = c.getGreen() + amount;
        		int b = c.getBlue() + amount;
        		
        		// edge cases
        		if (r > 255)
        			r = 255;
        		if (g > 255)
        			g = 255;
        		if (b > 255)
        			b = 255;
        		
        		if (r < 0)
        			r = 0;
        		if (g < 0)
        			g = 0;
        		if (b < 0)
        			b = 0;
        		
        		// sets the original RGB values of the pixel to the increased values
        		pixels[i][j] = new Color (r, g, b);
        	}
        }
        
        
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        if (horizontally) {
        	
        	// nested loop that goes through the left half the pixels in the array
        	for (int i = 0; i < pixels.length; i++) {
        		for (int j = 0; j < pixels[i].length/2; j++) {
        			// determines the corresponding opposite pixel on the right half
        			int o = (pixels[i].length/2 - j) + (pixels[i].length/2-1);
        			
        			// saves the RGB value of the current pixel
        			Color c = pixels[i][j];
        			int tempr = c.getRed();
        			int tempg = c.getGreen();
        			int tempb = c.getBlue();
        			
        			// swaps the RGB values of the current  and opposite pixel
        			pixels[i][j] = pixels[i][o];
        			pixels[i][o] = new Color (tempr, tempg, tempb);
        		}
        	} 
        }
        else {
        	
        	// nested loop that goes through the top half the pixels in the array
        	for (int i = 0; i < pixels.length/2; i++) {
        		for (int j = 0; j < pixels[i].length; j++) {
        			// determines the corresponding opposite pixel on the bottom half
        			int o = (pixels.length/2 - i) + (pixels.length/2);
        			
        			// saves the RGB value of the current pixel
        			Color c = pixels[i][j];
        			int tempr = c.getRed();
        			int tempg = c.getGreen();
        			int tempb = c.getBlue();
        			
        			// swaps the RGB values of the current  and opposite pixel
        			pixels[i][j] = pixels[o][j];
        			pixels[o][j] = new Color (tempr, tempg, tempb);
        		}
        	}
        }
    }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName;
        
        // nested loop that goes through each pixel
        for (int i = 0; i < pixels.length; i++) {
        	for (int j = 0; j < pixels[i].length; j++) {
        		Color c = pixels[i][j];
        		
        		// algorithm that changes each RGB value of the pixel to it's negated value
        		pixels[i][j] = new Color (255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
        	}
        } 
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    	// the list of colors to compare to. Feel free to change/add colors
    	Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.PINK};
    	outputName = "simplified_" + outputName;
    	
    	// nested loop that goes through each pixel 
    	for (int i = 0; i < pixels.length; i++) {
        	for (int j = 0; j < pixels[i].length; j++) {
        		Color c = pixels[i][j];
        		Color closest = colorList[0];
        		
        		// loop that goes through the distance of the pixel from each color in the array and saves the closest
        		for (int n = 1; n < colorList.length; n++) {
        			if (distance(c, colorList[n]) < distance(c, closest)) {
        				closest = colorList[n];
        			}
        		}
        		
        		// changes the pixel to the closet color in the array
        		pixels[i][j] = closest;
        	}
        }
    }
    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
    	int x2 = c2.getRed(), y2 = c2.getGreen(), z2 = c2.getBlue();
    	int x1 = c1.getRed(), y1 = c1.getGreen(), z1 = c1.getBlue();
    	double d = Math.sqrt( Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) + Math.pow(z2-z1, 2));
    		return d;
    }
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur(int n) {
		outputName = "blurred_" + outputName;
		// determines the index used to access the matrix throughout the method based on the parameter
		int index = (int)(0.5*(n-1));
		
		// creates an empty duplicate 2d array(blank image) that hold the same length values as the original
		Color[][] blurred = new Color[pixels.length][];
        for (int i = 0; i < pixels.length; i++) {
        	blurred[i] = new Color[pixels[i].length];
        }
        
        // nested loop that goes through each pixel
        for (int i = index; i < pixels.length-index; i++) {
        	for (int j = index; j < pixels[i].length-index; j++) {
        		
        		// sums each RGB value of the matrix
        		int r = 0, g = 0, b = 0;
        		for (int ii = -index; ii <= index; ii++) {
        			for (int jj = -index; jj <= index; jj++) {
        				r += pixels[i+ii][j+jj].getRed();
        				g += pixels[i+ii][j+jj].getGreen();
        				b += pixels[i+ii][j+jj].getBlue();
        			}
        		}
        		
        		// divides the rgb value by the area of the matrix
        		r /= n*n;
        		g /= n*n;
        		b /= n*n;
        		
        		// edge cases
        		if (r > 255)
        			r = 255;
        		if (g > 255)
        			g = 255;
        		if (b > 255)
        			b = 255;
        		
        		if (r < 0)
        			r = 0;
        		if (g < 0)
        			g = 0;
        		if (b < 0)
        			b = 0;
        		
        		// fills in the corresponding pixels in the duplicate image using the configured RGB values
        		blurred[i][j] = new Color (r, g, b);
        	}
        }
        
        // turns the original image into the duplicate image
        for (int i = index; i < pixels.length-index; i++) {
    		for (int j = index; j < pixels[i].length-index; j++) {
    			pixels[i][j] = blurred[i][j];
    		}
    	}
	}
   
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName;
        
        // creates an empty duplicate 2d array(blank image) that hold the same length values as the original
        Color[][] edged = new Color[pixels.length][];
        for (int i = 0; i < pixels.length; i++) {
        	edged[i] = new Color[pixels[i].length];
        }
        
     // nested loop that goes through each pixel
        for (int i = 1; i < pixels.length-1; i++) {
        	for (int j = 1; j < pixels[i].length-1; j++) {
        		Color c = pixels[i][j];
        		
        		// sums each RGB value of the surrounding pixels 
        		int r = -(pixels[i][j].getRed()), g = -(pixels[i][j].getGreen()), b = -(pixels[i][j].getBlue());
        		for (int ii = -1; ii <= 1; ii++) {
        			for (int jj = -1; jj <= 1; jj++) {
        				
        					r +=  pixels[i+ii][j+jj].getRed();
        					g += pixels[i+ii][j+jj].getGreen();
        					b += pixels[i+ii][j+jj].getBlue();
        				
        			}
        		}
        		
        		// multiplies the current pixels RGB value by 8 and subtracts the sum
        		r = (c.getRed()*8 - r); 
        		g = (c.getGreen()*8 - g); 
        		b = (c.getBlue()*8 - b); 
        		
        		// edge cases
        		if (r > 255)
        			r = 255;
        		if (g > 255)
        			g = 255;
        		if (b > 255)
        			b = 255;
        		
        		if (r < 0)
        			r = 0;
        		if (g < 0)
        			g = 0;
        		if (b < 0)
        			b = 0;
        		
        		// fills in the corresponding pixels in the duplicate image using the configured RGB values
        		edged[i][j] = new Color (r, g, b);
        	}
        }
        
        // turns the original image into the duplicate image
        for (int i = 1; i < pixels.length-1; i++) {
    		for (int j = 1; j < pixels[i].length-1; j++) {
    			pixels[i][j] = edged[i][j];
    		}
    	}
    }
    
    //
    public void greyscale() {
    	outputName = "greyscaled_" + outputName;
    	
    	// nested loop that goes through each pixel
        for (int i = 0; i < pixels.length; i++) {
        	for (int j = 0; j < pixels[i].length; j++) {
        		Color c = pixels[i][j];
        		
        		// equation that determines the scale of gray for the pixel based on the RGB values
        		int y = (int) (0.2126*c.getRed() + .7512*c.getGreen() + .0722*c.getBlue());
        		
        		// edge cases
        		if (y > 255)
        			y = 255;
        		if (y < 0)
        			y = 0;
        		
        		// changes the original pixel to the scaled pixel
        		pixels[i][j] = new Color (y, y, y);
        	}
        } 
    }
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, simplify, or greyscale.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else if (action.equals("blur")) {
		    				System.out.println("enter blur amount (odd number matrix: 3x3, 5x5...)");
		    				int matrix = in.nextInt();
		    				while (matrix % 2 == 0) {
		    					System.out.println("enter an odd number");
		    					matrix = in.nextInt();	
		    				}
		    				Method m = getClass().getDeclaredMethod(action, int.class);
		    				m.invoke(this, matrix);
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new PhotoshopFiller();
	}

    public PhotoshopFiller() {
		run();
    }
}