/* �{���d��: Ch11_2_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch11_2_1 extends JFrame {
   public Ch11_2_1() {   // �غc�l
      super("JFrame�̤W�h�e��");
      Container c=getContentPane();// ���oContentPane����
      c.setBackground(Color.white);// ���w�I����m
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
   	  Ch11_2_1 app = new Ch11_2_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�ؤo
      app.setVisible(true);  // ��ܵ���
   }
}