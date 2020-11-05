/**
 * @author chen xuanyi
 * @Date 2020/5/2 20:35
 */


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @Title: Image.java
 * @Description: OpenCV-4.0.0 测试文件
 * @Package com.xu.test
 * @author: xuhyacinth
 * @date: 2019年5月7日12:13:13
 * @version: V-1.0.0
 * @Copyright: 2019 xuhyacinth
 *
 */
public class Image {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.iterator();
    }

    static {
        //在使用OpenCV前必须加载Core.NATIVE_LIBRARY_NAME类,否则会报错
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        canny();
    }

    /**
     * OpenCV-4.0.0 边缘检测
     * @return: void
     * @date: 2019年5月7日12:16:55
     */
    public static void canny() {
        Mat src = Imgcodecs.imread("C:\\Users\\Administrator\\Pictures\\3.jpeg");
        Mat dst= new Mat();
        Mat gray= new Mat();
        Mat image= new Mat();
        //1 高斯降噪
        Imgproc.GaussianBlur(src, dst, new Size(3,3),5,5);
        //2 转灰度图片
        Imgproc.cvtColor(dst, gray, Imgproc.COLOR_BGR2GRAY);
        //3 描绘边缘
        Imgproc.Canny(gray, image, 3, 6, 3, false);
        Mat colorimage=new Mat(image.size(),image.type());
        src.copyTo(colorimage, image);

        HighGui.imshow("边缘检测", image);
        HighGui.waitKey(0);
    }

}



