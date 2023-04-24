package com.System;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Piece extends JButton {
    URL url;
    Point originalPosition;
    Image image;



    Piece(URL url,Point pos){
        this.url=url;
        image=Toolkit.getDefaultToolkit().getImage(url);

        this.originalPosition=pos;





        setIcon(new ImageIcon(image.getScaledInstance(155,233,Image.SCALE_SMOOTH)));
        setContentAreaFilled(false);
        setFocusable(false);
        setOpaque(false);
//            setEnabled(false);
    }

    public boolean hasBlankImage(){
        boolean hasBlank=false;
        URL urlBlank=getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_blank.png");
        if(image.equals(Toolkit.getDefaultToolkit().getImage(urlBlank))){
            hasBlank=true;
        }
        return hasBlank;
    }


}
