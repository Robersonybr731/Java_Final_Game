/* 程式範例: Ch11_3_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_3_1 extends JFrame {
   public Ch11_3_1() {   // 建構子
      super("JPanel中間容器範例");
      Container c = getContentPane();
      JPanel jpane1 = new JPanel(); // 建立JPanel物件
      jpane1.add(new JButton("左按鈕"));
      JPanel jpane2 = new JPanel(); // 建立JPanel物件
      jpane2.add(new JLabel("右標籤"));
      c.add(jpane1, BorderLayout.WEST); // 新增在西方
      c.add(jpane2, BorderLayout.EAST); // 新增在東方
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_3_1 app = new Ch11_3_1();
   	  app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}