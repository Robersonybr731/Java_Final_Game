/* 程式範例: Ch13_5_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ItemListener介面
public class Ch13_5_2 extends JFrame
                      implements ItemListener {
   private Container c;
   private JCheckBox gBox;
   private JRadioButton rdb1, rdb2;
   public Ch13_5_2() {   // 建構子
      super("ItemEvent事件處理");
      c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.green);
      gBox = new JCheckBox("綠色");
      gBox.setSelected(true);
      gBox.addItemListener(this);  // 註冊事件處理
      ButtonGroup buttonGroup = new ButtonGroup();
      rdb1 = new JRadioButton("紅色");
      rdb1.setSelected(true);  // 預選
      rdb1.addItemListener(this);  // 註冊事件處理
      buttonGroup.add(rdb1);
      rdb2 = new JRadioButton("藍色");
      rdb2.addItemListener(this);  // 註冊事件處理
      buttonGroup.add(rdb2);
      c.add(rdb1);  c.add(rdb2);  c.add(gBox);
   }
   // 實作事件處理方法
   public void itemStateChanged(ItemEvent evt) {
      if (evt.getSource() == gBox)
         if (evt.getStateChange() == ItemEvent.SELECTED)
            c.setBackground(Color.green);
         else  c.setBackground(Color.white);
      if (evt.getSource() == rdb1)
         c.setBackground(Color.red);
      if (evt.getSource() == rdb2)
         c.setBackground(Color.blue);
      repaint();  // 重繪
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch13_5_2 app = new Ch13_5_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}