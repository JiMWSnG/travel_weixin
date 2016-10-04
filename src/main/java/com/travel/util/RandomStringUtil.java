package com.travel.util;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

/**
 * Created by Jim Wang on 2016/8/5.
 */
public class RandomStringUtil {

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(52);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String getRandomString2(int length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(3);
            long result=0;
            switch(number){
                case 0:
                    result=Math.round(Math.random()*25+65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }

        }
        return sb.toString();
    }
    public static String getRandomString3(int length){

       return  RandomStringUtils.randomAlphanumeric(length);
    }

    public  static void main(String args[]){
        System.out.println(getRandomString2(11));
        System.out.println(getRandomString(11));
        System.out.println(getRandomString3(11));
    }
}
