import java.util.*;

public class Main{
    
    static int budget = 600;
    
    public static void main(String [] args){
        
        List<String> result = possibleCombinations(budget);

        if(result.size() != 0){
            System.out.println("Available combinations obtained for budget of Rs - " + budget + " : are ");
            for(String res : result){
                System.out.println(res);
            }
        }else{
            System.out.println("Oops !!! could not find any valid combination for the  budget given .");
        }
    }

    public static List<String> possibleCombinations(int balance){
        
        int tshirtCost = 50;
        int jeansCost = 80;
        int jacketCost = 100;

        List<String> possibleCombinations = new ArrayList<>();

        for(int tshirtNum = 1; tshirtNum <= balance / tshirtCost; tshirtNum++){
            
            for(int jeansNum = 1; jeansNum <= balance / jeansCost; jeansNum++){
                
                for(int jacketNum = 1; jacketNum <= balance / jacketCost; jacketNum++){
                    
                    int totalBill = tshirtNum * tshirtCost + jeansNum * jeansCost + jacketNum * jacketCost;
                    
                    int remainingBalance = balance - totalBill;

                    // 1st condition : Ensure that every item is purchased atleast once
                    if(tshirtNum >= 1 && jeansNum >= 1 && jacketNum >= 1){
                        
                        // 2nd condition : Ensure that remaining balnce is  less than the cost of the least-priced item (T-shirt) i.e RS.50;
                        if(remainingBalance >= 0 && remainingBalance < tshirtCost){
                            possibleCombinations.add("T-shirts: " + tshirtNum + ", jeans: " + jeansNum + ", jackets: " + jacketNum);
                        }
                    }
                }
            }
        }

        return possibleCombinations;
    }
}
