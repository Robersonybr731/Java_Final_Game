/* �{���d��: Ch11_1_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O, ��@ActionListener����
public class Ch11_1_2 extends JFrame
                     implements ActionListener {
   private static String labelString = "���X��: ";
   private int num = 0;  // ���Ʋέp
   private JLabel label;
   public Ch11_1_2() {   // �غc�l
      super("Swing���ε{���d��");  // �������D��r
      Container c = getContentPane(); // ���oContentPane
      c.setLayout(new FlowLayout());  // �����t�m
      label = new JLabel(labelString + num);
      label.setBorder(   // �]�w�ؽu
      	    BorderFactory.createLineBorder(Color.blue));
      JButton button = new JButton("���@�U(K)");
      button.setMnemonic(KeyEvent.VK_K);// �]�w����Alt_K
      button.addActionListener(this);   // ���U�ƥ�B�z
      JPanel jpane = new JPanel();  // �إ�JPanel����
      jpane.setBorder(   // �]�w�ؽu
      	  BorderFactory.createLineBorder(Color.yellow));
      jpane.add(label);  // �s�W�����JPanel
      jpane.add(button);
      c.add(jpane);      // �s�W�����ContentPane
   }
   // ��@�ƥ�B�z��k
   public void actionPerformed(ActionEvent evt) {
      num++; // ���s���ƥ[�@
      label.setText(labelString+num); // ���]��r���e
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��������
      Ch11_1_2 app = new Ch11_1_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}