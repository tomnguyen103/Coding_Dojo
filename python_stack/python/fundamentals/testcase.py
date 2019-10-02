import unittest

def reverseArray(list):
    for i in range(int(len(list)/2)):
        list[i], list[len(list)-1-i] = list[len(list)-i-1], list[i]
    return list

class reverseArrayTests(unittest.TestCase):
    def testOne(self):
        self.assertEqual(reverseArray([1,2,3,4,5]),[5,4,3,2,1])
    def testTwo(self):
        self.assertEqual(reverseArray([5,4,3,2,1]), [1,2,3,4,5])
    def setUp(self):
        print("running setup")
    def tearDown(self):
        print("running tearDown tasks")

if __name__ == '__main__':
    unittest.main()