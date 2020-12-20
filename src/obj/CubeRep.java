package obj;

import java.awt.*;

public class CubeRep {

    private static CubeRep t;
    private Color[][][] c;
    private Color[] temp;

    public static final Color[] COLORS = {Color.WHITE, Color.ORANGE, Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW};

    public static CubeRep getInstance() {
        if (t == null) {
            t = new CubeRep();
        }
        return t;
    }

    private CubeRep() {
        this.temp = new Color[3];
        this.c = new Color[6][3][3];
        for (int i = 0; i < COLORS.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    c[i][j][k] = COLORS[i];
                }
            }
        }
    }

    public String findSolution() {
        return "";
    }

    public boolean isSolved() {
        for (int i = 0; i < COLORS.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (!c[i][j][k].equals(COLORS[i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Color getColor(int c, int x, int y) {
        return this.c[c][x][y];
    }

    private void rotateFace(int i) {
        Color t = this.c[i][0][0];
        this.c[i][0][0] = this.c[i][2][0];
        this.c[i][2][0] = this.c[i][2][2];
        this.c[i][2][2] = this.c[i][0][2];
        this.c[i][0][2] = t;
        t = this.c[i][0][1];
        this.c[i][0][1] = this.c[i][1][0];
        this.c[i][1][0] = this.c[i][2][1];
        this.c[i][2][1] = this.c[i][1][2];
        this.c[i][1][2] = t;
    }

    public void r() {
        for (int i = 0; i < 3; i++) {
            temp[i] = this.c[2][i][2];
        }
        for (int i = 0; i < 3; i++) {
            this.c[2][i][2] = this.c[5][i][2];
        }
        for (int i = 0; i < 3; i++) {
            this.c[5][i][2] = this.c[4][2 - i][0];
        }
        for (int i = 0; i < 3; i++) {
            this.c[4][2 - i][0] = this.c[0][i][2];
        }
        for (int i = 0; i < 3; i++) {
            this.c[0][i][2] = temp[i];
        }
        rotateFace(3);
    }

    public void rPrime() {
        for (int i = 0; i < 3; i++) {
            this.r();
        }
    }

    public void r2() {
        for (int i = 0; i < 2; i++) {
            this.r();
        }
    }

    public void u() {
        for (int i = 0; i < 3; i++) {
            temp[i] = this.c[2][0][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[2][0][i] = this.c[3][0][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[3][0][i] = this.c[4][0][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[4][0][i] = this.c[1][0][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[1][0][i] = temp[i];
        }
        rotateFace(0);
    }

    public void uPrime() {
        for (int i = 0; i < 3; i++) {
            this.u();
        }
    }

    public void u2() {
        for (int i = 0; i < 2; i++) {
            this.u();
        }
    }

    public void f() {
        for (int i = 0; i < 3; i++) {
            temp[i] = this.c[0][2][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[0][2][i] = this.c[1][2 - i][2];
        }
        for (int i = 0; i < 3; i++) {
            this.c[1][2 - i][2] = this.c[5][0][2 - i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[5][0][2 - i] = this.c[3][i][0];
        }
        for (int i = 0; i < 3; i++) {
            this.c[3][i][0] = temp[i];
        }
        rotateFace(2);
    }

    public void fPrime() {
        for (int i = 0; i < 3; i++) {
            this.f();
        }
    }

    public void f2() {
        for (int i = 0; i < 2; i++) {
            this.f();
        }
    }

    public void l() {
        for (int i = 0; i < 3; i++) {
            temp[i] = this.c[0][i][0];
        }
        for (int i = 0; i < 3; i++) {
            this.c[0][i][0] = this.c[4][2 - i][2];
        }
        for (int i = 0; i < 3; i++) {
            this.c[4][2 - i][2] = this.c[5][i][0];
        }
        for (int i = 0; i < 3; i++) {
            this.c[5][i][0] = this.c[2][i][0];
        }
        for (int i = 0; i < 3; i++) {
            this.c[2][i][0] = temp[i];
        }
        rotateFace(1);
    }

    public void lPrime() {
        for (int i = 0; i < 3; i++) {
            this.l();
        }
    }

    public void l2() {
        for (int i = 0; i < 2; i++) {
            this.l();
        }
    }

    public void d() {
        for (int i = 0; i < 3; i++) {
            temp[i] = this.c[2][2][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[2][2][i] = this.c[1][2][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[1][2][i] = this.c[4][2][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[4][2][i] = this.c[3][2][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[3][2][i] = temp[i];
        }
        rotateFace(5);
    }

    public void dPrime() {
        for (int i = 0; i < 3; i++) {
            this.d();
        }
    }

    public void d2() {
        for (int i = 0; i < 2; i++) {
            this.d();
        }
    }

    public void b() {
        for (int i = 0; i < 3; i++) {
            temp[i] = this.c[0][0][i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[0][0][i] = this.c[3][i][2];
        }
        for (int i = 0; i < 3; i++) {
            this.c[3][i][2] = this.c[5][2][2 - i];
        }
        for (int i = 0; i < 3; i++) {
            this.c[5][2][2 - i] = this.c[1][2 - i][0];
        }
        for (int i = 0; i < 3; i++) {
            this.c[1][2 - i][0] = temp[i];
        }
        rotateFace(4);
    }

    public void bPrime() {
        for (int i = 0; i < 3; i++) {
            this.b();
        }
    }

    public void b2() {
        for (int i = 0; i < 2; i++) {
            this.b();
        }
    }
}
