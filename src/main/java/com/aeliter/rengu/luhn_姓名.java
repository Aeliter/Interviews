package com.aeliter.rengu;

public class luhn_姓名 {
	
	public static void main(String[] args) {
		System.out.println(checkBankCard("49927398716"));
	}
	
	public static boolean checkBankCard(String cardId) {
		
		String a = cardId.substring(0, cardId.length() - 1);
		
		if (a == null || a.trim().length() == 0)
			return false;
			
		char[] chs = a.trim().toCharArray();
		int sum = 0;
		for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
			int k = chs[i] - '0';
			if (j % 2 == 0) {
				k *= 2;
				k = k / 10 + k % 10;
			}
			sum += k;
		}
		return cardId.charAt(cardId.length() - 1) == ((sum % 10 == 0) ? '0' : (char) ((10 - sum % 10) + '0'));
	}
	
}
