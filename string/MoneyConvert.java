public class MoneyConvert{

	private static final char[] datas = new char[]{'��','Ҽ','��','��','��','��','½','��','��','��'};
	private static final char[] units = new char[]{'Ԫ','ʰ','��','Ǫ','��','ʰ','��','Ǫ','��'};

	public static void main(String[] args){
		System.out.println(convert(137510395));
	}

	public static String convert(int money){
		StringBuffer sbf = new StringBuffer();
		int unit = 0;
		while(money != 0){
			sbf.insert(0, units[unit++]);
			int number = money%10;
			sbf.insert(0, datas[number]);
			money /= 10;
		}

		//String str = sbf.toString();
		return sbf.toString().replaceAll("��[ʰ��Ǫ]", "��").replaceAll("��+��", "��").replaceAll("��+Ԫ", "Ԫ").replaceAll("��+", "��");
	}
}