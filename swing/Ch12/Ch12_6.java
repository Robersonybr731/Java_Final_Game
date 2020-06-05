/* 程式範例: Ch12_6.java */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
// 繼承JFrame類別
public class Ch12_6 extends JFrame {
   public Ch12_6() {    // 建構子
      super("Swing框線的顯示範例");
      Border bL, etchedL, emptyL;
      JLabel lbl1, lbl2, lbl3, lbl4, lbl5; // 建立框線
      bL = BorderFactory.createLineBorder(Color.blue);
      etchedL = BorderFactory.createEtchedBorder();
      TitledBorder titledL =
        BorderFactory.createTitledBorder(bL,"標題");
      emptyL = BorderFactory.createEmptyBorder();
      Container c = getContentPane();
      JPanel jpane1 = new JPanel();
      lbl1 = new JLabel("Line框線", JLabel.CENTER);
      jpane1.add(lbl1);  jpane1.setBorder(bL);
      c.add(jpane1, BorderLayout.NORTH);
      JPanel jpane2 = new JPanel();
      lbl2 = new JLabel("Etched框線", JLabel.CENTER);
      jpane2.add(lbl2);  jpane2.setBorder(etchedL);
      c.add(jpane2, BorderLayout.CENTER);
      JPanel jpane3 = new JPanel();
      lbl3 = new JLabel("Titled框線", JLabel.CENTER);
      jpane3.add(lbl3);  jpane3.setBorder(titledL);
      c.add(jpane3, BorderLayout.SOUTH);
      JPanel jpane4 = new JPanel();
      lbl4 = new JLabel("Empty框線", JLabel.CENTER);
      jpane4.add(lbl4);  jpane4.setBorder(emptyL);
      c.add(jpane4, BorderLayout.EAST);
      Border compoundL = BorderFactory.
             createCompoundBorder(etchedL, bL);
      JPanel jpane5 = new JPanel();
      lbl5 = new JLabel("Compound框線", JLabel.CENTER);
      jpane5.add(lbl5); jpane5.setBorder(compoundL);
      c.add(jpane5, BorderLayout.WEST);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch12_6 app = new Ch12_6();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}