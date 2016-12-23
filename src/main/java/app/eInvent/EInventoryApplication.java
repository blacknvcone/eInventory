package app.eInvent;

import app.eInvent.eInventModel.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EInventoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(EInventoryApplication.class, args);

		/**
		 * Init class product
		 */
		Product product = new Product();

		/**
		 * Set dummy data product
		 */
		product.setProductName("Coklat");
		product.setProductPrice(10000);
		product.setProductStock(100);

		/**
		 * Save dummy data product
		 */
		AppContainer.getInstance().getProductDAO().saveProduct(product);
	}
}
