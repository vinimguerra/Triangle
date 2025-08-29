package main;

import org.lwjgl.glfw.GLFW;
import net.viniguerra.core.Input;
import net.viniguerra.core.Window;
import org.lwjgl.opengl.GL11;

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
        window.setBackgroundColor(0.0f, 0.0f, 0.0f);
        window.create();
    }

    @Override
    public void run() {
        init();

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
        org.lwjgl.opengl.GL11.glBegin(GL11.GL_TRIANGLES);
        org.lwjgl.opengl.GL11.glColor3f(0.0f, 1.0f, 0.0f);
        org.lwjgl.opengl.GL11.glVertex2f(-0.5f, -0.5f);

        org.lwjgl.opengl.GL11.glColor3f(1.0f, 0.0f, 0.0f);
        org.lwjgl.opengl.GL11.glVertex2f(0.5f, -0.5f);

        org.lwjgl.opengl.GL11.glColor3f(0.0f, 0.0f, 1.0f);
        org.lwjgl.opengl.GL11.glVertex2f(0.0f, 0.5f);
        org.lwjgl.opengl.GL11.glEnd();

        window.swapBuffers();
    }

    public static void main(String[] args) {
        new Main().start();
    }
}