/*
	 1.SpringCallBack�е�doPrimary��Ϊ��ͳģ�巽���Ļ�������,SpringTemplate��execute��Ϊ��ͳģ�巽����ģ�巽��
	 2.ͨ���ص��ķ�ʽ���Ϳ���ͨ��ֻ�����ҵ����(load1��)ʵ�ִ�ͳģ�巽��ģʽ������ʵ�ֵĹ���
	 3.������spring�������ڼ̳е�˼��
	 4.���÷�Χ��
		 1.Springģ�巽��������ģ������Ҫ�ж������ʵ�ֲ�ͬ��������ʱ��������һ��������ͨ���̳�һ������ʵ�֡���springģ�巽��ͨ��ʵ��ĳЩcallback
		 �Ϳ����ɶ���Template
		 2.�����ģ�巽�����ģʽ���������ÿ������Ĳ��趼��Ҫ����ȥ����ʵ���ж�����巽���������Ǽ򵥵ĸı����������ĳ�������ok�Ļ���
		 ʹ��Callback����ȥ���ƣ���Ϊ�������Ҫ���ݶ��Callback��Ϊ�����������û�ȥʵ�֣�ʹ��Java���ڲ��౾������һ���Ƚϳ�ª���﷨�����ο������Ƕ��
*/
public class Main {
	 public static void main(String[] args) {
		 SpringTemplate template = new SpringTemplate();
		 template.load1("TEST",1);
	 }
}