package com.aeliter.hainengda;

import java.util.ArrayList;

public class ShuiXianHua {
	
	/*static int ge, shi, bai;
	
	public void f(int sum){
        bai = sum / 100;
        shi = (sum % 100) / 10;
        ge = (sum % 100) % 10;
        if(bai * bai * bai + shi * shi * shi + ge * ge * ge == sum){
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {

        for (int num = 101; num < 1000; num++) {
        	ShuiXianHua sxh = new ShuiXianHua();
        	sxh.f(num);
        }
    }*/
	public ArrayList<Integer> getSXHS() {
		// TODO Auto-generated method stub
		ArrayList<Integer> sxhs = new ArrayList<Integer>();
		for(int i = 100; i <= 999; i++){
			int i1 = i / 100;
			int temp = i % 100;
			int i2 = temp / 10;
			int i3 = temp % 10;
			int iresult = (int) (Math.pow(i1, 3) + Math.pow(i2, 3) + Math.pow(i3, 3));
			if(i == iresult) {
				sxhs.add(new Integer(i));
			}
		}
		return sxhs;
	}
	
	public static void main(String[] args) {
		for (int num = 101; num < 1000; num++) {
        	ShuiXianHua sxhs = new ShuiXianHua();
        	sxhs.getSXHS();
        }
	}
    
}
