package test;

import obj.CubeRep;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CubeRepTest {

    private final Color[][][] expected = {
            {
                    {Color.WHITE, Color.RED, Color.BLUE},
                    {Color.YELLOW, Color.WHITE, Color.GREEN},
                    {Color.YELLOW, Color.YELLOW, Color.YELLOW}
            },
            {
                    {Color.ORANGE, Color.RED, Color.RED},
                    {Color.BLUE, Color.ORANGE, Color.ORANGE},
                    {Color.ORANGE, Color.BLUE, Color.YELLOW}
            },
            {
                    {Color.GREEN, Color.BLUE, Color.BLUE},
                    {Color.YELLOW, Color.GREEN, Color.GREEN},
                    {Color.ORANGE, Color.GREEN, Color.GREEN}
            },
            {
                    {Color.RED, Color.YELLOW, Color.WHITE},
                    {Color.ORANGE, Color.RED, Color.RED},
                    {Color.ORANGE, Color.RED, Color.RED}
            },
            {
                    {Color.RED, Color.BLUE, Color.BLUE},
                    {Color.GREEN, Color.BLUE, Color.WHITE},
                    {Color.GREEN, Color.WHITE, Color.BLUE}
            },
            {
                    {Color.GREEN, Color.WHITE, Color.WHITE},
                    {Color.ORANGE, Color.YELLOW, Color.WHITE},
                    {Color.YELLOW, Color.ORANGE, Color.WHITE}
            }
    };

    @org.junit.jupiter.api.Test
    void testRots() {
        CubeRep t = CubeRep.getInstance();
        t.u();
        t.l();
        t.f();
        t.r();
        t.b();
        t.d();

        t.u2();
        t.l2();
        t.f2();
        t.r2();
        t.b2();
        t.d2();

        t.uPrime();
        t.lPrime();
        t.fPrime();
        t.rPrime();
        t.bPrime();
        t.dPrime();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    assertEquals(expected[i][j][k], t.getColor(i, j, k));
                }
            }
        }
    }
}