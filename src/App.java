public class App {
    public static void main(String[] args) throws Exception {
        /*
        var linkedlist = new MyLinkedList<Double>();
        for (int i= 0; i < 25; i++) {
            Double num = Math.random() * 25;
            linkedlist.addBefore(num);
        }

        System.out.println(linkedlist);
        linkedlist.sort();
        System.out.println(linkedlist);
        */

        var linkedlist = new MyLinkedList<String>();
        linkedlist.addBefore("banana");
        linkedlist.addBefore("carrots");
        linkedlist.addBefore("ha");
        linkedlist.addBefore("apple");
        linkedlist.addBefore("durian");
        linkedlist.addBefore("anchovies");
        linkedlist.addBefore("");
        linkedlist.addBefore("banana");

        System.out.println(linkedlist);
        linkedlist.sort();
        System.out.println(linkedlist);
    }
}
