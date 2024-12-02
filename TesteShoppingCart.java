/**
* Engenharia de Software Moderna - Testes  (Cap. 8)
* Prof. Marco Tulio Valente
* 
* Exercício simples de teste de unidade (ShoppingCart)
*
*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class TesteShoppingCart {

  private ShoppingCart shoppingCart;

  @Before
  public void setUp() {
    shoppingCart = new ShoppingCart();
    shoppingCart.addItem(new Item("ESM", 65.0));
    shoppingCart.addItem(new Item("GoF", 120.0));
  }

  @Test
  public void testAddItem() {
    Item newItem = new Item("Teste", 75.0);
    shoppingCart.addItem(newItem);

    assertEquals(3, shoppingCart.getItemCount());
    assertTrue(shoppingCart.getItems().contains(newItem));
  }

  @Test
  public void testRemoveItem() {
    Item removedItem = shoppingCart.getItems().get(0);
    shoppingCart.removeItem(removedItem);

    assertEquals(1, shoppingCart.getItemCount());
    assertFalse(shoppingCart.getItems().contains(removedItem));
  }

  @Test
  public void testGetTotalPrice() {
    double totalPrice = shoppingCart.getTotalPrice();
    assertEquals(185.0, totalPrice, 0.001);
  }

  @Test
  public void testClearCart() {
    shoppingCart.clearCart();
    assertEquals(0, shoppingCart.getItemCount());
    assertEquals(0.0, shoppingCart.getTotalPrice(), 0.001);
  }
}