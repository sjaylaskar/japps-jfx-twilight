/*
 * Copyright reserved © 2024 - https://in.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.twilight.logic.perf;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.stream.*;

import org.apache.commons.io.*;

/**
 * The ClassWriter.java.
 *
 * @author Subhajoy Laskar | https://in.linkedin.com/in/subhajoylaskar
 * @version 1.0
 */
public final class ClassWriter {

    /** The method index placeholder. */
    private static final String METHOD_INDEX_PLACEHOLDER = "###";

    /** The method signature. */
    //private static final String METHOD_SIGNATURE = "public int process###() {";
    private static final String METHOD_SIGNATURE = "else if (num == ###) {";

    /** The method body. */
    //private static final String METHOD_BODY = "return ###;";
    // private static final String METHOD_BODY = "NumLogger.log(NumProcessor.instance().process###());";
    //private static final String METHOD_BODY = "MESSAGE_LOGGING_MAP.put(###, () -> NumProcessor.instance().process###());";
    //private static final String METHOD_BODY = "case ### -> NumProcessor.instance().process###();";
    private static final String METHOD_BODY = "PROCESS_###(() -> NumProcessor.instance().process###()),";

    /** The method end. */
    private static final String METHOD_END = "}";

    /** The line separator. */
    private static final String LINE_SEPARATOR = "\n";

    /** The method separator. */
    private static final String METHOD_SEPARATOR = "\n\n";

    /** The method signature tab. */
    //private static final String METHOD_SIGNATURE_TAB = "\t";
    private static final String METHOD_SIGNATURE_TAB = " ";

    /** The method body tab. */
    //private static final String METHOD_BODY_TAB = "\t\t";
    private static final String METHOD_BODY_TAB = "\t";

    /** The method end tab. */
    private static final String METHOD_END_TAB = "\t";


    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
	File file = new File(ClassWriter.class.getResource(".").getFile() + "/SampleClass.txt");
	file.createNewFile();
	IOUtils.write(buildFileData(), Files.newOutputStream(file.toPath(), StandardOpenOption.CREATE), StandardCharsets.UTF_8);
    }


    /**
     * Builds the lines.
     *
     * @return the
     */
    private static String buildFileData() {
	StringBuilder fileDataBuilder = new StringBuilder();
	IntStream.range(1, 1001).forEach(count -> buildMethod(fileDataBuilder, count));
	//IntStream.range(2, 1001).forEach(count -> buildMethod(fileDataBuilder, count));
	return fileDataBuilder.toString();
    }


    /**
     * Builds the method.
     *
     * @param fileDataBuilder the file data builder
     * @param count the count
     * @return the
     */
    private static StringBuilder buildMethod(StringBuilder fileDataBuilder, int count) {
	return fileDataBuilder
		//.append(METHOD_SIGNATURE_TAB)
		//.append(METHOD_SIGNATURE.replaceAll(METHOD_INDEX_PLACEHOLDER, String.valueOf(count)))
		//.append(LINE_SEPARATOR)
		//.append(METHOD_BODY_TAB)
		.append(METHOD_BODY.replaceAll(METHOD_INDEX_PLACEHOLDER, String.valueOf(count)))
		.append(LINE_SEPARATOR);
	//.append(METHOD_END_TAB)
	//.append(METHOD_END);
	//.append(METHOD_SEPARATOR);
    }
}
