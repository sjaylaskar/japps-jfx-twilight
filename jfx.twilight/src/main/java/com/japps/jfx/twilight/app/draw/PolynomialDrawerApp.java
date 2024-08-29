/*
 * Copyright reserved © 2024 - https://in.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.twilight.app.draw;

import org.springframework.boot.autoconfigure.*;

import javafx.application.*;

/**
 * The PolynomialDrawerApp.java.
 *
 * @author Subhajoy Laskar | https://in.linkedin.com/in/subhajoylaskar
 * @version 1.0
 */
@SpringBootApplication
public class PolynomialDrawerApp {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
	Application.launch(PolynomialDrawer.class, args);
    }

}
