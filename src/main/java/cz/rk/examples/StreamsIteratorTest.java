package cz.rk.examples;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class StreamsIteratorTest {

    public static void main(String[] args) {

        var myGeneratingStream = Stream.generate(() -> RandomStringUtils.randomAlphabetic(4));

        var myGeneratingStreamIterator = myGeneratingStream.iterator();

        var myStream = StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(myGeneratingStreamIterator, Spliterator.ORDERED), false);

        System.out.println("MyStream reference: " + myStream);
        myStream.forEach(i -> System.out.println("Item: " + i));
    }
}
