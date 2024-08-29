/*
 * Copyright reserved © 2024 - https://in.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.twilight.app.perf;

import static com.japps.jfx.twilight.logic.perf.MessageLogger.*;

import java.time.*;
import java.util.stream.*;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.data.mongo.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.boot.autoconfigure.mongo.*;

import com.japps.jfx.twilight.logic.perf.*;

/**
 * The application.
 *
 * @author <a href=" https://in.linkedin.com/in/subhajoylaskar">Subhajoy
 *         Laskar</a>
 * @version 1.0
 */
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, MongoAutoConfiguration.class,
	MongoDataAutoConfiguration.class })
@SpringBootApplication
public class PerfApplication {

    /** The message logging enum logic. */
    private static final MessageLoggingEnumLogic MESSAGE_LOGGING_ENUM_LOGIC = new MessageLoggingEnumLogic();

    /** The message logging mapper logic. */
    private static final MessageLoggingMapperLogic MESSAGE_LOGGING_MAPPER_LOGIC = new MessageLoggingMapperLogic();

    /** The message logging switching logic. */
    private static final MessageLoggingSwitchingLogic MESSAGE_LOGGING_SWITCHING_LOGIC = new MessageLoggingSwitchingLogic();

    /** The message logging conditional logic. */
    private static final MessageLoggingConditionalLogic MESSAGE_LOGGING_CONDITIONAL_LOGIC = new MessageLoggingConditionalLogic();

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
	SpringApplication.run(PerfApplication.class, args);
	printNums();
    }

    /**
     * Prints the nums.
     */
    private static void printNums() {
	// Via conditional
	print("=========================================================Start print nums via conditional processing=========================================================");
	Instant now = Instant.now();
	print("Time start: " + now);
	IntStream.range(0, 1001).forEach(num -> MESSAGE_LOGGING_CONDITIONAL_LOGIC.process(num));
	print("Time elapsed: " + Duration.between(now, Instant.now()));
	print("=========================================================End print nums via conditional processing=========================================================");

	// Via switching
	print("=========================================================Start print nums via switch processing=========================================================");
	now = Instant.now();
	print("Time start: " + now);
	IntStream.range(0, 1001).forEach(num -> MESSAGE_LOGGING_SWITCHING_LOGIC.process(num));
	print("Time elapsed: " + Duration.between(now, Instant.now()));
	print("=========================================================End print nums via switch processing=========================================================");

	// Via mapper
	print("=========================================================Start print nums via mapper processing=========================================================");
	now = Instant.now();
	print("Time start: " + now);
	IntStream.range(0, 1001).forEach(num -> MESSAGE_LOGGING_MAPPER_LOGIC.process(num));
	print("Time elapsed: " + Duration.between(now, Instant.now()));
	print("=========================================================End print nums via mapper processing=========================================================");

	// Via enum
	print("=========================================================Start print nums via enum processing=========================================================");
	now = Instant.now();
	print("Time start: " + now);
	IntStream.range(0, 1001).forEach(num -> MESSAGE_LOGGING_ENUM_LOGIC.process(num));
	print("Time elapsed: " + Duration.between(now, Instant.now()));
	print("=========================================================End print nums via enum processing=========================================================");
    }
}
