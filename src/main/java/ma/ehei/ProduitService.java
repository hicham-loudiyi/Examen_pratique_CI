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
    
    public boolean produitExists(Long id, String nom) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id) || produit.getNom().equals(nom)) {
                return true;
            }
        }
        return false; 
    }

    public void CreateProduit(Produit produit) throws IllegalArgumentException {
        if (!produitExists(produit.getId(), produit.getNom())) {
            if (produit.getPrix() >= 0 && produit.getQuantite() >= 0) {
                produits.add(produit);
                System.out.println("Produit ajouté : " + produit.getNom());
            } else {
                throw new IllegalArgumentException("Le prix et la quantité doivent être positifs pour la création du produit");
            }
        } else {
            throw new IllegalArgumentException("Un produit avec le même Id ou nom existe déjà");
        }
    }
}
