import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class CarPictureView extends JFrame implements Observer{

    CarModel cm ;
    private String carSelected;

    String file_path;
    JPanel imagePanel;
    ImageIcon background;
    JLabel label;
    File htmlFile;
    JTextArea cartext;
    JEditorPane editorPane;
    JScrollPane scrollPane;

    public void pictureView(String car) throws URISyntaxException, IOException {

        System.out.println("当前的车型为： "+car);
        if (label != null){
            this.remove(label);
        }

        //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
        file_path= this.getClass().getClassLoader().getResource("CarImages/"+car+".jpg").toURI().getPath();
        // 背景图片
        background = new ImageIcon(file_path);
        // 把背景图片显示在一个标签里面
        label = new JLabel(background);
        // 把标签的大小位置设置为图片刚好填充整个面板
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
        imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        setTitle("详细信息");
        //设置大小
        setSize(500, 400);
        //设置位置
        setLocation(200, 50);
        // 把背景图片添加到分层窗格的最底层作为背景
        this.add(label, BorderLayout.CENTER);
        //显示html文件的内容
        if (editorPane!= null){
            this.remove(editorPane);
        }
        editorPane = new JEditorPane();
        URL resource = getClass().getClassLoader().getResource("CarFiles/"+ car +".html");
        editorPane.setPage(resource);

        this.add(editorPane,BorderLayout.NORTH);
        this.setVisible(true);

    }

    @Override
    public void update(String car) throws URISyntaxException, IOException { pictureView(car); }
}
