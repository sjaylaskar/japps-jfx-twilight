/*
 * Copyright reserved © 2024 - https://in.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.twilight.logic.perf;

/**
 * The MessageLoggingMapLogic.java.
 *
 * @author Subhajoy Laskar | https://in.linkedin.com/in/subhajoylaskar
 * @version 1.0
 */
public class MessageLoggingMapperLogic {

    /**
     * Process.
     *
     * @param num the num
     */
    public void process(int num) {
	NumLogger.log(MessageLoggingMap.of().getOrDefault(num, () -> 0).getAsInt());
    }
}
