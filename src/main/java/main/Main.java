package main;

import org.lwjgl.glfw.GLFW;
import net.viniguerra.core.Input;
import net.viniguerra.core.Window;

public class Main implements Runnable {

    private Thread game;
    private Window window;
    private final int WIDTH = 1280, HEIGHT = 760;

    public void start() {
        game = new Thread(this, "Game");
        game.start();
    }

    private void init() {
        window = new Window(WIDTH, HEIGHT, "Game");
        window.setBackgroundColor(1.0f, 0.0f, 0.0f);
        window.create();
    }

    @Override
    public void run() {
        init();

        // loop principal
        while (!window.shouldClose() && !Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) {
            update();
            render();
        }

        window.destroy();
    }

    private void update() {
        window.update();

        if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
            System.out.println("Scroll X: " + Input.getScrollX() + ", Scroll Y: " + Input.getScrollY());
        }
    }

    private void render() {
        window.swapBuffers();
    }

    public static void main(String[] args) {
        new Main().start();
    }
}