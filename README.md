# codeU

## Asignment2

### Question1
Method takes the root of a binary tree and a key and prints out the key's ancestors from root to its parent.
Used recursion to traverse the tree in preorder and construct a path from the root to the node with the desired key and reverse the order at the end
Should run in O(n) time where n is the number of nodes in the binary tree

### Question2
Method takes two node references and outputs their lowest common ancestor
Keeps looking for a node for which one of the input nodes is in the left subtree and the other input node is the right subtree
Runs in *O*(*n*) time where *n* is the number of nodes in the binary tree. In the beginning, presentInSubtree is called
*2n* times to see if the input nodes are present in the graph and afterwards the tree is traversed only once more.
