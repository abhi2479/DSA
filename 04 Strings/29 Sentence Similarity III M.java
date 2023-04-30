/* A sentence is a list of words that are separated by a single space with no leading or trailing spaces. For example, "Hello World", "HELLO", "hello world hello world" are all sentences. Words consist of only uppercase and lowercase English letters.

Two sentences sentence1 and sentence2 are similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. For example, sentence1 = "Hello my name is Jane" and sentence2 = "Hello Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in sentence2.

Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.

 

Example 1:

Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
Output: true
Explanation: sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".

Example 2:

Input: sentence1 = "of", sentence2 = "A lot of words"
Output: false
Explanation: No single sentence can be inserted inside one of the sentences to make it equal to the other.

Example 3:

Input: sentence1 = "Eating right now", sentence2 = "Eating"
Output: true
Explanation: sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.

 

Constraints:

    1 <= sentence1.length, sentence2.length <= 100
    sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
    The words in sentence1 and sentence2 are separated by a single space.

 */
 
/*  Logic And Explanation
Here what we did is..

    We just make the first string larger, so that we can run the loop on the basis of smaller string
    Make 2 arrays consiting strings which are saperated by space (arrays of words)
    Now use 2 pointers (one from start and one from last)
    Now the limited conditions are

    if first word are equal increment first pointers
    if second word are equal increment second pointers

    In any other case, code should return false */


 
 class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
		// Just to make s1 always bigger in size
        if (s1.length() < s2.length()) {
            boolean ans=areSentencesSimilar(s2,s1);
            return ans;
        }
		// making array of every word
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        int i1 = 0, i2 = 0, j1 = arr1.length - 1, j2 = arr2.length - 1;
		
		// iterating from start as well as from last
        while (i2 <= j2) {
            if (arr1[i1].equals(arr2[i2])) {
                i1++; 
                i2++;
            } else if (arr1[j1].equals(arr2[j2])) {
                j1--;
                j2--;
            } else {
                return false;
            }
        }
        return true;
    }
}