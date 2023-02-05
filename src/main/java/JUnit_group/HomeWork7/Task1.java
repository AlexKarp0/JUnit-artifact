package JUnit_group.HomeWork7;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
    Map<Double,String> stringMap= generateList(100,100).stream()
            .map(i -> i * Math.PI -20.0)
            .filter(f -> f<100.0)
            .sorted(((o1, o2) -> o1.compareTo(o2)))
            .skip(3)
            .distinct()//нужно чтобы мапа работала нормально, иначе начинает ругаться на попытку вставить одинаковый элемент
            .collect(Collectors.toMap(x -> x,String::valueOf));

        System.out.println(stringMap);
    }
    private static List<Long> generateList(long bound, int size) {
        Supplier<Long> generator = () -> new Random().nextLong(bound);
        return Stream.generate(generator).limit(size).toList();
    }
}
