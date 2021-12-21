package com.floppa.Position;

/**
 * Implements a Position, so a Vector2D
 */
public class Pos {
    private int x;
    private int y;

    /**
     * Sets the X and Y Values
     * @param x
     * @param y
     */
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X Value
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the Y Value
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the Position, so X and Y Values to the given Ones
     * @param x
     * @param y
     * @return
     */
    public Pos setPos(int x, int y) {
        return new Pos(x, y);
    }
}
