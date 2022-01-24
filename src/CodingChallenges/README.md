# Coding Challenges
______________________________
**Almost Palindrome**
----------------------
A string is an almost-palindrome if, by changing only one character, you can make it a palindrome. Create a function that returns true if a string is an almost-palindrome and false otherwise.

Examples:  
almostPalindrome("abcdcbg") ➞ true  
// Transformed to "abcdcba" by changing "g" to "a".

almostPalindrome("abccia") ➞ true  
// Transformed to "abccba" by changing "i" to "b".

almostPalindrome("abcdaaa") ➞ false  
// Can't be transformed to a palindrome in exactly 1 turn.

almostPalindrome("1234312") ➞ false

**Staircase of Recursion**
---------------------------
Write a function that returns the number of ways a person can climb n stairs, where the person may only climb 1 or 2 steps at a time.

To illustrate, if n = 4 there are 5 ways to climb:

[1, 1, 1, 1]  
[2, 1, 1]  
[1, 2, 1]  
[1, 1, 2]  
[2, 2]  
  
<ins> Examples </ins> <br/>
waysToClimb(1) ➞ 1 <br/>
waysToClimb(2) ➞ 2 <br/>
waysToClimb(5) ➞ 8

Notes:
A staircase of height 0 should return 1.

**Heteromecic**
----------------------
A pronic number (or otherwise called as heteromecic) is a number which is a product of two consecutive integers, that is, a number of the form n(n + 1). Create a function that determines whether a number is pronic or not.

<ins> Examples </ins> <br/>
isHeteromecic(0) ➞ true
// 0 (0 + 1) = 0 1 = 0

isHeteromecic(2) ➞ true
// 1 (1 + 1) = 1 2 = 2

isHeteromecic(7) ➞ false

isHeteromecic(110) ➞ true
// 10 (10 + 1) = 10 11 = 110

isHeteromecic(136) ➞ false

isHeteromecic(156) ➞ true

**New Number From Squares**
---------------------------
Given any number, we can create a new number by adding the sums of squares of digits of that number  
For example, given 203, our new number is 4 + 0 + 9 = 13. If we repeat this process, we get a sequence of numbers:
  
<ins> Examples </ins> <br/>
happy(203) ➞ true

happy(11) ➞ false

happy(107) ➞ false

Notes:
You can assume (and it is actually true!) that all positive whole numbers are either happy or unhappy. Any happy number will have a 1 in its sequence, and every unhappy number will have a 4 in its sequence.
The only numbers passed to your function will be positive whole numbers.