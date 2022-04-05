import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

/*
    CarAuctionGUI -> Controller -> CarModel -> { CarBitView, CarPictrueView }
 */
public class Controller implements ActionListener {

    private CarAuctionGUI caGUI = new CarAuctionGUI();
    private CarPictureView cpv = new CarPictureView();
    private CarModel cm;
    private String carPrice;

    //初始化
    public Controller(CarAuctionGUI caGUI, CarModel cm) {
        this.caGUI = caGUI;
        this.cm = cm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Search")){
            String selectedCar = caGUI.getSelectedCar();
            cm.setCarSelected(selectedCar);
            cm.setCarFileURL();
            cm.setImgIcon();
            try {
                cm.notifyObservers();
            } catch (URISyntaxException | IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getActionCommand().equals("Bit")){
            carPrice = caGUI.getBitPrice();
            if(Integer.parseInt(carPrice) < Integer.parseInt(cm.getBitPrice())){
                cm.setBitPrice("竞价错误");
            }else{
                cm.setBitPrice(carPrice);
            }
            try {
                cm.notifyObservers();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
