/* 程式範例: Ch12_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch12_4 extends JFrame
                    implements ActionListener {
   private JScrollBar scroll;
   private JSlider slider;
   private JLabel lbl;
   public Ch12_4() {  // 建構子
      super("JSlider與JScrollBar元件範例");
      Container c = getContentPane();
      c.setLayout(new BorderLayout());
      lbl = new JLabel("0/0");
      c.add(lbl, BorderLayout.CENTER);
      slider = new JSlider(JSlider.VERTICAL,0,100,50);
      slider.setPaintTicks(true);
      slider.setMinorTickSpacing(5);
      c.add(slider, BorderLayout.WEST);
      scroll = new JScrollBar(
               JScrollBar.HORIZONTAL,50,10,0,100);
      c.add(scroll, BorderLayout.NORTH);
      JButton btn1 = new JButton("選擇");
      btn1.addActionListener(this); // 註冊事件處理
      c.add(btn1, BorderLayout.SOUTH);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      int v1 = 0, v2 = 0;
      if ( !scroll.getValueIsAdjusting() )
         v1 = (int)scroll.getValue();
      if ( !slider.getValueIsAdjusting() )
         v2 = (int)slider.getValue();
      lbl.setText(Integer.toString(v1) + "/" +
                  Integer.toString(v2) );
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch12_4 app = new Ch12_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}