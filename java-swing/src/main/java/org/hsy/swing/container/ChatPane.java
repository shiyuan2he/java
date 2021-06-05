package org.hsy.swing.container;

import javax.swing.*;
import java.awt.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.swing.container
 * @date 12/10/2017 2:49 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ChatPane {
    public static void main(String[] args){
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Login Pane");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * @description <p>局中显示</p>
         * @author heshiyuan
         * @date 12/10/2017 3:22 PM
         */
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int x = (int)(toolkit.getScreenSize().getWidth()-frame.getWidth())/2;
        int y = (int)(toolkit.getScreenSize().getHeight()-frame.getHeight())/2;
        frame.setLocation(x, y);
        // 局中显示第二种方法
        //frame.setLocationRelativeTo(null);
        JSplitPane splitPaneLeft = new JSplitPane();
        splitPaneLeft.setDividerLocation(100);
        frame.getContentPane().add(splitPaneLeft,BorderLayout.WEST) ;

        JSplitPane splitPaneRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPaneRight.setLeftComponent(new JLabel("    2"));
        splitPaneRight.setRightComponent(new JLabel("    3"));
        splitPaneRight.setDividerLocation(30);
        splitPaneRight.setDividerSize(8);
        splitPaneRight.setOneTouchExpandable(true);
        splitPaneRight.setContinuousLayout(true);
        splitPaneRight.setRightComponent(splitPaneLeft);

        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        chatComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void chatComponents(JPanel panel) {
        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        /*panel.setLayout(new GridLayout(2,2));

        JTextArea chatTextArea = new JTextArea(25,50);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        panel.add(scrollPane,BorderLayout.NORTH);

        JTextArea chatRecord = new JTextArea(25,50);
        JScrollPane scrollPane2 = new JScrollPane(chatRecord);
        panel.add(scrollPane2,BorderLayout.NORTH);

        JTextField textField = new JTextField("请输入聊天内容") ;
        textField.setBounds(10,470,590,80);
        panel.add(textField,BorderLayout.WEST);*/

        panel.setBackground(Color.darkGray);
    }
}
