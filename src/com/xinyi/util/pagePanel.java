package com.xinyi.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.xinyi.view.dingDanIFM;



public class pagePanel extends JPanel{
	
	  	private  JButton firstPageButton;//首页
	    
	  	private  JButton prevPageButton;//上一页
	    
	  	private  JTextField currentPageField;//当前页
	    
	  	private  JButton jumpPageButton;//跳页
	    
	  	private  JButton nextPageButton;//下一页
	    
	  	private  JButton LastPageButton;//尾页
	    
	  	private  JTextField totalPages;//总页数
	    
	  	private  JTextField totalRows;//总条数
	  	
	  	private dingDanIFM danIFM;
	    
	
	public pagePanel() {
		super();
		 // 创建 3 行 3 列 的网格布局
		setLayout(new GridLayout(1, 5));
		
		firstPageButton = new JButton("首页");
		firstPageButton.setFont(new Font("幼圆", Font.BOLD, 18));
		
		firstPageButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				paging(e);
			}
		});
        
		prevPageButton = new JButton("上一页");
		prevPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paging(e);
			}
		});
		prevPageButton.setFont(new Font("幼圆", Font.BOLD, 18));
        
		currentPageField = new JTextField();
		currentPageField.setFont(new Font("幼圆", Font.BOLD, 18));
        
		jumpPageButton = new JButton("跳页");
		jumpPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paging(e);
			}
		});
		
		jumpPageButton.setFont(new Font("幼圆", Font.BOLD, 18));
        
		nextPageButton = new JButton("下一页");
		nextPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paging(e);
			}
		});
		
		nextPageButton.setFont(new Font("幼圆", Font.BOLD, 18));
		
		
        
		LastPageButton = new JButton("尾页");
		LastPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paging(e);
			}
		});
		LastPageButton.setFont(new Font("幼圆", Font.BOLD, 18));
		
		JLabel jLabel1 = new JLabel(" 总页数: ");
		jLabel1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel jLabel2 = new JLabel(" 总条数: ");
		jLabel2.setFont(new Font("宋体", Font.BOLD, 18));
		
		totalPages = new JTextField();
		totalPages.setEditable(false);
		totalPages.setFont(new Font("幼圆", Font.BOLD, 18));       
		totalPages.setForeground(Color.RED);
		totalPages.setText("1");
        
		totalRows = new JTextField();
		totalRows.setEditable(false);
		totalRows.setFont(new Font("幼圆", Font.BOLD, 18));	  
		totalRows.setForeground(Color.RED);
		totalRows.setText("1");
        
        add(firstPageButton);
        add(prevPageButton);
        add(currentPageField);
        add(jumpPageButton);
        add(nextPageButton);
        add(LastPageButton);
        
        add(jLabel1);
        add(totalPages);
        add(jLabel2);
        add(totalRows);
        
        this.currentPageField.setText("1");
	}

	//处理翻页
	private void paging(ActionEvent e) {
		String eveString = e.getActionCommand();//获取事件源
		int currentPage = Integer.valueOf(this.currentPageField.getText());
		int totalPage = Integer.valueOf(this.totalPages.getText());
		switch (eveString) {
			case"首页":
				this.currentPageField.setText("1");
				this.prevPageButton.setEnabled(false);
				this.nextPageButton.setEnabled(true);
				this.danIFM.Search();
				break;
			case"上一页":
				currentPage--;
				if(currentPage > 1) {
					this.currentPageField.setText(String.valueOf(currentPage));
					this.nextPageButton.setEnabled(true);		
					this.danIFM.Search();
				}else{
					this.currentPageField.setText(String.valueOf("1"));
					this.prevPageButton.setEnabled(false);
					this.nextPageButton.setEnabled(true);		
					this.danIFM.Search();
				}
				break;
			case"跳页":
				if(currentPage<=1) {
					   this.currentPageField.setText(String.valueOf("1"));
						this.prevPageButton.setEnabled(false);
						this.nextPageButton.setEnabled(true);		
						this.danIFM.Search();
				   }else if (currentPage >= totalPage) {
					    this.currentPageField.setText(String.valueOf(totalPage));
						this.nextPageButton.setEnabled(false);
						this.prevPageButton.setEnabled(true);
						this.danIFM.Search();
				}else {
					    this.currentPageField.setText(String.valueOf(currentPage));
						this.nextPageButton.setEnabled(true);
						this.prevPageButton.setEnabled(true);
						this.danIFM.Search();
				}
				break;
			case"下一页":
				currentPage++;
				if(currentPage < totalPage) {
					this.currentPageField.setText(String.valueOf(currentPage));
					this.prevPageButton.setEnabled(true);
					this.danIFM.Search();
				}else {
					this.currentPageField.setText(String.valueOf(totalPage));
					this.nextPageButton.setEnabled(false);
					this.prevPageButton.setEnabled(true);
					this.danIFM.Search();
				}
				break;
			case"尾页":
				this.currentPageField.setText(this.totalPages.getText());
				this.prevPageButton.setEnabled(true);
				this.nextPageButton.setEnabled(false);
				this.danIFM.Search();
				break;
		}
	}



	public String getCurrentPageField() {
		return currentPageField.getText();
	}


	public void setCurrentPageField(String currentPageField) {
		this.currentPageField.setText(currentPageField);
	}


	public String getTotalPages() {
		return totalPages.getText();
	}


	public void setTotalPages(String totalPages) {
		this.totalPages.setText(totalPages);
	}


	public String getTotalRows() {
		return totalRows.getText();
	}


	public void setTotalRows(String totalRows) {
		this.totalRows.setText(totalRows); 
	}


	public dingDanIFM getDanIFM() {
		return danIFM;
	}


	public void setDanIFM(dingDanIFM danIFM) {
		this.danIFM = danIFM;
	}

	public void resetButton() {
		// TODO Auto-generated method stub
		this.prevPageButton.setEnabled(true);
		this.nextPageButton.setEnabled(true);
	}	
	
}
