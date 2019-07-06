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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RendererPunto implements GLEventListener ,MouseListener, MouseMotionListener {

    private Punto punto;
    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    double theta;
    
    double Rotacion;
 
    double Sx;
    double Sy;
    double Sz;

    
    public RendererPunto() {
        punto = new Punto();
        glu = new GLU();
        glut = new GLUT();
       
        Rotacion = 0;
        Sx = 1;
        Sy = 1;
        Sz = 1;
        theta=0;

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

        glu.gluPerspective(60.0, aspect, 0.1, 1000.0);

        gl.glMatrixMode(GL2.GL_MODELVIEW);

        glu.gluLookAt(10, 0, 50,
                      0, 0, 0, 
                      0, 1, 0);

        gl.glDrawBuffer(GL2.GL_FRONT_AND_BACK);

    }

    @Override
    public void dispose(GLAutoDrawable glad) {

    }

    @Override

    public void display(GLAutoDrawable glad) {
        // invocar al encargado de dibujar (canvas)
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl = glad.getGL().getGL2();
        //cubo1
        this.Cubo();
        //cubo2
        this.Cubo1();
        //cubo3
        this.Cubo2();
        //cubo4
        this.Cubo3();
        //cubo5
        this.Cubo4();
        //cubo6
        this.Cubo5();

    }

    public void Cubo() {
        gl.glPushMatrix();
        gl.glColor3d(1, 0, 0);
        gl.glTranslatef(0, 0, 0);
        gl.glRotated(theta, 0,1,0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();
    }

    public void Cubo1() {
        gl.glPushMatrix();
        gl.glColor3d(0, 1, 0);
        gl.glTranslatef(-15, 0, 0);
        gl.glRotated(theta, 0,1,0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();
    }

    public void Cubo2() {
        //Cubo
        gl.glPushMatrix();
        gl.glColor3d(0, 1, 0);
        gl.glTranslatef(15, 0, 0);
        gl.glRotated(theta, 0,1,0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();

    }

    public void Cubo3() {
        //Cubo
        gl.glPushMatrix();
        gl.glColor3d(0, 1, 0);
        gl.glTranslatef(-15, -15, 0);
        gl.glRotated(theta, 0,1,0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();

    }

    public void Cubo4() {
        //Cubo
        gl.glPushMatrix();
        gl.glColor3d(0, 1, 0);
        gl.glTranslatef(0, -15, 0);
        gl.glRotated(theta, 0,1,0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();

    }

    public void Cubo5() {
        //Cubo
        gl.glPushMatrix();
        gl.glColor3d(0, 1, 0);
        gl.glTranslatef(15, -15, 0);
        gl.glRotated(theta, 0,1,0);
        glut.glutSolidCube(10);
        gl.glPopMatrix();

    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
          
        int tempX = e.getX();
        int tempY = e.getY();
        System.out.println(" RatonX: "+ tempX+" - RatonY :"+tempY);

        Component c = e.getComponent();
        double width = c.getWidth() / 2;
        double height = c.getHeight() / 2;
        
        if((tempX >= 190) && (tempX <= 230)){
            System.out.println("funcion");
            theta = 60;
        }else if ((tempX >= 231) && (tempX <= 270)){
            System.err.println("regresa");
            theta=0;
            
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
     
      
        
       
        
        IU.AppPuntoIU.glCanvas.repaint();
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
