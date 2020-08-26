package algorithm;

public class Main {
    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(15);
        numbers.addLast(20);
        numbers.addLast(30);

        LinkedList.ListIterator li = numbers.listIterator();
        while (li.hasNext()){
            if((int)li.next() == 15){
                li.remove();
            }
        }
        System.out.println(numbers);
    }
}
