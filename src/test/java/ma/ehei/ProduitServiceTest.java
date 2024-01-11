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

}
