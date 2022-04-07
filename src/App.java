public class App {
    public static void main(String[] args) throws Exception {
       
        //BookReader hey = new BookReader("src\\WarAndPeace.txt");
        MyLinkedList test = new MyLinkedList<Double>();
        for (int i = 0; i < 25; i++){  
            test.addBefore(i);
        }
        Double a = 12.5;

        System.out.println(test.indexOf("123"));
    }
}
