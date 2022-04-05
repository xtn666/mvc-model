import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CarModel implements Observable{

    private List<Observer> observerList;
    private URL imgURL;
    private ImageIcon imgIcon;
    private URL carFileUrl;
    private String[] carNameList;
    private String carSelected;
    private String bitPrice;
    static final String CARFILES = "./CarFiles/";
    static final String CARIMAGES = "./CarImages/";

    public ImageIcon getImgIcon() {
        return imgIcon;
    }

    public CarModel() {
        carNameList = new String[20];
        observerList = new ArrayList<Observer>();
        bitPrice = null;
        observerList = new ArrayList<>();
    }

    public void setImgIcon() {
        String iconStr = CARIMAGES + carSelected + ".jpg";
        imgIcon = createImgIcon(iconStr);
    }

    public String[] getCarNameList() {
        return carNameList;
    }

    public void setCarNameList(String[] carNameList) {
        this.carNameList = carNameList;
    }

    public String getCarSelected() {

        if(carSelected == null) {
            return "Honda Accord-2005";
        }
        return carSelected;
    }

    public void setCarSelected(String carSelected) {
        this.carSelected = carSelected;
    }

    public String getBitPrice() {
        return bitPrice;
    }

    public void setBitPrice(String bitPrice) {
        this.bitPrice = bitPrice;
    }

    public void setCarFileURL() {
        try{
            String fileURLStr = CARFILES + carSelected + ".html";
            carFileUrl = (new File(fileURLStr)).toURL();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    protected ImageIcon createImgIcon(String path){
        imgURL = getClass().getResource(path);
        if(imgURL != null){
            return new ImageIcon(imgURL);
        }
        else{
            System.out.println("Couldn't find file path: " + path);
            return null;
        }
    }

    @Override
    public void notifyObservers() throws URISyntaxException, IOException {
        System.out.println(getBitPrice()+"   12312");

        for (Observer observer : observerList) {
            observer.update(getCarSelected());
        }
    }

    @Override
    public void addObservers(Observer obs) {
            observerList.add(obs);
    }
}
