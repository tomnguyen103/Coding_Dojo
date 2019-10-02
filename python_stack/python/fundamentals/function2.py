# x = [ [5,2,3], [10,8,9] ] 
# students = [
#      {'first_name':  'Michael', 'last_name' : 'Jordan'},
#      {'first_name' : 'John', 'last_name' : 'Rosales'}
# ]
# sports_directory = {
#     'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
#     'soccer' : ['Messi', 'Ronaldo', 'Rooney']
# }
# z = [ {'x': 10, 'y': 20} ]

# # 1.
# x[1][0] = 15
# print(x)

# # 2.
# print(students[0]['last_name'])
# students[0]['last_name'] = 'Bryant'
# print(students[0]['last_name'])

# # 3.
# print(sports_directory['soccer'][0])
# sports_directory['soccer'][0] = 'Andres'   
# print(sports_directory['soccer'][0])

# # 4.
# print(z[0]['y'])
# z[0]['y']= 30
# print(z[0]['y'])


###########################################
# students = [
#          {'first_name':  'Michael', 'last_name' : 'Jordan'},
#          {'first_name' : 'John', 'last_name' : 'Rosales'},
#          {'first_name' : 'Mark', 'last_name' : 'Guillen'},
#          {'first_name' : 'KB', 'last_name' : 'Tonel'}
#     ]

# should output: (it's okay if each key-value pair ends up on 2 separate lines;
# bonus to get them to appear exactly as below!)
# first_name - Michael, last_name - Jordan
# first_name - John, last_name - Rosales
# first_name - Mark, last_name - Guillen
# first_name - KB, last_name - Tonel

# def iterateDictionary(some_list):
#     for i in some_list:
#         print("first_name" , "-" , i["first_name"],",","last_name", "-" , i["last_name"])

# iterateDictionary(students) 


        # for key,val in some_list.items():
        #     print(key[i], '-', val[i])
        # for j in some_list:
        #     print(j.keys)
        # print(some_list[i].keys())
        #print(i.keys())
        #print(i) #dictionary
        
        #print("last_name", i["last_name"])
        # print(i.keys())
        # for k in i.keys():
        #     print('k: ' + k)
        # for j in i[0].keys():
        #     for k in j:
        #         print(k[0])
            #print(j)
        # for j in i:
        #     print(j[0])
            # print(j)
            # for k in range(len(j)):
            #     print(j[k])
        # print(i.values())
        # print(str(i.keys() + '-' + i.values()))
        # for j in some_list[i]:
        #     print(j.keys())
        # for j in i.items():
        #     print(j.keys())



# print(students[0]['first_name'])
# print(students[0].keys())

# print(students[0].keys())

# 3.
# def iterateDictionary2(key_name,some_list):
#     for i in some_list:
#         #print(i)
#         #print(i.keys())
#         #print(i.values())
#         print(i[key_name])  

# iterateDictionary2('first_name', students)
# iterateDictionary2('last_name', students)

# 4.
dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(dic):
    print(dic.keys())
    for i in dic.values():
        print(str(len(i))+ " Locations")
        for j in range(len(i)):
            print(i[j])
        print("\n")

printInfo(dojo)

# printInfo(dojo)
# # output:
# 7 LOCATIONS
# San Jose
# Seattle
# Dallas
# Chicago
# Tulsa
# DC
# Burbank
    
# 8 INSTRUCTORS
# Michael
# Amy
# Eduardo
# Josh
# Graham
# Patrick
# Minh
# D



