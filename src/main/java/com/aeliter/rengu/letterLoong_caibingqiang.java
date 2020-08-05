package com.aeliter.rengu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class letterLoong_caibingqiang {
	
	static int number = -1;

	public static int Di(List<String> list, String b, int index) {
		if (list.size() == 1 && list.get(0).equals(b)) {
			number = 1;
			return number;
		}
		list.remove(index);
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).substring(0, 1).equals(b.substring(1, 2))) {
				Di(list, list.get(i), i);
			}
			if (number == 1) {
				break;
			}
		}
		list.add(index, b);
		return number;

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			list.add(scan.nextLine());
		}
		for (int i = 0; i < 5; ++i) {
			Di(list, list.get(i), i);
		}
		System.out.println(number);

	}
}
