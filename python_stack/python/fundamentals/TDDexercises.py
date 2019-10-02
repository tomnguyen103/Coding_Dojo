import unittest
import math
def reverseList(arr):
    return arr[::-1]
def isPalindrome(s):
    rev = reverseList(s)

    if(s==rev):
        return True
    return False
def coin(amount):
    arr = []
    for coin in [25,10,5,1]:
        q = amount/coin
        
        


class testCase(unittest.TestCase):
    def testOne(self):
        self.assertEqual(reverseList([1,2,3,4,5]), [5,4,3,2,1])
    def testTwo(self):
        self.assertEqual(reverseList([5,4,3,2,1]),[1,2,3,4,5])
    def testThree(self):
        self.assertEqual(reverseList([5,4,3,2,5]),[5,2,3,4,5])
    def testFour(self):
        self.assertEqual(isPalindrome("racecar"), True)
        self.assertTrue(isPalindrome("racecar"))
    def testFive(self):
        self.assertEqual(isPalindrome("boob"), True)
        self.assertTrue(isPalindrome("boob"))
    def testSix(self):
        self.assertEqual(isPalindrome("laptop"), False)
        self.assertFalse(isPalindrome("laptop"))
    def testSeven(self):
        self.assertEqual(isPalindrome("computer"), False)
        self.assertFalse(isPalindrome("computer"))
    def testEight(self):
        self.assertEqual(isPalindrome("Alex"), False)
        self.assertFalse(isPalindrome("Alex"))
    def testNine(self):
        self.assertEqual(coin(87), [3,1,0,2])
    def setUp(self):
        print("running setup")
    def tearDown(self):
        print("running tearDown")
if __name__ == "__main__":
    unittest.main()