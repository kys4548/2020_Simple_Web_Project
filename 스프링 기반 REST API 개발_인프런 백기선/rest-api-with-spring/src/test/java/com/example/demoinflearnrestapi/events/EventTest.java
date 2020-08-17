package com.example.demoinflearnrestapi.events;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
        .name("Inflearn Spring REST API")
        .description("REST API development with Spring")
        .build();
        assertNotNull(event);
    }

    @Test
    public void javaBean() {
        Event event = new Event();
        final String name = "Event";
        event.setName(name);
        final String description = "Spring";
        event.setDescription(description);

        assertEquals(name, event.getName());
        assertEquals(description, event.getDescription());
    }

    @DisplayName("파라미터 테스트1")
    @ParameterizedTest(name = "{index} {displayName} {0}, {1}, {2}")
    @MethodSource("parametersForTestFree")
    public void testFree(int basePrice, int maxPrice, boolean isFree) {
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        // When
        event.update();
        // Then
        assertEquals(isFree, event.isFree());
    }

    static private Object[] parametersForTestFree() {
        return new Object[] {
                new Object[] {0, 0, true},
                new Object[] {100, 0, false},
                new Object[] {0, 100, false},
                new Object[] {100, 200, false}
        };
    }

//    static class EventAggregator implements ArgumentsAggregator {
//
//        @Override
//        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
//            return Event.builder()
//                    .basePrice(accessor.getInteger(0))
//                    .maxPrice(accessor.getInteger(1))
//                    .build();
//        }
//    }

    @DisplayName("파라미터 테스트2")
    @ParameterizedTest(name = "{index} {displayName} {0}, {1}")
    @MethodSource("parametersForTestOffline")
    public void testOffline(String location, boolean isOffline) {
        // Given
        Event event = Event.builder()
                .location(location)
                .build();
        // When
        event.update();

        //Then
        assertEquals(isOffline, event.isOffline());
    }

    static Object[] parametersForTestOffline() {
        return new Object[] {
                new Object[] {"강남", true},
                new Object[] {null, false},
                new Object[] {"           ", false}
        };
    }
}