package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tobias on 15/10/15.
 */
public class ContainerPanel extends JPanel {

    public static final String LOGINPANEL = "LOGINPANEL";
    public static final String USERPANEL = "USERNPANEL";
    public static final String ADMINPANEL = "ADMINPANEL";

    private LoginPanel loginPanel;
    private UserContainerPanel userPanel;
    //  private AdminContainerPanel adminPanel;

    private ContainerPanel container;
    private CardLayout layout;

    public ContainerPanel() {
        this.setLayout(new CardLayout());
        container = this;

        loginPanel = new LoginPanel();
        add(loginPanel, LOGINPANEL);

        /*userPanel = new UserContainerPanel();
        add(userPanel, CLIENTPANEL);*/

        //  adminPanel = new AdminContainerPanel();
        // add(adminPanel, ADMINPANEL);

        // foerste panel der koeres
        changePanel(LOGINPANEL);
    }


    public void changePanel(String panel) {
        layout = (CardLayout) this.getLayout();
        layout.show(container, panel);
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    /*public UserContainerPanel getUserContainerPanel() {
        return userPanel;
    }*/


}


