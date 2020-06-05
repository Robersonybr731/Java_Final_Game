/* 程式範例: Ch11_3_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch11_3_2 extends JFrame {
   public Ch11_3_2() {  // 建構子
      super("JScrollPane中間容器範例");
      Container c = getContentPane();
      JTextArea area = new
                JTextArea("準備輸入資料...\n", 15, 30);
      JScrollPane scroll = new JScrollPane(area);
      scroll.setPreferredSize(new Dimension(250, 100));
      scroll.setMinimumSize(new Dimension(250,100));
      scroll.setAlignmentX(LEFT_ALIGNMENT);
      c.add(scroll, BorderLayout.CENTER); // 新增在中間
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_3_2 app = new Ch11_3_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}