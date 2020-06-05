/* 程式範例: Ch13_3_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作MouseListener介面
public class Ch13_3_1 extends JFrame
                      implements MouseListener {
   private JTextField txt;
   public Ch13_3_1() {  // 建構子
      super ("基本滑鼠事件範例");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      txt = new JTextField(12);   // 建立文字方塊
      txt.addMouseListener(this); // 註冊事件處理
      txt.setBackground(Color.white);
      c.add(txt);
   }
   // 實作事件處理方法
   public void mousePressed(MouseEvent evt) {
      txt.setText("mousePressed");
   }
   public void mouseEntered(MouseEvent evt) {
      txt.setText("mouseEntered");
      txt.setBackground(Color.yellow);
   }
   public void mouseExited(MouseEvent evt) {
      txt.setText("mouseExited");
      txt.setBackground(Color.white);
   }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseReleased(MouseEvent evt) { }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_3_1 app = new Ch13_3_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}