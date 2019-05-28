# Assignment 1 - Linked Lists
This repository is for Assignment 1 in Algorithm Analysis and Advanced Data Structures.This projects main focus was based on the linked list, and double linked list data strucrues with some attention to reintroduce beginner and advanced topics as a refresher.

## Question 1

Write a Java program that allows the user to input a list of words, separated by whitespace, and then the program should output how many times each word appears in the list.

### Approach
For this question I knew the program would be collecting user input, for this reason scanner was used for simplicty. Knowing the list inputed by the user was a string separted by whitspaces I then knew that splitting the string by whitespaces would be essential and thus implemented the split() method. With having an array of words I then knew I would be mapping the words to their count so I created a new map object m
```
Map<String, Integer> m = new HashMap<>();
```
With this new map object I was able to create a nested for loop that got the count of each word in the word array and map the string of that word to the count of how many times that word appeared.
### Output
![](/Images/Output1.png)

## Question 2
Write a non-recursive algorithm (follow pseudocode style similar to Code Fragment 3.11) for finding, by link hopping, the middle node of a doubly linked list with header and trailer sentinels.

### Approach
```
node frontEnd = head
node rearEnd = tail

while frontEnd != rearEnd and frontEnd!= NULL and readEnd != Null
do
   frontEnd = frontEnd -> next;
   rearEnd = readEnd -> previous;
end while

if frontEnd != NULL
   print frontEnd is middle node
else
   print no middle node present
end if
```
#### Time requirment
If the linked list size (n) is odd, it will take take time in order of (n+1)/2. Otherwise it will take time in order of n
   
