import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Category> categoriesForImport = new ArrayList<>();
        try {
            JAXBContext context = JAXBContext.newInstance(ProductWrapper.class,Category.class,Product.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ProductWrapper wrapper = (ProductWrapper) unmarshaller.unmarshal(new File("categories.xml"));
            List<Category> c =wrapper.getCategories();
            System.out.println(c);
            for (Category category:c){
                if (category.getAverageProductPrice() > 300){
                    categoriesForImport.add(category);
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("categories.json"),categoriesForImport);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
