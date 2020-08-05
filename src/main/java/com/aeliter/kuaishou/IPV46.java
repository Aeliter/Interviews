package com.aeliter.kuaishou;

import java.util.Scanner;

public class IPV46 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String IP = sc.nextByte(sc);
//        validIPAddressAll(IP);
	}

	/**
	 * 判断所有的IP地址
	 * 
	 * @param IP
	 * @return
	 */
	public static String validIPAddressAll(String IP) {

		if (!IP.contains(".") && !IP.contains(":")) {
			return "Neither";
		}
		// 如果是IPV4
		if (IP.contains(".")) {
			if (IP.endsWith(".")) {
				return "Neither";
			}
			String[] arr = IP.split("\\.");
			if (arr.length != 4) {
				return "Neither";
			}

			for (int i = 0; i < 4; i++) {
				if (arr[i].length() == 0 || arr[i].length() > 3) {
					return "Neither";
				}
				for (int j = 0; j < arr[i].length(); j++) {
					if (arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9') {
						continue;
					}
					return "Neither";
				}
				if (Integer.valueOf(arr[i]) > 255 || (arr[i].length() >= 2 && String.valueOf(arr[i]).startsWith("0"))) {
					return "Neither";
				}
			}
			return "IPv4";
		} // 如果是IPV4

		// 如果是IPV6
		if (IP.contains(":")) {
			if (IP.endsWith(":") && !IP.endsWith("::")) {
				return "Neither";
			}
			// 如果包含多个“::”，一个IPv6地址中只能出现一个“::”
			if (IP.indexOf("::") != -1 && IP.indexOf("::", IP.indexOf("::") + 2) != -1) {
				return "Neither";
			}

			// 如果含有一个“::”
			if (IP.contains("::")) {
				String[] arr = IP.split(":");
				if (arr.length > 7 || arr.length < 1) {// "1::"是最短的字符串
					return "Neither";
				}
				for (int i = 0; i < arr.length; i++) {
					if (arr[i].equals("")) {
						continue;
					}
					if (arr[i].length() > 4) {
						return "Neither";
					}
					for (int j = 0; j < arr[i].length(); j++) {
						if ((arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9')
								|| (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'F')
								|| (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'f')) {
							continue;
						}
						return "Neither";
					}
				}
				return "IPv6";
			}

			// 如果不含有“::”
			if (!IP.contains("::")) {
				String[] arr = IP.split(":");
				if (arr.length != 8) {
					return "Neither";
				}
				for (int i = 0; i < arr.length; i++) {
					if (arr[i].length() > 4) {
						return "Neither";
					}
					for (int j = 0; j < arr[i].length(); j++) {
						if ((arr[i].charAt(j) >= '0' && arr[i].charAt(j) <= '9')
								|| (arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'F')
								|| (arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'f')) {
							continue;
						}
						return "Neither";
					}
				}
				return "IPv6";
			}
		} // 如果是IPV6
		return "Neither";
	}

}
