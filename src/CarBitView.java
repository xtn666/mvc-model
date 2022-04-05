import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import java.awt.*;


public class CarBitView extends JFrame implements Observer{

    private JFrame carJFrame = new JFrame();
    private JTextArea priceInfo =new JTextArea();
    private String price;
    CarModel cm;

    public void BitView()  {
        carJFrame=new JFrame("汽车竞价页面");
        priceInfo=new JTextArea();
        priceInfo.append("\n\t"+"竞价如下:"+"\r\n");
        carJFrame.add(priceInfo);
        carJFrame.setVisible(true);
        carJFrame.setSize(500, 400);
        //设置位置
        carJFrame.setLocation(1150, 50);
        carJFrame.setVisible(true);
    }

    public void setCarModel(CarModel cm){
        this.cm = cm;
    }

    public void update(String car){
        if( cm.getBitPrice() == "竞价错误"){
            priceInfo.append("\t竞拍价格不符合拍卖规则，请重新输入！\r\n");
            cm.setBitPrice("0");
        }else {
            priceInfo.append("\t当前" + car + "车型的竞价为" + cm.getBitPrice() + "元" + "\r\n");
        }
    }
}
