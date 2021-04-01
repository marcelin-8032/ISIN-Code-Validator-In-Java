
package fr.isin.code.main;

import fr.isin.code.call.IsinCall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {


    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);//number of Thread

        List<Future<Boolean>> futureList = new ArrayList<>();

        Scanner inputIsin = new Scanner(System.in);

        System.out.println("Enter your ISIN Code here:");

        String isin ="";
        isin = inputIsin.nextLine();

        IsinCall myCall = new IsinCall(isin);
        Future<Boolean> result = executor.submit(myCall);
        futureList.add(result);

        String s1 = " is Valid";
        String s2 = " is Not Valid";

        for (Future<Boolean> sFuture : futureList) {
            try {
                if (sFuture.get()) {
                    System.out.println("Your ISIN code: " + isin + s1);
                } else
                    System.out.println("Your ISIN code: " + isin + s2);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}

