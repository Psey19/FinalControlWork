package Model;


public abstract class Animal {
    private int animal_Id;
    private String name;
    private String dateBirth;
    private String commands;

    public Animal(int animal_Id, String name, String dateBirth, String commands) {
        this.animal_Id = animal_Id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.commands = commands;
    }

    public abstract String getSpeciesToString();
    public abstract String getTypeToString();
    public abstract Species getSpecies();
    public abstract Type getType();

    public String getName() { return name; }

    public String getDateBirth() { return dateBirth; }

    public String getCommands() { return commands; }

    public int getAnimal_Id() { return animal_Id; }

    public void setAnimal_Id(int animal_Id) {
        this.animal_Id = animal_Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return  "{Id: " + animal_Id +
                ", Name: " + name +
                ", DateBirth: " + dateBirth +
                ", Commands: " + commands + "}";
    }
}
