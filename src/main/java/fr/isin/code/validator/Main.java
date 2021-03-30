package fr.isin.code.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {


    public static void main(String[] args) {


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);//number of Thread

        List<Future<String>> futureList = new ArrayList<>();

        Random randomGenerator = new Random(System.currentTimeMillis());

        for (int i = 0; i < 3; i++) {//number of certificate update
            int intNumbers = randomGenerator.nextInt(123456789);
            String twoAlphbet = randomGenerator.ints(65, 90)
                    .limit(2).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            String number = twoAlphbet + intNumbers;
            System.out.println("Random number is : " + number);

            IsinCall myCall = new IsinCall(number);
            Future<String> result = executor.submit(myCall);
            futureList.add(result);
        }

        for (Future<String> stringFuture : futureList) {
            try {
                System.out.println("Certificate updates: " + stringFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}



