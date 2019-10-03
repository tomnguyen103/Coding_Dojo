class SLNode:
    def __init__(self,value):
        self.val = value
        self.next = None

class SLList:
    def __init__(self):
        self.head = None
    def addToFront(self,val):
        #create a node to hold the value
        new_node = SLNode(val)
        #set the new node's next to the current head
        new_node.next = self.head

        #set the list's head to the new node
        self.head = new_node


x = "hello"
my_list = SLList()
my_list.addToFront("Jim")
my_list.addToFront("Dom")
my_list.addToFront("Andy")