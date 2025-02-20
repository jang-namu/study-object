package com.namu.object._03_movie;

import java.time.DayOfWeek;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountCondition {
    private DiscountConditionType type;

    // 순번 조건에만 사용
    private int sequence;

    // 기간 조건에만 사용
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
