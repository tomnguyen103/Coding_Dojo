class Store:
    def __init__(self, name, product):
        self.name = name
        self.product = Product(product.name,product.price,product.category)
    def add_product(self,new_product):
        self.product += new_product
    def sell_product(self,id):
        self.product -= id
    def inflation(self,percent_increase):
        self.product.price *= percent_increase
    def set_clearance(self,category,percent_discount):
        if self.product.category == category:
            self.product.price *=percent_discount
class Product:
    def __init__(self,name,price,category):
        self.name = name
        self.price = price
        self.category = category
    def update_price(self, percent_change, is_increased):
        if is_increased is True:
            self.price = percent_change * self.price
    def print_infor(self):
        print("Product: {}, Category: {}, Price; {}".format(self.name,self.category,self.price))
