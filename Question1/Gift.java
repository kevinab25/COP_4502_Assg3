public class Gift {
	
	private static int assignTag = 0; 
	private int giftTag = 0;

	public Gift() {
		assignTag++;
		giftTag = assignTag;
	}
	
	public int getTag() {
		return giftTag;
	}

}
