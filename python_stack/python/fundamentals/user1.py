class User:
    def __init__(self, username, email):
        self.name = username
        self.email = email
        self.account_balance = 0
    def make_deposit(self, amount):
        self.account_balance += amount
        return self
    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self
    def display_user_balance(self):
        # name = self.name
        # balance = self.account_balance
        print('User: {}, Balance: ${}'.format(self.name, self.account_balance))

    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
        return self


guido = User("Guido van Rossum", "guido@python.com")
monty = User("Monty Python", "monty@yahoo.com")
tom = User("Tom Nguyen", "huuthong103@gmail.com")
# guido.make_deposit(100)
# guido.make_deposit(200)
# guido.make_deposit(300)
# guido.make_withdrawal(50)
# guido.display_user_balance()
guido.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawal(50).display_user_balance()

monty.make_deposit(300)
monty.make_deposit(200)
monty.make_withdrawal(50)
monty.make_withdrawal(50)
monty.display_user_balance()

tom.make_deposit(200)
tom.make_withdrawal(50)
tom.make_withdrawal(50)
tom.make_withdrawal(50)
tom.display_user_balance()

guido.transfer_money(tom, 50)
guido.display_user_balance()
tom.display_user_balance()