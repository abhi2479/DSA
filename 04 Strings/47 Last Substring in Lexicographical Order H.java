/* Given a string s, return the last substring of s in lexicographical order.

 

Example 1:

Input: s = "abab"
Output: "bab"
Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
Example 2:

Input: s = "leetcode"
Output: "tcode"
 

Constraints:

1 <= s.length <= 4 * 105
s contains only lowercase English letters.

//===================================================================================

Explanation
Understanding the question:

Before we try to understand the solution let us first ensure that we have understood the problem correctly the problem states that:

"Given a string s, return the last sub-string of s in lexicographical order."

to simply all you have to do is to find the lexicographic-ally largest sub-string of the given string

Let's take an example to understand:
s=abab

All possible sub strings of s are:
b
a
ab
ba
bab
aba

When these sub-strings are arranged alphabetically the order is:
a
b
ab
ba
aba
bab

Since bab appears last in this list our answer is bab.

This is what we mean when we say the largest sub-string.
Understanding the solution:

So from our new formed understanding we can say that the the alphabetically largest sub-string will be the one that begins with the largest letter present in the string because:

A Sub-string starting with z will always be largest when compared to a sub string starting with any other letter.

So we must find the largest letter in our string and take the longest possible sub-string starting from the the largest letter i.e. from the largest letter to the end of the string.

But there is a problem with the above approach what if the largest letter appears twice or more in the string. For e.g.:
zuiarazaaera there are two 'z'. So which of these should we consider?

This requires us to compare the sub-strings created starting with these letters and compare each character to determine which is larger. We can see that the first z is followed by a u while the second z is followed by an a. The substrings thus formed are zu... and za. Ofcourse, we can include more characters in these substrings but we do not need to. We can already tell that the substring starting with zu will be greater than the substring starting with za so we should record the index of the first z as starting index of the largest sub-string(lexicographically) found so far.

##Understanding the code

public String lastSubstring(String s) {

We use the variable maxIndex to keep track of the starting index of the largest string(lexicographically) found so far. At any point during the execution of the code the largest lexicographic substring found
is the one starting for maxIndex to the end of the string.

`int maxIndex = s.length() - 1;

for(int currIndex = s.length() - 1 ; currIndex >= 0 ; currIndex--){`

We check if the character at current index currIndex is greater than the character at the maxIndex(which is starting posn of the lexicographically largest substring so far found. If this is the case then we update the value of maxIndex to be currIndex as a larger starting letter means than the sub-string thus formed will also be larger.)

if(s.charAt(currIndex) > s.charAt(maxIndex)) maxIndex = currIndex;

Now if the character at currIndex and maxIndex are the same then we must compare the character that come after them to determine larger of the sub-strings formed by including them.

else if(s.charAt(currIndex) == s.charAt(maxIndex)){ int i = currIndex + 1; int j = maxIndex + 1;

We increment the value of i and j. We increment i as long as it is less than maxIndex and j is less than length. We continue to increment these indexes as long as the character at correspoding postions are same.

Once we are out of the while loop we update the value of maxIndex to currIndex under 4 conditions:
i == maxIndex

This is because if i is equal to maxIndex then the sub-string formed by starting from currIndex will clearly be greater.
This can be understood by means of an example.

In this case we start comparing the string formed by starting from the two z. The characters compared by while loop will be as follows:
substring st from first z substring starting from the second z
z z
a a
a a
r r
a a
m m
o o
n n

The substring achieved by starting from first z: zaaramonzaaramon
The substring achieved by starting from second z: zaaramon

Clearly the substring achieved by starting from currIndex will be greater than the sub-string achieved by starting from maxIndex
j==s.length()

This case means that the we iterated through every character in maxIndex substring and found it to be equal to every character in currIndex substring. We ran out of characters in maxIndex string which means that currIndex substring is longer. E.g:

maxIndex: Zellons
currIndex: ZellonsKuins

Clearly the substring achieved by starting from currIndex will be greater than the sub-string achieved by starting from maxIndex
s.charAt(i) > s.charAt(j)

This case means that we found the characters at the corresponding postions to be unequal for some value of i and j. We update the value of maxIndex only if character in currIndex string is larger than character at maxIndex string( and characters before them are all same. The loop ensures that)

` while(i < maxIndex && j < s.length() && s.charAt(i) == s.charAt(j)){
i++;
j++;
}

    if(i == maxIndex || j == s.length() || s.charAt(i) > s.charAt(j))
        maxIndex = currIndex;
}

}`

Finally we return the max substring found i.e. substring starting from maxIndex to end of the string.
return s.substring(maxIndex);
} */


class Solution {

public String lastSubstring(String s) {
int maxIndex = s.length() - 1;

for(int currIndex = s.length() - 1 ; currIndex >= 0 ; currIndex--){
    if(s.charAt(currIndex) > s.charAt(maxIndex))
        maxIndex = currIndex;
        
    else if(s.charAt(currIndex) == s.charAt(maxIndex)){
        int i = currIndex + 1;
        int j = maxIndex + 1;
        
        
        while(i < maxIndex && j < s.length() && s.charAt(i) == s.charAt(j)){
            i++;
            j++;
        }
        
        if(i == maxIndex || j == s.length() || s.charAt(i) > s.charAt(j))
            maxIndex = currIndex;
    }
}

return s.substring(maxIndex);
}
}