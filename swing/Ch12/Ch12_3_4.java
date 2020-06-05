/* 程式範例: Ch12_3_4.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 繼承JFrame類別, 實作ActionListener介面
public class Ch12_3_4 extends JFrame
                      implements ActionListener {
   private JList<String> nList, cList;
   private JLabel lbl;
   public Ch12_3_4() {  // 建構子
      super("JList元件範例");
      String[] names = {"陳會安", "江小魚",
                        "小龍女", "陳允傑"};
      String[] items = {"程式語言", "計算機概論",
                        "資料庫系統", "網頁設計"};
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      nList = new JList<>(names);  // 建立單選的JList元件
      nList.setVisibleRowCount(1); // 顯示1個選項
      nList.setSelectionMode(
               ListSelectionModel.SINGLE_SELECTION);
      JScrollPane scroll1 = new JScrollPane(nList);
      cList = new JList<>(items);  // 複選的JList元件
      cList.setVisibleRowCount(3); // 顯示3個選項
      JScrollPane scroll2 = new JScrollPane(cList);
      JButton btn1 = new JButton("選擇");
      btn1.addActionListener(this); // 註冊事件處理
      lbl = new JLabel("選擇結果");
      c.add(scroll1);  c.add(scroll2);
      c.add(btn1);     c.add(lbl);
   }
   // 實作事件處理方法
   public void actionPerformed(ActionEvent evt) {
       String str = "";
       if ( nList.getSelectedIndex() != -1 ) // 處理單選
          str = nList.getSelectedValue();
       if ( !cList.isSelectionEmpty() ) { // 處理複選
          str = "";
          for (String item:cList.getSelectedValuesList())
             str = str + item + " ";
       }
       lbl.setText(str);  // 顯示選擇的選項
   }
   // 主程式
   public static void main(String[] args) {
      // 建立Swing應用程式
      Ch12_3_4 app = new Ch12_3_4();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,150);  // 設定視窗尺寸
      app.setVisible(true);  // 顯示視窗
   }
}