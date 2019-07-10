/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

import MODELO.Punto;

import RENDERE.RendererPuntoNivel2;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Docente
 */
public class AppPuntoIU1Nivel2 extends javax.swing.JFrame {

    int status = 1;
    public static GLCanvas glCanvas;
    private RendererPuntoNivel2 rendererPunto;
    String jugador;
    JFrame ventana;

    public AppPuntoIU1Nivel2() {
        initComponents();
        cronometro.start();
        rendererPunto = new RendererPuntoNivel2();

        initCanvas();
        this.setLocationRelativeTo(null);
        this.Mostrar();

    }

    public void initCanvas() {

        GLProfile profile = GLProfile.getDefault();
        GLCapabilities glcaps = new GLCapabilities(profile);
        glCanvas = new GLCanvas(glcaps);

        glCanvas.addGLEventListener(rendererPunto);
        glCanvas.addMouseListener(rendererPunto);  //Evento Click
        glCanvas.addMouseMotionListener(rendererPunto);
        glCanvas.setFocusable(true);
        this.PanelJOGL.add(glCanvas);
        int w = this.PanelJOGL.getWidth();
        int h = this.PanelJOGL.getHeight();
        glCanvas.setSize(w, h);

    }
    //METODO RECUPERADO DE : Juego Memoria parte 3 netbeans java grafico
    //Link: https://www.youtube.com/watch?v=bxTRrzZuiqs
    public void Mostrar() {
        jugador = JOptionPane.showInputDialog(ventana, "Nombre del jugador", "Escribe aqui");
        while (jugador == null || jugador.compareTo("Escribe aqui") == 0 || jugador.compareTo("") == 0) {
            jugador = JOptionPane.showInputDialog(ventana, "Debes ingresar usuario", "Escribe aqui");
        }
        this.HOLAAA.setText("Jugador: " + jugador);

    }
    //METODO RECUPERADO DE : Agregar contador de tiempo a un frame en netbeans
    //Link: https://www.youtube.com/watch?v=jfpha2yzPLk&feature=youtu.be
    Thread cronometro = new Thread() {
        public void run() {
            int hor = 00, min = 00, seg = 00;
            for (;;) {
                try {
                    seg++;
                    if (seg > 59) {
                        seg = 0;
                        min++;
                    }
                    if (min > 59) {
                        seg = 0;
                        min = 0;
                        hor++;
                    }
                    if (seg == 10) {
                        JOptionPane.showMessageDialog(null, "Se acabo tu tiempo vuelve a intentarlo ");
                        dispose();
                        cronometro.stop();
//                        App_Juego vista = new App_Juego();
//                        

//                         vista.setVisible(true);
//                         dispose();
                    }
                    tiempo.setText(hor + ":" + min + ":" + seg);
                    Thread.sleep(999);
                } catch (InterruptedException e) {

                }

            }
        }

    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider2 = new javax.swing.JSlider();
        PanelJOGL = new javax.swing.JPanel();
        tiempo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Secuencia = new javax.swing.JButton();
        HOLAAA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelJOGL.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualizacion OpenGL"));

        javax.swing.GroupLayout PanelJOGLLayout = new javax.swing.GroupLayout(PanelJOGL);
        PanelJOGL.setLayout(PanelJOGLLayout);
        PanelJOGLLayout.setHorizontalGroup(
            PanelJOGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        PanelJOGLLayout.setVerticalGroup(
            PanelJOGLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        tiempo.setText("00:00:00");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Secuencia.setText("Detener");
        Secuencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecuenciaActionPerformed(evt);
            }
        });

        HOLAAA.setText("Jugador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelJOGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Secuencia)
                        .addGap(18, 18, 18)
                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HOLAAA)
                        .addGap(124, 124, 124)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HOLAAA)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelJOGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Secuencia)
                    .addComponent(tiempo)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SecuenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecuenciaActionPerformed
        if (status == 1) {
            cronometro.suspend();
            Secuencia.setText("Continuar");
            status = 0;
        } else {
            cronometro.resume();
            Secuencia.setText("Detener");
            status = 1;
        }
    }//GEN-LAST:event_SecuenciaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppPuntoIU1Nivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppPuntoIU1Nivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppPuntoIU1Nivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppPuntoIU1Nivel2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppPuntoIU1Nivel2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HOLAAA;
    private javax.swing.JPanel PanelJOGL;
    private javax.swing.JButton Secuencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables
}
