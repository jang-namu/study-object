package com.namu.object._06_command_and_query;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Event Test")
class EventTest {

    RecurringSchedule schedule;

    @BeforeEach
    void setUp() {
        schedule = new RecurringSchedule("반복 일정", DayOfWeek.MONDAY,
                LocalTime.of(6, 30), Duration.ofMinutes(60));
    }

    @Test
    @DisplayName("이벤트가 반복 일정에 포함되어 있는지 확인한다")
    void isSatisfied() {
        Event event1 = new Event("주간 회의", LocalDateTime.of(2025, 3, 3, 6, 30), Duration.ofMinutes(60));
        Event event2 = new Event("주간 회의", LocalDateTime.of(2025, 3, 4, 6, 30), Duration.ofMinutes(60));

        boolean isIn1 = event1.isSatisfied(schedule);
        boolean isIn2 = event2.isSatisfied(schedule);

        assertThat(isIn1).isTrue();
        assertThat(isIn2).isFalse();
    }

    @Test
    @DisplayName("이벤트를 반복 일정에 맞춰 조정한다")
    void reschedule() {
        Event event = new Event("주간 회의", LocalDateTime.of(2025, 3, 4, 6, 30), Duration.ofMinutes(60));

        boolean isIn1 = event.isSatisfied(schedule);
        assertThat(isIn1).isFalse();

        event.reschedule(schedule);
        boolean isIn2 = event.isSatisfied(schedule);
        assertThat(isIn2).isTrue();
    }
}