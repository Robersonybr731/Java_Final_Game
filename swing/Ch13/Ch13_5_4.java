/* 程式範例: Ch13_5_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch13_5_4 extends JFrame {
   private JScrollBar scroll;
   private JLabel lbl;
   public Ch13_5_4() {  // 建構子
      super("AdjustmentEvent事件處理");
      Container c = getContentPane();
      c.setLayout(new BorderLayout());
      lbl = new JLabel("50");
      c.add(lbl, BorderLayout.SOUTH);
      scroll = new JScrollBar(
               JScrollBar.HORIZONTAL,50,10,0,100);
      // 註冊事件處理
      scroll.addAdjustmentListener(
                          new AdjustmentListener() {
         public void adjustmentValueChanged(
                             AdjustmentEvent evt) {
            JScrollBar s = (JScrollBar)evt.getSource();
            if ( !s.getValueIsAdjusting() ) {
               int v = (int)s.getValue();
               lbl.setText(Integer.toString(v));
            }
         } });
      c.add(scroll, BorderLayout.NORTH);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_5_4 app = new Ch13_5_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,100);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}