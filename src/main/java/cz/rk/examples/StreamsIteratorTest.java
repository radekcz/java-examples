package cz.rk.examples;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Test for generating infinite stream and it's processing
 */
@Slf4j
public class StreamsIteratorTest {

    private static final int WORD_LENGTH = 4;


    public static void main(String[] args) {
        generateInfiniteStream();
    }

    private static void generateInfiniteStream() {
        var myGeneratingStream = Stream
                .generate(() -> RandomStringUtils.randomAlphabetic(WORD_LENGTH));

        var myGeneratingStreamIterator = myGeneratingStream.iterator();

        var myStream = StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(myGeneratingStreamIterator, Spliterator.ORDERED), false);

        log.info("MyStream reference: " + myStream);
        myStream.limit(10)
                .forEach(i -> log.info("Item: " + i));
    }
}
