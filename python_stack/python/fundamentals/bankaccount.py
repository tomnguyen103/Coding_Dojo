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


guido = BankAccount(0.01, 200)
monty = BankAccount(0.05, 100)

guido.deposit(200).deposit(100).deposit(50).withdraw(120).yield_interest().display_account_infor()
monty.deposit(100).deposit(50).withdraw(50).withdraw(50).withdraw(50).withdraw(50).yield_interest().display_account_infor()