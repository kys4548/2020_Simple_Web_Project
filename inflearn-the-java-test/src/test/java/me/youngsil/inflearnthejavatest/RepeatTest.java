package me.youngsil.inflearnthejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;
import org.mockito.internal.invocation.ArgumentsProcessor;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
시간에 따라 값이 달리진다거나, 랜덤값, 조건 등
테스트를 진행할 때 반복적으로 한 테스트를 여러번
해야할 수 도 있다.
 */
public class RepeatTest {

    @DisplayName("repeat 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition} / {totalRepetitions}")
    void repeated1(RepetitionInfo repetitionInfo) {
        System.out.println("test : " + repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());
    }

    /*
        다른 값들을 가지고 테스트를 반복하고 싶을 때
        junit4에서는 다른 라이브러리를 이용해 사용했지만
        jnit5에서는 기본으로 제공
     */
    @DisplayName("반복테스트2")
    @ParameterizedTest(name = "{index} : message = {0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    @EmptySource //빈 소스 테스트를 하나 넣어줌
    @NullSource // null 소스 테스트를 하나 넣어줌 => 총 6개의 테스트
    void repeated2(String message) {
        System.out.println("message = " + message);
    }

    @DisplayName("반복테스트3")
    @ParameterizedTest(name = "{index} : message = {0}")
    @ValueSource(ints = {10, 20, 40})
    void repeated3(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println("study = " + study.getLimit());
    }

    //converter는 하나의 argument에만 적용된다.
    static class StudyConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            assertEquals(Study.class, aClass, "Can only convert to Study");
            return new Study(Integer.parseInt(o.toString()));
        }
    }

    @DisplayName("반복테스트4")
    @ParameterizedTest(name = "{index}")
    @CsvSource({"10, 'java'", "20, 'spring'"})
    void repeat4(Integer limit, String name) {
        Study study = new Study(limit, name);
        System.out.println("study = " + study);
    }


    //argument를 하나로 만들어주는 방식
    @DisplayName("반복테스트5")
    @ParameterizedTest(name = "{index}")
    @CsvSource({"10, 'java'", "20, 'spring'"})
    void repeat5(ArgumentsAccessor argumentsAccessor) {
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
    }

    //aggregateWith 사용
    @DisplayName("반복테스트6")
    @ParameterizedTest(name = "{index}")
    @CsvSource({"10, 'java'", "20, 'spring'"})
    void repeat6(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println("study = " + study);
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));

        }
    }
}