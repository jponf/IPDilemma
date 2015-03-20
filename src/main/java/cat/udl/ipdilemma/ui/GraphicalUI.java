/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.udl.ipdilemma.ui;

import cat.udl.ipdilemma.Play;
import cat.udl.ipdilemma.PlayBuilder;
import cat.udl.ipdilemma.Register;
import cat.udl.ipdilemma.RoundInfo;
import cat.udl.ipdilemma.exceptions.NonExistingException;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author josep
 */
public class GraphicalUI extends javax.swing.JFrame implements Observer {

	// Represents a prisoner's dilemma game
	Play game;

	/**
	 * Creates new form GraphicalUI
	 */
	public GraphicalUI() {
		// Auto Generated code, initializes all the GUI components
		initComponents();

		// fill the combo boxes
		setPlayerStrategiesBoxes();

		// Set table alignment
		setTableColumnAlignment();
		
		// Confiugure message text area
		setUpMessageTextArea();
	}

	/**
	 * Fill the combo box with the available strategies
	 */
	private void setPlayerStrategiesBoxes() {
		Register reg = Register.getRegister();

		int index = 0;
		for (String name : reg.getRegisteredNames()) {
			playera_combobox.insertItemAt(name, index);
			playerb_combobox.insertItemAt(name, index);
			index++;
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

        set_button = new javax.swing.JButton();
        reset_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        message_textarea = new javax.swing.JTextArea();
        run_round_button = new javax.swing.JButton();
        run_all_button = new javax.swing.JButton();
        temptation_label = new javax.swing.JLabel();
        reward_label = new javax.swing.JLabel();
        punishment_label = new javax.swing.JLabel();
        sucker_label = new javax.swing.JLabel();
        temptation_textfield = new javax.swing.JTextField();
        reward_textfield = new javax.swing.JTextField();
        punishment_textfield = new javax.swing.JTextField();
        sucker_textfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        playera_combobox = new javax.swing.JComboBox();
        playerb_combobox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        rounds_textfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        set_button.setText("Set Game");
        set_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                set_buttonActionPerformed(evt);
            }
        });

        reset_button.setText("Reset");
        reset_button.setEnabled(false);
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        result_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Round", "Player A action", "Player A Score", "Player B action", "Player B Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        result_table.setFocusable(false);
        jScrollPane1.setViewportView(result_table);

        message_textarea.setEditable(false);
        message_textarea.setColumns(25);
        message_textarea.setLineWrap(true);
        message_textarea.setRows(5);
        message_textarea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(message_textarea);

        run_round_button.setText("Run Round");
        run_round_button.setEnabled(false);
        run_round_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                run_round_buttonActionPerformed(evt);
            }
        });

        run_all_button.setText("Run All");
        run_all_button.setEnabled(false);
        run_all_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                run_all_buttonActionPerformed(evt);
            }
        });

        temptation_label.setText("(T)emptation:");

        reward_label.setText("(R)eward:");

        punishment_label.setText("(P)unishment:");

        sucker_label.setText("(S)ucker:");

        jLabel1.setText("Player A Strategy:");

        jLabel2.setText("Player B Strategy:");

        playera_combobox.setActionCommand("");

        playerb_combobox.setActionCommand("");

        jLabel3.setText("Rounds:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(set_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset_button)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(run_round_button)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(run_all_button)
                            .addComponent(rounds_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(temptation_label)
                                .addGap(4, 4, 4)
                                .addComponent(temptation_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reward_label)
                                .addGap(3, 3, 3)
                                .addComponent(reward_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playera_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(punishment_label)
                                .addGap(2, 2, 2)
                                .addComponent(punishment_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sucker_label)
                                .addGap(4, 4, 4)
                                .addComponent(sucker_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerb_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(sucker_label)
                    .addComponent(punishment_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sucker_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(punishment_label)
                    .addComponent(temptation_label)
                    .addComponent(reward_label)
                    .addComponent(reward_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temptation_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(playera_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerb_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rounds_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(set_button)
                                .addComponent(reset_button))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(run_round_button)
                                .addComponent(run_all_button))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * Executed when reset button is clicked
	 *
	 * @param evt
	 */
    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
		game = null;
		reset_button.setEnabled(false);
		run_all_button.setEnabled(false);
		run_round_button.setEnabled(false);

		set_button.setEnabled(true);

		DefaultTableModel dm = (DefaultTableModel) result_table.getModel();
		for (int i = dm.getRowCount() - 1; i >= 0; i--) {
			dm.removeRow(i);
		}
    }//GEN-LAST:event_reset_buttonActionPerformed

	/**
	 * Executed when set button is clicked
	 *
	 * @param evt
	 */
    private void set_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_set_buttonActionPerformed
		PlayBuilder builder = new PlayBuilder();

		boolean good_data = true;
		good_data &= setUtilityMatrix(builder);
		good_data &= setPlayerStrategies(builder);
		good_data &= setNumberOfRounds(builder);

		if (good_data) {
			game = builder.create();
			game.addObserver(this);			// Add this as observer
			set_button.setEnabled(false);
			reset_button.setEnabled(true);
			run_all_button.setEnabled(true);
			run_round_button.setEnabled(true);
			message_textarea.append("Game set correctly :)\n");
		}
    }//GEN-LAST:event_set_buttonActionPerformed

	/**
	 * Executed when run round button is clicked
	 *
	 * @param evt
	 */
    private void run_round_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_run_round_buttonActionPerformed
		game.runRound();

		// No more rounds means it's necessary a new game
		if (!game.hasMoreRounds()) {
			message_textarea.append("Game Finished\n");
			run_all_button.setEnabled(false);
			run_round_button.setEnabled(false);
		}
    }//GEN-LAST:event_run_round_buttonActionPerformed

	/**
	 * Executed when run all button is clicked
	 *
	 * @param evt
	 */
    private void run_all_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_run_all_buttonActionPerformed
		game.runAll();
		message_textarea.append("Game Finished\n");
		run_all_button.setEnabled(false);
		run_round_button.setEnabled(false);
    }//GEN-LAST:event_run_all_buttonActionPerformed

	/**
	 * Executed by the game on every round
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (arg != null && arg.getClass() == RoundInfo.class) {
			RoundInfo rinfo = (RoundInfo) arg;

			DefaultTableModel dm = (DefaultTableModel) result_table.getModel();
			dm.addRow(new Object[]{
				String.valueOf(rinfo.getRoundNumber()),
				rinfo.getPlayerAAction().toString(),
				String.valueOf(rinfo.getPlayerAScore()),
				rinfo.getPlayerBAction().toString(),
				String.valueOf(rinfo.getPlayerBScore())
			});

			if (!game.hasMoreRounds()) {
				message_textarea.append("Final Socres\n");
				message_textarea.append("Player A: "
						+ String.valueOf(rinfo.getPlayerAScore()) + "\n");
				message_textarea.append("Player B: "
						+ String.valueOf(rinfo.getPlayerBScore()) + "\n");
			}

		}
	}

	/**
	 * Reads the utility matrix values and try to set it
	 *
	 * @param builder
	 * @return True if the matrix was created, false otherwise
	 */
	private boolean setUtilityMatrix(PlayBuilder builder) {
		int t = 0, r = 0, p = 0, s = 0;
		boolean good_values = true;

		// Read Temptation value
		try {
			t = Integer.parseInt(temptation_textfield.getText());
		} catch (NumberFormatException ex) {
			message_textarea.append("Invalid Integer value for temptation field\n");
			good_values = false;
		}

		// Read Reward value
		try {
			r = Integer.parseInt(reward_textfield.getText());
		} catch (NumberFormatException ex) {
			message_textarea.append("Invalid Integer value for reward field\n");
			good_values = false;
		}

		// Read Punishment value
		try {
			p = Integer.parseInt(punishment_textfield.getText());
		} catch (NumberFormatException ex) {
			message_textarea.append("Invalid Integer value for punishment field\n");
			good_values = false;
		}

		// Read Sucker value
		try {
			s = Integer.parseInt(sucker_textfield.getText());
		} catch (NumberFormatException ex) {
			message_textarea.append("Invalid Integer value for sucker field\n");
			good_values = false;
		}

		// Create matrix
		if (good_values) {
			try {
				builder.setUtilityMatrix(t, r, p, s);
			} catch (IllegalArgumentException ex) {
				message_textarea.append(ex.getMessage() + "\n");
				good_values = false;
			}
		}

		return good_values;
	}

	/**
	 * Read an sets the number of rounds
	 *
	 * @param builder
	 * @return
	 */
	private boolean setNumberOfRounds(PlayBuilder builder) {
		boolean good_value = false;

		try {
			int nrounds = Integer.parseInt(rounds_textfield.getText());
			builder.setNumberOfRounds(nrounds);
			good_value = true;
			
		} catch (NumberFormatException ex) {
			message_textarea.append("Invalid Integer value for Rounds field\n");
		} catch (IllegalArgumentException ex) {
			message_textarea.append(
						"The number of rounds must be greater than 0\n");
		}

		return good_value;
	}

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
			java.util.logging.Logger.getLogger(GraphicalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GraphicalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GraphicalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GraphicalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Set up register */
		IPDilemma.initializeRegister();

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GraphicalUI().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea message_textarea;
    private javax.swing.JComboBox playera_combobox;
    private javax.swing.JComboBox playerb_combobox;
    private javax.swing.JLabel punishment_label;
    private javax.swing.JTextField punishment_textfield;
    private javax.swing.JButton reset_button;
    private javax.swing.JTable result_table;
    private javax.swing.JLabel reward_label;
    private javax.swing.JTextField reward_textfield;
    private javax.swing.JTextField rounds_textfield;
    private javax.swing.JButton run_all_button;
    private javax.swing.JButton run_round_button;
    private javax.swing.JButton set_button;
    private javax.swing.JLabel sucker_label;
    private javax.swing.JTextField sucker_textfield;
    private javax.swing.JLabel temptation_label;
    private javax.swing.JTextField temptation_textfield;
    // End of variables declaration//GEN-END:variables

	/**
	 * Read and sets the player strategies
	 *
	 * @param builder
	 */
	private boolean setPlayerStrategies(PlayBuilder builder) {
		boolean good_values = true;

		String pa_strategy = (String) playera_combobox.getSelectedItem();

		// Read and set player A strategy
		if (pa_strategy != null) {
			try {
				builder.setPlayerAStrategy(pa_strategy);
			} catch (NonExistingException ex) {
				message_textarea.append(ex.getMessage() + "\n");
				good_values = false;
			}
		} else {
			message_textarea.append("Invalid strategy for player A\n");
			good_values = false;
		}

		// Read and set player B strategy
		String pb_strategy = (String) playerb_combobox.getSelectedItem();
		if (pb_strategy != null) {
			try {
				builder.setPlayerBStrategy(pb_strategy);
			} catch (NonExistingException ex) {
				message_textarea.append(ex.getMessage() + "\n");
				good_values = false;
			}
		} else {
			message_textarea.append("Invalid strategy for player B\n");
			good_values = false;
		}

		return good_values;
	}

	/**
	 * Set all the columns alignment
	 */
	private void setTableColumnAlignment() {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		Enumeration<TableColumn> tc = result_table.getColumnModel().getColumns();
		while (tc.hasMoreElements()) {
			tc.nextElement().setCellRenderer(centerRenderer);
		}
	}
	
	/**
	 * Configure message text area
	 */
	private void setUpMessageTextArea() {
		DefaultCaret caret = (DefaultCaret)message_textarea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		message_textarea.append("To start\n");
		message_textarea.append("1 - Introduce the payoff matrix values\n");
		message_textarea.append("2 - Chose the players strategies\n");
		message_textarea.append("3 - Introduce the number of rounds\n");
		message_textarea.append("4 - Click the 'Set Game' button\n");
		
	}
}