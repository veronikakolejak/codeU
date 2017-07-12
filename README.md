# codeU

## Asignment1

### Question1
Method takes two strings and returns true if the strings are permutations of each other.
Used integer arrays to count occurrences of individual lowercase characters in each string

### Question2
Method takes a reference to the head node of a linked list and returns the kth to the last element of the linked list.
Used two pointers of which one was ahead exactly k nodes from the other

## Asignment5

### Determine language alphabet
Method takes a dictionary array and returns the alphabet as an array of characters. <br />
Creates a directed graph representing which characters should come before which characters based on the dictionary words
and uses the Kahn's algorithm to topologically sort the character nodes. <br />
Creation of the graph runs in *O*(*n***k*) where *n* is the number of words and *k* is the number of characters in a word as every character is checked at most twice.
The topological sort runs in *O*(*N*+*E*) where *N* is the number of nodes (characters in the alphabet) and *E* is the number of edges between the nodes. <br />
The overall time complexity is *O*(*n***k*).
