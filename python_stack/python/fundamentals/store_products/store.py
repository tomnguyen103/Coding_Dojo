class Store:
    def __init__(self, name):
        self.name = name
        self.productList = []
    def add_product(self,new_product):
        self.productList.append(new_product)
    def sell_product(self,id):
        product_to_sell = self.productList[id]
        self.productList.pop(id)
        product_to_sell.print_infor()

    def inflation(self,percent_increase):
        for i in range(len(self.productList)):
            self.productList[i].update_price(percent_increase,True)

    def set_clearance(self,category,percent_discount):
        for i in range(len(self.productList)):
            single_product = self.productList[i]
            if single_product.category == category:
                single_product.update_price(percent_discount,False)

    def print_info(self):
        for product in self.productList:
            print(product)

class Product:
    def __init__(self,name,price,category):
        self.name = name
        self.price = price
        self.category = category
    def update_price(self, percent_change, is_increased):
        if is_increased is True:
            self.price *= 1 + (percent_change/100)
        else:
            self.price *= 1 - (percent_change/100)
    def print_infor(self):
        print("Product: {}, Category: {}, Price; {}".format(self.name,self.category,self.price))
    def __str__(self):
        return "Name: " + self.name


store1 = Store("Malph's")

store1.add_product(Product("hair spray", 5.75, "cosmetic"))
store1.add_product(Product("banana",1.25, "grocery"))
store1.add_product(Product("apple", 6, "grocery"))

rotten_fruit = Product("rotten fruit", 10, "grocery")
store1.add_product(rotten_fruit)

store1.set_clearance("grocery", 50)
store1.productList[2]
store1.sell_product(3)

store1.print_info()