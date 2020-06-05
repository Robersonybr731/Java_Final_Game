/* 程式範例: Ch12_3_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch12_3_1 extends JFrame
                      implements ActionListener {
   private JCheckBox ckbg, ckbr;
   public Ch12_3_1() {  // 建構子
      super("JCheckBox元件範例");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      ckbg = new JCheckBox("前景綠色(G)");
      ckbg.setMnemonic(KeyEvent.VK_G);
      ckbg.setSelected(true);
      ckbr = new JCheckBox("背景紅色(R)");
      ckbr.setMnemonic(KeyEvent.VK_R);
      JButton btn1 = new JButton("設定色彩");
      btn1.addActionListener(this); // 註冊事件處理
      JPanel jpane = new JPanel(); // 建立JPanel物件
      jpane.add(ckbg); jpane.add(ckbr); jpane.add(btn1);
      c.add(jpane);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      if ( ckbg.isSelected() )
            ckbg.setForeground(Color.green);
      else  ckbg.setForeground(Color.black);
      if ( ckbr.isSelected() )
            ckbr.setBackground(Color.red);
      else  ckbr.setBackground(Color.white);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch12_3_1 app = new Ch12_3_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}