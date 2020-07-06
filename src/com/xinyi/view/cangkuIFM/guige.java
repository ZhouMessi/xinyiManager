package com.xinyi.view.cangkuIFM;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class guige extends JPanel {
	private  JTextField currentPageField = new JTextField();//颜色规格
	private JLabel thirty_six = new JLabel();//三十六
	private JLabel thirty_seven = new JLabel();//三十七
	private JLabel thirty_eight = new JLabel();//三十八
	private JLabel thirty_nine = new JLabel();//三十九
	private JLabel forty = new JLabel();//四十
	private JLabel forty_one = new JLabel();//四十一
	private JLabel forty_two = new JLabel();//四十二
	private JLabel forty_three = new JLabel();//四十三
	private JLabel forty_four = new JLabel();//四十四
	private JLabel forty_five = new JLabel();//四十五
	private JLabel forty_six = new JLabel();//四十六


	public guige() {
		setBounds(0, 0, 768, 256);
		
		GridBagLayout gridBag = new GridBagLayout();    // 布局管理器
        GridBagConstraints c = null;                    // 约束
        setLayout(gridBag);
        
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
        
        /* 添加 组件 和 约束 到 布局管理器 */
        // Button00  显示规格
        c = new GridBagConstraints();
        c.gridwidth = 2;
        gridBag.addLayoutComponent(btn00, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn01, c); // 内部使用的仅是 c 的副本
        
     // Button02
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn02, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn03, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn04, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn05, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn06, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn07, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn08, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn09, c); // 内部使用的仅是 c 的副本
        
     // Button01
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(btn10, c); // 内部使用的仅是 c 的副本
        
     // Button11 换行,
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(btn11, c); // 内部使用的仅是 c 的副本
        //==========添加输入框
        
        
       
        // Button00  颜色规格输入
        c = new GridBagConstraints();
        c.gridwidth = 2;
        gridBag.addLayoutComponent(this.currentPageField, c); // 内部使用的仅是 c 的副本
        
        // 36码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(thirty_six, c); // 内部使用的仅是 c 的副本
        
     // 37码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(thirty_seven, c); // 内部使用的仅是 c 的副本
        
     // 38码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(thirty_eight, c); // 内部使用的仅是 c 的副本
        
     // 39码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(thirty_nine, c); // 内部使用的仅是 c 的副本
        
     // 40码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(forty, c); // 内部使用的仅是 c 的副本
        
     // 41码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(forty_one, c); // 内部使用的仅是 c 的副本
        
     // 42码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(forty_two, c); // 内部使用的仅是 c 的副本
        
     // 43码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(forty_three, c); // 内部使用的仅是 c 的副本
        
        // 44码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(forty_four, c); // 内部使用的仅是 c 的副本
        
        // 45码
        c = new GridBagConstraints();
        gridBag.addLayoutComponent(forty_five, c); // 内部使用的仅是 c 的副本
        
        // 46码
        c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        gridBag.addLayoutComponent(forty_six, c); // 内部使用的仅是 c 的副本
        //添加组件到面板
//        this.add(btn00);
//        this.add(btn01);
//        this.add(btn02);
//        this.add(btn03);
//        this.add(btn04);
//        this.add(btn05);
//        this.add(btn06);
//        this.add(btn07);
//        this.add(btn08);
//        this.add(btn09);
//        this.add(btn10);
//        this.add(btn11);

        this.add(this.currentPageField);
        this.add(thirty_six);
        this.add(thirty_seven);
        this.add(thirty_eight);
        this.add(thirty_nine);
        this.add(forty);
        this.add(forty_one);
        this.add(forty_two);
        this.add(forty_three);
        this.add(forty_four);
        this.add(forty_five);
        this.add(forty_six);
        

	}
		
}
