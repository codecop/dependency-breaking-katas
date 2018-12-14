package org.codecop.dependencies.extract_and_override_factory;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserConfirmation {

    private boolean accepted;

    public UserConfirmation(String message) {
        JFrame frame = new JFrame();
        frame.setVisible(true);

        int result = JOptionPane.showConfirmDialog(frame, message);
        accepted = result == JOptionPane.YES_OPTION;

        frame.setVisible(false);
        frame.dispose();
    }

    public boolean isAccepted() {
        return accepted;
    }

}
