import java.util.Arrays;

public class MyList<T> {
    T[] list;
    int capacity;
    int listSize=0;

    public MyList() {
        this.capacity=10;
        this.list=(T[]) new Object[capacity];
    }
    public MyList(int capacity) {
        this.capacity = capacity;
        this.list=(T[]) new Object[capacity];
    }
    public int size(){
        return this.listSize;
    }
    public int getCapacity() {
        return capacity;
    }
    public void add(T data){
        if(size() == capacity){

            int newCapacity = capacity * 2;
            list = Arrays.copyOf(list, newCapacity);
            capacity = newCapacity;
        }
        list[listSize++] = data;
    }
    public T get(int index){
        if(index < 0 || index >= listSize) return null;
        return list[index];
    }
    public T remove(int index){
        if(index < 0 || index >= listSize) return null;
        T removedIndex = list[index];
        list[index]=null;
        for(int i = index+1;i<listSize;i++){
            if(list[i]!=null){
                list[i-1]=list[i];
                list[i]=null;
            }
        }
        listSize--;
        return removedIndex;
    }
    public T set(int index, T data){
        if(index < 0 || index >= listSize) return null;
        list[index] = data;
        return data;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i = 0; i<listSize;i++){
            stringBuilder.append(list[i]);
            if(i!=listSize-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    public int indexOf(T data){
        for(int i =0;i<listSize;i++){
            if(data.equals(list[i])){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        return listSize==0;
    }
    public T[] toArray(){
        return Arrays.copyOf(list,listSize);
    }
    public void clear(){
        Arrays.fill(list,null);
        listSize=0;
    }
    public MyList<T> sublist(int start,int finish){
        if (start < 0 || finish >= listSize || start > finish) {
            throw new IndexOutOfBoundsException();
        }
        MyList<T> subList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            subList.add(get(i));
        }
        return subList;
    }
    public boolean contains(T data){
        for(int i =0;i<listSize;i++){
            if(list[i].equals(data)){
                return true;
            }

        }
        return false;
    }
}