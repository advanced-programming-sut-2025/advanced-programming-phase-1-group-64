package StrdewValley.Models.Items.CrafingItems.Products;

import StrdewValley.Models.Time;

public enum ProductType {
    HONEY(new Product("Honey",75,new Time(4), 350));

    private final Product product;

    ProductType(Product product) {
        this.product = product;
    }
}
