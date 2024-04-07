import java.util.Scanner;

public class Inventaire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Combien d'articles voulez-vous ajouter à l'inventaire ?");
        int nombreArticles = sc.nextInt();
        sc.nextLine(); // Pour consommer le saut de ligne après le nombre d'articles
        
        String[] nomsArticles = new String[nombreArticles];
        int[] quantitesArticles = new int[nombreArticles];
        double[] prixUnitaires = new double[nombreArticles];
        
        // Saisie des informations pour chaque article
        for (int i = 0; i < nombreArticles; i++) {
            System.out.println("Article " + (i + 1) + ":");
            System.out.println("Nom de l'article :");
            nomsArticles[i] = sc.nextLine();
            System.out.println("Quantité en stock :");
            quantitesArticles[i] = Integer.parseInt(sc.nextLine()); // Convertir la ligne en entier
            System.out.println("Prix unitaire :");
            prixUnitaires[i] = sc.nextDouble();
            sc.nextLine(); // Pour consommer le saut de ligne après le prix unitaire
        }
        System.out.println("Entrez le taux de TVA (en pourcentage, par exemple 20 pour 20%) :");
        final double tauxTVA = sc.nextDouble() / 100; // Converti en pourcentage

        System.out.println("Entrez le taux de TCC (en pourcentage, par exemple 5 pour 5%) :");
        final double tauxTCC = sc.nextDouble() / 100; // Converti en pourcentage
        
        // Affichage de l'inventaire
       // System.out.println("Récapitulatif de l'inventaire :");
       System.out.println("\nRécapitulatif de l'inventaire :");
       System.out.printf("%-20s %-15s %-15s %-15s%n", "Article", "Quantité", "Prix unitaire", "Valeur");
        double sommeTotale = 0.0;
        for (int i = 0; i < nombreArticles; i++) {
            double valeurArticle = quantitesArticles[i] * prixUnitaires[i];
            sommeTotale += valeurArticle;
            System.out.printf("%-20s %-15d %-15.2f %-15.2f%n", nomsArticles[i], quantitesArticles[i], prixUnitaires[i], valeurArticle);
            /*
            System.out.println("Article : " + nomsArticles[i] );
            System.out.println( " Quantité : " + quantitesArticles[i]); 
            System.out.println(  "Prix unitaire : " + prixUnitaires[i]);
            System.out.println( " Valeur : " + valeurArticle); */
                              
        }
        System.out.println("\nSomme totale de la valeur de l'inventaire : " + String.format("%.2f", sommeTotale));

       // System.out.println("Somme totale de la valeur de l'inventaire : " + sommeTotale);
       double montantTVA = sommeTotale * tauxTVA;
       double montantTCC = sommeTotale * tauxTCC;
       
       System.out.println("\nSomme totale de la valeur de l'inventaire : " + String.format("%.2f", sommeTotale));
       System.out.println("Montant TVA (" + (tauxTVA * 100) + "%) : " + String.format("%.2f", montantTVA));
       System.out.println("Montant TCC (" + (tauxTCC * 100) + "%) : " + String.format("%.2f", montantTCC));
       System.out.println("Total avec taxes : " + String.format("%.2f", sommeTotale + montantTVA + montantTCC));
       
       
        
        sc.close();
    }
}
