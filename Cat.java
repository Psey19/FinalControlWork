package Model;


public class Cat extends Pet{
    private final Type type = Type.Cat;
    private final String typeToString = "Cat";

    public Cat(int animal_Id, String name, String dateBirth, String commands) {
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
