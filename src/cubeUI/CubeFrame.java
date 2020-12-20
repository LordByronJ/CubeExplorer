package cubeUI;

import obj.CubeRep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CubeFrame extends JFrame {
    private CubeRep rep;
    private JPanel panel;

    public static void main(String[] args) {
        new CubeFrame();
    }

    public CubeFrame() {
        System.out.println("running");
        this.rep = CubeRep.getInstance();
        JFrame f = new JFrame("CubeFrame");
        f.setFocusable(true);
        f.addKeyListener(new Controls());
        f.setSize(1000, 750);
        f.setLocation(100,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel = new CubePane());
        f.pack();
        f.setVisible(true);
    }

    public class CubePane extends JPanel {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(750, 500);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 750, 500);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    g.setColor(rep.getColor(0, i, j));
                    g.fillRect(120 + j * 40, i * 40, 38, 38);
                }
            }
            for (int i = 1; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        g.setColor(rep.getColor(i, j, k));
                        g.fillRect((i - 1) * 120 + k * 40, 120 + j * 40, 38, 38);
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    g.setColor(rep.getColor(5, i, j));
                    g.fillRect(120 + j * 40, 240 + i * 40, 38, 38);
                }
            }
        }
    }

    public class Controls extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event) {
            switch (event.getKeyChar()) {
                case 'r':
                    rep.r();
                    break;
                case 'R':
                    rep.rPrime();
                    break;
                case 'u':
                    rep.u();
                    break;
                case 'U':
                    rep.uPrime();
                    break;
                case 'f':
                    rep.f();
                    break;
                case 'F':
                    rep.fPrime();
                    break;
                case 'l':
                    rep.l();
                    break;
                case 'L':
                    rep.lPrime();
                    break;
                case 'd':
                    rep.d();
                    break;
                case 'D':
                    rep.dPrime();
                    break;
                case 'b':
                    rep.b();
                    break;
                case 'B':
                    rep.bPrime();
                    break;
                default:
                    break;
            }
            System.out.println(event.getKeyChar());
            panel.repaint();
        }

        @Override
        public void keyReleased(KeyEvent event) {
        }
    }
}
