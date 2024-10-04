package Model;


public class Dog extends Pet{
    private final Type type = Type.Dog;
    private final String typeToString = "Dog";

    public Dog(int animal_Id, String name, String dateBirth, String commands) {
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