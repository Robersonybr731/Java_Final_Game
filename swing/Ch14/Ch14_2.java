/* 程式範例: Ch14_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch14_2 extends JFrame
                    implements ActionListener {
   private JButton blue, yellow, green;
   private Container c;
   public Ch14_2() {    // 建構子
      super ("JToolBar元件範例");
      c = getContentPane();
      c.setBackground(Color.white);
      JToolBar toolBar = new JToolBar();
      blue = new JButton(new ImageIcon("blue1.gif"));
      blue.setToolTipText("藍色");
      blue.addActionListener(this);
      yellow=new JButton(new ImageIcon("yellow1.gif"));
      yellow.setToolTipText("黃色");
      yellow.addActionListener(this);
      green = new JButton(new ImageIcon("green1.gif"));
      green.setToolTipText("綠色");
      green.addActionListener(this);
      toolBar.add(blue);  toolBar.add(yellow);
      toolBar.add(green);
      c.add(toolBar, BorderLayout.NORTH);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      if ( evt.getSource() == blue )
         c.setBackground(Color.blue);
      if ( evt.getSource() == yellow )
         c.setBackground(Color.yellow);
      if ( evt.getSource() == green )
         c.setBackground(Color.green);
      repaint();  // 重繪
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch14_2 app = new Ch14_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}