package dev.galasso.marketApp.service;

import dev.galasso.marketApp.model.Product;
import dev.galasso.marketApp.repository.ProductRepository;
import dev.galasso.marketApp.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProductTests {

   @Mock
   private ProductRepository repository;

   @InjectMocks
   private ProductServiceImpl service;

   private Integer existingId = 1;
   private Integer nonExistingId = 100;
   private String keyWord = "Pickles";
   private Product newProduct;
   private Product createdProduct;
   private ArrayList<Product> productsList;

   @BeforeEach
   public void setup() throws Exception{
      newProduct = new Product();
      newProduct.setName("Pickles");

      createdProduct = new Product();
      createdProduct.setName("Pickles");
      createdProduct.setId(1);

      productsList = new ArrayList<Product>();
      Product p1,p2;
      p1 = new Product();
      p1.setId(2);
      p1.setName("Pickles argentino");
      p2 = new Product();
      p2.setId(3);
      p2.setName("Pickles Tailandês");
      productsList.add(p1);
      productsList.add(p2);

      Mockito.when(repository.save(newProduct)).thenReturn(createdProduct);
      Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(new Product()));
      Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));
      Mockito.when(repository.findAllByNameContaining("Pepino")).thenReturn(new ArrayList<Product>());
      Mockito.when(repository.findAllByNameContaining(keyWord)).thenReturn(productsList);
   }

   @Test
   public void shouldRegisterProduct(){
      assertEquals(service.createProduct(newProduct), createdProduct);
   }

   @Test
   public void shouldReturnById(){
      assertNotNull(service.findById(existingId));
   }

   @Test
   public void shouldNotReturnById(){
      assertNull(service.findById(nonExistingId));
   }

   @Test
   public void shouldReturnListByKeyWord(){
      assertFalse(service.getProductByKeyWord(keyWord).isEmpty());
   }

   @Test
   public void shouldReturnEmptyList(){
       assertTrue(service.getProductByKeyWord("B").isEmpty());
   }
}
