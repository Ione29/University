import java.util.*;

// character class
class Character implements Cloneable {
    private String name;
    private String className;
    private String story;
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;

    // constructor
    public Character(String name, String className, String story,
                     int strength, int constitution, int dexterity,
                     int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.className = className;
        this.story = story;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // getters / setters for the details of the character
    public String getName() { return name; }
    public String getClassName() { return className; }
    public String getStory() { return story; }
    public int getStrength() { return strength; }
    public int getConstitution() { return constitution; }
    public int getDexterity() { return dexterity; }
    public int getIntelligence() { return intelligence; }
    public int getWisdom() { return wisdom; }
    public int getCharisma() { return charisma; }

    public void setName(String name) { this.name = name; }
    public void setClassName(String className) { this.className = className; }
    public void setStory(String story) { this.story = story; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setConstitution(int constitution) { this.constitution = constitution; }
    public void setDexterity(int dexterity) { this.dexterity = dexterity; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setWisdom(int wisdom) { this.wisdom = wisdom; }
    public void setCharisma(int charisma) { this.charisma = charisma; }
}

// character setup class
public class RPGCharacterSetup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Character> characterLibrary = new HashMap<>();

        // we predefine 2 characters
        Character warrior = new Character("Aragorn", "Warrior", "A brave warrior from the north.",
                18, 16, 14, 10, 12, 8);
        Character wizard = new Character("Gandalf", "Wizard", "A wise wizard with great power.",
                8, 10, 12, 18, 16, 14);

        characterLibrary.put("Warrior", warrior);
        characterLibrary.put("Wizard", wizard);

        System.out.println("Welcome to the RPG Character Setup!");
        System.out.println("Choose:");
        System.out.println("1. Create a new character");
        System.out.println("2. Modify an already-existing character");

        // read the option
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        // initialize the character
        // we will use this one regardless of the player's choice
        Character playerCharacter = null;

        if (choice == 1) {
            // create character from scratch
            playerCharacter = createCharacterFromScratch(scanner);
        } else if (choice == 2) {
            // modify predefined character
            playerCharacter = modifyExistingCharacter(scanner, characterLibrary);
        } else {
            System.out.println("Invalid choice.");
            System.exit(0);
        }

        // display the character stats
        displayCharacterStats(playerCharacter);
    }

    // function for creating a new character
    private static Character createCharacterFromScratch(Scanner scanner) {
        System.out.println("Creating a new character from scratch.");

        // set the name, class and the background of the character
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        System.out.print("Enter character class: ");
        String className = scanner.nextLine();
        System.out.print("Enter character story: ");
        String story = scanner.nextLine();

        // set the attributes of the character
        int strength = getAttributeValue(scanner, "Strength");
        int constitution = getAttributeValue(scanner, "Constitution");
        int dexterity = getAttributeValue(scanner, "Dexterity");
        int intelligence = getAttributeValue(scanner, "Intelligence");
        int wisdom = getAttributeValue(scanner, "Wisdom");
        int charisma = getAttributeValue(scanner, "Charisma");

        // construct the character
        return new Character(name, className, story,
                strength, constitution, dexterity,
                intelligence, wisdom, charisma);
    }

    // function for modifying an already-existing character
    private static Character modifyExistingCharacter(Scanner scanner, Map<String, Character> library) {
        System.out.println("Available predefined characters:");
        for (String key : library.keySet()) {
            System.out.println("- " + key);
        }

        // player selects the character to modify by writing it's name
        System.out.print("Enter the name of the predefined character to modify: ");
        String choice = scanner.nextLine();

        // get the character by name
        Character baseCharacter = library.get(choice);

        // if we don't find the character by name
        if (baseCharacter == null) {
            System.out.println("Character not found.");
            System.exit(0);
        }

        // clone the character so we can modify it & keep the original one intact
        Character clonedCharacter = null;
        try {
            clonedCharacter = (Character) baseCharacter.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Modifying " + choice);

        // here we start letting the player modify the character

        // first the name & story
        System.out.print("Enter new character name (" + clonedCharacter.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            clonedCharacter.setName(name);
        }

        System.out.print("Enter new character story (" + clonedCharacter.getStory() + "): ");
        String story = scanner.nextLine();
        if (!story.isEmpty()) {
            clonedCharacter.setStory(story);
        }

        // and then the attributes
        System.out.println("Modify attributes (press Enter to keep current value):");
    
        clonedCharacter.setStrength(modifyAttribute(scanner, "Strength", clonedCharacter.getStrength()));
        clonedCharacter.setConstitution(modifyAttribute(scanner, "Constitution", clonedCharacter.getConstitution()));
        clonedCharacter.setDexterity(modifyAttribute(scanner, "Dexterity", clonedCharacter.getDexterity()));
        clonedCharacter.setIntelligence(modifyAttribute(scanner, "Intelligence", clonedCharacter.getIntelligence()));
        clonedCharacter.setWisdom(modifyAttribute(scanner, "Wisdom", clonedCharacter.getWisdom()));
        clonedCharacter.setCharisma(modifyAttribute(scanner, "Charisma", clonedCharacter.getCharisma()));

        return clonedCharacter;
    }

    private static int getAttributeValue(Scanner scanner, String attributeName) {
        int value;
        do {
            System.out.print("Enter the new value for " + attributeName + " (3-20): ");
            value = scanner.nextInt();
            scanner.nextLine();
            if (value < 3 || value > 20) {
                System.out.println("The value of the attribute must be between 3 and 20.");
            }
        } while (value < 3 || value > 20);
        return value;
    }

    private static int modifyAttribute(Scanner scanner, String attributeName, int currentValue) {
        System.out.print(attributeName + " (" + currentValue + "): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return currentValue;
        } else {
            try {
                int value = Integer.parseInt(input);
                if (value >= 3 && value <= 20) {
                    return value;
                } else {
                    System.out.println("Value must be between 3 and 20. Keeping current value.");
                    return currentValue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Keeping current value.");
                return currentValue;
            }
        }
    }

    private static void displayCharacterStats(Character character) {
        System.out.println("\n--- Character Stats ---");
        System.out.println("Name: " + character.getName());
        System.out.println("Class: " + character.getClassName());
        System.out.println("Story: " + character.getStory());
        System.out.println("Strength: " + character.getStrength());
        System.out.println("Constitution: " + character.getConstitution());
        System.out.println("Dexterity: " + character.getDexterity());
        System.out.println("Intelligence: " + character.getIntelligence());
        System.out.println("Wisdom: " + character.getWisdom());
        System.out.println("Charisma: " + character.getCharisma());
    }
}
