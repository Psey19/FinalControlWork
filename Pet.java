package Model;


public abstract class Pet extends Animal {
    private final Species species = Species.Pet;
    private final String speciesToString = "Pet";

    public Pet(int animal_Id, String name, String dateBirth, String commands) {
        super(animal_Id, name, dateBirth, commands);
    }

    @Override
    public String getSpeciesToString() { return speciesToString; }

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    public String toString() { return "(" + speciesToString + "): " + super.toString(); }
}
