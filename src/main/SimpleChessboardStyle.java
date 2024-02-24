package main;

import java.awt.*;

public class SimpleChessboardStyle implements ChessboardStyle{
    private Color colorLight;
    private Color colorDark;

    public SimpleChessboardStyle(Color colorLight, Color colorDark){
        this.colorLight = colorLight;
        this.colorDark = colorDark;
    }
    @Override
    public Color getSquareColor(boolean isLightSquare) {
        return isLightSquare ? colorLight : colorDark;
    }
}
