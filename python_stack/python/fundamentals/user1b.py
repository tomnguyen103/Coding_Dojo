class User:
    def __init__(self, username, email):
        self.name = username
        self.email = email
        self.account = BankAccount(int_rate=0.02, balance=0)
    def make_deposit(self, amount):
        self.account.deposit(amount)
        return self
    def make_withdrawal(self, amount):
        self.account.withdraw(amount)
        return self
    def display_user_balance(self):
        # name = self.name
        # balance = self.account_balance
        print('User: {}, Balance: ${}'.format(self.account.name, self.account.display_account_infor()))

    def transfer_money(self, other_user, amount):
        self.account -= amount
        other_user.account += amount
        return self

class BankAccount:
    def __init__(self,int_rate, balance):
        self.rate = int_rate
        self.account_balance = 0
    def deposit(self,amount):
        self.account_balance += amount
        return self
    def withdraw(self,amount):
        if(self.account_balance > amount):
            self.account_balance -= amount
        else:
            print('Insufficient funds: Charging a $5 fee')
            self.account_balance -= 5
        return self
    def display_account_infor(self):
        print('Balance: ${}'.format(self.account_balance))

    def yield_interest(self):
        if(self.account_balance > 0):
            self.account_balance = self.account_balance+ (self.account_balance*self.rate)
        return self


# guido = BankAccount(0.01, 200)
# monty = BankAccount(0.05, 100)

# guido.deposit(200).deposit(100).deposit(50).withdraw(120).yield_interest().display_account_infor()
# monty.deposit(100).deposit(50).withdraw(50).withdraw(50).withdraw(50).withdraw(50).yield_interest().display_account_infor()

# guido = User("Guido van Rossum", "guido@python.com")
# monty = User("Monty Python", "monty@yahoo.com")
# tom = User("Tom Nguyen", "huuthong103@gmail.com")
# guido.make_deposit(100)
# guido.make_deposit(200)
# guido.make_deposit(300)
# guido.make_withdrawal(50)
# guido.display_user_balance()
# guido.make_deposit(100).make_deposit(200).make_deposit(300).make_withdrawal(50).display_user_balance()

# monty.make_deposit(300)
# monty.make_deposit(200)
# monty.make_withdrawal(50)
# monty.make_withdrawal(50)
# monty.display_user_balance()

# tom.make_deposit(200)
# tom.make_withdrawal(50)
# tom.make_withdrawal(50)
# tom.make_withdrawal(50)
# tom.display_user_balance()

# guido.transfer_money(tom, 50)
# guido.display_user_balance()
# tom.display_user_balance()