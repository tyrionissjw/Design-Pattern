public class ConcreateProduct3  implements Product {
   public ConcreateProduct3() {
   }
   //�򵥹�������:��������λ�ھ����Ʒ
   public static Product factory() {
      return new ConcreateProduct3();   
   }
   public void business() {
     System.out.println("��ҵ����3����");
   }
}