import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public int tileSize = 85;

    final int cols = 8;
    final int rows = 8;


    ChessboardStyle simpleStyle = new SimpleChessboardStyle(new Color(238,238,210),new Color(118,150,86));

    public Board(){
        this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                g2d.setColor(simpleStyle.getSquareColor((c + r) % 2 == 0));
                g2d.fillRect(c*tileSize, r*tileSize, tileSize, tileSize);
            }

        }

    }
}
