/*
 * Copyright reserved © 2024 - https://in.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.twilight.app.draw;

import java.util.*;
import java.util.function.*;

import javafx.animation.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

/**
 * The PolynomialDrawer.java.
 *
 * @author Subhajoy Laskar | https://in.linkedin.com/in/subhajoylaskar
 * @author <i>Source (modified from): </i> <b>Almas Baimagambetov
 *         (almaslvl@gmail.com); <a href=https://github.com/AlmasB>Almas
 *         B</a></b>
 * @version 1.0
 */
public class PolynomialDrawer extends Application {

    /** The w. */
    private static final int W = 1680;

    /** The h. */
    private static final int H = 760;

    /** The pixels per unit. */
    private static final double PIXELS_PER_UNIT = 50.0;

    /** The duration. */
    private static final double DURATION = 8.0;

    /** The functions. */
    private static final List<FunctionData> functions = Arrays.asList(
	    new FunctionData(Color.RED, x -> x),
	    new FunctionData(Color.BLUE, x -> x * x),
	    new FunctionData(Color.GREEN, x -> x * x * x),
	    new FunctionData(Color.DARKBLUE, x -> Math.sin(x)),
	    new FunctionData(Color.DARKGREEN, x -> Math.cos(x)),
	    new FunctionData(Color.LIGHTGRAY, x -> Math.cos(2 * x)),
	    new FunctionData(Color.DARKGOLDENROD, x -> Math.tan(x)),
	    new FunctionData(Color.DARKKHAKI, x -> Math.log(x)),
	    new FunctionData(Color.BROWN, x -> Math.pow(Math.E, x)),
	    new FunctionData(Color.DARKSEAGREEN, x -> Math.pow(1 / x, 2) + Math.pow(1 / (x + 1), 2)));

    /** The t. */
    private double t = 0.0;

    /** The g. */
    private GraphicsContext graphicsContext;

    /**
     * Start.
     *
     * @param stage the stage
     * @throws Exception the exception
     */
    @Override
    public void start(Stage stage) throws Exception {
	stage.setScene(new Scene(createContent()));
	stage.setTitle("JAPPS - Polynomial Drawer");
	stage.setIconified(true);
	stage.show();
    }

    /**
     * Creates the content.
     *
     * @return the
     */
    private Parent createContent() {
	Pane pane = new Pane();
	pane.setPrefSize(W, H);
	Canvas canvas = new Canvas(W, H);
	graphicsContext = canvas.getGraphicsContext2D();
	graphicsContext.setLineWidth(3.0);
	animate();
	pane.getChildren().add(canvas);
	return pane;
    }

    /**
     * Animate.
     */
    private void animate() {
	AnimationTimer animationTimer = new AnimationTimer() {
	    @Override
	    public void handle(long now) {
		t += 0.016;
		if (t >= DURATION) {
		    sleep();
		    t = 0.0;
		}
		if (t >= DURATION * 2) {
		    stop();
		}
		onUpdate();
	    }
	};
	animationTimer.start();
    }

    /**
     * Sleep.
     */
    private void sleep() {
	try {
	    Thread.sleep(2000);
	} catch (InterruptedException exception) {
	    exception.printStackTrace();
	}
    }

    /**
     * On update.
     */
    private void onUpdate() {
	graphicsContext.clearRect(0, 0, W, H);

	functions.forEach(this::plot);
    }

    /**
     * Plot.
     *
     * @param functionData the function data
     */
    private void plot(FunctionData functionData) {
	graphicsContext.setStroke(functionData.color);

	int maxDrawX = (int) (W * t / DURATION);

	for (int drawX = 0; drawX < maxDrawX; drawX++) {
	    draw(drawX, functionData);
	}

	functionData.oldX = 0.0;
	functionData.oldY = 0.0;
    }

    /**
     * Draw.
     *
     * @param drawX        the draw X
     * @param functionData the function data
     */
    private void draw(int drawX, FunctionData functionData) {
	double x = (drawX - W / 2) / PIXELS_PER_UNIT;
	double y = functionData.function.apply(x);

	double drawY = H - (y * PIXELS_PER_UNIT + H / 2);

	if (!(functionData.oldX == 0.0 && functionData.oldY == 0.0)) {
	    graphicsContext.strokeLine(functionData.oldX, functionData.oldY, drawX, drawY);
	}

	functionData.oldX = drawX;
	functionData.oldY = drawY;
    }

    /**
     * The function data.
     *
     * @author Subhajoy Laskar | https://in.linkedin.com/in/subhajoylaskar
     * @version 1.0
     */
    private static class FunctionData {

	/** The color. */
	private Color color;

	/** The function. */
	private Function<Double, Double> function;

	/** The old X. */
	private double oldX = 0.0;

	/** The old Y. */
	private double oldY = 0.0;

	/**
	 * Instantiates a new function data.
	 *
	 * @param color    the color
	 * @param function the function
	 */
	public FunctionData(Color color, Function<Double, Double> function) {
	    this.color = color;
	    this.function = function;
	}
    }
}