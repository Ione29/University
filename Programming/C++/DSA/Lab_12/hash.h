#include <string.h>
#include "Linked_list.h"
#include <iostream>

using namespace std;

///struct for each element - has key and value
template<typename Tkey, typename Tvalue> struct elem_info {
    Tkey key;
    Tvalue value; };

//implementation of Hashtable using LinkedList
template<typename Tkey, typename Tvalue> class Hashtable {
    private:
    ///we have a list for each key! (an array of lists)
        LinkedList< struct elem_info<Tkey, Tvalue> > *H;
        int HMAX;
        ///pointer to a hash function, of a certain type
        int (*hash)(Tkey);

        public:
            Hashtable(int hmax, int (*h) (Tkey)) {
	                HMAX = hmax;
	                hash = h;
	                H = new LinkedList< struct elem_info<Tkey,Tvalue> > [HMAX];
				}

			///add the pair (key, value)
			void put(Tkey key, Tvalue value)
			{
            	struct list_elem<struct elem_info<Tkey, Tvalue> > *p;
            	struct elem_info<Tkey, Tvalue> info;

            	//transform using the hash function
            	int hkey = hash(key);
				//first element of the list H[hkey]
            	p = H[hkey].pfirst;

            	while (p != NULL)
                {
					///if we find an element of this key, we will replace it
	                if (p->info.key == key)
	                    break;
                    p = p->next;
                }

                if (p != NULL) ///element which already has a key
                    p->info.value = value;
                else ///element which does not have a key
                {
                    info.key = key;
                    info.value = value;
                    H[hkey].addLast(info);
                }
            }

	            ///return value of a certain key
            Tvalue get(Tkey key)
                {
                     struct list_elem<struct elem_info<Tkey, Tvalue> > *p;

                        int hkey = hash(key);
                         p = H[hkey].pfirst;

                         while (p != NULL)
                        {
                            if (p->info.key == key) break;
                            p = p->next;
                        }

                        if (p != NULL)
                            return p->info.value;
                        else
                        {
                            fprintf(stderr, "Error 101 - The key does not exist in the hashtable\n");
                           // Tvalue x;
                          //  return x;
                        }
                }

            ///verify if the element with a certain key exists
            int hasKey(Tkey key)
            {
                struct list_elem<struct elem_info<Tkey, Tvalue> > *p;

                int hkey = hash(key);
                p = H[hkey].pfirst;

                while (p != NULL)
                {
                    if (p->info.key == key)
                        break;
                    p = p->next;
                }

                if (p != NULL)
                    return 1;
                else
                    return 0;
            }
};
