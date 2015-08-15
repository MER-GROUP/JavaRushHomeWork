package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by maxim on 21.05.2015.
 */
public class ImageReaderFactory implements ImageReader{
    public static ImageReader getReader(ImageTypes imageTypes) {
        ImageReader imageReader=null;
        if (imageTypes == ImageTypes.JPG)
        {
            imageReader = new JpgReader();
        } else if (imageTypes == ImageTypes.BMP)
        {
            imageReader = new BmpReader();
        } else if (imageTypes == ImageTypes.PNG)
        {
            imageReader = new PngReader();
        } else
        {
            throw  new  IllegalArgumentException("Неизвестный тип картинки");
        }

        return imageReader;
    }
}
