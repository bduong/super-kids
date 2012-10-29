package superkidsapplication;

import superkidsapplication.panels.MainFrame;

public class Application {

    public static void main(String [] args) {
        setLookAndFeel();
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
