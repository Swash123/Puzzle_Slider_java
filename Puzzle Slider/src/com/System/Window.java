package com.System;

import com.System.GlassPanePopup.DefaultLayoutCallBack;
import com.System.GlassPanePopup.DefaultOption;
import com.System.GlassPanePopup.GlassPanePopup;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Window extends JFrame {

    JPanel pnlPuzzle;
    JPanel pnlBot;
    originalImage pnlImage;

    JButton btnImg;
    JButton btnReset;

    Piece[][] pieces;

    int count=0;

    JLabel lblMovedCount;

    Window(){

        GlassPanePopup.install(this);

        pnlImage = new originalImage();


        pieces=new Piece[3][3];

        pnlPuzzle=new JPanel();
        pnlBot=new JPanel();

        btnImg=new JButton();

        btnReset=new JButton();

        lblMovedCount = new JLabel();


        pieces[0][0]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_part_001.png"),
                new Point(0,0));
        pieces[0][1]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_part_002.png"),
                new Point(0,1));
        pieces[0][2]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_part_003.png"),
                new Point(0,2));
        pieces[1][0]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_part_004.png"),
                new Point(1,0));
        pieces[1][1]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_part_005.png"),
                new Point(1,1));
        pieces[1][2]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_part_006.png"),
                new Point(1,2));
        pieces[2][0]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_part_007.png"),
                new Point(2,0));
        pieces[2][1]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_part_008.png"),
                new Point(2,1));
        pieces[2][2]=new Piece(getClass().getClassLoader().getSystemResource("\\com\\System\\Image\\image_blank.png"),
                new Point(2,2));








        suffle(pieces);







        pnlPuzzle.setBounds(5,5,475,710);
        pnlBot.setBounds(5,710,469,100);

        pnlPuzzle.setFocusable(true);
        pnlPuzzle.setFocusTraversalKeysEnabled(false);
        pnlPuzzle.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {
                Point blankPos=new Point();
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    blankPos=findBlank();
                    int x=blankPos.x;
                    int y=blankPos.y;
                    if(x!=2){
                        Piece temp=pieces[x][y];
                        pieces[x][y]=pieces[x+1][y];
                        pieces[x+1][y]=temp;

                        pnlPuzzle.removeAll();
                        pnlPuzzle.repaint();
                        pnlPuzzle.revalidate();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                pnlPuzzle.add(pieces[i][j]);
                            }

                        }
                        pnlPuzzle.repaint();
                        pnlPuzzle.revalidate();

                        count++;
                        lblMovedCount.setText("Pieces moved : "+count);

                        if(checkGameover()){
                            JOptionPane.showMessageDialog(pnlPuzzle,"la thulo vaies");
                            suffle(pieces);
                            count=0;
                            lblMovedCount.setText("Pieces moved : "+count);
                        }


                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    blankPos=findBlank();
                    int x=blankPos.x;
                    int y=blankPos.y;
                    if(x!=0){
                        Piece temp=pieces[x][y];
                        pieces[x][y]=pieces[x-1][y];
                        pieces[x-1][y]=temp;


                        pnlPuzzle.removeAll();
                        pnlPuzzle.repaint();
                        pnlPuzzle.revalidate();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                pnlPuzzle.add(pieces[i][j]);
                            }

                        }
                        pnlPuzzle.repaint();
                        pnlPuzzle.revalidate();

                        count++;
                        lblMovedCount.setText("Pieces moved : "+count);

                        if(checkGameover()){
                            JOptionPane.showMessageDialog(pnlPuzzle,"la thulo vaies");
                            suffle(pieces);
                            count=0;
                            lblMovedCount.setText("Pieces moved : "+count);
                        }
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    blankPos=findBlank();
                    int x=blankPos.x;
                    int y=blankPos.y;
                    if(y!=2){
                        Piece temp=pieces[x][y];
                        pieces[x][y]=pieces[x][y+1];
                        pieces[x][y+1]=temp;


                        pnlPuzzle.removeAll();
                        pnlPuzzle.repaint();
                        pnlPuzzle.revalidate();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                pnlPuzzle.add(pieces[i][j]);
                            }

                        }
                        pnlPuzzle.repaint();
                        pnlPuzzle.revalidate();

                        count++;
                        lblMovedCount.setText("Pieces moved : "+count);

                        if(checkGameover()){
                            JOptionPane.showMessageDialog(pnlPuzzle,"la thulo vaies");
                            suffle(pieces);
                            count=0;
                            lblMovedCount.setText("Pieces moved : "+count);
                        }
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    blankPos=findBlank();
                    int x=blankPos.x;
                    int y=blankPos.y;
                    if(y!=0){
                        Piece temp=pieces[x][y];
                        pieces[x][y]=pieces[x][y-1];
                        pieces[x][y-1]=temp;


                        pnlPuzzle.removeAll();
                        pnlPuzzle.repaint();
                        pnlPuzzle.revalidate();
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                pnlPuzzle.add(pieces[i][j]);
                            }

                        }
                        pnlPuzzle.repaint();
                        pnlPuzzle.revalidate();

                        count++;
                        lblMovedCount.setText("Pieces moved : "+count);


                        if(checkGameover()){
                            JOptionPane.showMessageDialog(pnlPuzzle,"la thulo vaies");
                            suffle(pieces);
                            count=0;
                            lblMovedCount.setText("Pieces moved : "+count);
                        }
                    }
                }
                System.out.println();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });




        pnlPuzzle.setLayout(new GridLayout(3,3,3,3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pnlPuzzle.add(pieces[i][j]);
            }

        }


        btnImg.setText("Image");
        btnImg.setPreferredSize(new Dimension(150,33));
        btnImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GlassPanePopup.showPopup(pnlImage,new DefaultOption(){
                    @Override
                    public float opacity(){
                        return (float) 0.3;

                    }


                    @Override
                    public LayoutCallback getLayoutCallBack(Component parent) {
                        return new DefaultLayoutCallBack(parent) {

                            @Override
                            public  void correctBounds(ComponentWrapper cw) {
                                if (parent.isVisible()) {
                                    Point p1 = parent.getLocationOnScreen();
                                    Point b1 = pnlPuzzle.getLocationOnScreen();
                                    int x=b1.x-p1.x;
                                    int y = b1.y-p1.y;
                                    cw.setBounds(x-cw.getWidth()+pnlPuzzle.getWidth()-35,y-cw.getHeight()+pnlPuzzle.getHeight(),400,650);
                                }else {
                                    super.correctBounds(cw);
                                }
                            }
                        };

                    }
                });
            }
        });

        lblMovedCount.setText("Pieces moved : "+count);
        lblMovedCount.setHorizontalAlignment(JLabel.CENTER);

        btnReset.setText("Reset");
        btnReset.setPreferredSize(new Dimension(150,33));
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suffle(pieces);
                pnlPuzzle.removeAll();
                pnlPuzzle.repaint();
                pnlPuzzle.revalidate();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        pnlPuzzle.add(pieces[i][j]);
                    }

                }
                pnlPuzzle.repaint();
                pnlPuzzle.revalidate();
                pnlPuzzle.requestFocusInWindow();
                count=0;
                lblMovedCount.setText("Pieces moved : "+count);
            }
        });


        pnlBot.setBorder(new EmptyBorder(33,0,35,0));
        pnlBot.setLayout(new BorderLayout());
        pnlBot.add(btnImg,BorderLayout.EAST);
        pnlBot.add(lblMovedCount,BorderLayout.CENTER);
        pnlBot.add(btnReset,BorderLayout.WEST);




        add(pnlBot);
        add(pnlPuzzle);


        setLayout(null);
        setSize(495,826);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        pnlPuzzle.requestFocus();
    }

    public boolean checkGameover(){
        boolean gameover=true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if(!pieces[i][j].originalPosition.equals( new Point(i,j))){
                    gameover=false;
                }
            }
        }
        System.out.println(gameover);
        return gameover;
    }

    public Point findBlank(){
        Point pt=new Point();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(pieces[i][j].hasBlankImage()){
                    pt=new Point(i,j);
                }
            }
        }
        return pt;
    }

    public void suffle(Piece[][] pieces){
        Random random=new Random();

        for (int i = pieces.length-1; i >0 ; i--) {
            for (int j = pieces[i].length-1; j >0 ; j--) {
                int m=random.nextInt(i+1);
                int n=random.nextInt(j+1);
                Piece temp=pieces[i][j];
                pieces[i][j]=pieces[m][n];
                pieces[m][n]=temp;


            }

        }
    }
}
