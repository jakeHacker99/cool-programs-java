package udemymasterclass.collections;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread" , 20.5, 50);
        stockList.addStock(temp);

        temp = new StockItem("cake", 120.5, 10);
        stockList.addStock(temp);


        temp = new StockItem("capri sun cherry", 14.2 , 200);
        stockList.addStock(temp);


        temp = new StockItem("capri sun mango", 14.2 , 200);
        stockList.addStock(temp);


        temp = new StockItem("cola vanilj", 9.9 , 200);
        stockList.addStock(temp);


        temp = new StockItem("Maserati", 30_000, 2);
        stockList.addStock(temp);



        temp = new StockItem("ferrari", 10_000, 6);
        stockList.addStock(temp);



        temp = new StockItem("Lamborghini", 20_000, 1);
        stockList.addStock(temp);


        System.out.println(stockList);

    }
}
