package main;

import net.viniguerra.core.Window;
import org.lwjgl.glfw.GLFW;

public class Main implements Runnable {
    public Thread game;
    public static Window window;
    public static final int WIDTH = 1280, HEIGHT = 760;

    public void start() {
        game = new Thread(this, "game");
        game.start();
    }

    public static void init() {
        window = new Window(WIDTH, HEIGHT, "Game");
        window.create();
    }

    public void run() {
        init();
        while (!window.shouldClose()) {
            update();
            render();
        }
    }

    private void update() {
        window.update();
    }

    private void render() {
        window.swapBuffers();
    }

    public static void main(String[] args) {
        new Main().start();
    }
}