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
