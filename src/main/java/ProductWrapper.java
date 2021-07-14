import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "categories")
public class ProductWrapper {
private List<Category> categories;

    public ProductWrapper(List<Category> categories) {
        this.categories = categories;
    }

    public ProductWrapper(){}

    @XmlElement(name = "category")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
