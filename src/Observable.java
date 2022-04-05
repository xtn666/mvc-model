import java.io.IOException;
import java.net.URISyntaxException;

public interface Observable {
    public void notifyObservers() throws URISyntaxException, IOException;
    public void addObservers(Observer obs);
}
