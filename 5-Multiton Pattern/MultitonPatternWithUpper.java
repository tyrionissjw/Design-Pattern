public class MultitonPatternWithUpper {
   private static MultitonPatternWithUpper instance1 = new MultitonPatternWithUpper();
   private static MultitonPatternWithUpper instance2= new MultitonPatternWithUpper();
   private static MultitonPatternWithUpper instance3= new MultitonPatternWithUpper();
   
   private MultitonPatternWithUpper() {
   }
   
   public static MultitonPatternWithUpper getInstance(int which) {
        if (which ==1) {
		    return instance1;
		} if (which ==2) {
		    return instance2;
		} if (which ==3) {
		    return instance3;
		} else {
		    throw new IllegalArgumentException("²ÎÊý´íÎó");
		}		
   }
}