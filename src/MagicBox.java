import java.util.Random;

public class MagicBox<T> {

    Object[] objects;

    public MagicBox(int size){
        objects = (T[]) new Object[size];
    }

    public boolean add(T object) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = object;
                return true;
            }
        }

        return false;
    }

    public T pick() {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                throw new RuntimeException(String.format("Коробка не полна. Осталось заполнить %s элементов", objects.length - i));
            }
        }

        Random random = new Random();
        int randomInt = random.nextInt(objects.length);

        return (T) objects[randomInt];
    }
}
