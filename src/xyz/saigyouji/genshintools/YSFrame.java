package xyz.saigyouji.genshintools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class YSFrame {
    public static void main(String[] args) {
        new MainFrame("原神小工具");
    }
}
class MainFrame extends Frame {
    public MainFrame(String title) {
        super(title);//标题


        //窗口大小背景
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(400, 400);
        setBackground(new Color(253, 253, 253));
        setVisible(true);


        Button button = new Button();
        CalculateButton calculateButton = new CalculateButton();
        button.addActionListener(calculateButton);


        Panel textZone = new Panel();
        Panel MainPanel = new Panel();

        MainPanel.add(textZone,BorderLayout.CENTER);
        MainPanel.setSize(200,20);


        TextField YS_input = new TextField();
//            YS_input.setSize(200,300);


        textZone.setLayout(new GridLayout(4,2,5,5));
        textZone.add(YS_input);

//            add(button,BorderLayout.CENTER);
        add(MainPanel,BorderLayout.CENTER);

        //listing mouse click exit button to exit
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class CalculateButton implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("CalculateButton");
    }
}