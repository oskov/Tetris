package com.mygdx.gameWorld;

import com.badlogic.gdx.math.RandomXS128;

public class EntityClass {
    private boolean controllable;
    private Coord coord;
    private int[][] figure;
    private Forms[] forms;
    private Forms currentForm;
    private Forms nextForm;
    private RandomXS128 randomXS128;
    private Coord[] points;
    private int color;
    private int oldColor;

    public EntityClass() {
        controllable = false;
        coord = new Coord();
        randomXS128 = new RandomXS128();
        forms = Forms.values();
        nextForm = forms[randomXS128.nextInt(forms.length)];
        oldColor = randomXS128.nextInt(5) + 1;
        recreate();
    }

    public void recreate() {
        currentForm = nextForm;
        coord.x = 4;
        coord.y = 25;
        nextForm = forms[randomXS128.nextInt(forms.length)];
        figure = currentForm.generateForm();
        color = randomXS128.nextInt(5) + 1;
        while (color == oldColor) color = randomXS128.nextInt(5) + 1;
        oldColor = color;
        setPoints();
    }

    public void rotate() {
        if (currentForm != Forms.SQUARE_FORM && currentForm != Forms.I_FORM) {
            int m = 3;
            for (int k = 0; k < m / 2; k++) {
                for (int j = k; j < m - 1 - k; j++) {

                    int tmp = figure[k][j];
                    figure[k][j] = figure[j][m - 1 - k];
                    figure[j][m - 1 - k] = figure[m - 1 - k][m - 1 - j];
                    figure[m - 1 - k][m - 1 - j] = figure[m - 1 - j][k];
                    figure[m - 1 - j][k] = tmp;
                }
            }
            setPoints();
        } else {
            if (currentForm == Forms.I_FORM) {
                for (int i = 0; i < figure.length; i++) {
                    int tmp = figure[i][0];
                    figure[i][0] = figure[figure.length - 1][figure.length - 1 - i];
                    figure[figure.length - 1][figure.length - 1 - i] = tmp;
                }

            }
            setPoints();
        }

    }

    public void setPoints() {
        points = new Coord[4];
        int c = 0;
        for (int i = 0; i < figure.length; i++) {
            for (int a = 0; a < figure[i].length; a++) {
                if (figure[i][a] == 1) {
                    points[c] = new Coord(i + coord.x, a + coord.y);

                    c++;
                }
            }
        }
    }

    public Coord[] getPoints() {
        return points;
    }

    public int getColor() {
        return color;
    }

    public void addCoordX(int x) {
        coord.x += x;
        for (int i = 0; i < points.length; i++) points[i].x += x;
    }

    public void addCoordY(int y) {
        coord.y += y;
        for (int i = 0; i < points.length; i++) points[i].y += y;
    }

    public boolean isControllable() {
        return controllable;
    }

    public void setControllable(boolean controllable) {
        this.controllable = controllable;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Forms getCurrentForm() {
        return currentForm;
    }

    public void setCurrentForm(Forms currentForm) {
        this.currentForm = currentForm;
    }

    public Forms getNextForm() {
        return nextForm;
    }

    public void setNextForm(Forms nextForm) {
        this.nextForm = nextForm;
    }

}
