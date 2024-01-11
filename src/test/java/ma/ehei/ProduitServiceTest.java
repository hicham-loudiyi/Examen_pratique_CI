package ma.ehei;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ProduitServiceTest {
	private ProduitService ps;
	
	@Before
	public void setup() {
		ps = new ProduitService();
	}
	
	@Test
    public void testCreateProduit() {
        Produit produit = new Produit(1L,"omo",12,100);
        ps.CreateProduit(produit);
        assertTrue(ps.getProduits().contains(produit));
    }
	
	@Test
    public void testReadProduit() {
        Produit produit = new Produit(1L,"omo",12,100);
        ps.CreateProduit(produit);
        assertTrue(ps.ReadProduit(1L).equals(produit));
    }
	
	@Test
    public void testUpdateProduit() {
        Produit produit = new Produit(1L,"omo",12,100);
        ps.CreateProduit(produit);
        Produit updatedProduit = new Produit(1L,"tide",11,100);
        ps.UpdateProduit(updatedProduit);
        assertTrue(ps.ReadProduit(1L).equals(updatedProduit));
    }
	@Test
    public void testDeleteProduit() {
        Produit produit = new Produit(1L,"omo",12,100);
        ps.CreateProduit(produit);
        ps.DeleteProduit(1L);
        assertTrue(ps.ReadProduit(1L) == null);
    }
	
	@Test
	public void testProduitExists() {
        Produit produit = new Produit(1L,"omo",12,100);
        ps.CreateProduit(produit);
        assertTrue(ps.produitExists(1L,"omo"));
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateExistingIdOrName() {
        Produit produit1 = new Produit(1L,"omo",12,100);
        Produit produit2 = new Produit(1L,"tide",12,100);
        ps.CreateProduit(produit1);
        ps.CreateProduit(produit2);
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateNegativePriceOrQuantity() {
        Produit produit = new Produit(1L,"omo",-12,-100);
        ps.CreateProduit(produit);
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testUpdateNegativePriceOrQuantity() {
		Produit produit = new Produit(1L,"omo",12,100);
        ps.CreateProduit(produit);
        Produit updatedProduit = new Produit(1L,"omo",-12,-100);
        ps.updateProduit(updatedProduit);
    }
	

}
