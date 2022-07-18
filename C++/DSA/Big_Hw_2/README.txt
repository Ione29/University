1) For the first exercise, I tried to implement a backtracking function in order to navigate through the ports and find the most efficient path.
2) For the second one, I hope I did the first 2 tasks succesfully, as I didn't get to test them.
   For the 3rd task, we can try to implement a BST for each house and add each wizard to their respective House. Then just output each school using an In-Order traversal.
   For the 4th task, we just traverse each node and check if they have zero (node.left_son == NULL and node.right_son == NULL) or 2 children (node.left_son != NULL and node.right_son != NULL.
   Finally, for the 5th task, we first have to check if the sequence given is in ascending order. If not, throw an error on screen. If it is in ascending order, by using an inorder traversal, check if we find all the scores given in the sequence in the BST.
   For the interactive menu I decided to just use switch statements, but it could've been done with _getch() (so we would only have to press the key and not press ENTER as well), and throw a "system("cls")" on top to make everything look nice, but I realized it was a bit of an overkill.
