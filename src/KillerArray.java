/*В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по
кругу вычеркивается каждый второй человек, пока не останется один. Соста-
вить две программы, моделирующие процесс. Одна из программ должна ис-
пользовать класс ArrayList, а вторая – LinkedList. Проанализируйте, какая из
двух программ работает быстрее? Почему?*/


import java.util.ArrayList;
import java.util.Scanner;

public class KillerArray {

    public static void main(String[] args){

        ArrayList arraylist = new ArrayList();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество людей:");
        int n = in.nextInt();
        long m = System.currentTimeMillis();
        for(int i = 1; i <= n;i++){
            arraylist.add(i);
        }
        kill(arraylist);
        for(int i = 0; i < arraylist.size();i++){
            System.out.println(arraylist.get(i) + "");
        }
        System.out.println((double) (System.currentTimeMillis() - m)/1000);
    }

    public static ArrayList kill(ArrayList arraylist){

        if(arraylist.size() < 2){
            return arraylist;
        }

        for(int i = 0;i < arraylist.size();i++){
            if(i+1 < arraylist.size()) {
                arraylist.remove(i + 1);
            }
        }


        return kill(arraylist);
    }
}