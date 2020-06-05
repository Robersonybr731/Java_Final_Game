/* 程式範例: Ch14_1_1.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch14_1_1 extends JFrame
                      implements ActionListener {
   private JPopupMenu popup;
   private JMenuItem blue, yellow, green;
   private Container c;
   public Ch14_1_1() {    // 建構子
      super("JPopupMenu元件範例");
      c = getContentPane();
      c.setBackground(Color.white);
      popup = new JPopupMenu();
      popup.add(blue = new JMenuItem("藍色"));
      blue.addActionListener(this);
      popup.add(yellow = new JMenuItem("黃色"));
      yellow.addActionListener(this);
      popup.add(green = new JMenuItem("綠色"));
      green.addActionListener(this);
      popup.addSeparator();
      popup.add("紅色");  // 使用字串新增選項
      addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent evt) {
            if ( evt.isPopupTrigger() ) // 顯示選單
               popup.show(evt.getComponent(),
                          evt.getX(), evt.getY());
         }
         public void mouseReleased(MouseEvent evt) {
            if ( evt.isPopupTrigger() ) // 顯示選單
               popup.show(evt.getComponent(),
                          evt.getX(), evt.getY());
         } });
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      if ( evt.getSource() == blue )
         c.setBackground(Color.blue);    // 藍色
      if ( evt.getSource() == yellow )
         c.setBackground(Color.yellow);  // 黃色
      if ( evt.getSource() == green )
         c.setBackground(Color.green);   // 綠色
      repaint();  // 重繪
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch14_1_1 app = new Ch14_1_1();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}