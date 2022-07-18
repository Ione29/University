#include <stdio.h>

template<typename T> struct list_elem {
    T info;
    struct list_elem<T> *next, *prev;
};

template <typename T> class LinkedList {
    public:
        struct list_elem<T> *pfirst, *plast;

        void addFirst(T x) {
            struct list_elem<T> *paux;

            paux = new struct list_elem<T>;
            paux->info = x;
            paux->prev = NULL;
            paux->next = pfirst;

            if (pfirst != NULL) pfirst->prev = paux;
            pfirst = paux;

            if (plast==NULL) plast=pfirst;
        }
		void addLast(T x) {
            struct list_elem<T> *paux;

            paux = new struct list_elem<T>;
            paux->info = x;
            paux->prev = plast;
            paux->next = NULL;

            if (plast != NULL) plast->next = paux;
            plast = paux;
            if (pfirst == NULL) pfirst = plast;
        }

	LinkedList() {
        pfirst = plast = NULL;
    }

    int isEmpty() {
    if (pfirst == plast == NULL)
        return 1;
    else return 0;

    }

    void deleteFirst() {
            struct list_elem<T> *aux;
            aux = new struct list_elem<T>;
            if (pfirst != NULL) {
            aux = pfirst->next;
            delete(pfirst);
            pfirst=aux;
            if (pfirst != NULL)
            pfirst->prev=NULL;
            }
}

};

