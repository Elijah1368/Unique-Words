public class UniqueWords {
    private BookReader book;
    public UniqueWords() {
        book = new BookReader("src\\WarAndPeace.txt");
        addUniqueWordsToArrayList();
        addUniqueWordsToLinkedList();
        addUniqueWordsToOrderedList();
    }

    public void addUniqueWordsToLinkedList() {
        //Resets pointer to first word
        book.words.first();
        MyLinkedList<String> linkedListUnique = new MyLinkedList<String>();

        //Times adding unique words
        long start = System.currentTimeMillis();

        String currWord = book.words.current();
        while (currWord != null) {
            if (!linkedListUnique.contains(currWord)) {
               linkedListUnique.addBefore(currWord); 
            }
            currWord = book.words.next();
        }
        long time = System.currentTimeMillis() - start;
        System.out.printf("Adding unique words to linked list... in %d milliseconds%n", time);
        System.out.printf("%d unique words%n", linkedListUnique.size());
        System.out.printf("%d comparisons%n", linkedListUnique.comparisons);

        //Times sorting unique words
        start = System.currentTimeMillis();
        linkedListUnique.sort();
        time = System.currentTimeMillis() - start;

        System.out.printf("Quick sorting linked list... in %d milliseconds%n%n", time);
    }

    public void addUniqueWordsToArrayList() {
        //resets pointer to first word
        book.words.first();
        MyArrayList<String> arrayListUnique = new MyArrayList<String>();

        long start = System.currentTimeMillis();
        
        String currWord = book.words.current();
        int index = 0;
        while (currWord != null) {
            if (!arrayListUnique.contains(currWord)) {
               arrayListUnique.insert(currWord, index++); 
            }
            currWord = book.words.next();
        }
        
        long time = System.currentTimeMillis() - start;
        System.out.printf("Adding unique words to an array list... in %d milliseconds%n", time);
        System.out.printf("%d unique words%n", arrayListUnique.size());
        System.out.printf("%d comparisons%n", arrayListUnique.comparisons);
        start = System.currentTimeMillis();
        arrayListUnique.sort();
        time = System.currentTimeMillis() - start;

        System.out.printf("Quick sorting array list... in %d milliseconds%n%n", time);
    }

    public void addUniqueWordsToOrderedList() {
        //resets pointer to first word
        book.words.first();
        MyOrderedList<String> orderedListUnique = new MyOrderedList<String>();

        long start = System.currentTimeMillis();

        String currWord = book.words.current();
        while (currWord != null) {
            if (!orderedListUnique.binarySearch(currWord)) {
               orderedListUnique.add(currWord); 
            }
            currWord = book.words.next();
        }
        long time = System.currentTimeMillis() - start;
        System.out.printf("Adding unique words to an ordered list... in %d milliseconds%n", time);
        System.out.printf("%d unique words%n%n", orderedListUnique.size());
    }
}
