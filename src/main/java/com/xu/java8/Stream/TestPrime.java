package com.xu.java8.Stream;



public class TestPrime {

    public static void main(String[] args) {
//        int[] retArr=getPrimeNumber(100);
//        for(int i=0;i<retArr.length;i++){
//            if(retArr[i] !=0){
//                System.out.println(retArr[i]);
//            }
//        }
//        System.out.println(getPrimeNumber(0));
    }

    public static int getPrimeNumber(int n){
        if(n <=1){
            return 3;
        }
         while (true){
            boolean isPrime = true;
            for(int j=2;j<n;j++){
                if(n%j==0){
                    isPrime = false;
                    break ;
                }
            }
            if(isPrime){
                break ;
            }
        }
        return n;
//        //质数为大于1的自然数, 故i从2开始
//        for(int i=2;i<n;i++){
//            //isPrime作为当前这个数是否为质数的标记位
//            boolean isPrime=true;
//            for(int j=2;j<i;j++){
//                if(i%j==0){
//                    isPrime=false;
//                    break;
//                }
//            }
//            if(isPrime){
//                priArr[i]=i;
//            }
//        }
//        return priArr;
    }

  
}
