package com.aeliter.rengu;

public class letterLoong_caibingqian {

	public static String Loong(String inputStr) {

		String[] str = inputStr.split(" ");
		inputStr = "";
		inputStr = str[0];
		for (int i = 0; i < str.length - 1; i++) {
			for (String string : str) {
				if (string.substring(0, 1) == inputStr.substring(inputStr.length() - 1, 1)) {
					inputStr = inputStr + "	" + string;
					break;
				}
			}
		}
		return inputStr;
		
		/*List<String> list = new ArrayList<>();
		list.add(inputStr);
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).substring(0, 1).equals(inputStr)) {
				
			}
		}
		
		System.out.println(list);
		
		return null;*/

	}

	public static void main(String[] args) {
		Loong("arachnid aloha dog rat tiger gopher");
	}

}
