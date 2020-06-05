/* 程式範例: Ch11_4_3.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch11_4_3 extends JFrame
                     implements ActionListener {
   private int num = 1;  // 第1張卡片
   JPanel cards;
   public Ch11_4_3() {   // 建構子
      super("CardLayout版面配置");
      Container c = getContentPane();
      JButton button = new JButton("下一頁");
      button.addActionListener(this);
      c.add(button, BorderLayout.NORTH);
      cards = new JPanel();
      cards.setLayout(new CardLayout());
      JPanel jp1 = new JPanel(); // 第一組卡片
      jp1.add(new JButton("按鈕一"));
      jp1.add(new JButton("按鈕二"));
      jp1.add(new JButton("按鈕三"));
      JPanel jp2 = new JPanel(); // 第二組卡片
      jp2.add(new JLabel("標籤四"));
      jp2.add(new JLabel("標籤五"));
      cards.add(jp1, "按鈕卡片");
      cards.add(jp2, "標籤卡片");
      c.add(cards, BorderLayout.SOUTH);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      num++;  // 卡片數加一
      CardLayout cl = (CardLayout)(cards.getLayout());
      if ( num > 2 ) {
         cl.first(cards);
         num = 1;
      } else  cl.next(cards);
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch11_4_3 app = new Ch11_4_3();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}