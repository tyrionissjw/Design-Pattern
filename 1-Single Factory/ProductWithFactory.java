public abstract class ProductWithFactory {
     public abstract void business();
	 //�򵥹�������:��������λ�ڳ����Ʒ
	 public static ProductWithFactory factory() {
	    return new ConcreateProduct1();
	 }
}