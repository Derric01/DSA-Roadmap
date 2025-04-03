class MyArray:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.arr = [None] * capacity

    # Insert element at the end
    def insert(self, element):
        if self.size == self.capacity:
            print("Array is full!")
            return
        self.arr[self.size] = element
        self.size += 1

    # Delete element by value
    def delete(self, element):
        index = self.search(element)
        if index == -1:
            print("Element not found!")
            return
        for i in range(index, self.size - 1):
            self.arr[i] = self.arr[i + 1]
        self.arr[self.size - 1] = None
        self.size -= 1

    # Search for an element
    def search(self, element):
        for i in range(self.size):
            if self.arr[i] == element:
                return i
        return -1  # Element not found

    # Display the array elements
    def display(self):
        if self.size == 0:
            print("Array is empty!")
            return
        print(" ".join(str(self.arr[i]) for i in range(self.size)))

# Example Usage
myArray = MyArray(5)
myArray.insert(10)
myArray.insert(20)
myArray.insert(30)
myArray.display()

myArray.delete(20)
myArray.display()

print("Index of 30:", myArray.search(30))
