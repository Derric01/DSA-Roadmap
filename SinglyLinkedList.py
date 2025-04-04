class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # Insertion
    def insert_at_beginning(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def insert_at_end(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new_node

    def insert_at_position(self, data, pos):
        if pos <= 0:
            print("Position must be > 0")
            return
        new_node = Node(data)
        if pos == 1:
            self.insert_at_beginning(data)
            return
        temp = self.head
        count = 1
        while temp and count < pos - 1:
            temp = temp.next
            count += 1
        if not temp:
            print("Position out of range")
            return
        new_node.next = temp.next
        temp.next = new_node

    # Deletion
    def delete_at_beginning(self):
        if not self.head:
            print("List is empty")
            return
        self.head = self.head.next

    def delete_at_end(self):
        if not self.head:
            print("List is empty")
            return
        if not self.head.next:
            self.head = None
            return
        temp = self.head
        while temp.next.next:
            temp = temp.next
        temp.next = None

    def delete_at_position(self, pos):
        if pos <= 0:
            print("Position must be > 0")
            return
        if not self.head:
            print("List is empty")
            return
        if pos == 1:
            self.delete_at_beginning()
            return
        temp = self.head
        count = 1
        while temp.next and count < pos - 1:
            temp = temp.next
            count += 1
        if not temp.next:
            print("Position out of range")
            return
        temp.next = temp.next.next

    # Display
    def display(self):
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")

# Example usage
ll = SinglyLinkedList()
ll.insert_at_end(10)
ll.insert_at_beginning(5)
ll.insert_at_position(7, 2)
ll.display()            # 5 -> 7 -> 10 -> None
ll.delete_at_position(2)
ll.display()            # 5 -> 10 -> None
ll.delete_at_end()
ll.display()            # 5 -> None
