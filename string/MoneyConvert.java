public class MoneyConvert{

	private static final char[] datas = new char[]{'Áã','Ò¼','·¡','Èş','ËÁ','Îé','Â½','Æâ','°Æ','¾Á'};
	private static final char[] units = new char[]{'Ôª','Ê°','°Û','Çª','Íò','Ê°','°Û','Çª','ÒÚ'};

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
		return sbf.toString().replaceAll("Áã[Ê°°ÛÇª]", "Áã").replaceAll("Áã+Íò", "Íò").replaceAll("Áã+Ôª", "Ôª").replaceAll("Áã+", "Áã");
	}
}