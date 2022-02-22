package data_structures.arrays;

// Not a complete example of a dynamic array. Simply a Java version of the course example

public class DynamicArray {

    private Object[] data;
    private int capacity;
    private int length;

    public DynamicArray () {
        data = new Object[1];
        capacity = 1;
        length = 0;
    }

    public int length() {
        return this.length;
    }

    public Object get(int index) {
        if (index > -1 && index < this.length) {
            return data[index];
        } else return "Index Out Of Bound";
    }

    public void push(Object obj) {
        if (this.length == this.capacity) {
            // full, so need to create new array with double capacity
            int newCapacity = this.capacity * 2;
            Object[] tempArray = new Object[newCapacity];
            for (int i = 0; i < this.length; i++) {
                tempArray[i] = this.data[i];
            }
            this.data = tempArray;
            this.capacity = newCapacity;
        }
        this.data[this.length] = obj;
        this.length++;
    }

    public Object pop() {
        if (this.length > 0) {
            Object popped = this.data[this.length - 1];
            this.data[this.length - 1] = null;
            this.length--;
            return popped;
        } else return null;
    }

    public void delete(int index) {
        if (index > -1 && index < this.length) {
            if (index == this.length - 1) {
                pop();
            } else {
                shiftItems(index);
            }
        }
    }

    private void shiftItems(int index) {
        for (int i = index; i < this.length - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[length - 1] = null;
        this.length--;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < this.length; i++) {
            str.append(this.data[i]);
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.push(0);
        dynamicArray.push(1);
        dynamicArray.push(2);
        dynamicArray.push(3);
        System.out.println("Array-Length: " + dynamicArray.length());
        System.out.println("array: " + dynamicArray);
        System.out.println("item at index 2: " + dynamicArray.get(2));
        dynamicArray.pop();
        System.out.println("array: " + dynamicArray);
        dynamicArray.delete(1);
        System.out.println("array: " + dynamicArray);
        System.out.println("Array-Length: " + dynamicArray.length());
    }

}
