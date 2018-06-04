/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perseguido.logica;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author daza
 */
public class Heroe implements Personaje {

    Image[][] imagenes = {{new ImageIcon(getClass().getResource("../imagenes/B1.png")).getImage(),
        new ImageIcon(getClass().getResource("../imagenes/B2.png")).getImage(),
        new ImageIcon(getClass().getResource("../imagenes/B3.png")).getImage()
    },
    {new ImageIcon(getClass().getResource("../imagenes/D1.png")).getImage(),
        new ImageIcon(getClass().getResource("../imagenes/D2.png")).getImage(),
        new ImageIcon(getClass().getResource("../imagenes/D3.png")).getImage()
    },
    {new ImageIcon(getClass().getResource("../imagenes/F1.png")).getImage(),
        new ImageIcon(getClass().getResource("../imagenes/F2.png")).getImage(),
        new ImageIcon(getClass().getResource("../imagenes/F3.png")).getImage()
    },
    {new ImageIcon(getClass().getResource("../imagenes/I1.png")).getImage(),
        new ImageIcon(getClass().getResource("../imagenes/I2.png")).getImage(),
        new ImageIcon(getClass().getResource("../imagenes/I3.png")).getImage()
    }
    };
    int sentido = 2;
    int cont = 0;
    Image imagen = imagenes[sentido][cont];
    int xPos = 40;
    int yPos = 36;
    int xVel = 0;
    int yVel = 0;

    @Override
    public void draw(Graphics g) {

        g.drawImage(imagen, xPos, yPos, null);
    }

    @Override
    public void update() {
        xPos += xVel;
        yPos += yVel;
        cont++;
        cont = cont % 3;
        imagen = imagenes[sentido][cont];

    }

    public void update(char c) {
        switch (c) {
            case 'a':
                sentido = 3;
                xPos += -32;
                yPos += 0;
                break;
            case 'w':
                sentido = 0;
                xPos += 0;
                yPos += -32;
                break;
            case 'd':
                sentido = 1;
                xPos += 32;
                yPos += 0;
                break;
            case 's':
                sentido = 2;
                xPos += 0;
                yPos += 32;
                break;
        }
        System.out.println(c);
    }

    @Override
    public void cambiarSentido() {
//        xVel *= -1;
//        yVel *= -1;
        switch (sentido) {
            case 0:
                xPos += 0;
                yPos += 32;
                break;
            case 1:
                xPos += -32;
                yPos += 0;
                break;
            case 2:
                xPos += 0;
                yPos += -32;
                break;
            case 3:
                xPos += 32;
                yPos += 0;
                break;
        }
    }

    @Override
    public Rectangle getRect() {
        Rectangle rect = null;
        rect = new Rectangle(xPos, yPos, imagen.getWidth(null), imagen.getHeight(null));
        return rect;
    }

    @Override
    public void update(int c) {
    }

}
