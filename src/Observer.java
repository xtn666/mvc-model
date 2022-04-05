import java.io.IOException;
import java.net.URISyntaxException;

public interface Observer {
    public void update(String car) throws URISyntaxException, IOException;
}
