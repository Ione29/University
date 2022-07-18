#include <stdio.h>
#include <math.h>
#include <iostream>

using namespace std;

//recursive definition
template<typename T> class BinarySearchTree {
    public:
        //current node has references to: root, left child, right child, parent
        BinarySearchTree<T> *root, *left_son, *right_son, *parent;
        //current node info
        T *pinfo;

        //constructor
        BinarySearchTree() {
            left_son = right_son = NULL;
            root = this;
            pinfo = NULL;
        }

        void setInfo(T info) {
            pinfo = new T;
            *pinfo = info;
        }

        void insert(T x) {
            if (pinfo == NULL)
                setInfo(x);
            else
                insert_rec(x);
        }

        ///insert function depends on the value that we want to insert
        ///if it should be on the left / right subtree
        void insert_rec(T x) {
            int next_son;
			if (x <= (*pinfo))
                next_son = 0;
            else
                next_son = 1;

            if (next_son == 0)
            {
                if (left_son == NULL)
                { ///left son
                    left_son = new BinarySearchTree<T>;
                    left_son->pinfo = new T;
                    *(left_son->pinfo) = x;
                    left_son->left_son = left_son->right_son = NULL;
                    left_son->parent = this;
                    left_son->root = root;
                }
                else
                    left_son->insert_rec(x);

            }
            else
            { /// right son
                if (right_son == NULL)
                {
                    right_son = new BinarySearchTree<T>;
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

		BinarySearchTree<T>* find(T x) {
            BinarySearchTree<T> *rez;

            if (pinfo == NULL)
                return NULL;

            if ((*pinfo) == x)
                return this;

            if (x <= (*pinfo))
            {
                if (left_son != NULL)
                    return left_son->find(x);
                else
                    return NULL;
            }
            else
            {
                if (right_son != NULL)
                    return right_son->find(x);
                else
                    return NULL;
            }
        }

        void removeInfo(T x) {
            BinarySearchTree<T> *t = find(x);
            if (t != NULL)
                t->remove();
        }


		void remove() {
            BinarySearchTree<T> *p;
            T *paux;

            if (left_son == NULL && right_son == NULL)
            {
                if (parent == NULL)
                { /// this == root
                    delete this->pinfo;
                    root->pinfo = NULL;
                }
                else ///leaf
                {
                    if (parent->left_son == this)
                        parent->left_son = NULL;
                    else
                        parent->right_son = NULL;

                    delete this->pinfo;
                    delete this;
                }
            }
            else
            {
                if (left_son != NULL)
                {
                    p = left_son;
                    while (p->right_son != NULL)
                        p = p->right_son;
                }
                else
                { /// right_son != NULL
                    p = right_son;
                    while (p->left_son != NULL)
                        p = p->left_son;
                }

                paux = p->pinfo;
                p->pinfo = this->pinfo;
                this->pinfo = paux;
                p->remove();
            }
        }

        void inOrderTraversal() {
            if (left_son != NULL)
                left_son->inOrderTraversal();

            cout<<*pinfo<<" ";

            if (right_son != NULL)
                right_son->inOrderTraversal();
        }


        void preOrderTraversal(){
            cout<<*pinfo<<" ";
            if (left_son != NULL)
                left_son->preOrderTraversal();

            if (right_son != NULL)
                right_son->preOrderTraversal();
        }

        void postOrderTraversal(){
            if (left_son != NULL){
                left_son->postOrderTraversal();}

            if (right_son != NULL){
                right_son->postOrderTraversal();}

            cout<<*pinfo<<" ";
        }

        T findMin()
        {
                BinarySearchTree<T>* node = this;
                while(node->left_son)
                    node = node->left_son;

                return *node->pinfo;
        }

        int rangeQuerySimple(BinarySearchTree<T> *node, T x, T y)
        {
            if(node == NULL)
                return 0;
            if(*node->pinfo < x)
                rangeQuerySimple(node->right_son, x, y);
            else if(*node->pinfo > y)
                rangeQuerySimple(node->left_son, x, y);
            else
            {
                rangeQuerySimple(node->left_son, x, y);
                cout << *node->pinfo;
                rangeQuerySimple(node->right_son, x, y);
            }
        }

};

template <typename T>
void rotateRight(BinarySearchTree<T> *newRoot)
{
    BinarySearchTree<T> *oldRoot = newRoot;
    newRoot = oldRoot->left_son;
    oldRoot->left_son = newRoot->right_son;
    newRoot-right_son = oldRoot;
}


template <typename T>
void rotateLeft(BinarySearchTree<T> *newRoot)
{
    BinarySearchTree<T> *oldRoot = newRoot;
    newRoot = oldRoot->right_son;
    oldRoot->right_son = newRoot->left_son;
    newRoot->left_son = oldRoot;

}

int main(){

    BinarySearchTree<char> *r = new BinarySearchTree<char>();

    r->insert('G');
    r->insert('B');
    r->insert('A');
    r->insert('C');
    r->insert('D');
    r->insert('F');
    r->insert('E');
    r->insert('I');

    cout<<"In order: ";
    r->inOrderTraversal();
    cout<<endl;
    cout<<"Pre order: ";
    r->preOrderTraversal();
    cout<<endl;
    cout<<"Post order: ";
    r->postOrderTraversal();
    cout<<endl;
    
    ///ex_1
    cout << "Smallest element is: ";
    cout << r->findMin() << endl;

    ///ex_2

    BinarySearchTree<char> *node = r;
    r->rangeQuerySimple(node, 'C', 'T');
    cout << endl;

    //ex_3
    cout << "Right Rotation Preorder: ";
    rotateRight(r);
    r->preOrderTraversal();

    cout << "Left Rotation Preorder: ";
    rotateLeft(r);
    r->preOrderTraversal();

    return 0;
}






