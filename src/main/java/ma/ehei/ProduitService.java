package ma.ehei;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {
	private List<Produit> produits;
    
    public List<Produit> getProduits(){
    	return produits;
    }

    public ProduitService() {
        this.produits = new ArrayList<>();
    }
    
    public void afficher() {
		System.out.println("Liste des produits :");
		for(int i = 0; i < produits.size(); i++)
			System.out.println(produits.get(i));
	}
}
