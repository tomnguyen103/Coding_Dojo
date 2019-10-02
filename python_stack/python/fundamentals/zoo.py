class Zoo:
    def __init__(self, zoo_name):
        self.animals = []
        self.name = zoo_name
    def add_lion(self,name):
        self.animals.append(Lion(name))
        return self
    def add_tiger(self,name):
        self.animals.append(Tiger(name))
        return self
    def print_all_info(self):
        print("-"*30, self.name, "-"*30)
        for animal in self.animals:
            animal.display_info()
    
class Lion(Zoo):
    #pass
    def __init__(self, lion_name):
        self.name = lion_name
    def display_info(self):
        print("Lion List:",self.name)

class Tiger(Zoo):
    #pass
    def __init__(self,tiger_name):
        self.name = tiger_name
        self.tigers = []
    def display_info(self):
        print("Tiger List:",self.name)

zoo1 = Zoo("John's Zoo")
zoo1.add_lion("Nala")
zoo1.add_lion("Simba")
zoo1.add_tiger("Rajah")
zoo1.add_tiger("Shere Khan")
zoo1.print_all_info()
