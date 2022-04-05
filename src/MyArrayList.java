import java.util.Arrays;

public class MyArrayList<T> {
    private T[] list;
    private int capacity;
    private int size;
    
    public MyArrayList(){
        this.list = (T[]) new Object[16];
        this.capacity = 16;
        this.size = 0;
    }

    public MyArrayList(T[] elements) {
        this.list = (T[]) elements;
        if (elements.length > 16) {
            this.capacity = elements.length;
        } else {
            this.capacity = 16;
        }
        this.size = elements.length;
    }

    public void insert(T element, int index) {
        if (index > size || index < 0) return;
        if (this.capacity < size + 1) resize();
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        size += 1;
        list[index] = element;
    }

    public T remove(int index) {
        if (index >= size || index < 0) return null;
        T removedObj = list[index];
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size -= 1;
        return removedObj;
    }

    public boolean contains(T element){
        for (T e : this.list) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element){
        for (int i = 0; i < size; i++) {
            if (element.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index){
        if (index >= size || index < 0)  return null;
        return list[index];
    }

    public void set(int index, T elem){
        if (index >= size || index < 0)  return;
        list[index] = elem;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(this.list, 0, size));
    }

    private void resize(){
        int newCapacity = this.capacity * 2;
        T[] newArr = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newArr[i] = list[i];
        }
        list = newArr;
        this.capacity = newCapacity;
    }
}
