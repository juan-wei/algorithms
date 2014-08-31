public class StringUtils {
	public static void main (String[] args){
		String str = "we are happy!";
		replaceBlank(str);
	}

	/**
	 *  问题：将一个字符串中的空格替换成“%20”
	 *  算法：用正则表达式完成
	 * @param string 
	 */
	public static void replaceBlank(String string){
		if (string == null) {
			return;
		}
		String str = string.replaceAll("\\s", "%20");
		System.out.println("before:"+string+"\nafter:"+str);
	}
}