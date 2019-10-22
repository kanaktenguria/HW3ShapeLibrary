import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class EmbeddedImageTest {
    @Test
    public void testConstruction() throws Exception {
        String filename1 = "goku.jpg";
        String filename2 = "phoenix.png";

        EmbeddedImage myImage1 = new EmbeddedImage(filename1, 15, 15, 30, 30);
        EmbeddedImage myImage2 = new EmbeddedImage(filename1, 15, 15, 30, 30);

        EmbeddedImage myImage3 = new EmbeddedImage(filename2, 10, 10, 100, 100);
        EmbeddedImage myImage4 = new EmbeddedImage(filename2, 10, 100, 40, 10);
        EmbeddedImage myImage5 = new EmbeddedImage(filename2, 10, 20, 100, 100);

        assertTrue(myImage1.toString().equals(myImage2.toString()));
        assertNotEquals(myImage3.toString(),(myImage4.toString()));
        assertNotEquals(myImage4.toString(),(myImage5.toString()));

    }

    @Test
    public void testComputeArea() throws Exception {
        String filename = "goku.jpg";
        EmbeddedImage myImage = new EmbeddedImage(filename, 10, 10, 25, 25);
        assertEquals(625, myImage.computeArea(), 0);
    }

    @Test
    public void testMove() throws Exception {
        String filename = "goku.jpg";
        EmbeddedImage myImage = new EmbeddedImage(filename, 5, 5, 35, 40);
        myImage.move(10, 10);
        assertEquals(15,myImage.getInitCoordinate().getX(),0);
        assertEquals(15,myImage.getInitCoordinate().getY(),0);
    }

    @Test
    public void testScale() throws Exception {
        String filename = "goku.jpg";
        EmbeddedImage myImage = new EmbeddedImage(filename, 5, 5, 35, 40);
        myImage.scale(2);
        assertEquals(70,myImage.getHeight(),0);
        assertEquals(80,myImage.getWidth(),0);
    }

    @Test
    public void testConstructionViaString() throws Exception {
        String filename = "phoenix.png";
        EmbeddedImage myImage = new EmbeddedImage(filename, 10, 10, 30, 20);
        EmbeddedImage myImage2 = new EmbeddedImage(myImage.toString());
        assertTrue(myImage2.toString().equals(myImage.toString()));
    }

    @Test
    public void render() throws Exception {
        String filename = "goku.jpg";
        EmbeddedImage myImage = new EmbeddedImage(filename, 10, 10, 400, 300);
        BufferedImage bImage = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = bImage.createGraphics();
        graphics.setColor(Color.white);

        myImage.render(graphics);

        assertTrue(ImageIO.write(bImage, "png", new File("output/embeddedImage.png")));
    }
}