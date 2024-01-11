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
                System.out.println("Produit ajoutee : " + produit.getNom());
            } else {
                throw new IllegalArgumentException("Le prix et la quantitÃ© doivent Ãªtre positifs pour la creation du produit");
            }
        } else {
            throw new IllegalArgumentException("Un produit avec le meme Id ou nom existe deja ");
        }
    }
    public Produit ReadProduit(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }
        return null; 
    }

    public void UpdateProduit(Produit updatedProduit) throws IllegalArgumentException {
        for (Produit produit : produits) {
            if (produit.getId().equals(updatedProduit.getId())) {
                if (updatedProduit.getPrix() >= 0 && updatedProduit.getQuantite() >= 0) {
                    produit.setNom(updatedProduit.getNom());
                    produit.setPrix(updatedProduit.getPrix());
                    produit.setQuantite(updatedProduit.getQuantite());
                    System.out.println("Produit mis à jour : " + produit.getNom());
                } else {
                    throw new IllegalArgumentException("Le prix et la quantité doivent être positifs pour la mise à jour du produit");
                }
                return;
            }
        }
        throw new IllegalArgumentException("Produit non trouvé pour la mise à jour");
    }

    public void DeleteProduit(Long id) throws IllegalArgumentException {
        Produit produitToDelete = null;
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                produitToDelete = produit;
                break;
            }
        }
        if (produitToDelete != null) {
            produits.remove(produitToDelete);
            System.out.println("Produit supprimé");
        } else {
            throw new IllegalArgumentException("Aucun produit trouvé pour la suppression");
        }
    }
}
