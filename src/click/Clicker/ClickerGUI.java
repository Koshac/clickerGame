package click.Clicker;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class ClickerGUI extends JDialog  {
    private JButton clickButton;
    private JButton upgradeButton;
    private JPanel clickerPanel;
    private JLabel cashMonitor;
    private JLabel upgradeCostMonitor;
    private int cash;
    private int costUpgrade;
    private  int plusCash;
    public ClickerGUI(){
        cash = 0;
        plusCash = 1;
        costUpgrade = 1;
        cashMonitor.setText(String.valueOf(cash));
        upgradeCostMonitor.setText(String.valueOf(costUpgrade));
        setContentPane(clickerPanel);
        setModal(true);
        getRootPane().setDefaultButton(clickButton);
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onClick();
            }
        });
        upgradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onUpgrade();
            }
        });
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    private  void onUpgrade(){
        if(cash > costUpgrade){
            int i = cash - costUpgrade;
            int i1 = plusCash + 1;
            int i2 = costUpgrade * 2;
            cash = i;
            plusCash = i1;
            costUpgrade = i2;
            cashMonitor.setText(String.valueOf(cash));
            upgradeCostMonitor.setText(String.valueOf(costUpgrade));
        }else if (cash == costUpgrade){
            int i = cash - costUpgrade;
            int i1 = plusCash + 1;
            int i2 = costUpgrade * 2;
            cash = i;
            plusCash = i1;
            costUpgrade = i2;
            cashMonitor.setText(String.valueOf(cash));
            upgradeCostMonitor.setText(String.valueOf(costUpgrade));
        }else{
            cashMonitor.setText("Недостаточно денег");
            try {
                Thread.currentThread().sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cashMonitor.setText(String.valueOf(cash));
        }
    }
    private void  onClick(){
        int i = cash + plusCash;
        cash = i;
        cashMonitor.setText(String.valueOf(cash));
    }
    public void start(){
        pack();
        clickerPanel.setSize(555,555);
        setVisible(true);
        System.exit(0);
    }
}
