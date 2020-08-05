package com.aeliter.qianxin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author 10473
 * 
 * N个人排成一队，从1到5轮流报数，报5的人是幸运者，出列。
 * 报到队尾后，从队首接着报。依此循环。
 * 问：排在队尾的人是第几名幸运者？
 * 注： N为小于100000的正整数。
 * 
 * 例：
 * 1人排成一队，他就是第1名幸运者。
 * 3人排成一队，队尾是第2名幸运者。
 * 5人排成一队，队尾是第1名幸运者。
 * 8人排成一队，队尾是第3名幸运者
 * 即求：N人排成一队，队尾是第多少名幸运者？
 * 
 * 输入    队伍总人数
 * 输出    队尾者的幸运编号
 * 样例输入    20
 * 样例输出    4
 * 
 */
public class PaiDui {
	
	/*public static void main(String args[]) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1 ; i <= 100; i++){//将原来的号存入list
            list.add(i);
        }
        getItem(list,1);
    }*/
	
    public static int getItem(List<Integer> list, int index){
        List<Integer> tempList = new ArrayList<Integer>();//声明另外一个list集合，存放遍历后的人
        if(list.size()==1){//若集合大小为1，则是最后一人
            System.out.println("剩余的一个人是原来的第" + list.get(0) + "位");
            return 1;
        }
        for(int i = 0 ; i < list.size() ; i++){//遍历集合
            if((index++) % 3!=0){
                tempList.add(list.get(i));//报号不为3的，添加进另一个集合
            }
        }
        return getItem(tempList,index%3);
    }
    
    @SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;
        for(int i = 1 ; i <= 100; i++){//将原来的号存入list
            list.add(i);
        }
        getItem(list,1);
            
        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }
  
        res = getItem(list, index);
        System.out.println(String.valueOf(res));    

    }

}
