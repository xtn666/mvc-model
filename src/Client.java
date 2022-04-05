import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) throws URISyntaxException, IOException {	//主函数

        CarModel cm = new CarModel();
        CarAuctionGUI a = new CarAuctionGUI();
        a.MainGUI();

    }

}
