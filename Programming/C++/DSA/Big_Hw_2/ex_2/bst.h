template<typename T> class BST {
    public:
        //current node has references to: root, left child, right child, parent
        BST<T> *root, *left_son, *right_son, *parent;
        //current node info
        T *pinfo;

        //constructor
        BST() {
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
			if (x.score <= *pinfo->score)
                next_son = 0;
            else
                next_son = 1;

            if (next_son == 0)
            {
                if (left_son == NULL)
                { ///left son
                    left_son = new BST<T>;
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
                    right_son = new BST<T>;
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

		BST<T>* find(T x) {
            BST<T> *rez;

            if (pinfo == NULL)
                return NULL;

            if ((*pinfo) == x)
                return this;

            if (x.score <= (*pinfo->score))
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
            BST<T> *t = find(x);
            if (t != NULL)
                t->remove();
        }


		void remove() {
            BST<T> *p;
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
                BST<T>* node = this;
                while(node->left_son)
                    node = node->left_son;

                return *node->pinfo;
        }
};