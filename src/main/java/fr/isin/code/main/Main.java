
package fr.isin.code.main;

import fr.isin.code.call.IsinCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {


    public static void main(String[] args) throws IOException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);//number of Thread

        List<Future<String>> futureList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your ISIN Code here:");

        String isin = reader.readLine();
        reader.close();

        IsinCall myCall = new IsinCall(isin);
        Future<String> result = executor.submit(myCall);
        futureList.add(result);

        for (Future<String> sFuture : futureList) {
            try {
                System.out.println(isin + " : " + sFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}

