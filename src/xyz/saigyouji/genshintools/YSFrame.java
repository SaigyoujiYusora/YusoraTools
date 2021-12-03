package xyz.saigyouji.genshintools;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class YSFrame {
    public static void main(String[] args) {
        MainFrame mainframe =new MainFrame("wuhu");
    }
    static class MainFrame extends Frame {
        public MainFrame(String title) {
            super(title);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setSize(400, 400);
            setBackground(new Color(253, 253, 253));
            setVisible(true);
            //listing mouse click exit button to exit
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                }
            });
        }
    }
}
