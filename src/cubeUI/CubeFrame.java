package cubeUI;

import obj.CubeRep;

import javax.swing.*;
import java.awt.*;

public class CubeFrame {
    private CubeRep rep;

    public static void main(String[] args) {
        try {
            CubeFrame prog = new CubeFrame();
            prog.run();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() throws Exception {
        this.rep = CubeRep.getInstance();
        JFrame f = new JFrame("CubeFrame");
        f.setSize(1000, 750);
        f.setLocation(100,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new CubePane());
        f.pack();
        f.setVisible(true);
    }

    public class CubePane extends JPanel {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(750, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 750, 500);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    g.setColor(rep.getColor(0, i, j));
                    g.fillRect(120 + i * 40, j * 40, 38, 38);
                }
            }
            for (int i = 1; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        g.setColor(rep.getColor(i, j, k));
                        g.fillRect((i - 1) * 120 + j * 40, 120 + k * 40, 38, 38);
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    g.setColor(rep.getColor(5, i, j));
                    g.fillRect(120 + i * 40, 240 + j * 40, 38, 38);
                }
            }
        }
    }
}
