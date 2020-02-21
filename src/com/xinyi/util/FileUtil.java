package com.xinyi.util;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileUtil {
	
	
	 /*
     * 打开文件
     */
    public static String showFileOpenDialog(Component parent) {
    	String filePath = null;
    	
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();

        // 设置默认显示的文件夹为当前系统桌面
//        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());

        // 设置文件选择的模式（只选文件、只选文件夹、文件和文件均可选）
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // 设置是否允许多选
        fileChooser.setMultiSelectionEnabled(true);

        // 添加可用的文件过滤器（FileNameExtensionFilter 的第一个参数是描述, 后面是需要过滤的文件扩展名 可变参数）
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("zip(*.zip, *.rar)", "zip", "rar"));
        // 设置默认使用的文件过滤器
        fileChooser.setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));

        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"确定", 则获取选择的文件路径
            File file = fileChooser.getSelectedFile();

            // 如果允许选择多个文件, 则通过下面方法获取选择的所有文件
            // File[] files = fileChooser.getSelectedFiles();

            
            filePath = file.getAbsolutePath();
        }
        
        return filePath;
    }
    /**
     * 
     * @param parent 上传之后提示信息显示的组件
     * @param source 源文件的路径
     * @param dest 新文件的文件名(包含路径)
     */
    public static void copy(Component parent,String source, String dest) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File(source));
            out = new FileOutputStream(new File(dest));

            byte[] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "上传文件失败");
        } finally {         
           try {
			out.close();
			in.close();
		} catch (IOException e) {
			 JOptionPane.showMessageDialog(parent, "上传文件失败");
		}
        }
    }
    
    public static boolean deleteOldImg(String FileName) {
    		File file = new File(FileName);
    		return file.delete();
    }
    
    public static void main(String[] args) {
//		System.out.println(File.class.getResource("/images"));
    	System.out.println();
	}
}
