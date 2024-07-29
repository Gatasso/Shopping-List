package dev.galasso.marketApp.service;

import dev.galasso.marketApp.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class ProductTests {

    @Autowired
    private ProductService service;

    private static Product newProduct;
    private static Product createdProduct;
    private static Integer idFound = 1;
    private static Integer idNotFound = 100;

    @BeforeAll
    public static void setup() {
        System.out.println("Configurando parâmetros de teste");

        newProduct = new Product();
        newProduct.setName("Pickles");

        createdProduct = new Product();
        createdProduct.setName("Pickles");
        createdProduct.setId(1);


//        service = Mockito.mock((ProductServiceImpl.class));
//        Mockito.when(service.createProduct(newProduct)).thenReturn(createdProduct);
//        System.out.println("Teste 1");
//        Mockito.when(service.alterProduct(createdProduct)).thenReturn(createdProduct);
//        System.out.println("Teste 2");
//        Mockito.when(service.getAllProducts()).thenReturn(new ArrayList<Product>());
//        System.out.println("Teste 3");
//        Mockito.when(service.getProductByKeyWord("palavra")).thenReturn(new ArrayList<Product>());
//        System.out.println("Teste 4");
//        Mockito.when(service.findById(idFound)).thenReturn(createdProduct);
//        System.out.println("Teste 5");
//        Mockito.when(service.findById(idNotFound)).thenReturn(null);
//        System.out.println("Teste 6");
    }

    @Test
    public void shouldStoreProduct(){
        System.out.println("Dentro do método shouldStoreProduct");
        assertNotNull(service.createProduct(newProduct));
    }
}
