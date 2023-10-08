#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

template <typename T> class BinaryTree {
    public:
        T *pinfo;
        BinaryTree<T> *left_son, *right_son, *parent, *root;

        BinaryTree()
        {
            pinfo = NULL;
            left_son = right_son = parent = NULL;
            root = this;
        }

        void setInfo(T info)
        {
            pinfo = new T;
            *pinfo = info;
        }

		void setRoot(BinaryTree<T> *r)
		{
            root = r;
        }

        /// insert a new node
        void insert(T x)
        {
            ///if the tree is empty, this will be the first node
            if (pinfo == NULL)
                setInfo(x);
            ///if not, we insert it recursively
            else
                insert_rec(x);
        }

		void insert_rec(T x)
		{
		    ///choose randomly if it's left or right son (0 or 1)
            int next_son = rand() % 2; /// %100 -> 0..99
            if (next_son == 0) /// left son
			{
			    ///if we don't have a left son yet
                if (left_son == NULL)
				{
                    left_son = new BinaryTree<T>;
                    left_son->pinfo = new T;
                    *(left_son->pinfo) = x;

                    left_son->left_son = left_son->right_son = NULL;
                    left_son->parent = this;
                    left_son->root = root;
                }
                else
                    left_son->insert_rec(x);
            }
            else /// right son
            {
                if (right_son == NULL) {
                    right_son = new BinaryTree<T>;
                    right_son->pinfo = new T;
                    *(right_son->pinfo) = x;

                    right_son->left_son = right_son->right_son = NULL;
                    right_son->parent = this;
                    right_son->root = root;
                }
                else
                    right_son->insert_rec(x);
            }
        }

        ///find a certain node which contains the info x
		BinaryTree<T>* find(T x)
		{
            BinaryTree<T> *rez;

            if (pinfo == NULL)
                return NULL;

            if ((*pinfo) == x)
                return this;

             ///search in the left subtree
            if (left_son != NULL)
                rez = left_son->find(x);
            else
                rez = NULL;

            if (rez != NULL)
                return rez;
            else ///if not found, search in the right subtree
                if (right_son != NULL)
                    return right_son->find(x);
                else
                    return NULL;
        }

        ///search for a leaf
		BinaryTree<T>* findLeaf()
		{
            if (left_son == NULL && right_son == NULL)
                return this;
			else
				if (left_son != NULL)
					return left_son->findLeaf();
				else
					return right_son->findLeaf();
        }

        ///call remove with the node that we want to delete (this)
		 void remove()
		 {
            BinaryTree<T> *leaf;

            /// find a leaf in this node's subtree
            /// we use it to put it in the place of the node that we delete
            leaf = findLeaf();

            ///if the current node is a leaf
            if (this == leaf)
            {
                ///we will remove the leaf
                if (parent == NULL) /// because this == root == leaf
                {
                    if (this->pinfo != NULL)
                        delete this->pinfo;

                    root->pinfo = NULL;
                }
                else
                {
                    ///if what we remove is left son
                    if (parent->left_son == this)
                        parent->left_son = NULL;
                    else
                        ///if what we remove is right son
                        parent->right_son = NULL;

                    delete this->pinfo;
                    delete this;
                }
            }

            ///if the current node is not a leaf
            else
            {
                ///if the leaf is a left son
                if (leaf->parent->left_son == leaf)
                    leaf->parent->left_son = NULL;
                else
                    ///if the leaf is a right son
                    leaf->parent->right_son = NULL;

                ///replace the links for the leaf
                leaf->parent = parent;
                leaf->left_son = left_son;
                leaf->right_son = right_son;

                delete this->pinfo;

                ///the info of the current node becomes the info of the leaf
                this->pinfo = leaf->pinfo;
                delete leaf;
            }
        }

		void removeInfo(T x)
		{
            BinaryTree<T> *t = find(x);
            if (t != NULL)
                t->remove();
        }

		 void preOrderTraversal()
		 {
            ///display, left, right
            cout<<*pinfo <<" ";
            if (left_son != NULL)
                left_son->preOrderTraversal();
            if (right_son != NULL)
                right_son->preOrderTraversal();
        }

        void postOrderTraversal()
        {
            ///left, right, display
            if (left_son != NULL)
                left_son->postOrderTraversal();
            if (right_son != NULL)
                right_son->postOrderTraversal();
			cout<<*pinfo <<" ";
        }

        void inOrderTraversal()
        {
            ///left, display, right
            if (left_son != NULL)
                left_son->inOrderTraversal();
            cout<<*pinfo <<" ";
            if (right_son != NULL)
                right_son->inOrderTraversal();
        }

		void preOrderTraversalLevels(int level)
		{
            int i;
            for (i = 0; i < level; i++)
                cout<<"-";

          cout<<*pinfo<<endl;

          if (left_son != NULL)
                left_son->preOrderTraversalLevels(level + 1);
          if (right_son != NULL)
                right_son->preOrderTraversalLevels(level + 1);
        }

        int getMaxHeight()
        {
            if(this == NULL)
                return -1;
            else
                return max(this->left_son->getMaxHeight(), this->right_son->getMaxHeight()) + 1;
        }

        int getHeightDiff()
        {
            if(this == NULL)
                return -1;
            else
                return abs(this->left_son->getMaxHeight() - this->right_son->getMaxHeight());
        }

        void display(int i)
        {
            displayLevelNodes(root, i);
            cout << endl;
        }

        void displayLevelNodes(BinaryTree<T> *nod, int level)
        {
            if(!level)
                cout << *(nod->pinfo) << ' ';
            else
                if(nod->left_son != NULL)
                    displayLevelNodes(nod->left_son, level - 1);
                if(nod->right_son != NULL)
                    displayLevelNodes(nod->right_son, level - 1);
        }

        void displayByLevels()
        {
            for(int i = 0; i < getMaxHeight(); i++)
                display(i);
        }
};

int main() {
    BinaryTree<int> *r = new BinaryTree<int>;
    
    r->setRoot(r); /// optional
    r->insert(6);
    r->insert(8);
    r->insert(1);
    r->insert(9);
    r->insert(10);
    r->insert(4);
    r->insert(13);
    r->insert(1);
    r->insert(12);
    /*
    cout<<"Preorder1\n";
    r->preOrderTraversal();

    cout<<"\nPreorder2\n";
    r->preOrderTraversalLevels(0);

    cout<<"\nPostorder\n";
    r->postOrderTraversal();

    cout<<"\nInorder\n";
    r->inOrderTraversal();

    cout<<"\n\n";
    cout<<r->find(100)<<endl;
    cout<<r->find(10)<<endl;

     //(r->find(6))->remove();

    cout<<"_______\n"<<*(r->find(10)->pinfo);
    cout<<"\n"<<r->find(4);
    cout<<"\n"<<r->find(12);
    cout<<"\n"<<r->find(8)<<endl;
    */

    cout << endl << r->getMaxHeight() << endl;
    cout << endl << r->getHeightDiff() << endl;
    r->display(3);
    cout << endl;
    r->displayByLevels();
    return 0;
}





