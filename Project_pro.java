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
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class Project_pro extends JFrame implements ActionListener{

    static int drop_nuber; //control drop number
    static int turtle_nuber; //control drop number
    static int magic; //magic count max is 5
    static double times; //record time
    static double max_user; //record time
    static String names;

    static int move; // determine left or right
    static int move_x;//character location x
    static int move_y; //character location y
    static int blue_x; //blue mushroom x
    static int blue_y; //blue mushroom y
    static int []dropx=new int[20];//drop location x
    static int []dropy=new int[20]; //drop location y
    static int []dropSize=new int[20]; //drop Size
    static int []turtle_x=new int[4];//drop location x
    static int []turtle_y=new int[4]; //drop location y
    static int []turtle_size=new int[4]; //drop Size
    static int []magic_x=new int[5];//maigc location x
    static int []magic_y=new int[5]; //maigc location y
    static int []magic_size=new int[5]; //maigc size

    static JLabel name_label=new JLabel(""); //uers name
    static JLabel all_label=new JLabel(""); //uers name
    static JLabel time_label=new JLabel("0.0"); //time
    static JLabel str_label=new JLabel("Magic: "); //time
    static JLabel magic_label=new JLabel("0/5"); //time
    static JLabel hint_label=new JLabel("Hint:"); //time
    static JLabel a_label=new JLabel("Press A to use magic make mushroom number decrease."); //time
    static JLabel s_label=new JLabel("Press S to use magic make mushroom size to origine."); //time

    static boolean clock_con; //check wether timer control
    static boolean exits; //check wether exit
    static boolean is_blue; //check blue mushroom
    static boolean is_ability; //check blue mushroom
    static boolean is_move; //check move

    static Project_pro main_app; //JFrame
    private UserPanel userPane; //JPanel
    private ButtomPanel lab_Panels; //JPanel
    private Timer timer; //timer

    static Image img_turtle,img_mushroom,img_bluemushroom,img_ghost1,img_ghost2,img,backgrounds; //set Image
    static Vector vec_loading = new Vector();
    static Vector vec_names = new Vector();


    class ButtomPanel extends JPanel{

        /* constructer */
        public ButtomPanel() {  //UserPanel Constructer
            setPreferredSize(new Dimension(600,50));
        }
        /* constructer End */

        /* Paint */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);   // Clear
            Font fnt1=new Font("Serief",Font.ITALIC+Font.BOLD,23);
            Font fnt2=new Font("Serief",Font.ITALIC+Font.BOLD,18);
            Font fnt3=new Font("Serief",Font.ITALIC+Font.BOLD,15);
            Font fnt4=new Font("Serief",Font.ITALIC+Font.BOLD,18);


            name_label.setBounds(10,-5,250,30);
            str_label.setBounds(10,21,100,30);
            magic_label.setBounds(150,22,100,30);
            time_label.setBounds(490,-10,100,30);

            name_label.setForeground(Color.BLACK);
            str_label.setForeground(Color.BLUE);

            name_label.setFont(fnt1);
            str_label.setFont(fnt2);
            time_label.setText("Times: "+Double.toString(times)+"sec");
            if(names.equals("Roberson_is_handsome")||names.equals("妹妹很可愛"))
                magic=5;
            if(magic!=5){
                magic_label.setFont(fnt3);
                magic_label.setBounds(70+magic*25,21,100,30);
                magic_label.setForeground(Color.BLUE);
                magic_label.setText(magic+"/5");
                hint_label.setText("");
                a_label.setText("");
                s_label.setText("");
                hint_label.setOpaque(false);
                magic_label.setOpaque(false);
            }
            else{
                hint_label.setText("Hint:");
                a_label.setText("Press A to use magic make mushroom number decrease.");
                s_label.setText("Press S to use magic make mushroom size to origine.");
                hint_label.setBounds(220,-25,600,69);
                a_label.setBounds(250,9,600,30);
                s_label.setBounds(250,19,600,30);
                hint_label.setOpaque(true);
                hint_label.setBackground(Color.YELLOW);
                magic_label.setOpaque(true);
                magic_label.setBackground(Color.YELLOW);
                magic_label.setBounds(68+magic*25-5,21,60,23);
                magic_label.setForeground(Color.RED);
                magic_label.setFont(fnt4);
                magic_label.setText("Max =>");
            }

            for(int i=0;i<magic;i++)
                g.drawImage(img_bluemushroom,magic_x[i] ,magic_y[i] , magic_size[i], magic_size[i], this);
        }
        /* Paint End */
     }


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
        c.add(userPane);
        

        lab_Panels=new ButtomPanel();
        lab_Panels.setLayout(null);
        lab_Panels.setBackground(Color.white);
        lab_Panels.add(name_label);
        lab_Panels.add(magic_label);
        lab_Panels.add(time_label);
        lab_Panels.add(str_label);
        lab_Panels.add(a_label);
        lab_Panels.add(s_label);
        lab_Panels.add(hint_label);

        

        c.add(lab_Panels);
        timer.start();

        this.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        move=0;
                        is_move=true;
                        userPane.repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        move=1;
                        is_move=true;
                        userPane.repaint();
                        break;
                    case KeyEvent.VK_R:
                        timer.stop();
                        Double []r=new Double[vec_loading.size()];
                        String []s=new String[vec_names.size()];
                        for(int i=0;i<vec_loading.size();i++){
                            Object objs = vec_loading.get(i);
                            r[i]=Double.parseDouble(objs.toString());
                            objs=vec_names.get(i);
                            s[i]=objs.toString();
                        }
                        for(int i=0;i<vec_loading.size();i++){
                            for(int j=i+1;j<vec_loading.size();j++){
                                if(r[i]<r[j]){
                                    Double a=r[i];
                                    r[i]=r[j];
                                    r[j]=a;
                                    String b=s[i];
                                    s[i]=s[j];
                                    s[j]=b;
                                }
                            }
                        }
                        String req="";
                        for(int i=0;i<5;i++){
                            if(i<vec_loading.size())
                                req+="No"+Integer.toString(i+1)+". "+s[i]+" "+r[i]+"s"+"\n";
                            else
                                req+="No"+Integer.toString(i+1)+". "+"Null"+"\n";
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
                        userPane.repaint();
                        break;
                    case KeyEvent.VK_S: //small size
                        if(magic==5){
                            magic-=5;
                            for(int i=0;i<=drop_nuber;i++)
                            dropSize[i]=50;
                            is_ability=true;
                            userPane.repaint();
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

        /* Add number */
        if(times%5==0 && drop_nuber<15){
            drop_nuber++;
            if(times>=30)
                drop_nuber++;
            if(drop_nuber>15)
                drop_nuber=15;
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
                        dropSize[i]+=20;
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
            }
        }

        //Game Over
        if(exits){
            timer.stop();
            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                for(int i=0;i<vec_loading.size();i++){
                    Object objs = vec_names.get(i);
                    myWriter.write(objs.toString()+" ");
                    objs = vec_loading.get(i);
                    myWriter.write(objs.toString()+"\n");
                }
                
                myWriter.write(names+" ");
                myWriter.write(Double.toString(times)+"\n");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(times>=max_user)
                    JOptionPane.showMessageDialog(main_app,"Hi "+names+",Congratuation to create New Record!\nYou continue: "+Double.toString(times)+" sec","Over",JOptionPane.QUESTION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(main_app,"Hi "+names+", Game Over!\nYou continue: "+Double.toString(times)+" sec","Over",JOptionPane.QUESTION_MESSAGE);
            int result = JOptionPane.showConfirmDialog(main_app,"Sure? You want to exit?", "Swing Tester",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION)
                System.exit(0);
            else if (result == JOptionPane.NO_OPTION){
                init_setting();
                timer.restart();
            }     
        }
        userPane.repaint();  //ReDraw
        lab_Panels.repaint();
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

        names="";
        times=0;
        max_user=0;
        magic=0;
        drop_nuber=4;
        turtle_nuber=0;
        /* setting name */
        names=JOptionPane.showInputDialog(main_app,"Enter Your Name!","Name.",JOptionPane.QUESTION_MESSAGE);
        if(names.length()==0)
            names="Roberson";
        else{
            String []data = names.split(" ");
            names="";
            for (String token:data) {
                names+=token;
            }
        }
        JOptionPane.showMessageDialog(main_app,"Hi "+names+", Welcome to ball game!","Name Confirm",JOptionPane.QUESTION_MESSAGE);
        name_label.setText("Name: "+names);

        vec_loading.clear();
        vec_names.clear();
        /* Load Record File */
        try {
            File input_file = new File("filename.txt");
            Scanner myReader = new Scanner(input_file);
            while (myReader.hasNextLine()) {
                String []data = myReader.nextLine().split(" ");
                vec_names.add(data[0]);
                vec_loading.add(Double.parseDouble(data[1]));
                System.out.println(data[0]);
                System.out.println(Double.parseDouble(data[1]));
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

        for(int i=0;i<5;i++)
            magic_x[i]=48+23*(i+1);
        for(int i=0;i<5;i++)
            magic_y[i]=20;
        for(int i=0;i<5;i++)
            magic_size[i]=25;

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