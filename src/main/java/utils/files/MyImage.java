package utils.files;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by apple on 2017/7/20.
 */
public class MyImage {
    private static MyImage myImage;
    public static MyImage getInstance(){
        if(myImage == null){
            synchronized (MyImage.class){
                if(myImage == null){
                    myImage = new MyImage();
                }
            }
        }
        return myImage;
    }

    public MyImage() {
    }

//    public static void main(String[] aa){
//        File f1 = new File("/Users/apple/Documents/123a.png");
//        File f2 = new File("/Users/apple/Documents/123b.png");
//        BufferedImage img1 = MyImage.getInstance().fileToImage(f1);
//        BufferedImage img2 = MyImage.getInstance().fileToImage(f2);
//        try {
//            System.out.println(MyImage.getInstance().sameAs(img1,img2,0.2));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private  BufferedImage fileToImage(File file){
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    /**
     *
     * @param myImage 图片1
     * @param otherImage 图片2
     * @param percent 需要满足的图片相似度比例(0.0~1.0)
     * @return
     */
    private boolean sameAs(BufferedImage myImage, BufferedImage otherImage, double percent)
    {
        //BufferedImage otherImage = other.getBufferedImage();
        //BufferedImage myImage = getBufferedImage();


        if (otherImage.getWidth() != myImage.getWidth()) {
            return false;
        }
        if (otherImage.getHeight() != myImage.getHeight()) {
            return false;
        }

        int[] otherPixel = new int[1];
        int[] myPixel = new int[1];

        int width = myImage.getWidth();
        int height = myImage.getHeight();

        int numDiffPixels = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (myImage.getRGB(x, y) != otherImage.getRGB(x, y)) {
                    numDiffPixels++;
                }
            }
        }
        double numberPixels = height * width;
        double diffPercent = numDiffPixels / numberPixels;
        return percent <= 1.0D - diffPercent;
    }
}
