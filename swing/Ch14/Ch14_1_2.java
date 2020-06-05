/* 程式範例: Ch14_1_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch14_1_2 extends JFrame
                      implements ActionListener {
   private JRadioButtonMenuItem red, green, blue;
   private Container c;
   public Ch14_1_2() {    // 建構子
      super ("JMenuBar元件範例");
      c = getContentPane();
      c.setBackground(Color.white);
      JMenuBar jmb = new JMenuBar();
      setJMenuBar(jmb);  // 新增下拉式功能表
      JMenu file = new JMenu("檔案(F)"); // 第一個選單
      file.setMnemonic(KeyEvent.VK_F);
      JMenuItem item;
      file.add(item = new
               JMenuItem("新增(N)",KeyEvent.VK_N));
      item.addActionListener(this);
      file.add(item = new
               JMenuItem("開啟(O)",KeyEvent.VK_O));
      item.addActionListener(this);
      JMenu setting = new JMenu("參數設定"); // 子選單
      setting.add(item = new JMenuItem("編碼"));
      item.addActionListener(this);
      setting.add(item = new JMenuItem("字型"));
      item.addActionListener(this);
      file.add(setting);    // 新增子選單
      file.addSeparator();  // 分隔線
      file.add(item = new
               JMenuItem("關閉(X)",KeyEvent.VK_X));
      item.addActionListener(this);
      jmb.add(file); // 新增file選單
      JMenu choice = new JMenu("選項(C)"); // 第二個選單
      choice.setMnemonic(KeyEvent.VK_C);
      JCheckBoxMenuItem check;
      check = new JCheckBoxMenuItem("切換");
      check.addActionListener(this);
      choice.add(check);
      ButtonGroup buttongroup = new ButtonGroup();
      red = new JRadioButtonMenuItem("紅色");
      choice.add(red);    buttongroup.add(red);
      red.addActionListener(this);
      green = new JRadioButtonMenuItem("綠色");
      choice.add(green);  buttongroup.add(green);
      green.addActionListener(this);
      blue = new JRadioButtonMenuItem("藍色");
      choice.add(blue);   buttongroup.add(blue);
      blue.addActionListener(this);
      jmb.add(choice);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
      if ( evt.getSource() == red )
         c.setBackground(Color.red);
      if ( evt.getSource() == green )
         c.setBackground(Color.green);
      if ( evt.getSource() == blue )
         c.setBackground(Color.blue);
      repaint();  // 重繪
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch14_1_2 app = new Ch14_1_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}