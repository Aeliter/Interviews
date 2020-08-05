package com.aeliter.xiaomi;

import java.util.Scanner;

/*public class LeastSell {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	}

}*/

public class Main {


/*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
******************************开始写代码******************************/
    static int solution(int[] prices, int budget) {
    	
    	int i = 0;
    	int sum = 0;
     	if (budget < prices[i]) {
			return i;
		}
    	
		for (i = 0; i < prices.length - 1; i++) {
			
			sum = prices[i] + prices[i + 1];
			System.out.println(sum);
			if (budget < sum) {
				return i;
			}
			
		}
		
		return i + 1;


    }
/******************************结束写代码******************************/


    @SuppressWarnings("resource")
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        
        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }
        
        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());
        
        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));    

    }
}

