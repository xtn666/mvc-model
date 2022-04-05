import java.awt.*;		//导包
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import javax.swing.*;

//用户输入界面
public class CarAuctionGUI extends JFrame{	//继承JFrame顶层容器类

    //定义组件
    JPanel jp = new JPanel();		//创建面板
    JLabel jlb = new JLabel("Cars on auction: ");	//创建标签
    JButton search_btn = new JButton("Search");
    JButton exit_btn = new JButton("Exit");
    JButton bit_btn = new JButton("Bit");
    String []cars = {"Honda Accord-2005","Honda Civic-2006","Toyota Camry-2003","Toyota Corolla-2002"};	//创建车型
    JComboBox jcb = new JComboBox(cars);		//把汽车添加到下拉框中
    TextField textField = new TextField("offer your bit price");


    CarPictureView cpv = new CarPictureView() ;
    CarBitView cbv = new CarBitView();
    private CarModel cm  ;


    public void MainGUI() throws URISyntaxException, IOException    //构造函数
    {
        cm = new CarModel();

        cm.addObservers(cpv);
        cm.addObservers(cbv);

        cm.setBitPrice(getBitPrice());

        Controller controller = new Controller(this,cm);
        search_btn.addActionListener(controller);
        bit_btn.addActionListener(controller);

        String car = jcb.getSelectedItem().toString();
        cpv.pictureView(car);
        cbv.BitView();
        cbv.setCarModel(cm);

        cm.setCarNameList(cars);

        //加入组件
        this.add(jp);    //添加面板

        //设置布局管理器
        jp.setLayout(null);

        jlb.setBounds(20, 20, 100, 30);
        jcb.setBounds(170, 20, 150, 30);
        search_btn.setBounds(50, 80, 90, 30);
        exit_btn.setBounds(150, 80, 70, 30);
        bit_btn.setBounds(20, 150, 70, 30);
        textField.setBounds(150, 150, 130, 30);

        jp.add(jlb);    //添加面板1的组件
        jp.add(jcb);
        jp.add(search_btn);
        jp.add(exit_btn);
        jp.add(bit_btn);
        jp.add(textField);

        //设置窗体属性
        this.setTitle("MVC pattern demo-Car auction");        //设置界面标题
        this.setSize(450, 300);                //设置界面像素
        this.setLocation(700, 120);            //设置界面初始位置
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置程序和界面一同关闭
        this.setVisible(true);                //设置界面可视化

    }


    public String getBitPrice(){
        if(textField.getText() == "offer your bit price"){
            return "0";
        }
        return	textField.getText();
    }

    public String getSelectedCar(){
        return (String)jcb.getSelectedItem();
    }

}
