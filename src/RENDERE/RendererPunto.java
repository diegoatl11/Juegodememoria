/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RENDERE;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import MODELO.Punto;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class RendererPunto implements GLEventListener, MouseListener, MouseMotionListener {

    private Punto punto;
    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    double rot0, rot1, rot2, rot3, rot4, rot5;
   
    
    double scaX, scaY, scaZ;
    double Sx;
    double Sy;
    double Sz;

    //inicializamos la matriz para los colores 
    private int mat[][];
    //creamos un objeto de la clase Random
    public Random aleatorio;

    public RendererPunto() {
        punto = new Punto();
        glu = new GLU();
        glut = new GLUT();

      
        Sx = 1;
        Sy = 1;
        Sz = 1;
        rot0 = 0;
        rot1 = 0;
        rot2 = 0;
        rot3 = 0;
        rot4 = 0;
        rot5 = 0;

        scaX = 1;
        scaY = 1;
        scaZ = 1;
        
        //
        

        //ingresamos los parametros de filas y columnas
        mat = new int[2][3];
        //reservamos memoria de la clase Random
        aleatorio = new Random();

    }
    //nuevo Metodo
    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    @Override
    public void init(GLAutoDrawable glad) {

        gl = glad.getGL().getGL2();

        int w = ((Component) glad).getWidth();
        int h = ((Component) glad).getHeight();
        
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        double aspect = w / h;
        
        //LA PERPECTIVA
        glu.gluPerspective(60.0, aspect, 0.1, 1000.0);
        
        //ACCEDEMOS AL METODO  MATRIX MODE VISTA DE MODELO 
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        //ANGULO DE LA CAMARA
        glu.gluLookAt(0, 0, 50,
                0, 0, 0,
                0, 1, 0);

        gl.glDrawBuffer(GL2.GL_FRONT_AND_BACK);
        //INICIALIZAMOS ILUMINACION , LUZ  Y PROFUNDIDAD
        float position[] = {0f, 10f, 0f, 0f};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, position, 0);
        float diffuse[] = {.7f, .7f, 0.7f, 0f};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
        float ambient[] = {.2f, .2f, .2f, 0f};
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
        
        
        //HABILITAR ILUMINACION     
        gl.glEnable(GL2.GL_LIGHTING);
        //HABILITAR LA LUZ
        gl.glEnable(GL2.GL_LIGHT0);
        //HABILITAR PRUEBA DE PROFUNDIDAD
        gl.glEnable(GL2.GL_DEPTH_TEST);

    }

    @Override
    public void dispose(GLAutoDrawable glad) {

    }

    @Override

    public void display(GLAutoDrawable glad) {
        // invocar al encargado de dibujar (canvas)
        this.numerosAleatorios();

        gl = glad.getGL().getGL2();
        //RESETEAR EL COLOR
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glClearColor(0, 0, 0, 1);

        //CUBO1-----*
        gl.glPushMatrix();
       
        //INICIALIZAMOS UNA VARIABLE TIPO FLOAT DONDE HABILITAMOS EL COLOR DE LA ILUMINAZION 
        float material1[] = {mat[0][0], 0.4f, 0.5f, 0.5f};
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, material1, 0);

        gl.glTranslatef(0, 0, 0);
        gl.glRotated(rot0, 0, 1, 0);
        gl.glScaled(scaX, scaY, scaZ);
        glut.glutSolidCube(10);
        gl.glPopMatrix();
        
        //CUBO2-----*
        gl.glPushMatrix();
        //INICIALIZAMOS UNA VARIABLE TIPO FLOAT DONDE HABILITAMOS EL COLOR DE LA ILUMINAZION 
        float material2[] = {mat[0][1], 0.4f, 0.5f, 0.5f};
        //
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, material2, 0);
        
        gl.glColor3f(mat[0][1], 0, 1);
        gl.glTranslatef(-15, 0, 0);
        gl.glRotated(rot1, 0, 1, 0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();
        
        //CUBO3-----*

        gl.glPushMatrix();
        
        float material3[] = {mat[0][2], 0.4f, 0.5f, 0.5f};
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, material3, 0);
        
        gl.glColor3d(mat[0][2], 0, 1);
        gl.glTranslatef(15, 0, 0);
        gl.glRotated(rot2, 0, 1, 0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();
        //CUBO4-----*
        gl.glPushMatrix();
        
        float material4[] = {mat[1][0], 0.4f, 0.5f, 0.5f};
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, material4, 0);
        //INICIALIZAMOS UNA VARIABLE TIPO FLOAT DONDE HABILITAMOS EL COLOR DE LA ILUMINAZION 
        gl.glColor3f(mat[1][0], 0, 1);
        gl.glTranslatef(-15, -15, 0);
        gl.glScaled(scaX, scaY, scaZ);
        gl.glRotated(rot3, 0, 1, 0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();
        //CUBO5-----*
        gl.glPushMatrix();
        //INICIALIZAMOS UNA VARIABLE TIPO FLOAT DONDE HABILITAMOS EL COLOR DE LA ILUMINAZION 
        float material5[] = {mat[1][1], 0.4f, 0.5f, 0.5f};
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, material5, 0);
        
        gl.glColor3f(mat[1][1], 0, 1);
        gl.glTranslatef(0, -15, 0);
        gl.glRotated(rot4, 0, 1, 0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();
        //CUBO6-----*
        gl.glPushMatrix();
        //INICIALIZAMOS UNA VARIABLE TIPO FLOAT DONDE HABILITAMOS EL COLOR DE LA ILUMINAZION 
        float material6[] = {mat[1][2], 0.4f, 0.5f, 0.5f};
        gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, material6, 0);
        
        gl.glColor3f(mat[1][2], 0, 1);
        gl.glTranslatef(15, -15, 0);
        gl.glRotated(rot5, 0, 1, 0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();
        
        //valores de matriz  
//        System.out.println("numero  = "+ mat[0][0] );
//        System.out.println("numero  = "+ mat[0][1] );
//        System.out.println("numero  = "+ mat[0][2] );
//        System.out.println("numero  = "+ mat[1][0] );
//        System.out.println("numero  = "+ mat[1][1] );
//        System.out.println("numero  = "+ mat[1][2] );
//      
        System.out.println("hola");
              
    }
    //METODO RECUPERADO DE : Juego Memoria parte 3 netbeans java grafico
    //Link: https://www.youtube.com/watch?v=bxTRrzZuiqs
    public void numerosAleatorios() {

        int acumulador = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = 0;

            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = aleatorio.nextInt(3);
                do {
                    acumulador = 0;
                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (mat[i][j] == mat[k][l]) {
                                acumulador += 1;
                            }
                        }
                    }
                    if (acumulador == 3) {
                        mat[i][j] = aleatorio.nextInt(3);
                    }
                } while (acumulador == 3);
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + "   ");

            }
            System.out.println("");
        }

    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int tempX = e.getX();
        int tempY = e.getY();

        System.out.println(" RatonX: " + tempX + " - RatonY :" + tempY);

        Component c = e.getComponent();
        double width = c.getWidth() / 2;
        double height = c.getHeight() / 2;

        // cubo0
        if (tempX >= 190 && tempX <= 280) {
            
                System.out.println("funcion");
                scaX=0;
                scaY=0;
                scaZ=0;
            
        } 


    }

    @Override
    public void mousePressed(MouseEvent e) {

       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
