import random
def randInt(min=0, max=100):
    if min > max or max < 0:
        return False
    else: 
        num = random.random() * max + min

    return round(num)

print(randInt(max=50))
print(randInt(min=50))
print(randInt(min=50, max=500))
print(randInt(min=500, max=50))
print(randInt(min=50, max=-2))