public class SingeltonIodh {	
	private SingeltonIodh() {
	}
	
	static class SingeltonIodhHodler {
		static SingeltonIodh instance = new SingeltonIodh();
	}
	
	// ��֤�ڵ���getInstanceʱ�ų�ʼ��
	public static SingeltonIodh getInstance() {
		return SingeltonIodhHodler.instance;
	}
}