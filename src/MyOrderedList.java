public class MyOrderedList<T extends Comparable<T>> {
    private MyArrayList<T> list;
    public int comparisons;
    
    public MyOrderedList(){
        list = new MyArrayList<T>();
        comparisons = 0;
    }

    public void add(T item){
        if (list.size() == 0) {
            list.insert(item, 0);
            return;
        }

        int insertIndex = findInsertIndex(0, list.size() - 1, item);
        list.insert(item, insertIndex);
    }

    public T remove(T item) {
        int start = comparisons;
        int insertIndex = findInsertIndex(0, list.size() - 1, item);

        //since we only want to count comparisons in add and binarysearch method.
        comparisons = start;

        if (list.get(insertIndex).compareTo(item) == 0) {
            return list.remove(insertIndex);
        }
        return null;
    } 

    public int size() {
        return list.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public String toString(){
        return list.toString();
    }

    public boolean binarySearch(T item) {
        return binarySearch(0, list.size() - 1, item);
    }

    private boolean binarySearch(int left, int right, T elem) {
        if (left <= right) {
            comparisons++;
            int mid = left + ((right - left) / 2);
            if (list.get(mid).compareTo(elem) == 0) {
                return true;
            } else if (list.get(mid).compareTo(elem) > 0){
                return binarySearch(left, mid - 1, elem);
            } else {
                return binarySearch(mid + 1, right, elem);
            }
        }
        return false;
    }

    //Like binary search but returns index instead of boolean
    //iterative implementation
    private int findInsertIndex(int left, int right, T elem){
        while (left <= right) {
            comparisons++;
            int middle = (right + left) / 2;

            int comparison = list.get(middle).compareTo(elem);

            if (comparison == 0) {
                return middle;
            } else if (comparison > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return right + 1;
    }

}
