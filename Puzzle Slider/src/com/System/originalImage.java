package com.System;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

public class originalImage extends JPanel {

    URL url;
    Image img;
    JLabel lblImageContainer;

    originalImage(){

        lblImageContainer = new JLabel();

        url=getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\Monalisa.png");
        img=Toolkit.getDefaultToolkit().getImage(url);

        lblImageContainer.setIcon(new ImageIcon(img.getScaledInstance(400,650,Image.SCALE_SMOOTH)));

        setLayout(new BorderLayout());
        add(lblImageContainer);
    }
}
