package lectures.part2fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatmapFilterFor {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Character> chars = Arrays.asList('a', 'b', 'c', 'd');
        List<String> colors = Arrays.asList("black", "white");

        Stream<String> combinationStream = numbers.stream().flatMap(n -> chars.stream().map(c -> "" + c + n));
        List<String> combinationString = combinationStream.collect(Collectors.toList());
        System.out.println(combinationString);

        Stream<String> combinationStream2 = numbers.stream().flatMap(n -> chars.stream().flatMap(c -> colors.stream().map(color -> n + c + color)));
        List<String> combinationString2 = combinationStream2.collect(Collectors.toList());
        System.out.println(combinationString2);


    }
}
