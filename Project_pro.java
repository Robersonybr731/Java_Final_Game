import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.text.DecimalFormat;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Vector;

public class Project_pro extends JFrame implements ActionListener{
	static int drop_nuber=6; //control drop number
    static Project_pro main_app; //JFrame
    static int move; // determine left or right
    static int move_x=280; //character location x
    static int move_y=525; //character location y
    static int []dropx=new int[20];//drop location x
    static int []dropy=new int[20]; //drop location y
    static int []dropSize=new int[20]; //drop Size
    static JLabel name_label; //uers name
    static JLabel time_label; //time
    static boolean clock_con=false; //check wether timer control
    static boolean exits=false; //check wether exit
    private UserPanel userPane; //JPanel
    private Timer timer; //timer
    static double times=0; //record time
    static Image img_turtle,img_mushroom,img_ghost1,img_ghost2,img,backgrounds; //set Image
    static Vector vec_loading = new Vector();

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
            g.drawImage(backgrounds,0 , 0, 600,600,this); //Draw background
            for(int i=0;i<=drop_nuber;i++)
                if(i==5 || i==10 || i==19)
                    g.drawImage(img_turtle,dropx[i] , dropy[i], dropSize[i],dropSize[i],this); //Draw turtle
            for(int i=0;i<=drop_nuber;i++)
                if(i!=5 && i!=10 && i!=19)
                    g.drawImage(img_mushroom,dropx[i] , dropy[i], dropSize[i],dropSize[i],this); //Draw mushroom
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
        c.add(time_label);
        


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
        DecimalFormat df = new DecimalFormat("##.0");
        times = Double.parseDouble(df.format(times));
        time_label.setText(Double.toString(times)+"s");
        if(times%5==0 && drop_nuber<19){
            drop_nuber++;
            if(times>=30)
                drop_nuber++;
            if(drop_nuber>19)
                drop_nuber=19;
            System.out.println("add");
            System.out.println(times);
            System.out.println(drop_nuber);
        }
        /* Condition1 */
        for(int i=0;i<=drop_nuber;i++){
            if(dropy[i]+dropSize[i]-35>=move_y){
                if(dropx[i]+dropSize[i]>=move_x+10&&dropx[i]<=move_x+60){
                    if(i!=5 && i!=10 && i!=19){
                        dropx[i]=(int)(Math.random()*600);
                        while(dropx[i]<=0||dropx[i]+dropSize[i]>=600)
                            dropx[i]=(int)(Math.random()*600);
                        dropy[i]=10;
                        if(dropSize[i]<=300)
                            dropSize[i]+=30;
                    }
                    else{
                        exits=true;
                    }
                }
            }
        }

        /* Condition2 */
        for(int i=0;i<=drop_nuber;i++) //if down to horizon
            if(dropy[i]+dropSize[i]>=600){
                dropx[i]=(int)(Math.random()*600);
                while(dropx[i]<=0||dropx[i]+dropSize[i]>=600)
                    dropx[i]=(int)(Math.random()*600);
                dropy[i]=10;
            }
        
        for(int i=0;i<=drop_nuber;i++) //set different speed
            dropy[i]+=i+5;

        if(exits){ //Game Over
            timer.stop();
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
        time_label=new JLabel("0.0");
        try {
            File input_file = new File("filename.txt");
            Scanner myReader = new Scanner(input_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                vec_loading.add(new Double(Double.parseDouble(data)));
                System.out.println(Double.parseDouble(data));
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        for(int i=0;i<vec_loading.size();i++)
            System.out.println(vec_loading[i]); 
    }
    /* Input Name End */

    /* Image setting */
    static void img_setting(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        img_ghost1 = toolkit.getImage("ghost_left.png");
        img_ghost2 = toolkit.getImage("ghost_right.png");
        img_turtle=toolkit.getImage("turtle.png");
        img_mushroom=toolkit.getImage("mushroom.png");
        backgrounds=toolkit.getImage("background1.jpg");
        img=img_ghost1;

        for(int i=0;i<20;i++) //set different init x location
            dropx[i]=(int)(Math.random()*525)+15;
        for(int i=0;i<20;i++) //set different init y location
            dropy[i]=(int)(Math.random()*20)-30;
        for(int i=0;i<20;i++) //set different init drop size
            dropSize[i]=50;
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