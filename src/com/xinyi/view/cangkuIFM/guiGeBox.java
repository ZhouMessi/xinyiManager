package com.xinyi.view.cangkuIFM;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class guiGeBox extends JPanel {

	public guiGeBox() {
		setBounds(0, 0, 650, 200);
        GridBagConstraints c = null;
        
        JButton btn00 = new JButton("颜色规格");
        JButton btn01 = new JButton("36#");
        JButton btn02 = new JButton("37#");
        JButton btn03 = new JButton("38#");
        JButton btn04 = new JButton("39#");
        JButton btn05 = new JButton("40#");
        JButton btn06 = new JButton("41#");
        JButton btn07 = new JButton("42#");
        JButton btn08 = new JButton("43#");
        JButton btn09 = new JButton("44#");
        JButton btn10 = new JButton("45#");
        JButton btn11 = new JButton("46#");
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;

        
        JButton btn00a = new JButton("颜色规格");
        JButton btn01a = new JButton("36#");
        JButton btn02a = new JButton("37#");
        JButton btn03a = new JButton("38#");
        JButton btn04a = new JButton("39#");
        JButton btn05a = new JButton("40#");
        JButton btn06a = new JButton("41#");
        JButton btn07a = new JButton("42#");
        JButton btn08a = new JButton("43#");
        JButton btn09a = new JButton("44#");
        JButton btn10a = new JButton("45#");
        JButton btn11a = new JButton("46#");
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(btn01, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        		.addComponent(btn02, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        		.addComponent(btn00, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        		.addComponent(btn04, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        		.addComponent(btn03, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(btn05, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        			.addComponent(btn06)
        			.addComponent(btn07)
        			.addComponent(btn08)
        			.addComponent(btn09)
        			.addComponent(btn10)
        			.addComponent(btn11)
        			.addComponent(btn00a)
        			.addComponent(btn01a)
        			.addComponent(btn02a)
        			.addComponent(btn03a)
        			.addComponent(btn04a)
        			.addComponent(btn05a)
        			.addComponent(btn06a)
        			.addComponent(btn07a)
        			.addComponent(btn08a)
        			.addComponent(btn09a)
        			.addComponent(btn10a)
        			.addComponent(btn11a))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btn01, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn02, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn00, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn04, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn03, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
        			.addGap(88)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btn05)
        				.addComponent(btn06)
        				.addComponent(btn07)
        				.addComponent(btn08)
        				.addComponent(btn09)
        				.addComponent(btn10)
        				.addComponent(btn11)
        				.addComponent(btn00a)
        				.addComponent(btn01a)
        				.addComponent(btn02a)
        				.addComponent(btn03a)
        				.addComponent(btn04a)
        				.addComponent(btn05a)
        				.addComponent(btn06a)
        				.addComponent(btn07a)
        				.addComponent(btn08a)
        				.addComponent(btn09a)
        				.addComponent(btn10a)
        				.addComponent(btn11a)))
        );
        setLayout(groupLayout);
	}

}
