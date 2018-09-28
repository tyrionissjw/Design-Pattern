public class SingeltonIodh {	
	private SingeltonIodh() {
	}
	
	static class SingeltonIodhHodler {
		static SingeltonIodh instance = new SingeltonIodh();
	}
	
	// 保证在调用getInstance时才初始化
	public static SingeltonIodh getInstance() {
		return SingeltonIodhHodler.instance;
	}
}