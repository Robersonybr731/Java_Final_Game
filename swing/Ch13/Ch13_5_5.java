/* 程式範例: Ch13_5_5.java */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別
public class Ch13_5_5 extends JFrame {
   private JSlider slider;
   private JLabel lbl;
   public Ch13_5_5() {   // 建構子
      super("ChangeEvent事件處理範例");
      Container c = getContentPane();
      c.setLayout(new BorderLayout());
      lbl = new JLabel("50");
      c.add(lbl, BorderLayout.CENTER);
      slider = new JSlider(JSlider.VERTICAL,0,100,50);
      slider.setPaintTicks(true);
      slider.setMinorTickSpacing(5);
      // 註冊事件處理
      slider.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent evt) {
            JSlider s = (JSlider)evt.getSource();
            if ( !s.getValueIsAdjusting() ) {
               int v = (int)s.getValue();
               lbl.setText(Integer.toString(v));
            }
         } });
      c.add(slider, BorderLayout.WEST);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_5_5 app = new Ch13_5_5();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}