//ARRAYS IMPLEMENTATION
class MyArray {
    private int[] arr;
    private int size;
    private int capacity;

    public MyArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    // Insert element at the end
    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Array is full!");
            return;
        }
        arr[size] = element;
        size++;
    }

    // Delete element by value
    public void delete(int element) {
        int index = search(element);
        if (index == -1) {
            System.out.println("Element not found!");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // Search for an element
    public int search(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1; // Element not found
    }

    // Display the array elements
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(5);
        myArray.insert(10);
        myArray.insert(20);
        myArray.insert(30);
        myArray.display();

        myArray.delete(20);
        myArray.display();

        System.out.println("Index of 30: " + myArray.search(30));
    }
}
