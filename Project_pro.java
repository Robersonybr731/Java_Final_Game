import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.text.DecimalFormat;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;

public class Project_pro extends JFrame implements ActionListener{
    static int drop_nuber; //control drop number
    static int turtle_nuber; //control drop number
    static Project_pro main_app; //JFrame
    static int move; // determine left or right
    static int move_x;//character location x
    static int move_y; //character location y
    static int []dropx=new int[20];//drop location x
    static int []dropy=new int[20]; //drop location y
    static int []dropSize=new int[20]; //drop Size

    static int []turtle_x=new int[4];//drop location x
    static int []turtle_y=new int[4]; //drop location y
    static int []turtle_size=new int[4]; //drop Size
    
    static int blue_x; //blue mushroom x
    static int blue_y; //blue mushroom y
    static int magic;
    static JLabel name_label=new JLabel(""); //uers name
    static JLabel all_label=new JLabel(""); //uers name
    static JLabel time_label=new JLabel("0.0"); //time
    static JLabel magic_label=new JLabel("0/5"); //time

    static boolean clock_con; //check wether timer control
    static boolean exits; //check wether exit
    static boolean is_blue; //check blue mushroom
    static boolean is_ability; //check blue mushroom
    static boolean is_move; //check move
    private UserPanel userPane; //JPanel
    private Timer timer; //timer
    static double times; //record time
    static double max_user; //record time
    static Image img_turtle,img_mushroom,img_bluemushroom,img_ghost1,img_ghost2,img,backgrounds; //set Image
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

            /* Draw move activity */
            if(is_move){ //if is button event not timer event
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
                is_move=false;
            }
                
            g.drawImage(backgrounds,0 , 0, 600,600,this); //Draw background
            if(is_blue){ //Draw blue mushroom
                if(clock_con)
                    blue_y+=12;
                g.drawImage(img_bluemushroom,blue_x ,blue_y , 50, 50, this);
            }
                
            for(int i=0;i<=turtle_nuber;i++) //Draw turtle
                g.drawImage(img_turtle,turtle_x[i] , turtle_y[i], turtle_size[i],turtle_size[i],this); 
            for(int i=0;i<=drop_nuber;i++) //Draw mushroom
                g.drawImage(img_mushroom,dropx[i] , dropy[i], dropSize[i],dropSize[i],this);
            g.drawImage(img,move_x , 525, 75,75,this); //Draw character
            clock_con=false;
            is_ability=false;
        }
        /* Paint End */
     }
    /*JPanel constructer End*/  

    /*JFrame constructer*/
    public Project_pro() { 
        super("Dodge Ball Game.");
        timer = new Timer(100, this); //set timer each  is 0.1s
        timer.setInitialDelay(0);
        Container c = getContentPane(); //container
        c.setLayout(new FlowLayout());
        c.setBackground(Color.white);
        userPane = new UserPanel(); //JPanel
        userPane.setBorder(BorderFactory.createLineBorder(Color.red));
        JPanel kk=new JPanel();
        c.add(userPane);
        //all_label.setText("Name: "+name_label.getText()+"\n"+
        //"Time: "+time_label.getText()+"\n"+"Power: "+Integer.toString(magic)+"/5");
        c.add(new JPanel().add(name_label));
        c.add(new JPanel().add(time_label));
        c.add(new JPanel().add(magic_label));
        timer.start();

        this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        move=0;
                        is_move=true;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        move=1;
                        is_move=true;
                        repaint();
                        break;
                    case KeyEvent.VK_R:
                        timer.stop();
                        Double []r=new Double[vec_loading.size()];
                        for(int i=0;i<vec_loading.size();i++){
                            Object objs = vec_loading.get(i);
                            r[i]=Double.parseDouble(objs.toString());
                        }
                        for(int i=0;i<vec_loading.size();i++){
                            for(int j=i+1;j<vec_loading.size();j++){
                                if(r[i]<r[j]){
                                    Double a=r[i];
                                    r[i]=r[j];
                                    r[j]=a;
                                }
                            }
                        }
                        String req="";
                        for(int i=0;i<5;i++){
                            if(i<vec_loading.size())
                                req+="No"+Integer.toString(i+1)+" . "+r[i]+"s"+"\n";
                            else
                                req+=Integer.toString(i+1)+" . "+"Null"+"\n";
                        }
                        JOptionPane.showMessageDialog(main_app,req,"Rank Record",JOptionPane.QUESTION_MESSAGE);
                        timer.restart();
                        break;
                    case KeyEvent.VK_A: //decrease mushroom number
                        if(magic==5){
                            magic-=5;
                            int randoms=5+(int)(Math.random()*(drop_nuber/5));
                            for(int i=1;i<=randoms;i++){
                                if(drop_nuber-i>=0){
                                    dropx[drop_nuber-i]=(int)(Math.random()*525)+15;
                                    dropy[drop_nuber-i]=10;
                                    dropSize[drop_nuber-i]=50;
                                }
                            }
                            if(drop_nuber-randoms<0)
                                drop_nuber=0;
                            else
                                drop_nuber-=randoms;
                        }
                        is_ability=true;
                        repaint();
                        break;
                    case KeyEvent.VK_S: //small size
                        if(magic==5){
                            magic-=5;
                            for(int i=0;i<=drop_nuber;i++)
                            dropSize[i]=50;
                            is_ability=true;
                            repaint();
                        }
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

        /* Add number */
        if(times%5==0 && drop_nuber<15){
            drop_nuber++;
            if(times>=30)
                drop_nuber++;
            if(drop_nuber>15)
                drop_nuber=19;
        }
        if(times%25==0 && turtle_nuber<3){
            turtle_nuber++;
        }
        /* Condition1 */
        for(int i=0;i<=drop_nuber;i++){
            if(dropy[i]+dropSize[i]-35>=move_y){
                if(dropx[i]+dropSize[i]>=move_x+10&&dropx[i]<=move_x+60){
                    dropx[i]=(int)(Math.random()*600);
                    while(dropx[i]<=0||dropx[i]+dropSize[i]>=600)
                        dropx[i]=(int)(Math.random()*600);
                    dropy[i]=10;
                    if(dropSize[i]<=300)
                        dropSize[i]+=30;
                }
            }
        }
        for(int i=0;i<=turtle_nuber;i++){
            if(turtle_y[i]+turtle_size[i]-35>=move_y){
                if(turtle_x[i]+turtle_size[i]>=move_x+10&&turtle_x[i]<=move_x+60){
                    exits=true;
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
        for(int i=0;i<=turtle_nuber;i++) //if down to horizon
            if(turtle_y[i]+turtle_size[i]>=600){
                turtle_x[i]=(int)(Math.random()*600);
                while(turtle_x[i]<=0||turtle_x[i]+turtle_size[i]>=600)
                    turtle_x[i]=(int)(Math.random()*600);
                turtle_y[i]=10;
            }

        /* Speed */
        for(int i=0;i<=drop_nuber;i++)
            dropy[i]+=i+5;
        for(int i=0;i<=turtle_nuber;i++)
            turtle_y[i]+=i+8;
        
        /* Magic */
        if(times%5==0) //drop blue
            is_blue=true;
        if(blue_y+50>=600){ //horizon
            blue_x=(int)(Math.random()*600);
            while(blue_x<=0||blue_x+50>=600)
                blue_x=(int)(Math.random()*600);
            blue_y=10;
            is_blue=false;
        }
        if(blue_y+50-35>=move_y){
            if(blue_x+50>=move_x+10&&blue_x<=move_x+60){
                blue_x=(int)(Math.random()*600);
                while(blue_x<=0||blue_x+50>=600)
                    blue_x=(int)(Math.random()*600);
                blue_y=10;
                is_blue=false;
                if(magic<5)
                    magic++;
                System.out.println("magic: "+magic);
            }
        }

        //Game Over
        if(exits){
            timer.stop();
            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                for(int i=0;i<vec_loading.size();i++){
                    Object objs = vec_loading.get(i);
                    myWriter.write(objs.toString()+"\n");
                }
                myWriter.write(Double.toString(times)+"\n");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int result = JOptionPane.showConfirmDialog(main_app,"Sure? You want to exit?", "Swing Tester",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                if(times>=max_user)
                    JOptionPane.showMessageDialog(main_app,"Hi "+name_label.getText()+",Congratuation to create New Record!\nYou continue: "+Double.toString(times)+" sec","Over",JOptionPane.QUESTION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(main_app,"Hi "+name_label.getText()+", Game Over!\nYou continue: "+Double.toString(times)+" sec","Over",JOptionPane.QUESTION_MESSAGE);
                System.exit(0);
            }
            else if (result == JOptionPane.NO_OPTION){
                init_setting();
                timer.restart();
            }     
        }
        //all_label.setText("Name: "+name_label.getText()+"\n"+
        //"Time: "+time_label.getText()+"\n"+"Power: "+Integer.toString(magic)+"/5");
        magic_label.setText(magic+"/5");
        userPane.repaint();  //ReDraw
     }

    /* Initial Setting */
    static void init_setting(){
        is_blue=false;
        is_ability=false;
        is_move=false;
        blue_x=(int)(Math.random()*525)+15;
        blue_y=(int)(Math.random()*20)-30;

        move_x=280; //character location x
        move_y=525; //character location y

        exits=false;
        clock_con=false;

        times=0;
        max_user=0;
        magic=0;
        drop_nuber=4;
        turtle_nuber=0;
        /* setting name */
        String names=JOptionPane.showInputDialog(main_app,"Enter Your Name!","Name.",JOptionPane.QUESTION_MESSAGE);
        if(names.length()==0)
            names="Roberson";
        JOptionPane.showMessageDialog(main_app,"Hi "+names+", Welcome to ball game!","Name Confirm",JOptionPane.QUESTION_MESSAGE);
        name_label.setText(names);

        vec_loading.clear();
        /* Load Record File */
        try {
            File input_file = new File("filename.txt");
            Scanner myReader = new Scanner(input_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                vec_loading.add(Double.parseDouble(data));
                System.out.println(Double.parseDouble(data));
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        for(int i=0;i<vec_loading.size();i++){ //compute max record
            Object objs = vec_loading.get(i);
            if(max_user<(Double)objs)
                max_user=(Double)objs;
        }

        /* Setting image */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        img_ghost1 = toolkit.getImage("ghost_left.png");
        img_ghost2 = toolkit.getImage("ghost_right.png");
        img_turtle=toolkit.getImage("turtle.png");
        img_mushroom=toolkit.getImage("mushroom.png");
        img_bluemushroom=toolkit.getImage("b_mushroom.png");
        backgrounds=toolkit.getImage("background1.jpg");
        img=img_ghost1;

        /* Setting Initial image Location and Size */
        for(int i=0;i<20;i++) //set different init x location
            dropx[i]=(int)(Math.random()*525)+15;
        for(int i=0;i<20;i++) //set different init y location
            dropy[i]=(int)(Math.random()*20)-30;
        for(int i=0;i<20;i++) //set different init drop size
            dropSize[i]=50;
        
        for(int i=0;i<4;i++) //set different init x location
            turtle_x[i]=(int)(Math.random()*525)+15;
        for(int i=0;i<4;i++) //set different init y location
            turtle_y[i]=10;
        for(int i=0;i<4;i++) //set different init drop size
            turtle_size[i]=50;

    }
    /* Initial setting END */

    public static void main ( String[] args ){
        init_setting(); //initial_setting
        main_app = new Project_pro();
        main_app.setDefaultCloseOperation(EXIT_ON_CLOSE); //close
        main_app.setSize(600, 700);
        main_app.setLocation(250,0);
        main_app.setVisible(true);
    }
}