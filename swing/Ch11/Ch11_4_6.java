/* 程式範例: Ch11_4_6.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_4_6 extends JFrame {
   public Ch11_4_6() {    // 建構子
      super("BoxLayout版面配置");
      Container c = getContentPane();
      JPanel jpane1 = new JPanel(); // 第一個JPanel
      BoxLayout bl1, bl2;
      bl1 = new BoxLayout(jpane1, BoxLayout.Y_AXIS);
      jpane1.setLayout(bl1); // 設定容器預設的版面配置
      JLabel label = new JLabel("地址:");
      jpane1.add(label);
      jpane1.add(
      	     Box.createRigidArea(new Dimension(2,5)));
      JTextArea area = new
             JTextArea("準備輸入資料...\n", 15, 30);
      JScrollPane scroll = new JScrollPane(area);
      scroll.setAlignmentX(LEFT_ALIGNMENT);
      jpane1.add(scroll);
      JPanel jpane2 = new JPanel(); //  第二個JPanel
      bl2 = new BoxLayout(jpane2, BoxLayout.X_AXIS);
      jpane2.setLayout(bl2); // 設定容器預設版面配置
      JButton button1 = new JButton("儲存");
      jpane2.add(button1);
      jpane2.add(Box.createHorizontalGlue());
      JButton button2 = new JButton("複製");
      jpane2.add(button2);
      jpane2.add(
      	     Box.createRigidArea(new Dimension(20,5)));
      JButton button3 = new JButton("貼上");
      jpane2.add(button3);
      c.add(jpane1, BorderLayout.CENTER);
      c.add(jpane2, BorderLayout.SOUTH);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_4_6 app = new Ch11_4_6();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}