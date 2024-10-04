package Model;


public abstract class Pack_Animal extends Animal {
    private final Species species = Species.Pack_Animal;
    private final String speciesToString = "Pack_Animal";

    public Pack_Animal(int animal_Id, String name, String dateBirth, String commands) {
        super(animal_Id, name, dateBirth, commands);
    }

    @Override
    public String getSpeciesToString() {
        return speciesToString;
    }

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return "(" + speciesToString + "): " + super.toString();
    }
}
