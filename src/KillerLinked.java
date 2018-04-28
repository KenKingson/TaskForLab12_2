/*В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по
кругу вычеркивается каждый второй человек, пока не останется один. Соста-
вить две программы, моделирующие процесс. Одна из программ должна ис-
пользовать класс ArrayList, а вторая – LinkedList. Проанализируйте, какая из
двух программ работает быстрее? Почему?*/

/*ArrayList следует использовать, когда в приоритете доступ по индексу,
так как эти операции выполняются за константное время.
Добавление в конец списка в среднем тоже выполняется за константное время.
Кроме того в ArrayList нет дополнительных расходов на хранение связки между элементами.
 Минусы в скорости вставки/удаления элементов находящихся не в конце списка,
 так как при этой операции все элементы правее добавляемого/удаляемого сдвигаются.


LinkedList удобен когда важнее быстродействие операций вставки/удаления,
которые в LinkedList выполняются за константное время.
Операции доступа по индексу производятся перебором с начала или конца (смотря что ближе) до нужного элемента.
Дополнительные затраты на хранение связки между элементами.
*/
import java.util.LinkedList;
import java.util.Scanner;

public class KillerLinked{

    public static void main(String[] args){

        
        LinkedList linkedlist = new LinkedList();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество людей:");
        int n = in.nextInt();
        long m = System.currentTimeMillis();
        for(int i = 1; i <= n;i++){
            linkedlist.add(i);
        }

        kill(linkedlist);
        for(int i = 0; i < linkedlist.size();i++){
            System.out.println(linkedlist.get(i) + "");
        }
        System.out.println((double) (System.currentTimeMillis() - m)/1000);
    }

    public static LinkedList kill(LinkedList linkedlist){

        if(linkedlist.size() < 2){
            return linkedlist;
        }

        for(int i = 0;i < linkedlist.size();i++){
            if(i+1 < linkedlist.size()) {
                linkedlist.remove(i + 1);
            }
        }


        return kill(linkedlist);
    }
}