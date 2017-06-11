package javatest.rmbnumtocn;

/**
 * @author youhuan
 * @date 创建时间：2017年5月18日 下午5:43:36
 * @describe:
 * @version 1.0
 */
public class Rmbnumtocn {

	public static void main(String[] args) {
		String rmbnumtocn = rmbnumtocn(432554737);
		System.out.println(rmbnumtocn);
	}

	public static String rmbnumtocn(Integer num) {
		String newstring = "";
		String string = num.toString();
		char[] charArray = string.toCharArray();
		char[] rmbcn = new char[] { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
		String[] rmbcndw = new String[] { "", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万" };
		for (int i = 0; i < charArray.length; i++) {
			newstring += rmbcn[Integer.parseInt((charArray[i] + ""))];
			if (Integer.parseInt((charArray[i] + "")) != 0) {
				newstring += rmbcndw[Integer.parseInt(charArray.length - i - 1 + "")];
			}
		}
		newstring += "元整";
		 while (newstring.contains("零零")) {
			 newstring = newstring.replace("零零", "零");
		 }
		 while (newstring.contains("零元")) {
			 newstring = newstring.replace("零元", "元");
		 }
		 
		return newstring;
	}
}
