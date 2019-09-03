package com.ekfet.common;

import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.value.SpecialChar;

import static com.cronutils.model.field.expression.FieldExpressionFactory.*;

public class CronTest {
    public static void main(String[] args) {
        Cron cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ))
                .withYear(between(2019,2030))
                .withMonth(FieldExpression.always())
                .withHour(on(1))
                .withDoM(FieldExpression.always())
                .withDoW(questionMark())
                .withMinute(on(10))
                .withSecond(on(0))
                .instance();
// Obtain the string expression
        String cronAsString = cron.asString(); // 0 * * L-3 * ? *
        System.out.println(cronAsString);
    }
}
