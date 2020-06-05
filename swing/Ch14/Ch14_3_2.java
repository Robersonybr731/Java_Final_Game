/* 程式範例: Ch14_3_2.java */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.colorchooser.*;
// 繼承JFrame類別
public class Ch14_3_2 extends JFrame {
   public Ch14_3_2() {   // 建構子
      super("JColorChooser元件範例");
      final Container c = getContentPane();
      c.setBackground(Color.white); // 背景為白色
      // 建立JColorChooser()物件
      final JColorChooser jcc = new JColorChooser();
      JButton button = new JButton("選擇背景色彩");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Color newColor;
            newColor = jcc.showDialog(Ch14_3_2.this,
                     "選擇背景色彩", c.getBackground());
            if ( newColor != null )
               c.setBackground(newColor);
         } });
      c.add(new JLabel(), BorderLayout.CENTER);
      c.add(button, BorderLayout.SOUTH);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch14_3_2 app = new Ch14_3_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}