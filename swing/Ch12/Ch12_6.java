/* �{���d��: Ch12_6.java */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
// �~��JFrame���O
public class Ch12_6 extends JFrame {
   public Ch12_6() {    // �غc�l
      super("Swing�ؽu����ܽd��");
      Border bL, etchedL, emptyL;
      JLabel lbl1, lbl2, lbl3, lbl4, lbl5; // �إ߮ؽu
      bL = BorderFactory.createLineBorder(Color.blue);
      etchedL = BorderFactory.createEtchedBorder();
      TitledBorder titledL =
        BorderFactory.createTitledBorder(bL,"���D");
      emptyL = BorderFactory.createEmptyBorder();
      Container c = getContentPane();
      JPanel jpane1 = new JPanel();
      lbl1 = new JLabel("Line�ؽu", JLabel.CENTER);
      jpane1.add(lbl1);  jpane1.setBorder(bL);
      c.add(jpane1, BorderLayout.NORTH);
      JPanel jpane2 = new JPanel();
      lbl2 = new JLabel("Etched�ؽu", JLabel.CENTER);
      jpane2.add(lbl2);  jpane2.setBorder(etchedL);
      c.add(jpane2, BorderLayout.CENTER);
      JPanel jpane3 = new JPanel();
      lbl3 = new JLabel("Titled�ؽu", JLabel.CENTER);
      jpane3.add(lbl3);  jpane3.setBorder(titledL);
      c.add(jpane3, BorderLayout.SOUTH);
      JPanel jpane4 = new JPanel();
      lbl4 = new JLabel("Empty�ؽu", JLabel.CENTER);
      jpane4.add(lbl4);  jpane4.setBorder(emptyL);
      c.add(jpane4, BorderLayout.EAST);
      Border compoundL = BorderFactory.
             createCompoundBorder(etchedL, bL);
      JPanel jpane5 = new JPanel();
      lbl5 = new JLabel("Compound�ؽu", JLabel.CENTER);
      jpane5.add(lbl5); jpane5.setBorder(compoundL);
      c.add(jpane5, BorderLayout.WEST);
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch12_6 app = new Ch12_6();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}