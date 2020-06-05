/* 程式範例: Ch15_1_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch15_1_4 extends JFrame {
   JLabel label;
   int pointX, pointY;
   public Ch15_1_4() {    // 建構子
      super("JPanel畫布");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      UserPanel userPane = new UserPanel();
      userPane.setBorder(
             BorderFactory.createLineBorder(Color.red));
      c.add(userPane);
      label = new JLabel("請按一下JPanel畫布");
      c.add(label);
   }
   // 繪圖的JPanel
   class UserPanel extends JPanel {
      public UserPanel() {   // 建構子
         setPreferredSize(new Dimension(200, 150));
         // 註冊事件處理
         addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
               // 取得座標
               pointX = evt.getX(); pointY = evt.getY();
               repaint();   // 重繪
            } });
      }
      public void paintComponent(Graphics g) {
         super.paintComponent(g);   // 清除背景
         Insets ins = getInsets();  // 取得邊線尺寸
         // 計算實際的繪圖尺寸
         int width = getWidth()-(ins.left+ins.right);
         int height = getHeight()-(ins.top+ins.bottom);
         int x = ins.left, y = ins.top;
         g.setColor(Color.yellow);
         g.drawRect(x, y, width-1, height-1);
         label.setText("目前座標 :"+pointX+","+pointY);
      }
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch15_1_4 app = new Ch15_1_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(250,250);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}