//package com.aeliter.xiaodupi;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
///**
// * @description:
// * @author: caibingqiang
// * @date: 2020-06-05 14:29
// * @version: V1.0
// */
//public class BargainCommonUtils {
//
//    private static final Logger logger = LoggerFactory.getLogger(BargainCommonUtils.class);
//
//    /**
//     * 砍价算法优化，避免死循环和空指针
//     * 为避免价格生成出错，要求：count<=100;price/count>=0.08
//     * @param count
//     * @param price
//     * @param finalPrice
//     * @return
//     */
//    public static List<BigDecimal> getBargainList(Integer count, BigDecimal price, BigDecimal finalPrice) {
//        List<BigDecimal> list = new BargainCommonUtils().getTempBargainList(count, price, finalPrice);
//        int i = 0;
//        while (list == null || list.size() == 0 || list.size() != count) {
//            list = new BargainCommonUtils().getTempBargainList(count, price, finalPrice);
//            i++;
//            if (i > 50000) {
//                logger.info("砍价集合生成超时！请重试或重新设定价格/次数比例！");
//                break;
//            }
//        }
//        return list;
//    }
//
//    /**
//     * 获取砍价的价格集合
//     * @param count
//     * @param price
//     * @param finalPrice
//     * @return
//     */
//    public static  List<BigDecimal> getTempBargainList(Integer count, BigDecimal price, BigDecimal finalPrice) {
//
//        BigDecimal sourcePrice = price;
//        sourcePrice = sourcePrice.subtract(finalPrice);    // 实际要折扣掉的金额
//        sourcePrice = sourcePrice.setScale(2, RoundingMode.HALF_DOWN);// 把多余的小数点去掉
//        ArrayList<BigDecimal> tempPrices = new ArrayList<>();//		实际被砍掉的价格集合
//        Map<String, BigDecimal> lastPrice = new HashMap<>();//		 最后一次的砍价剩余的价格
//        int sum = 0;// 实际砍价次数
//        ArrayList<BigDecimal> finalPrices = new ArrayList<>();    // 最终所需要的砍价集合
//
//        finalPrice = new BigDecimal(0);
//
//        BigDecimal divisor = new BigDecimal(count);
////		获取砍价的平均值
//        int countTmep = 2;
//        getPirces(sourcePrice, countTmep, tempPrices, finalPrice, lastPrice);
//
//        tempPrices.add(lastPrice.get("lastPrice"));
//
//        sum = tempPrices.size();
//
//        if (sum > count) {    // 如果实际砍价次数大于预期次数，则再进行处理
//            int temp = sum - count;// 相差次数
//
//            BigDecimal sumPrice = new BigDecimal(0.00);
//
//            for (int i = 0; i < tempPrices.size(); i++) {
//                if (i < tempPrices.size() - temp) {
//                    finalPrices.add(tempPrices.get(i));
//                } else {
//                    sumPrice = sumPrice.add(tempPrices.get(i));    // 多余的砍价
//                }
//            }
////			把多余的砍价平均分散到前count中的砍价
//            BigDecimal divide = null;
//            try {
//                divide = sumPrice.divide(new BigDecimal(count), 2, RoundingMode.HALF_DOWN);
//            } catch (Exception e) {
//                logger.warn(e.getMessage());
//                e.printStackTrace();
//            }
//            divide = divide.setScale(2, RoundingMode.HALF_DOWN);
//
//            for (int i = 0; i < finalPrices.size(); i++) {
//                BigDecimal add = finalPrices.get(i).add(divide);
//                finalPrices.set(i, add);
//            }
//        } else if (sum == count) {
//            finalPrices = tempPrices;
//        } else {
//            return null;
//        }
//
//
////		价格矫正 补总差价，多减少增
//        BigDecimal totalPrice = new BigDecimal(0);
//        for (BigDecimal bd : finalPrices) {
//            totalPrice = bd.add(totalPrice);
//        }
//        logger.info("价格矫正前的totalPrice:" + totalPrice);
////		如果集合中的总价大于实际原价，则把集合中任意一个大于这个差价的价格减去差价（误差都不会超过0.1）
//        int inFlag = 0;
//        if (totalPrice.compareTo(sourcePrice) > 0) {
//            BigDecimal subtract = totalPrice.subtract(sourcePrice);
//
//            for (int i = 0; i < finalPrices.size(); i++) {
//                if (finalPrices.get(i).compareTo(subtract) > 0) {    // 集合中的大于这个差价的价格
//                    BigDecimal changedPrice = finalPrices.get(i).subtract(subtract);
//                    finalPrices.set(i, changedPrice);
//                    inFlag = 1;
//                    break;
//                }
//            }
//        }
//        if (totalPrice.compareTo(sourcePrice) < 0) {    // 如果集合中的总价小于等于实际原价，则把集合中最后一个价格加上差价（误差都不会超过0.1）
//            BigDecimal subtract = sourcePrice.subtract(totalPrice);
//            BigDecimal sourceLastPrice = finalPrices.get(finalPrices.size() - 1);
//            BigDecimal changedPrice = sourceLastPrice.add(subtract);
//            finalPrices.set(finalPrices.size() - 1, changedPrice);
//            inFlag = 1;
//        }
//        if (totalPrice.compareTo(sourcePrice) == 0) {
//            inFlag = 1;
//        }
//
//
//        if (inFlag == 0) {    // 如果没有价格大于这个差价，则再完整的调一次本方法
//            return null;
//        } else {
//            logger.info("sourcePrice:" + sourcePrice);
//            logger.info("*********************************");
//            totalPrice = new BigDecimal(0);
//            for (BigDecimal bd : finalPrices) {
//                totalPrice = bd.add(totalPrice);
//            }
//            logger.info("预期砍价次数：" + count + " 实际砍价次数：" + finalPrices.size() + " 价格矫正后的totalPrice:" + totalPrice);
//            logger.info(Arrays.toString(finalPrices.toArray()));
//
//            return finalPrices;
//        }
//    }
//
//
//    /**
//     *
//     * <br/>2018年6月4日 下午3:19:07
//     * <br/>version 1.0
//     * <br/>@author lwf
//     * <br/>@param sourcePrice
//     * <br/>@param
//     * <br/>@param tempPrices
//     * <br/>@param finalPrice
//     */
//    /**
//     * 获取被砍的价格集合
//     * avgPrice	砍价平均值：	原价/砍价次数=砍价平均值
//     * @param sourcePrice 原价
//     * @param countTemp
//     * @param tempPrices 砍价价格集合
//     * @param finalPrice 最终价
//     * @param lastPrice
//     *
//     */
//    public static  void getPirces(BigDecimal sourcePrice, int countTemp, List<BigDecimal> tempPrices, BigDecimal finalPrice, Map<String, BigDecimal> lastPrice) {
//        Random r = new Random();
//        double d = sourcePrice.divide(new BigDecimal(++countTemp), 2, RoundingMode.HALF_DOWN).doubleValue();
//        if (tempPrices.size() > 0 && tempPrices.size() % 4 == 0) {
//            countTemp = countTemp - 3;
//        }
//
//        Double randomPrice = r.nextDouble() * d + 0.01;    // 例如：生成0到9.99之间的随机数
//
//        BigDecimal bargainPrice = new BigDecimal(randomPrice); // 被砍掉的价格
//
//        bargainPrice = bargainPrice.setScale(2, RoundingMode.HALF_DOWN);
//
//        BigDecimal surplusPrice = sourcePrice.subtract(bargainPrice);    // 剩余价格
//
//        if (surplusPrice.compareTo(finalPrice) <= 0) {
//            return;
//        }
//
//        tempPrices.add(bargainPrice);
//        lastPrice.put("lastPrice", surplusPrice);
//        getPirces(surplusPrice, countTemp, tempPrices, finalPrice, lastPrice);
//
//    }
//
//    /*	@Test
//        public void testBargain() {
//            int count = 100;
//            BigDecimal price = new BigDecimal(7);
//            BigDecimal finalPrice = new BigDecimal(0);
//            List<BigDecimal> list = new BargainCommonServiceImpl().getTempBargainList(count, price, finalPrice);
//            int i = 0;
//            while(list==null || list.size()==0||list.size()!=count) {
//                list = new BargainCommonServiceImpl().getTempBargainList(count, price, finalPrice);
//                i ++;
//                if(i>50000) {
//                    logger.info("砍价集合生成超时！请重试或重新设定价格/次数比例！");
//                    System.out.println("砍价集合生成超时！请重试或重新设定价格/次数比例！");
//                    break;
//                }
//            }
//            System.out.println(i);
//        }*/
//    public static void main(String[] args) {
//        int count = 10;
//        BigDecimal price = BigDecimal.valueOf(7L);
//        BigDecimal finalPrice =BigDecimal.ZERO;
//        List<BigDecimal> list = BargainCommonUtils.getTempBargainList(count, price, finalPrice);
//        list.forEach(bigDecimal -> {
//            System.out.printf(bigDecimal.toString());
//        });
//    }
//
//}
