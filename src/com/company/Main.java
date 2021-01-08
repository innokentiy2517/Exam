package com.company;

import com.sun.org.apache.bcel.internal.generic.FNEG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Первый вопрос
 */
class Student implements AutoCloseable{
    private String name;
    private int age;
    public Student (String name,int age){
        setName(name);
        setAge(age);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Deleted object:\t"+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getInfo(){
        String studentInfo = toString();
        System.out.println(studentInfo);
    }

    @Override
    public String toString(){
        return String.format("Name:\t"+name+"\nAge:\t"+age);
    }
}

/**
 *Второй вопрос
 */
class Result {
    public int firstR;
    public int secondR;
    public Result (int firstR, int secondR){
        this.firstR = firstR;
        this.secondR = secondR;
    }
}

/**
 * Четвёртый вопрос
 */
interface CountSum{
    public Integer apply(Integer v);
}

/**
 * Шестой и седьмой вопросы
 */
interface Fn{
    int get();
}
class Var implements Fn{
    int value;

    public Var(int value){
        this.value = value;
    }

    @Override
    public int get() {
        return value;
    }

    void set (int value){
        this.value = value;
    }
}

public class Main {
    /**
     * Второй вопрос
     * @return
     */
    public static Result getTwoResults(){
        int first = 1+1;
        int second = 2+2;
        return new Result(first,second);
    }

    /**
     * Третий вопрос
     * @param list - Список объектов, поступающий на вход функции printList
     * @param func - Функция, применяемая к list.
     * Function<T,R> - T - Оперируемый аргумент
     *                 R - Выходной аргумент
     */
    public static void printListFirst(ArrayList<Integer> list, Function<Integer,Integer> func){
        for (int v :
                list) {
            int c = func.apply(v);
            System.out.println(c);
        }
    }

    /**
     * Четвёртый вопрос
     */
    public static void printListSecond(ArrayList<Integer> list, CountSum func){
        for (int v :
                list) {
            int c = func.apply(v);
            System.out.println(c);
        }
    }

    /**
     * Шестой и седьмой вопросы
     */
    public static Fn add(Fn x1, Fn x2){
        return () -> x1.get() + x2.get();
    }

    public static void main(String[] args) {
        /**
         * Первый вопрос
        try (Student student1 = new Student("Innokentiy", 21); Student student2 = new Student("Alex",20)){
            student1.getInfo();
            student2.getInfo();
        } catch (Exception e){
            e.printStackTrace();
        }*/
        /**
         *  Второй вопрос
         System.out.println("First result:\t" + getTwoResults().firstR
                          + "\nSecond result:\t" + getTwoResults().secondR);
         */
        /**
         * Третий вопрос
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        printList(list, x -> x * x);
         */
        /**
         * Четвёртый вопрос
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        printListSecond(list, x -> x + x);
         */
        /**
         * Шестой и седьмой вопросы
        Fn x1 = new Var(2);
        Fn x2 = new Var(2);
        Fn c = add(x1,x2);
        System.out.println(c.get());
         */
        /**
         * Восьмой вопрос
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,5,54,48,9,2,3,1,48,6));
        Optional<Integer> min = list.stream().min(((x1,x2) -> x1<x2?-1:x1>x2?1:0));
        if (min.isPresent()){
            System.out.println(min.get());
        }
        Optional<Integer> max = list.stream().max(((x1,x2) -> x1>x2?1:x1<x2?-1:0));
        if (max.isPresent()){
            System.out.println(max.get());
        }
         */
    }
}
