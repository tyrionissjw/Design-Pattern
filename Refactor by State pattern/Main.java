public class Main {
	 public static void main(String[] args) {
		 /* 
			 δ�ع�ǰ
			 �����ض�Employee������ص�ֵ��ͷ�����������Employee��
			 �ڵ���Ҫ���һ���µ�Employee����ʱ����Ҫ��һ�޸�doBusiness()���Ʒ����е�switch���
		 */
		 Employee e = new Employee(Employee.ENGINEER);
		 e.doBusiness();
		 /*
			 Replace Type Code With Subclasses
			 ���в��ɱ��typeCode����Ӱ������class(Employee)��Ϊ
			 �ڵ�switch/if-else�ĳ��֣���ʱ��Ҫʹ��Replace Conditional With Polymorphism�ع���
				 �������ع���ǰ�����ʹ�ñ�������ع�
             �۵�typecodeֵ�ڶ��󴴽���ı�����������Ѿ���subclassʱ���޷�ʹ�ñ����ع���Ӧ��ʹ��Replace Type Code With State/Strategy
             �ܽ�subclass��Ϊ����������࣬���ҽ��ض������йص���Ϊ�������ࡣ
			 ���ŵ㣺�Բ�ͬ��Ϊ���˽��class�û����Ƶ���class��������Ҫ�����µ���Ϊʱ��ֻ�����һ���µ�����
				 Ҳֻ��һ�����õ�switch���������������ֶ���
		 */
		 EmployeeRef1 ref1 = EmployeeRef1.create(EmployeeRef1.ENGINEER);		 
		 /*
			 Replace Type Code With State/Strategy
		 */
		 EmployeeRef2 e2 = new EmployeeRef2(EmployeeType.ENGINEER);
		 e2.pay();
		 /*
			 Replace Type Code With Polymorphism(������ǰ��)
			 1.���붯���йص���Ϊ����State����(EmployeeTypeRef3)����Ϊ���󷽷�����������ʵ��
				 ��Ҳ������Replace Type Code With State/Strategy������
		 */
		 EmployeeRef3 e3 = new EmployeeRef3(EmployeeTypeRef3.ENGINEER);
		 e3.pay();
	 }
}