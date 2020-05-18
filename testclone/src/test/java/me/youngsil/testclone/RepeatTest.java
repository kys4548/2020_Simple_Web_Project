package me.youngsil.testclone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RepeatTest {

    @DisplayName("반복 테스트 실행1")
    @RepeatedTest(value = 10, name = "{currentRepetition} / {totalRepetitions}")
    void test1(String name) {

    }

    @DisplayName("반복 테스트 실행2")
    @ParameterizedTest(name = "{index} : {0}")
    @ValueSource(strings = {"비가", "오고", "있네요"})
    @NullAndEmptySource
    void test2(String message) {
        System.out.println("message = " + message);
    }

    @DisplayName("반복 테스트 실행3")
    @ParameterizedTest(name = "{index} : {0}")
    @ValueSource(ints = {1, 2, 3})
    void test3(@ConvertWith(MemberConverter.class) Member member) {
        System.out.println("member = " + member.getId());
    }

    static class MemberConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            if(aClass == Member.class) {
                return new Member(Integer.parseInt(o.toString()));
            }
            return null;
        }
    }

    @DisplayName("반복 테스트4")
    @ParameterizedTest(name = "{index} : {0}, {1}")
    @CsvSource({"1, 'java'", "2, 'test'"})
    void test4(Integer id, String name) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }

    @DisplayName("반복 테스트5")
    @ParameterizedTest(name = "{index} : {0}, {1}")
    @CsvSource({"1, 'java'", "2, 'test'"})
    void test5(ArgumentsAccessor accessor) {
        System.out.println("accessor.get(0) = " + accessor.get(0));
        System.out.println("accessor.get(0) = " + accessor.get(1));
    }

    @DisplayName("반복 테스트6")
    @ParameterizedTest(name = "{index} : {0}, {1}")
    @CsvSource({"1, 'java'", "2, 'test'"})
    void test6(@AggregateWith(MemberAggregator.class) Member member) {

    }

    static class MemberAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return null;
        }
    }

}
