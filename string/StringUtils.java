public class StringUtils {
	public static void main (String[] args){
		String str = "we are happy!";
		replaceBlank(str);
	}

	/**
	 *  ���⣺��һ���ַ����еĿո��滻�ɡ�%20��
	 *  �㷨����������ʽ���
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