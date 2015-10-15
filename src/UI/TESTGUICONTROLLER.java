package UI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tobias on 15/10/15.
 */
public class TESTGUICONTROLLER {

    public static void main (String []args){

        private MyFrame myFrame;
        private ContainerPanel containerPanel;

        public TESTGUICONTROLLER()
        {
            myFrame = new MyFrame();
        }


    public void injectListeners()
    {
        // Login, logout and forgot password actionlisteners
        ContainerPanel.getLoginPanel().addActionListener(new LoginActionListener());

    }

    public MyFrame getMyframe()
    {
        return myFrame;
    }

   /* private class LoginActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ac)
        {
          if (ac.getActionCommand().equals("DoLogin"))
            {
                // Vertificerer om brugeren eksisterer i databasen
                 currentUser = dbConnection.autorizeAndGetUser(containerPanel.getLoginPanel().getTextFieldUserName(), containerPanel.getLoginPanel().getTextFieldPassword());

                if (currentUser == null)
                {
                    containerPanel.getLoginPanel().setError("username or password is incorrect...");
                }
                // Om currentUser ikke har admin rettigheder indlogges currentUser som bruger
                else if (currentUser.isAdminRights() == false)
                {
                    containerPanel.getUserContainerPanel().getUserInfo()
                            .setLabelUserName(currentUser.getUsername());
                    autoUpdateBalanceExchangeRate();
                    userListeners.loadUserHistoryTable();
                    containerPanel.changePanel(ContainerPanel.USERPANEL);
                    userCenterPanel.changePanel(UserCenterPanel.HISTORY);
                }
                // Om currentUser har admin rettigheder indlogges currentUser som administrator
                else if (currentUser.isAdminRights() == true)
                {
                    containerPanel.getAdminContainerPanel().getAdminNorthInfo()
                            .setLblUserName(currentUser.getUsername());
                    setAdminInfo();
                    adminListeners.getAdminOptions().loadUserTable();
                    containerPanel.changePanel(ContainerPanel.ADMINPANEL);
                    adminCenterPanel.changePanel(AdminCenterPanel.EXCHANGERATE);
                }
            }*/
        }
    }


 /*   private class LogOutActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ac)
        {
            if (ac.getActionCommand().equals("DoLogOut"))
            {
                currentUser = null;
                containerPanel.getLoginPanel().setClearUserName();
                containerPanel.getLoginPanel().setClearPassword();
                containerPanel.getLoginPanel().setError("");
                containerPanel.changePanel(ContainerPanel.LOGINPANEL);
            }
        }
    }*/


    /*private class ForgotPassActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ac)
        {
            String actionC = ac.getActionCommand();
            boolean userToChangePasswordExists;
            String userToChangePassword = containerPanelResetPassword.getResetWelcome()
                    .getTextFieldUserNamePassReset();

            switch (actionC)
            {
                case "OpenForgotCheckUser":
                    myFrameResetPassword.setVisible(true);
                    containerPanelResetPassword.changePanel(ContainerPanelResetPassword.RESETWELCOME);
                    containerPanelResetPassword.getResetWelcome().setClearUserNamePassReset();
                    containerPanelResetPassword.getResetWelcome().setLblUserResetError("");
                    containerPanelResetPassword.getResetQuestion().setClearAnswer();
                    containerPanelResetPassword.getResetQuestion().setLblAnswerResetError("");
                    containerPanelResetPassword.getResetPassword().setClearPasswordReset();
                    containerPanelResetPassword.getResetPassword().setClearPasswordRepeat();
                    containerPanelResetPassword.getResetPassword().setLblPasswordResetError("");
                    break;

                case "ShowQuestion":
                    // Vertificerer om det indtastede brugernavn eksisterer i databasen
                    userToChangePasswordExists = dbConnection.userExistsInDb(userToChangePassword);
                    if (userToChangePasswordExists == false)
                    {
                        containerPanelResetPassword.getResetWelcome().setLblUserResetError("username not found");
                    }
                    else
                    {
                        containerPanelResetPassword.changePanel(ContainerPanelResetPassword.RESETQUESTION);

                        // Om brugeren eksisterer, men ikke har et secretQuestion udskrives en besked
                        if (dbConnection.getUserInfo(DbConnection.USERSECRETQUESTION, userToChangePassword) == null)
                        {
                            containerPanelResetPassword.getResetComplete().setLblResetYourPassword(
                                    "<html>No question & answer!!!<br><br>Please contact Mads Nyborg</html>");
                            containerPanelResetPassword.changePanel(ContainerPanelResetPassword.RESETCOMPLETE);
                        }
                        // Brugerne får angivet sit tilhoerende sporgsmål
                        else
                        {
                            containerPanelResetPassword.getResetQuestion().setLblQuestion(
                                    dbConnection.getUserInfo(DbConnection.USERSECRETQUESTION,
                                            userToChangePassword));
                        }
                    }
                    break;

                case "showPassword":

                    String userAnswer = dbConnection.getUserInfo(DbConnection.USERSECRETANSWER,
                            userToChangePassword);

                    // Vertificerer om brugerens indput stemmer overens med brugerens svar i databasen
                    if (userAnswer.equalsIgnoreCase(containerPanelResetPassword.getResetQuestion()
                            .getTextFieldAnswer()))
                    {
                        containerPanelResetPassword.changePanel(ContainerPanelResetPassword.RESETPASSWORD);
                    }
                    else
                    {
                        containerPanelResetPassword.getResetQuestion().setLblAnswerResetError(
                                "answer is not correct");
                    }
                    break;

                case "ShowComplete":

                    boolean changePasswordApproved = true;
                    boolean checkPasswordCharacter;
                    String password = containerPanelResetPassword.getResetPassword()
                            .getTextFieldUserNamePassReset();
                    String passwordRepeat = containerPanelResetPassword.getResetPassword()
                            .getTextFieldUserNamePassResetRepeat();

                    // Begraenser brugeren til kun at indtaste tal og bokstaver
                    Pattern p = Pattern.compile("[0-9a-zA-Z]+");
                    Matcher m = p.matcher(password);
                    checkPasswordCharacter = m.matches();

                    // Vertificerer om brugerens input overholder kravet om password laengde
                    if (password.length() <= 5 || password.length() >= 16)
                    {
                        containerPanelResetPassword.getResetPassword().setLblPasswordResetError(
                                "Password must be between 6-15 characters");
                        changePasswordApproved = false;
                    }
                    // Vertificerer om brugerens input kun indeholder tal og bogstaver
                    if (!checkPasswordCharacter)
                    {
                        containerPanelResetPassword.getResetPassword().setLblPasswordResetError(
                                "Only letters & numbers allowed");
                        changePasswordApproved = false;
                    }
                    // Vertificerer om brugerens to indtastede password er identisk
                    if (!password.equalsIgnoreCase(passwordRepeat))
                    {
                        containerPanelResetPassword.getResetPassword().setLblPasswordResetError(
                                "Passwords does not match");
                        changePasswordApproved = false;
                    }
                    // Saetter brugerens nye password
                    if (changePasswordApproved == true)
                    {
                        dbConnection.updatePassword(userToChangePassword, password);
                        containerPanelResetPassword.getResetComplete().setLblResetYourPassword(
                                "Password has now been reset!");
                        containerPanelResetPassword.changePanel(ContainerPanelResetPassword.RESETCOMPLETE);
                    }
                    break;

                case "Complete":
                    myFrameResetPassword.dispose();
                    break;
            }
        }
    }*/


/*    public void autoUpdateBalanceExchangeRate()
    {
        Timer timer = new Timer();
        try
        {
            timer.scheduleAtFixedRate(new TimerTask()
            {
                public void run()
                {
                    // Koerer kun om currentUser ikke er null
                    if (!(currentUser == null))
                    {
                        double dbBalance = dbConnection.getUserBalance(currentUser.getUsername());

                        // Saetter kun balancen fra databasen om den er uaendret
                        if (!(currentUser.getUserBalance() == dbBalance))
                        {
                            currentUser.setUserBalance(dbBalance);
                        }
                        exchangeRate = dbConnection.getExchangeRate();
                        userCenterPanel.getHistoryPanel().setLblExchangeRate(exchangeRate);
                        setUserLabels();
                    }
                    else
                    {
                        timer.cancel();
                    }
                }
            }, 0, 5000);
        } catch (IllegalStateException e)
        {
            e.printStackTrace();
        }
    }*/


 /*   public void setUserLabels()
    {
        double userBalance = currentUser.getUserBalance();
        ContainerPanelontainerPanel.getUserContainerPanel().getUserInfo().setLabelBalance(userBalance + " btc");
        userCenterPanel.getHistoryPanel().setLblExchangeRate(exchangeRate);
        userCenterPanel.getHistoryPanel().setLblBalanceDkrAmount(userBalance * exchangeRate);
        userCenterPanel.getHistoryPanel().setLblBalanceBtcAmount(userBalance);
    }*/


/*    public void setAdminInfo()
    {
        double exchangeRate = dbConnection.getExchangeRate();
        int sumBitcoins = dbConnection.getCountAll(DbConnection.COUNTBITCOINS);
        int numberOfUsers = dbConnection.getCountAll(DbConnection.COUNTUSERS);
        containerPanel.getAdminContainerPanel().getAdminNorthInfo().setLblExchangeRate(exchangeRate);
        adminCenterPanel.getInfoPanel().setLblExhangeRate(exchangeRate);
        adminCenterPanel.getInfoPanel().setLblNumberUsers(numberOfUsers);
        adminCenterPanel.getInfoPanel().setLblBitcoins(sumBitcoins);
        adminCenterPanel.getInfoPanel().setLblDkr(sumBitcoins * exchangeRate);
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public DbConnection getDbConnection()
    {
        return dbConnection;
    }*/


}
