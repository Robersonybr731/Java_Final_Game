/* �{���d��: Ch13_2_1.java */
class MyInt {   // MyInt���O�ŧi
   public int value;
   public MyInt(int v) { value = v; }
   public void show() {
      System.out.println(value);
   }
}
interface IValue {  // IValue�����ŧi
  int value();
}
// �D���O
public class Ch13_2_1 {
   // �D�{��
   public static void main(String[] args) {
      // �~�Ӳ{�s���O�ӫإ߰ΦW���h���O
      MyInt myInt = new MyInt(100) {
         public void show() {
            System.out.println("��ƭȡG " + value);
         }
      };
      myInt.show();
      // ��@�����ӫإ߰ΦW���h���O
      IValue iValue = new IValue() {
         public int value() {
            return 50;
         }
      };
      System.out.println("�Ǧ^�ȡG " + iValue.value());
   }
}