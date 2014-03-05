
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class MonostableMultivibratorIC741 extends JApplet implements Runnable  {
    
    

    Thread animator;
    int pixel=0;
    boolean playing = true;
    boolean stopRequested = false;
    boolean rise=false;
    boolean trigger=true;
    boolean first = true;
   
    int ypixel;
   
    /** Initializes the applet DTS */
    public void init() {
       
        initComponents();
                  
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Container mainPanel = getContentPane();
        ImagePanel = new Ckt_JPanel();
        ParamPanel = new Param_JPanel();
        Capacitor = new javax.swing.JLabel("C = 100 nF");
        Resistance = new javax.swing.JLabel("R = 500 ohms");
        CapScrollBar = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,100,0,100,500);
        ResScrollBar = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,500,0,500,950);
        TrigAmpScrollBar = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,0,0,0,500);
        TriggerWidth = new javax.swing.JLabel("T_amp = 0.5 volts");
        StopPlay = new javax.swing.JButton("Stop");
        Graph = new Graph_JPanel();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        Color backgroundColor = new Color(231,248,255);

        ImagePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ImagePanel.setName("ImagePanel"); // NOI18N

        javax.swing.GroupLayout ImagePanelLayout = new javax.swing.GroupLayout(ImagePanel);
        ImagePanel.setLayout(ImagePanelLayout);
        ImagePanel.setBackground(backgroundColor);
        ImagePanelLayout.setHorizontalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        ImagePanelLayout.setVerticalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );

        ParamPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ParamPanel.setName("ParamPanel"); // NOI18N
        ParamPanel.setBackground(backgroundColor);


        Capacitor.setName("Capacitor"); // NOI18N


        Resistance.setName("Resistance"); // NOI18N

        CapScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        CapScrollBar.setName("CapScrollBar"); // NOI18N
        CapScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                CapScrollBarAdjustmentValueChanged(evt);
            }
        });

        ResScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        ResScrollBar.setName("ResScrollBar"); // NOI18N
        ResScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                ResScrollBarAdjustmentValueChanged(evt);
            }
        });

        TrigAmpScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        TrigAmpScrollBar.setName("TrigAmpScrollBar"); // NOI18N
        TrigAmpScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                TrigAmpScrollBarAdjustmentValueChanged(evt);
            }
        });


        TriggerWidth.setName("TriggerWidth"); // NOI18N


        StopPlay.setName("StopPlay"); // NOI18N
        StopPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ParamPanelLayout = new javax.swing.GroupLayout(ParamPanel);
        ParamPanel.setLayout(ParamPanelLayout);
        ParamPanelLayout.setHorizontalGroup(
            ParamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ParamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TriggerWidth, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(Resistance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(Capacitor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ParamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TrigAmpScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CapScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(StopPlay, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );
        ParamPanelLayout.setVerticalGroup(
            ParamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ParamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(StopPlay)
                    .addGroup(ParamPanelLayout.createSequentialGroup()
                        .addGroup(ParamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Capacitor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CapScrollBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(ParamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Resistance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ResScrollBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(ParamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ParamPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(TrigAmpScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ParamPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TriggerWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        Graph.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Graph.setName("Graph"); // NOI18N

        javax.swing.GroupLayout GraphLayout = new javax.swing.GroupLayout(Graph);
        Graph.setLayout(GraphLayout);
        Graph.setBackground(backgroundColor);
        GraphLayout.setHorizontalGroup(
            GraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
        GraphLayout.setVerticalGroup(
            GraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ParamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Graph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Graph, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ParamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        //setComponent(mainPanel);
    }// </editor-fold>

    private void CapScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
         Capacitor.setText("C = " + CapScrollBar.getValue() + " nF");
        Graph.set_values();
        Graph.repaint();
        // TODO add your handling code here:
    }

    private void ResScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
         Resistance.setText("R = " + ResScrollBar.getValue() + " ohms");
        Graph.set_values();
        Graph.repaint();
        // TODO add your handling code here:
    }

    private void TrigAmpScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        TriggerWidth.setText("T_amp = " + (0.5 - (float)(TrigAmpScrollBar.getValue()/1000.0) + " volts"));
        Graph.set_values();
        if(TrigAmpScrollBar.getValue()<=0)
                trigger=true;
            else
                trigger=false;
        Graph.repaint();
        ImagePanel.repaint();// TODO add your handling code here:
    }

    private void StopPlayActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (playing) {         
            StopPlay.setText("Play");
            stopRequested=true;
            playing = false;
            Graph.draw(Graph.Xaxislen);
            ImagePanel.repaint();
        }
        else {          
            StopPlay.setText("Stop");
            pixel = 0;
            stopRequested=false;
            playing = true;
        }
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollBar CapScrollBar;
    private javax.swing.JLabel Capacitor;
    private Graph_JPanel Graph;
    private Ckt_JPanel ImagePanel;
    private Param_JPanel ParamPanel;
    private javax.swing.JScrollBar ResScrollBar;
    private javax.swing.JLabel Resistance;
    private javax.swing.JButton StopPlay;
    private javax.swing.JScrollBar TrigAmpScrollBar;
    private javax.swing.JLabel TriggerWidth;

    // End of variables declaration

    
    public void start() {
        animator = new Thread(this);
        animator.start();
    }
   
    public void run() {
            try {
                while (true) {
                    while(!stopRequested) {
                        Graph.draw(pixel);   
                        ImagePanel.repaint();
                        Thread.sleep(60);
                        pixel++;
                        if (pixel > Graph.Xaxislen) {
                            pixel = 0;
                            Graph.resetplot();
                            ImagePanel.repaint();
                            Thread.sleep(2000);
                        }
                    }
                }
            }
            catch (InterruptedException e) {
            }       
        }
    
    public void stop() {
        animator = null;
    }
  
         
                                
 

    class Ckt_JPanel extends JPanel {
        int width = getWidth();
        int height = getHeight();
   
        public void change(MouseEvent evt) {
   
        }

   
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);
            CircuitA c = new CircuitA(10,10);
            Graphics2D g2 = (Graphics2D)g;                                                         
            g.setColor(Color.BLACK);
            c.draw(g2);
              
            Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,width,height);   
        }
    }

    class Param_JPanel extends JPanel {
        int width = getWidth();
        int height = getHeight();
   
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);   
            Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,width,height); 
        }
    }

    class Graph_JPanel extends JPanel {
  
        double Vcc = 12.0;
        int originx1 = 30;
        int originy1 = 140;
        int originx2 = 30;
        int originy2 = 230;
        int originx3 = 30;
        int originy3= 385;
        
        int dummyoriginy2 = 300;
        int ypixel1,prevy1,prevx1,ypixel2,ypixel3,prevx2,prevy2,prevx3,prevy3;
        int Xaxislen = 250;
        int Yaxislen = 63;
       
        double Capacitor = 100/Math.pow(10,9);
        double tau=Capacitor*500;
        double scaleX=25.0/tau;
         int prevx,prevy,xpixel,xreset,ypixel;
        double x,y;
        boolean reset = true;
        boolean line ;
        boolean first;
        int tvalue;
        int dummyy;
        double dummyy2;
        boolean charging;
        double taufall= Capacitor*500;
        double taurise= Capacitor*500;
       
       public void draw (int p) {
            pixel = p;
            reset = false;
            repaint();
        }
       
       
        public void resetplot () {
            rise = false;
        }
       
       
        void set_values(){
            Capacitor = CapScrollBar.getValue()/Math.pow(10,9);
            tau = Capacitor*ResScrollBar.getValue();
            taufall = Capacitor*ResScrollBar.getValue();
            taurise = Capacitor*ResScrollBar.getValue();
   
        }
       
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            rise=true;
          
            //setting background colour
            Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,getWidth(),getHeight());           
           
            //Drawing axes
            g.setColor(Color.BLACK);
            //plot axes
            g.drawLine(originx2,originy1,originx1+Xaxislen,originy1);
            g.drawLine(originx1,originy1,originx1,originy1-(2*Yaxislen));
            g.drawString("Vtrigger",originx1-20,originy1-(2*Yaxislen));
            g.drawString("t",originx1+Xaxislen,originy1+15);
           
            g.drawLine(originx2,originy2,originx2+Xaxislen,originy2);
            g.drawLine(originx2,originy2,originx2,originy2-Yaxislen);
            g.drawLine(originx2,originy2,originx2,originy2+Yaxislen);
            g.drawString("V_B",originx2-20,originy2-Yaxislen);
            g.drawString("t",originx2+Xaxislen,originy2+15);
           
            g.drawLine(originx3,originy3,originx3+Xaxislen,originy3);
            g.drawLine(originx3,originy3,originx3,originy3-Yaxislen);
            g.drawLine(originx3,originy3,originx3,originy3+Yaxislen);
            g.drawString("V_A",originx3-20,originy3-Yaxislen);
            g.drawString("t",originx3+Xaxislen,originy3+15);

           
            //arrows
            g.drawLine(originx1,originy1-(2*Yaxislen),originx1-3,originy1-(2*Yaxislen)+5);
            g.drawLine(originx1,originy1-(2*Yaxislen),originx1+3,originy1-(2*Yaxislen)+5);
            g.drawLine(originx1+Xaxislen,originy1,originx1+Xaxislen-5,originy1-3);
            g.drawLine(originx1+Xaxislen,originy1,originx1+Xaxislen-5,originy1+3);
            g.drawLine(originx2,originy2-Yaxislen,originx2-3,originy2-Yaxislen+5);
            g.drawLine(originx2,originy2-Yaxislen,originx2+3,originy2-Yaxislen+5);
            g.drawLine(originx2,originy2+Yaxislen,originx2+3,originy2+Yaxislen-5);
            g.drawLine(originx2,originy2+Yaxislen,originx2-3,originy2+Yaxislen-5);
            g.drawLine(originx2+Xaxislen,originy2,originx2+Xaxislen-5,originy2-3);
            g.drawLine(originx2+Xaxislen,originy2,originx2+Xaxislen-5,originy2+3);
            g.drawLine(originx3,originy3-Yaxislen,originx3-3,originy3-Yaxislen+5);
            g.drawLine(originx3,originy3-Yaxislen,originx3+3,originy3-Yaxislen+5);
            g.drawLine(originx3,originy3+Yaxislen,originx3+3,originy3+Yaxislen-5);
            g.drawLine(originx3,originy3+Yaxislen,originx3-3,originy3+Yaxislen-5);
            g.drawLine(originx3+Xaxislen,originy3,originx3+Xaxislen-5,originy3-3);
            g.drawLine(originx3+Xaxislen,originy3,originx3+Xaxislen-5,originy3+3);
           
            g.drawString("Beta * L-",originx3+Xaxislen+6,originy3-95);
            g.drawString("V_D2",originx3+Xaxislen+3,originy2-30);
           
            g.drawString("0.5",originx1+Xaxislen+3,originy1-94);
           
            //putting the grey lines
            g.setColor(Color.GRAY.brighter());
            g.drawLine(originx1,originy1-100,originx1+Xaxislen,originy1-100);
           
            g.drawLine(originx2,originy2-35,originx2+Xaxislen,originy2-35);
            g.drawLine(originx2,originy2+60,originx2+Xaxislen,originy2+60);
           
            g.drawLine(originx3,originy3-60,originx3+Xaxislen,originy3-60);
            g.drawLine(originx3,originy3+60,originx3+Xaxislen,originy3+60);
           
            //drawing graph
            rise=false;
            Arrow a1;
            prevx=originx2;
            prevy=originy2 - 35;
            prevy1=TrigAmpScrollBar.getValue()*20/100;
            prevy2=0;
            prevy3=108;
            xreset=0;
            first = true;
            
            for (xpixel=xreset=0;xpixel<=pixel;xpixel++){
                if(trigger){
                    
                    if(rise){
                    x=(double)(xpixel-xreset)/scaleX;
                    y=Vcc-(double)(Vcc*Math.exp(-x/taurise));
                    
                    g.setColor(Color.BLUE);
                    g.drawLine(originx1+xpixel-1,originy1-prevy1-100,originx1+xpixel,originy1-prevy1-100);
                    g.setColor(Color.GREEN.darker());
                    ypixel=(int)(y*114/Vcc);
                    ypixel2=originy3+60;
                    if(ypixel>=99){
                        ypixel=99;
                        rise=false;
                        charging = false;
                        xreset=xpixel;
                        g.setColor(Color.GRAY.brighter());
                        g.drawLine(originx3+xpixel,originy2-35,originx3+xpixel,originy3+60);
                        g.setColor(Color.RED);
                        g.drawLine(originx3+xpixel,originy3-60,originx3+xpixel,originy3+60);
                        
                    }
                    g.setColor(Color.GREEN.darker());
                    g.drawLine(prevx,prevy+64,xpixel+originx1,originy1-ypixel+154);
                    g.setColor(Color.BLUE); 
                    g.drawLine(originx1+xpixel,originy1-prevy1-100,originx1+xpixel,originy1-ypixel1);

                    prevx=originx2+xpixel;
                    prevy=originy2-ypixel;
                    }else {
                    x=(double)(xpixel-xreset)/scaleX;
                    y=(double)Vcc*Math.exp(-x/taufall);
                    
                    if ((xpixel-xreset)<5){
                            ypixel1 = TrigAmpScrollBar.getValue()*20/100;
                            g.setColor(Color.BLUE); 
                            g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                            
                            if((xpixel-xreset)==1){
                                   g.setColor(Color.BLUE); 
                                   g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1-100);
                                   g.setColor(Color.RED);
                                   a1=new Arrow(originx3+xpixel,originy3+80,"left");
                                   a1.draw(g2);
                            }
                        
                            } 
                    else if ((xpixel-xreset)==5) {         
                            ypixel1 = 100;
                            g.setColor(Color.BLUE); 
                            g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                            
                            line=true;
                            } 
                    else{
                            ypixel1 = 100;
                            g.setColor(Color.BLUE); 
                            g.drawLine(originx1+xpixel,originy1-prevy1-100,originx1+xpixel,originy1-ypixel1);
                            
                        }
                    ypixel=(int)(y*114/Vcc);
                    ypixel2=originy3-60;
                    g.setColor(Color.RED);
                    
                    g.drawLine(originx3+xpixel,originy3+80,originx3+xpixel+1,originy3+80);
                    if(ypixel<=20){
                        ypixel=20;
                        rise=true;
                        charging = true;
                        xreset=xpixel;
                        g.setColor(Color.GRAY.brighter());
                        g.drawLine(originx3+xpixel,originy2+60,originx3+xpixel,originy3+60);
                        g.setColor(Color.RED);
                        g.drawLine(originx3+xpixel,originy3-60,originx3+xpixel,originy3+60);
                        a1=new Arrow(originx3+xpixel,originy3+80,"right");
                        a1.draw(g2);
                        tvalue=(int)Math.round(1.1*ResScrollBar.getValue()*Capacitor*1000000);
                        g.drawString("0.105 * R3 * C = "+Double.toString(tvalue/1000.0)+" ms",originx3,originy3+75);
                    }
                    
                    g.setColor(Color.GREEN.darker());
                    g.drawLine(prevx,prevy+65,xpixel+originx2,originy2-ypixel+80);
                    prevx=originx2+xpixel;
                    prevy=originy2-ypixel+15;
                    
                    
                    
                }
                g.setColor(Color.RED);
                g.drawLine(originx3+xpixel,ypixel2,originx3+xpixel+1,ypixel2);
                g.setColor(Color.BLACK);
                g.drawLine(originx2,originy2-35,originx2,originy2+60);
                first = false;
            }
            
            else{

                    x=(double)(xpixel-xreset)/scaleX;
                    y=(double)Vcc*Math.exp(-x/taufall);
                    if ((xpixel-xreset)<5){
                            ypixel1 = TrigAmpScrollBar.getValue()*20/100;
                            g.setColor(Color.BLUE); 
                            g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                            g.setColor(Color.GREEN); 
                            g.drawLine(originx2+xpixel,originy2,originx2+xpixel+1,originy2);
                            g.setColor(Color.RED); 
                            g.drawLine(originx3+xpixel,originy3,originx1+xpixel+1,originy3);
                            
                            } 
                    else if ((xpixel-xreset)==5) {         
                            ypixel1 = 100;
                            g.setColor(Color.BLUE); 
                            g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                            g.setColor(Color.GREEN); 
                            g.drawLine(originx2+xpixel,originy2,originx2+xpixel+1,originy2);
                            g.setColor(Color.RED); 
                            g.drawLine(originx3+xpixel,originy3,originx1+xpixel+1,originy3);
                            
                            } 
                    else{
                            ypixel1 = 100;
                            g.setColor(Color.BLUE); 
                            g.drawLine(originx1+xpixel,originy1-100,originx1+xpixel+1,originy1-100);
                            g.setColor(Color.GREEN); 
                            g.drawLine(originx2+xpixel,originy2,originx2+xpixel+1,originy2);
                            g.setColor(Color.RED); 
                            g.drawLine(originx3+xpixel,originy3,originx1+xpixel+1,originy3);
                            
                        }
            }
        }
        }
    }    



 class CircuitA extends Ckt_JPanel{
        public CircuitA(int a, int b) {
            x = a;
            y = b;
        }

        //to draw the circuit
        public void draw(Graphics2D g2) {
            //wires
            g2.setColor(Color.BLACK);
                     
                   
            VResistor r1=new VResistor(300,195);
            VResistor r2=new VResistor(70,110);
           
            Comparator c1 = new Comparator(180,180);
            Line2D.Double w19= new Line2D.Double(340,110,340,195);
            Line2D.Double w20= new Line2D.Double(180,265,180,280);
            Line2D.Double w21= new Line2D.Double(180,210,180,265);
            Line2D.Double w22= new Line2D.Double(180,265,145,265);
            Line2D.Double w23= new Line2D.Double(120,265,90,265);
            Line2D.Double w24= new Line2D.Double(90,265,90,305);
            Line2D.Double w25= new Line2D.Double(180,265,300,265);
            Line2D.Double w26= new Line2D.Double(300,255,300,265);
            Line2D.Double w27= new Line2D.Double(100,180,100,225);  
            Line2D.Double w28= new Line2D.Double(160,180,180,180);
            Line2D.Double w29= new Line2D.Double(180,110,220,110); 
            Line2D.Double w30= new Line2D.Double(180,110,180,180); 
            Line2D.Double w31= new Line2D.Double(180,110,144,110);
            Line2D.Double w32= new Line2D.Double(120,110,70,110);
            Line2D.Double w33= new Line2D.Double(50,103,50,117);
            Line2D.Double w34= new Line2D.Double(42,103,42,117);
            Line2D.Double w35= new Line2D.Double(75,110,50,110);
            Line2D.Double w36= new Line2D.Double(42,110,20,110);
            Line2D.Double w37= new Line2D.Double(260,110,340,110);
            Line2D.Double w38= new Line2D.Double(80,85,80,100);
            Line2D.Double w39= new Line2D.Double(80,85,70,85);
            Line2D.Double w40= new Line2D.Double(80,100,83,85);
            Line2D.Double w41= new Line2D.Double(80,85,90,85);
            Line2D.Double w42= new Line2D.Double(340,195,370,195);
            Line2D.Double w43= new Line2D.Double(10,89,14,89);
            Line2D.Double w44= new Line2D.Double(14,89,14,99);
            Line2D.Double w45= new Line2D.Double(14,99,18,99);
            
            Capacitor c = new Capacitor(180,280);
           
            Ground gr1 = new Ground(90,305);
            Ground gr2 = new Ground(180,305);
            Ground gr3 = new Ground(100,225);
            Ground gr4 = new Ground(70,170);
            diode d1 = new diode(120,277,false);
            diode d2 = new diode(120,122,false);
            
             HResistor rc = new HResistor(100,180);
             HResistor rv = new HResistor(220,110);
             
             Rectangle ff = new Rectangle(250,120,80,120);
            Rectangle outline = new Rectangle(110,90,270,230);
            
           
            //diagram for trigger
              g2.draw(w19);
              g2.draw(w20);
              d1.draw(g2);
              g2.draw(w21);
              g2.draw(w22);
              g2.draw(w23);
              g2.draw(w24);
              g2.draw(w25);
              g2.draw(w26);
              g2.draw(w27);
              g2.draw(w28);
              g2.draw(w29);
              g2.draw(w30);
              g2.draw(w31);
              d2.draw(g2);
              g2.draw(w32);
              g2.draw(w33);
              g2.draw(w34);
              g2.draw(w35);
              g2.draw(w36);
              g2.draw(w37);
              g2.draw(w38);
              g2.draw(w39);
              g2.draw(w40);
              g2.draw(w41);
              g2.draw(w42);
              g2.draw(w43);
              g2.draw(w44);
              g2.draw(w45);
                         
            rc.draw(g2);
            r1.draw(g2);
            r2.draw(g2);
            
            rv.draw(g2);
            c1.draw(g2);
               
            c.draw(g2);
           
            gr1.draw(g2);
            gr2.draw(g2);
            gr3.draw(g2);
            gr4.draw(g2);
            
            g2.fillRect(179,179,3,3);
            g2.fillRect(179,264,3,3);
            g2.fillRect(339,194,3,3);
            g2.fillRect(369,194,3,3);
            g2.fillRect(20,109,3,3);
            
           
            //g2.setColor(Color.BLACK);
            
            g2.drawString("A",350,190);
            g2.drawString("C",165,170);
            g2.drawString("R1",125,170);
            g2.drawString("R2",243,97);
            g2.drawString("B",190,260);
            g2.drawString("C1",190,300);
            g2.drawString("D1",125,300);
            g2.drawString("R3",315,230);
            g2.drawString("C2",42,97);
            g2.drawString("R4",80,145);
            g2.drawString("D2",123,90);
            g2.drawString("Beta = R1/(R1 + R2)",340,20);
           
           
            if(playing) {
                if(trigger && rise){
                    g2.setColor(new Color(255,0,255));
                    g2.drawString("CAPACITOR DISCHARGING",220,300);
                    d1.draw(g2);
                    g2.setColor(Color.ORANGE);
                    g2.drawString("QUASI-STABLE STATE",120,50);
                   
                }
                else if(trigger && !rise){
                    g2.setColor(new Color(255,0,255));
                    g2.drawString("CAPACITOR CHARGING",220,300);
                    g2.setColor(Color.ORANGE);
                    g2.drawString("QUASI-STABLE STATE",120,50);
                     g2.setColor(new Color(255,0,255));
                    c.draw(g2);
                    

                    g2.setColor(Color.RED);
                   
                    if(ypixel>3 && ypixel<=36) {
                        g2.setColor(Color.RED);
                        g2.setColor(Color.BLACK);
                    } 
                  
                    g2.setColor(Color.BLACK);
                 
                }
                else{
                    g2.setColor(Color.ORANGE);
                    g2.drawString("STABLE STATE",120,50);
                 
                }
               
         
            }
          
            Color fontcolour = new Color(150,150,150);
            g2.setColor(Color.BLUE);
            //g2.draw(outline);
           
        }
        private int x,y;
    }
}
   
    class VResistor {
        public VResistor(int a, int b) {
            x = a;
            y = b;
        }
        public void draw(Graphics2D g2) {
            Line2D.Double w1= new Line2D.Double(x,y,x,y+20);
            Line2D.Double w2= new Line2D.Double(x,y+20,x-5,y+22);
            Line2D.Double w3= new Line2D.Double(x-5,y+22,x+5,y+25);
            Line2D.Double w4= new Line2D.Double(x+5,y+25,x-5,y+28);
            Line2D.Double w5= new Line2D.Double(x-5,y+28,x+5,y+31);
            Line2D.Double w6= new Line2D.Double(x+5,y+31,x-5,y+34);
            Line2D.Double w7= new Line2D.Double(x-5,y+34,x+5,y+37);
            Line2D.Double w8= new Line2D.Double(x+5,y+37,x,y+39);
            Line2D.Double w9= new Line2D.Double(x,y+39,x,y+60);
           
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
            g2.draw(w7);
            g2.draw(w8);
            g2.draw(w9);
        }
       
        private int x,y;
    }
   
    class HResistor {
        public HResistor(int a, int b) {
            x = a;
            y = b;
        }
        public void draw(Graphics2D g2) {
            Line2D.Double w1= new Line2D.Double(x,y,x+20,y);
            Line2D.Double w2= new Line2D.Double(x+20,y,x+22,y-5);
            Line2D.Double w3= new Line2D.Double(x+22,y-5,x+25,y+5);
            Line2D.Double w4= new Line2D.Double(x+25,y+5,x+28,y-5);
            Line2D.Double w5= new Line2D.Double(x+28,y-5,x+31,y+5);
            Line2D.Double w6= new Line2D.Double(x+31,y+5,x+34,y-5);
            Line2D.Double w7= new Line2D.Double(x+34,y-5,x+37,y+5);
            Line2D.Double w8= new Line2D.Double(x+37,y+5,x+39,y);
            Line2D.Double w9= new Line2D.Double(x+39,y,x+60,y);
           
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
            g2.draw(w7);
            g2.draw(w8);
            g2.draw(w9);
        }
       
        private int x,y;
    }
   
    class Comparator {
        public Comparator(int a, int b)
        {
            x=a;
            y=b;
        }
       
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x+40,y);
            Line2D.Double w2= new Line2D.Double(x,y+30,x+40,y+30);
            Line2D.Double w3= new Line2D.Double(x+40,y-15,x+40,y+45);
            Line2D.Double w4= new Line2D.Double(x+40,y-15,x+100,y+15);
            Line2D.Double w5= new Line2D.Double(x+40,y+45,x+100,y+15);
            Line2D.Double w6= new Line2D.Double(x+100,y+15,x+160,y+15);
           
            g2.drawString("+",x+45,y+5);
            g2.drawString("-",x+47,y+35);
           
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
   
        }
        private int x,y;
    }
   
    class Capacitor {
        public Capacitor(int a, int b)
        {
            x=a;
            y=b;
        }
       
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x,y+10);
            Line2D.Double w2= new Line2D.Double(x-5,y+10,x+5,y+10);
            Line2D.Double w3= new Line2D.Double(x-5,y+15,x+5,y+15);
            Line2D.Double w4= new Line2D.Double(x,y+15,x,y+25);
           
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
        }
       
        private int x,y;
    }
   
    class Ground {
        public Ground(int a, int b)
        {
            x=a;
            y=b;
        }
       
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x,y+10);
            Line2D.Double w2= new Line2D.Double(x-10,y+10,x+10,y+10);
            Line2D.Double w3= new Line2D.Double(x-6,y+15,x+6,y+15);
            Line2D.Double w4= new Line2D.Double(x-2,y+20,x+2,y+20);
           
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
        }
       
        private int x,y;
    }
   
    class Transistor {
        public Transistor(int a, int b)
        {
            x=a;
            y=b;
        }
       
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x+20,y+10);
            Line2D.Double w2= new Line2D.Double(x+20,y+15,x+40,y+15);
            Line2D.Double w3= new Line2D.Double(x+20,y,x+20,y+30);
            Line2D.Double w4= new Line2D.Double(x+20,y+20,x,y+30);
            Line2D.Double w5= new Line2D.Double(x,y+30,x+3,y+25);
            Line2D.Double w6= new Line2D.Double(x,y+31,x+5,y+31);
            Line2D.Double w7= new Line2D.Double(x+3,y+25,x+5,y+31);
           
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
            g2.draw(w7);
        }
        private int x,y;
    }
   
    class Arrowright {
        public Arrowright(int a, int b)
        {
            x=a;
            y=b;
        }
       
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x-5,y-3);
            Line2D.Double w2= new Line2D.Double(x,y,x-5,y+3);
           
            g2.draw(w1);
            g2.draw(w2);
        }
       
        private int x,y;
    }
   
    class Arrowleft {
        public Arrowleft(int a, int b)
        {
            x=a;
            y=b;
        }
       
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x+5,y-3);
            Line2D.Double w2= new Line2D.Double(x,y,x+5,y+3);
           
            g2.draw(w1);
            g2.draw(w2);
        }
       
        private int x,y;
    }
   
    class Arrowup {
        public Arrowup(int a, int b)
        {
            x=a;
            y=b;
        }
       
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x-3,y+5);
            Line2D.Double w2= new Line2D.Double(x,y,x+3,y+5);
           
            g2.draw(w1);
            g2.draw(w2);
        }
       
        private int x,y;
    }
   
    class Arrowdown {
        public Arrowdown(int a, int b)
        {
            x=a;
            y=b;
        }
       
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x-3,y-5);
            Line2D.Double w2= new Line2D.Double(x,y,x+3,y-5);
           
            g2.draw(w1);
            g2.draw(w2);
        }
       
        private int x,y;
    }
   
    class diode{
        public diode(int a, int b,boolean c){
            x = a;
            y = b;
            right = c;
        }
        public void draw(Graphics g){
            if(right){
                g.drawLine(x,y,x,y-24);
                g.drawLine(x,y,x+24,y-12);
                g.drawLine(x,y-24,x+24,y-12);
                g.drawLine(x+24,y-24,x+24,y);
            }
            else{
                g.drawLine(x,y,x,y-24);
                g.drawLine(x+24,y,x,y-12);
                g.drawLine(x+24,y-24,x,y-12);
                g.drawLine(x+24,y-24,x+24,y);
            }
        }
        private int x,y;
        private boolean right;
    }
    
    class Arrow {
        public Arrow(int a, int b, String dir)
        {
            x=a;
            y=b;
            direction=dir;
        }
        
        public void draw(Graphics2D g2)
        {
            if(direction == "up"){
       
                Line2D.Double w1= new Line2D.Double(x,y,x-3,y+5);
                Line2D.Double w2= new Line2D.Double(x,y,x+3,y+5);
                
                g2.draw(w1);
                g2.draw(w2);
            }
            
            else if(direction == "down") {
                Line2D.Double w1= new Line2D.Double(x,y,x-3,y-5);
                Line2D.Double w2= new Line2D.Double(x,y,x+3,y-5);
                
                g2.draw(w1);
                g2.draw(w2);
            }
            
            else if(direction == "left"){
                Line2D.Double w1= new Line2D.Double(x,y,x+5,y-3);
                Line2D.Double w2= new Line2D.Double(x,y,x+5,y+3);
                
                g2.draw(w1);
                g2.draw(w2);
            }
            else {
                Line2D.Double w1= new Line2D.Double(x,y,x-5,y-3);
                Line2D.Double w2= new Line2D.Double(x,y,x-5,y+3);
                
                g2.draw(w1);
                g2.draw(w2);
            }
        }
        
        private String direction;
        private int x,y;
    } //end of class Arrow        