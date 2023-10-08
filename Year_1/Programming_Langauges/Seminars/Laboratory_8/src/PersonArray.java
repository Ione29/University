class PersonArray{
    private Person[] members;
    private int items;

    public PersonArray(int full) {
    members = new Person[full];
    items = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        members[items++] = new Person(lastName, firstName, age);
    }

    public Person find(String searchName) {
        for(Person element : members) {
            if(element.getLast().equals(searchName)) 
                return element;
        }
        return null;
    }

    public boolean delete(String searchName) {
        for(int i = 0; i < items; i++) {
            if(members[i].getLast().equals(searchName)) {
                for(i++; i < items; i++)
                members[i-1] = members[i];

                items--;
                return true;
            }
        }
        return false;
    }

    public void displayArray() {
        for(int i = 0; i < items; i++) {
            members[i].displayPerson();
        }
    }
}

