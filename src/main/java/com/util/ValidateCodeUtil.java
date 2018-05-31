package com.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

public class ValidateCodeUtil {
    public static class Validate{
        String base64;
        String value;

        public Validate(String base64, String value) {
            this.base64 = base64;
            this.value = value;
        }

        public String getBase64() {
            return base64;
        }

        public String getValue() {
            return value;
        }
    }
    private static String randString="0123456789abcdefghijkmnpqrtyABCDEFGHIJLMNQRTY";
    private static Random random = new Random();


    private static void drawLine(Graphics g,int width,int height){
        int x=random.nextInt(width);
        int y =random.nextInt(height);
        int x1=random.nextInt(13);
        int y1=random.nextInt(15);
        g.setColor(new Color(random.nextFloat(),random.nextFloat(),random.nextFloat()));
        g.drawLine(x,y,x+x1,y+y1);
    }

    private static String drawString(Graphics g,int i){
        Graphics2D g2d = (Graphics2D)g;
        String randChar=String.valueOf(randString.charAt((int)(Math.random()*randString.length())));
        g2d.setColor(new Color(random.nextFloat(),random.nextFloat(),random.nextFloat()));
        int rot=5+random.nextInt(5);
        g2d.translate(random.nextInt(3),random.nextInt(3));
        g2d.rotate(rot*Math.PI/180);
        g2d.drawString(randChar,25*(i+1),20);
        g2d.rotate(-rot*Math.PI/180);
        return randChar;
    }

    public static Validate generateCertPic(int width,int height,int interLine,int stringNum){
        BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g= image.getGraphics();
        g.fillRect(0,0,width,height);
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
        //绘制干扰线
        for(int i=0;i<interLine;i++){
            drawLine(g,width,height);
        }

        //绘制字符
        String randString="";
        for(int i=0;i<stringNum;i++){
            randString+=drawString(g,i);
        }

        g.dispose();
        ByteArrayOutputStream bs =null;
        String imgsrc=null;
        try {
            bs=new ByteArrayOutputStream();
            ImageIO.write(image,"png",bs);
            imgsrc=Base64.getEncoder().encodeToString(bs.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回validate对象
        return new Validate(imgsrc,randString);
    }
}
