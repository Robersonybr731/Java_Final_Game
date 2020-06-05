import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.text.DecimalFormat;

public class Project_pro extends JFrame implements ActionListener{
	static int namessss;
    static Project_pro main_app; //JFrame
    static int move; // determine left or right
    static int move_x=280; //character location x
    static int move_y=525; //character location y
    static int[] dropx = {10, 10, 10, 10, 10,10}; //drop location x
    static int[] dropy = {10, 10, 10, 10, 10,10}; //drop location y
    static int[] dropSize = {50, 50, 50, 50, 50,50}; //drop Size
    static JLabel name_label; //uers name
    static boolean clock_con=false; //check wether timer control
    static boolean exits=false; //check wether exit
    private UserPanel userPane; //JPanel
    private Timer timer; //timer
    static double times=0; //record time
    static Image img_turtle,img_mushroom,img_ghost1,img_ghost2,img,b1; //set Image

    /* JPanel constructer */ 
    class UserPanel extends JPanel{

        /* constructer */
        public UserPanel() {  //UserPanel Constructer
            setPreferredSize(new Dimension(600, 600)); //Canvus Range
        }
        /* constructer End */

        /* Paint */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);   // Clear
            Insets ins = getInsets();  // Size
            int width = getWidth()-(ins.left+ins.right);   // compute actual size
            int height = getHeight()-(ins.top+ins.bottom); // compute actual size
            int x = ins.left, y = ins.top;
            g.setColor(Color.yellow);
            g.drawRect(x, y, width-1, height-1); //Draw border

            /* Draw move activity */
            if(!clock_con){ //if is button event not timer event
                if(move==0){ //left
                    if(move_x-5>=10)
                        move_x-=5;
                    img=img_ghost1;
                }
                else if(move==1){ //right
                    if(move_x+5<=520)
                        move_x+=5;
                    img=img_ghost2;
                }
            }
            else //if is timer event
                clock_con=false;
            g.drawImage(b1,0 , 0, 600,600,this); //Draw turtle
            g.drawImage(img_turtle,dropx[5] , dropy[5], dropSize[5],dropSize[5],this); //Draw turtle
            g.drawImage(img_mushroom,dropx[0] , dropy[0], dropSize[0],dropSize[0],this); //Draw mushroom1
            g.drawImage(img_mushroom,dropx[1] , dropy[1], dropSize[1],dropSize[1],this); //Draw mushroom2
            g.drawImage(img_mushroom,dropx[2] , dropy[2], dropSize[2],dropSize[2],this); //Draw mushroom3
            g.drawImage(img_mushroom,dropx[3] , dropy[3], dropSize[3],dropSize[3],this); //Draw mushroom4
            g.drawImage(img_mushroom,dropx[4] , dropy[4], dropSize[4],dropSize[4],this); //Draw mushroom5
            g.drawImage(img,move_x , 525, 75,75,this); //Draw character
        }
        /* Paint End */
     }
    /*JPanel constructer End*/ 

    /*JFrame constructer*/
    public Project_pro() { 
        super("Dodge Ball Game.");
        timer = new Timer(100, this);
        timer.setInitialDelay(0);
        Container c = getContentPane(); //container
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);
        userPane = new UserPanel(); //JPanel
        userPane.setBorder(BorderFactory.createLineBorder(Color.red));
        c.add(userPane);
        c.add(name_label);
        timer.start();


        this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        move=0;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        move=1;
                        repaint();
                        break;
                    default: move=-1;
                }
			}
            public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
    }
    /*JFrame constructer END*/

    public void actionPerformed(ActionEvent evt) {
        clock_con=true; //set timer event
        times+=0.1;
        /* Condition1 */
        for(int i=0;i<6;i++){
            if(dropy[i]+dropSize[i]-35>=move_y){
                if(dropx[i]+dropSize[i]+10>=move_x&&dropx[i]<=move_x+70){
                    if(i!=5){
                        dropx[i]=(int)(Math.random()*600);
                        while(dropx[i]<=0||dropx[i]+dropSize[i]>=600)
                            dropx[i]=(int)(Math.random()*600);
                        dropy[i]=10;
                        if(dropSize[i]<=300)
                            dropSize[i]+=30;
                        System.out.println("catch!");
                    }
                    else{
                        exits=true;
                        System.out.println("Opps!");
                    }
                }
            }
        }

        /* Condition2 */
        for(int i=0;i<6;i++) //if down to horizon
            if(dropy[i]+50>=600){
                dropx[i]=(int)(Math.random()*600);
                while(dropx[i]<=0||dropx[i]+dropSize[i]>=600)
                    dropx[i]=(int)(Math.random()*600);
                dropy[i]=10;
            }
        
        for(int i=0;i<6;i++) //set different speed
            dropy[i]+=i+5;

        if(exits){ //Game Over
            timer.stop();
            DecimalFormat df = new DecimalFormat("##.0");
            times = Double.parseDouble(df.format(times));
            JOptionPane.showMessageDialog(main_app,"Hi "+name_label.getText()+", Game Over!\nYou continue: "+Double.toString(times)+" sec","Over",JOptionPane.QUESTION_MESSAGE);
            System.exit(0);
        }

        userPane.repaint();  //ReDraw
     }

     /* Input Name */
     static void enter_name(){
        String names=JOptionPane.showInputDialog(main_app,"Enter Your Name!","Name.",JOptionPane.QUESTION_MESSAGE);
        if(names.length()==0)
            names="Roberson";
        JOptionPane.showMessageDialog(main_app,"Hi "+names+", Welcome to ball game!","Name Confirm",JOptionPane.QUESTION_MESSAGE);
        name_label=new JLabel(names);
    }
    /* Input Name End */

    /* Image setting */
    static void img_setting(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        img_ghost1 = toolkit.getImage("ghost_left.png");
        img_ghost2 = toolkit.getImage("ghost_right.png");
        img_turtle=toolkit.getImage("turtle.png");
        img_mushroom=toolkit.getImage("mushroom.png");
        b1=toolkit.getImage("b1.jpg");
        img=img_ghost1;

        for(int i=0;i<6;i++) //set different init x location
            dropx[i]=(int)(Math.random()*525)+15;
        for(int i=0;i<6;i++) //set different init y location
            dropy[i]=(int)(Math.random()*20)-30;
    }
    /* Image setting End */

    public static void main ( String[] args ){
        enter_name(); //Input Name
        img_setting();
        main_app = new Project_pro();
        main_app.setDefaultCloseOperation(EXIT_ON_CLOSE); //close
        main_app.setSize(600, 700);
        main_app.setLocation(250,0);
        main_app.setVisible(true);
    }
}