package Model;


public class Horse extends Pack_Animal{
    private final Type type = Type.Horse;
    private final String typeToString = "Horse";

    public Horse(int animal_Id, String name, String dateBirth, String commands) {
        super(animal_Id, name, dateBirth, commands);
    }

    @Override
    public String getTypeToString() { return typeToString; }

    @Override
    public Type getType() { return type; }

    @Override
    public String toString() {
        return typeToString + " " + super.toString();
    }
}