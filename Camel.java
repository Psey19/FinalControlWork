package Model;


public class Camel extends Pack_Animal{
    private final Type type = Type.Camel;
    private final String typeToString = "Camel";

    public Camel(int animal_Id, String name, String dateBirth, String commands) {
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