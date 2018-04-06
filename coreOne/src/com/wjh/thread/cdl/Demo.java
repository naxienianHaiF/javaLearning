package com.wjh.thread.cdl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WJH on 2018年04月06日 21:04
 * 读取a.txt文件中的数据，按照每一行来计算和，最后求总和
 */
public class Demo {

    private int[] lines = null;
    private int[] result = null;

    public Demo(int count){
        lines = new int[count];
        result = new int[count];
    }

    public void calc(String line, int index){
        String[] nums = line.split(",");
        int total = 0;
        for (String str: nums){
            total += Integer.parseInt(str);
        }
        System.out.println(Thread.currentThread().getName() + "" +
                " 线程开始计算第 "+ index +" 行的和... " + line + " 结果 = " +total);
        result[index] = total;
    }

    public void sum(){
        int total = 0;
        for (int i=0; i<result.length; i++){
            total += result[i];
        }
        System.out.println("计算后的最终结果是："+total);
    }

    public static void main(String[] args) {
        List<String> list = readFile();
        Demo d = new Demo(list.size());

        for (int i=0; i<list.size(); i++){
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    d.calc(list.get(j), j);
                }
            }).start();
        }

//        while (Thread.activeCount() > 1){
//        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.sum();
    }

    private static List<String> readFile() {
        List<String> result = new ArrayList<>();
        BufferedReader br = null;
        try {
             br = new BufferedReader(new FileReader("E:\\software\\IntelliJ\\program\\javaLearning\\coreOne\\src\\com\\wjh\\thread\\cdl\\a.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = null;
        try {
            while ((line = br.readLine()) != null){
                result.add(line);
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
