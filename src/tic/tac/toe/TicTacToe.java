import javax.swing.JOptionPane;
public class TicTacToe extends javax.swing.JFrame {
    int turn =2;
    int buttonused[]={0,0,0,0,0,0,0,0,0};
    int playerXwon[]={0,0,0,0,0,0,0,0,0};
    int playerOwon[]={0,0,0,0,0,0,0,0,0};
    int scoreX = 0;
    int scoreO = 0;
    String playerXSymbol = "X";
    String playerOSymbol = "O";
    String playerXName = "Player X";
    String playerOName = "Player O";

    int playerXwon()
    {
        if(playerXwon[0]==1 && playerXwon[1]==1 && playerXwon[2]==1)
        {
           return 1;
        }
         if(playerXwon[3]==1 && playerXwon[4]==1 && playerXwon[5]==1)
        {
            scoreX++;
            updateScore();
            resetGame();
           return 1;
        }
          if(playerXwon[6]==1 && playerXwon[7]==1 && playerXwon[8]==1)
        {
            scoreX++;
            updateScore();
            resetGame();
           return 1;
        }
           if(playerXwon[0]==1 && playerXwon[3]==1 && playerXwon[6]==1)
        {
            scoreX++;
            updateScore();
            resetGame();
           return 1;
        }
            if(playerXwon[1]==1 && playerXwon[4]==1 && playerXwon[7]==1)
        {
            scoreX++;
            updateScore();
            resetGame();
           return 1;
        }
             if(playerXwon[2]==1 && playerXwon[5]==1 && playerXwon[8]==1)
        {
            scoreX++;
            updateScore();
            resetGame();
           return 1;
        }
              if(playerXwon[2]==1 && playerXwon[4]==1 && playerXwon[6]==1)
        {
            scoreX++;
            updateScore();
            resetGame();
           return 1;
        }
               if(playerXwon[0]==1 && playerXwon[4]==1 && playerXwon[8]==1)
        {
            scoreX++;
            updateScore();
            resetGame();
           return 1;
        }

               return 0;
    }

    //Checking if Player O Won
    //Similar to playerXwon(), but for Player O.
      int playerOwon()
    {
        if(playerOwon[0]==1 && playerOwon[1]==1 && playerOwon[2]==1)
        {
            scoreO++;
            updateScore();
            resetGame();
           return 1;
        }
         if(playerOwon[3]==1 && playerOwon[4]==1 && playerOwon[5]==1)
        {
             scoreO++;
            updateScore();
            resetGame();
           return 1;
        }
          if(playerOwon[6]==1 && playerOwon[7]==1 && playerOwon[8]==1)
        {
             scoreO++;
            updateScore();
            resetGame();
           return 1;
        }
           if(playerOwon[0]==1 && playerOwon[3]==1 && playerOwon[6]==1)
        {
             scoreO++;
            updateScore();
            resetGame();
           return 1;
        }
            if(playerOwon[1]==1 && playerOwon[4]==1 && playerOwon[7]==1)
        {
             scoreO++;
            updateScore();
            resetGame();
           return 1;
        }
             if(playerOwon[2]==1 && playerOwon[5]==1 && playerOwon[8]==1)
        {
             scoreO++;
            updateScore();
            resetGame();
           return 1;
        }
              if(playerOwon[2]==1 && playerOwon[4]==1 && playerOwon[6]==1)
        {
             scoreO++;
            updateScore();
            resetGame();
           return 1;
        }
               if(playerOwon[0]==1 && playerOwon[4]==1 && playerOwon[8]==1)
        {
             scoreO++;
            updateScore();
            resetGame();
           return 1;
        }
               return 0;
    }

      private void checkForDraw() {

    boolean allUsed = true;
    for (int i = 0; i < 9; i++) {
        if (buttonused[i] == 0) {
             allUsed = false;
            break;
        }
    }


    if (allUsed && playerXwon() == 0 && playerOwon() == 0) {
        JOptionPane.showMessageDialog(this, "It's a draw!");
        resetGame();
    }
}

      //String.valueOf is a static method in Java that converts different data types to their corresponding String representation
    private void updateScore() {
        jLabel6.setText(String.valueOf (scoreX));
        jLabel4.setText(String.valueOf(scoreO));
    }

    //Checking Final Winner
    //Compares the scores of Player X and Player O and announces the final winner or a tie.
    private void checkFinalWinner() {
    if (scoreX > scoreO) {
        JOptionPane.showMessageDialog(this,"Final winner is " + playerXName + " : "+scoreX);
    } else if (scoreO > scoreX) {
        JOptionPane.showMessageDialog(this,"Final winner is " + playerOName + " : "+ scoreO);
    } else {
        JOptionPane.showMessageDialog(this, "It's a tie! Both players have the same score: " + scoreX);
    }
}
    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttonused[i] = 0;
            playerXwon[i] = 0;
            playerOwon[i] = 0;
        }
        turn = 2;
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
    }

    //Constructor
    //Initializes the game components and sets up the game by prompting for player names, choosing the first player, and selecting symbols.
    public TicTacToe() {
        initComponents();
        choosePlayerNames();
        chooseFirstPlayer();
        choosePlayerSymbols();

    }

    private void choosePlayerNames() {
        playerXName = JOptionPane.showInputDialog(this, "Enter name for Player X:", "Player Name Input", JOptionPane.PLAIN_MESSAGE);
        playerOName = JOptionPane.showInputDialog(this, "Enter name for Player O:", "Player Name Input", JOptionPane.PLAIN_MESSAGE);


        if (playerXName == null || playerXName.trim().isEmpty()) {
            playerXName = "Player X";
        }
        if (playerOName == null || playerOName.trim().isEmpty()) {
            playerOName = "Player O";
        }
        jLabel2.setText(playerXName);
        jLabel3.setText(playerOName);
    }


     private void chooseFirstPlayer() {
        String[] options = {playerXName, playerOName};
        int firstPlayer = JOptionPane.showOptionDialog(this, "Who plays first?", "First Player Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        turn = firstPlayer;
    }


     private void choosePlayerSymbols() {
        String[] options = {"X", "O"};
        int choice = JOptionPane.showOptionDialog(this, "Choose your symbol", "Player Symbol Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            playerXSymbol = "X";
            playerOSymbol = "O";
        } else {
            playerXSymbol = "O";
            playerOSymbol = "X";
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        b0 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1200, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 600));

        jPanel1.setBackground(new java.awt.Color(152, 112, 112));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 600));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(241, 229, 209));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 65)); // NOI18N
        jLabel1.setText("Tic Tac Toe");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 550, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1140, 100));

        jPanel3.setBackground(new java.awt.Color(195, 152, 152));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b0.setBackground(new java.awt.Color(241, 229, 209));
        b0.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b0.setToolTipText("");
        b0.setMaximumSize(new java.awt.Dimension(150, 120));
        b0.setMinimumSize(new java.awt.Dimension(150, 120));
        b0.setPreferredSize(new java.awt.Dimension(150, 120));
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });
        jPanel3.add(b0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        b1.setBackground(new java.awt.Color(241, 229, 209));
        b1.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b1.setToolTipText("");
        b1.setMaximumSize(new java.awt.Dimension(150, 120));
        b1.setMinimumSize(new java.awt.Dimension(150, 120));
        b1.setPreferredSize(new java.awt.Dimension(150, 120));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel3.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        b2.setBackground(new java.awt.Color(241, 229, 209));
        b2.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b2.setToolTipText("");
        b2.setMaximumSize(new java.awt.Dimension(150, 120));
        b2.setMinimumSize(new java.awt.Dimension(150, 120));
        b2.setPreferredSize(new java.awt.Dimension(150, 120));
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel3.add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        b3.setBackground(new java.awt.Color(241, 229, 209));
        b3.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b3.setToolTipText("");
        b3.setMaximumSize(new java.awt.Dimension(150, 120));
        b3.setMinimumSize(new java.awt.Dimension(150, 120));
        b3.setPreferredSize(new java.awt.Dimension(150, 120));
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel3.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        b4.setBackground(new java.awt.Color(241, 229, 209));
        b4.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b4.setToolTipText("");
        b4.setMaximumSize(new java.awt.Dimension(150, 120));
        b4.setMinimumSize(new java.awt.Dimension(150, 120));
        b4.setPreferredSize(new java.awt.Dimension(150, 120));
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel3.add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        b5.setBackground(new java.awt.Color(241, 229, 209));
        b5.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b5.setToolTipText("");
        b5.setMaximumSize(new java.awt.Dimension(150, 120));
        b5.setMinimumSize(new java.awt.Dimension(150, 120));
        b5.setPreferredSize(new java.awt.Dimension(150, 120));
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        jPanel3.add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        b6.setBackground(new java.awt.Color(241, 229, 209));
        b6.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b6.setToolTipText("");
        b6.setMaximumSize(new java.awt.Dimension(150, 120));
        b6.setMinimumSize(new java.awt.Dimension(150, 120));
        b6.setPreferredSize(new java.awt.Dimension(150, 120));
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        jPanel3.add(b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        b7.setBackground(new java.awt.Color(241, 229, 209));
        b7.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b7.setToolTipText("");
        b7.setMaximumSize(new java.awt.Dimension(150, 120));
        b7.setMinimumSize(new java.awt.Dimension(150, 120));
        b7.setPreferredSize(new java.awt.Dimension(150, 120));
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });
        jPanel3.add(b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        b8.setBackground(new java.awt.Color(241, 229, 209));
        b8.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        b8.setMaximumSize(new java.awt.Dimension(150, 120));
        b8.setMinimumSize(new java.awt.Dimension(150, 120));
        b8.setPreferredSize(new java.awt.Dimension(150, 120));
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });
        jPanel3.add(b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 550, 420));

        jPanel5.setBackground(new java.awt.Color(195, 152, 152));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(219, 181, 181));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setBackground(new java.awt.Color(241, 229, 209));
        jButton10.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        jButton10.setText("New Game");
        jButton10.setMaximumSize(new java.awt.Dimension(315, 64));
        jButton10.setMinimumSize(new java.awt.Dimension(315, 64));
        jButton10.setPreferredSize(new java.awt.Dimension(315, 64));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 460, 70));

        jButton11.setBackground(new java.awt.Color(241, 229, 209));
        jButton11.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        jButton11.setText("Reset");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 220, 50));

        jButton12.setBackground(new java.awt.Color(241, 229, 209));
        jButton12.setFont(new java.awt.Font("Georgia", 3, 50)); // NOI18N
        jButton12.setText("Exit");
        jButton12.setMaximumSize(new java.awt.Dimension(173, 64));
        jButton12.setMinimumSize(new java.awt.Dimension(173, 64));
        jButton12.setPreferredSize(new java.awt.Dimension(173, 64));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 220, 50));

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 510, 170));

        jPanel6.setBackground(new java.awt.Color(219, 181, 181));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Georgia", 3, 45)); // NOI18N
        jLabel2.setText("Player 1:");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 60));

        jLabel3.setFont(new java.awt.Font("Georgia", 3, 45)); // NOI18N
        jLabel3.setText("Player 2:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 70));

        jLabel4.setBackground(new java.awt.Color(241, 229, 209));
        jLabel4.setFont(new java.awt.Font("Georgia", 3, 45)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("0");
        jLabel4.setOpaque(true);
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 190, 50));

        jLabel6.setBackground(new java.awt.Color(241, 229, 209));
        jLabel6.setFont(new java.awt.Font("Georgia", 3, 45)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("0");
        jLabel6.setOpaque(true);
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 190, 50));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 510, 170));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 550, 420));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
       if(buttonused[2]==0)
    {


        if(turn%2==0)
    {
        turn++;
        b2.setText(playerXSymbol);
        buttonused[2]=1;
        playerXwon[2]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b2.setText(playerOSymbol);
        buttonused[2]=1;
        playerOwon[2]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b2ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
       if(buttonused[4]==0)
    {


        if(turn%2==0)
    {
        turn++;
        b4.setText(playerXSymbol);
        buttonused[4]=1;
        playerXwon[4]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b4.setText(playerOSymbol);
        buttonused[4]=1;
        playerOwon[4]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b4ActionPerformed

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
    if(buttonused[0]==0)
    {

        if(turn%2==0)
    {
        turn++;
        b0.setText(playerXSymbol);
        buttonused[0]=1;
        playerXwon[0]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b0.setText(playerOSymbol);
        buttonused[0]=1;
        playerOwon[0]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b0ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if(buttonused[1]==0)
    {


        if(turn%2==0)
    {
        turn++;
        b1.setText(playerXSymbol);
        buttonused[1]=1;
        playerXwon[1]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b1.setText(playerOSymbol);
        buttonused[1]=1;
        playerOwon[1]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b1ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        if(buttonused[3]==0)
    {


        if(turn%2==0)
    {
        turn++;
        b3.setText(playerXSymbol);
        buttonused[3]=1;
        playerXwon[3]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b3.setText(playerOSymbol);
        buttonused[3]=1;
        playerOwon[3]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b3ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        if(buttonused[5]==0)
    {


        if(turn%2==0)
    {
        turn++;
        b5.setText(playerXSymbol);
        buttonused[5]=1;
        playerXwon[5]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b5.setText(playerOSymbol);
        buttonused[5]=1;
        playerOwon[5]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        if(buttonused[6]==0)
    {


        if(turn%2==0)
    {
        turn++;
        b6.setText(playerXSymbol);
        buttonused[6]=1;
        playerXwon[6]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b6.setText(playerOSymbol);
        buttonused[6]=1;
        playerOwon[6]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        if(buttonused[7]==0)
    {


        if(turn%2==0)
    {
        turn++;
        b7.setText(playerXSymbol);
        buttonused[7]=1;
        playerXwon[7]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b7.setText(playerOSymbol);
        buttonused[7]=1;
        playerOwon[7]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    checkFinalWinner();
    choosePlayerSymbols();
        turn = 2;
    for (int i = 0; i < 9; i++) {
         buttonused[i] = 0;
         playerXwon[i] = 0;
         playerOwon[i] = 0;
    }
    scoreX = 0;
    scoreO = 0;
    updateScore();

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        checkFinalWinner();

    int confirm = JOptionPane.showConfirmDialog(this, "Confirm if you want to exit", "Tic Tac Toe", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0);
    }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        if(buttonused[8]==0)
    {


        if(turn%2==0)
    {
        turn++;
        b8.setText(playerXSymbol);
        buttonused[8]=1;
        playerXwon[8]=1;

        int result1=playerXwon();
        int result2=playerOwon();

        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
    else
    {
        turn++;
        b8.setText(playerOSymbol);
        buttonused[8]=1;
        playerOwon[8]=1;
        int result1=playerXwon();
        int result2=playerOwon();
        if(result1==1)
        {
        JOptionPane.showMessageDialog(this, playerXName + " won!");
        }
        else if (result2==1)
        {
           JOptionPane.showMessageDialog(this, playerOName + " won!");
        }
    }
        checkForDraw();
    }
        else{
                JOptionPane.showMessageDialog(rootPane,"This Button is already used!");
                }
    }//GEN-LAST:event_b8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        b0.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");

        turn=2;
        for(int i=0;i<9;i++)
        {
            buttonused[i]=0;
        }
         for(int i=0;i<9;i++)
        {
            playerXwon[i]=0;
        }
          for(int i=0;i<9;i++)
        {
            playerOwon[i]=0;
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
