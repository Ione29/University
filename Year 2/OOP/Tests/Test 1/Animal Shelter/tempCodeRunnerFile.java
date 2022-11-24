public boolean adoptPet(Animal vPet){
        if(animalsAvailable.contains(vPet)){
            animalsAdopted.add(animalsAvailable.get(animalsAvailable.indexOf(vPet)));
            animalsAvailable.remove(vPet);
            System.out.println(vPet.getName() + " was adopted succesfully!");
            return true;
        }
        else{
            System.out.println("The animal you are trying to adopt is not available.");
            return false;
        }
    }
