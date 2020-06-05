/* �{���d��: Ch13_3_2.java */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// �~��JFrame���O
public class Ch13_3_2 extends JFrame {
   private boolean isDragging;// �O�_�O��Ԫ��A
   private int x, y;          // �ثe�y��
   private int prevX, prevY;  // �e�@�I�y��
   public Ch13_3_2() {  // �غc�l
      super ("�ƹ���Ԩƥ�d��");
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      c.setBackground(Color.white);
      addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent evt) {
            // �ثe�O�_�O��Ԫ��A
            if ( isDragging == true) return;
            isDragging = true;  // �i�J��Ԫ��A
            // ���s�p��y��
            x = evt.getX();  y = evt.getY();
            prevX = x;       prevY = y;
         }
         public void mouseReleased(MouseEvent evt) {
            isDragging = false;  // ���}��Ԫ��A
         } });
      addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseDragged(MouseEvent evt) {
            // �ثe���O��Ԫ��A
            if ( isDragging == false ) return;
            int tempX = evt.getX(), tempY = evt.getY();
            Graphics g = getGraphics();
            g.setColor(Color.blue);   // ø�X�Žu
            g.drawLine(prevX, prevY, tempX, tempY);
            prevX = tempX;  prevY = tempY; // �O�d�y��
         } });
   }
   // �D�{��
   public static void main(String[] args) {
      // �إ�Swing���ε{��
      Ch13_3_2 app = new Ch13_3_2();
      app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      app.setSize(300,200);  // �]�w�����ؤo
      app.setVisible(true);  // ��ܵ���
   }
}