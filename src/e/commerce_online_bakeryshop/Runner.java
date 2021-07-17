/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce_online_bakeryshop;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *
 * @author Muhammad Ahmad Khan
 */
public class Runner {

    public static void main(String[] args) throws InvalidPriceException, InvalidProductCategoryException, InvalidCakeSizeException, InvalidPizzaSizeException, InvalidPhoneNumberException, InvalidEmailException, IDAlreadyExist {
        //Biscuits b1 = new Biscuits(12, "Biscuits", "bs01", 200, "Biscuits", true);

        ArrayList<Products> ProductList = Products.readAllData();
        ArrayList<Products> WishList = operations.readWishlistAllData();
        ArrayList<Products> Cart = new ArrayList<>();
        ArrayList<Cartj> Cartjarray = Cartj.readAllData();
        ArrayList<CheckOut> orders = new ArrayList<>();
        operations op = new operations();
        ArrayList<chekoutnew> orderss = chekoutnew.readAllData();
        for (chekoutnew c : orderss) {
            c.getName();
            System.out.println("Bill : " + c.Bill());
        }
        System.out.println("Cart");
        for (Cartj c : Cartjarray) {
            c.getPrduct().Display();
            System.out.println("Quantity : " + c.getQuantity());
        }

        try {
            int i = 1;
            do {
                System.out.println("                        ** Welcome to Online Bakery Shop **                        ");
                System.out.println("1.Home");
                System.out.println("2.Shop Now");
                System.out.println("3.Product Categories");
                System.out.println("4.Best Deals");
                System.out.println("5.Wishlist");
                System.out.println("6.Cart");
                System.out.println("7.Chekout");
                System.out.println("8.Contact Us");
                System.out.println("9.Term&Condition");
                System.out.println("10.Admin Login Here");
                System.out.println("0.Exit");
                Scanner input = new Scanner(System.in);
                System.out.println("Enter Your Choice...");
                int a = input.nextInt();
                switch (a) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("                        ** HOME **                        ");
                        if (ProductList.isEmpty()) {
                            System.out.println("Store is Empty");
                        } else {
                            try {
                                op.Home(ProductList);
                                System.out.println("1.Add to Cart");
                                System.out.println("2.Add to Wishlist");
                                System.out.println("Or Any Key to Move Forward");
                                int j = input.nextInt();
                                switch (j) {
                                    case 1:
                                        System.out.println("Enter Product ID");
                                        String idddh0 = input.next();
                                        op.idAlreadyExist(idddh0, ProductList);
                                        if (op.GetProductCategoryAgainstID(idddh0, ProductList).equalsIgnoreCase("pizza")) {
                                            System.out.println("Enter Pizza Size S|M|L");
                                            String s = input.next();
                                            try {
                                                op.Cart(0, idddh0, s, ProductList, Cart);
                                            } catch (InvalidPizzaSizeException ex) {
                                                System.out.println(ex.getMessage());
                                            }
                                            break;
                                        }
                                        if (op.GetProductCategoryAgainstID(idddh0, ProductList).equalsIgnoreCase("NormalCakes")) {
                                            System.out.println("Enter Weight of Cake in Pounds");
                                            int p = input.nextInt();
                                            op.Cart(p, idddh0, "", ProductList, Cart);
                                            break;
                                        }
                                        op.Cart(0, idddh0, "", ProductList, Cart);
                                        break;
                                    case 2:
                                        System.out.println("Enter Product ID");
                                        String idd = input.next();
                                        op.idAlreadyExist(idd, ProductList);
                                        op.Wishlist(idd, ProductList, WishList);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            } catch (Exception esss) {
                                System.out.println(esss.getMessage());
                            }
                        }
                        break;
                    case 2:
                        System.out.println("                        ** SHOP NOW **                        ");
                        if (ProductList.isEmpty()) {
                            System.out.println("There is No Product. Store is Empty");
                        } else {
                            try {
                                System.out.println("There Are " + ProductList.size() + " active Products in our Shop");
                                op.ShopNow(ProductList);
                                for (Products p : ProductList) {
                                    System.out.println(p.getQuantity());
                                }
                                for (Products p : ProductList) {

                                }
                                System.out.println("1.Add to Cart");
                                System.out.println("2.Add to Wishlist");
                                System.out.println("Or Any Key to Move Forward");
                                int k = input.nextInt();
                                switch (k) {
                                    case 1:
                                        System.out.println("Enter Product ID");
                                        String iddcd0 = input.next();
                                        op.idAlreadyExist(iddcd0, ProductList);
                                        if (op.GetProductCategoryAgainstID(iddcd0, ProductList).equalsIgnoreCase("pizza")) {
                                            System.out.println("Enter Pizza Size S|M|L");
                                            String s = input.next();
                                            op.Cart(0, iddcd0, s, ProductList, Cart);
                                            break;
                                        }
                                        if (op.GetProductCategoryAgainstID(iddcd0, ProductList).equalsIgnoreCase("NormalCakes")) {
                                            System.out.println("Enter Weight of Cake in Pounds");
                                            int p = input.nextInt();
                                            op.Cart(p, iddcd0, "", ProductList, Cart);
                                            break;
                                        }
                                        op.Cart(0, iddcd0, "", ProductList, Cart);
                                        break;
                                    case 2:
                                        System.out.println("Enter Product ID");
                                        String id1 = input.next();
                                        op.idAlreadyExist(id1, ProductList);
                                        op.Wishlist(id1, ProductList, WishList);
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            } catch (Exception esss) {
                                System.out.println(esss.getMessage());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("                        ** PRODUCT CATEGORIES **                        ");
                        try {
                            op.DisplayProductCategories();
                            System.out.println("Wanna Filter Product by there Categories..?");
                            System.out.print("Y/N  :  ");
                            String ch = input.next();
                            {
                                if (ch.equalsIgnoreCase("y")) {
                                    System.out.println("Enter Desired Category");
                                    String category = input.next();
                                    op.FilterProduct(category, ProductList);
                                    System.out.println("1.Add to Cart");
                                    System.out.println("2.Add to Wishlist");
                                    System.out.println("Or Any Key to Move Forward");
                                    int c = input.nextInt();
                                    switch (c) {
                                        case 1:
                                            System.out.println("Enter Product ID");
                                            String iddd0 = input.next();
                                            op.idAlreadyExist(ch, ProductList);
                                            if (op.GetProductCategoryAgainstID(iddd0, ProductList).equalsIgnoreCase("pizza")) {
                                                System.out.println("Enter Pizza Size S|M|L");
                                                String s = input.next();
                                                op.Cart(0, iddd0, s, ProductList, Cart);
                                                break;
                                            }
                                            if (op.GetProductCategoryAgainstID(iddd0, ProductList).equalsIgnoreCase("NormalCakes")) {
                                                System.out.println("Enter Weight of Cake in Pounds");
                                                int p = input.nextInt();
                                                op.Cart(p, iddd0, "", ProductList, Cart);
                                                break;
                                            }
                                            op.Cart(0, iddd0, "", ProductList, Cart);
                                            break;
                                        case 2:
                                            System.out.println("Enter Product ID");
                                            String idd2 = input.next();
                                            op.idAlreadyExist(idd2, ProductList);
                                            op.Wishlist(idd2, ProductList, WishList);
                                            break;
                                        default:
                                            break;
                                    }
                                } else if (ch.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    System.out.println("Invalid Choice");
                                    break;
                                }
                            }
                        } catch (Exception essss) {
                            System.out.println(essss.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("                        ** BEST DEALS **                        ");
                        for (Products best : ProductList) {
                            if ("BestDeal".equalsIgnoreCase(best.getCategory())) {
                                best.Display();
                            }
                        }

                        break;
                    case 5:
                        System.out.println("                        ** WISHLIST **                        ");
                        try {
                            if (WishList.isEmpty()) {
                                System.out.println("Nothing Here");
                            } else {
                                for (Products wishproducts : WishList) {
                                    wishproducts.Display();
                                }

                                System.out.println("1.Remove Specific Product from Wishlist ");
                                System.out.println("2.Clear Wishlist");
                                System.out.println("Press Any number to move Forward");
                                int ac = input.nextInt();
                                if (ac == 1) {
                                    System.out.println("Enter Product ID");
                                    String idd3 = input.next();
                                    op.RemoveProductFromList(idd3, WishList);
                                } else if (ac == 2) {
                                    WishList.clear();
                                    System.out.println("WishList Cleared...");
                                } else {
                                    break;
                                }
                            }
                        } catch (Exception esssss) {
                            System.out.println(esssss.getMessage());
                        }
                        break;

                    case 6:
                        System.out.println("                        ** CART **                        ");
                        try {
                            if (Cart.isEmpty()) {
                                System.out.println("Nothing Here");
                            } else {
                                for (Products cartproducts : Cart) {
                                    cartproducts.Display();

                                }
                                System.out.println("1.Remove Specific Product from Cart ");
                                System.out.println("2.Clear Cart");
                                System.out.println("Press Any number to move Forward");
                                int acc = input.nextInt();
                                if (acc == 1) {
                                    System.out.println("Enter Product ID");
                                    String idd3 = input.next();
                                    op.idAlreadyExist(idd3, ProductList);
                                    op.RemoveProductFromList(idd3, Cart);
                                } else if (acc == 2) {
                                    Cart.clear();
                                    System.out.println("Cart Cleared...");
                                } else {
                                    break;
                                }
                            }
                        } catch (Exception essss) {
                            System.out.println(essss.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println("                        ** CHECKOUT **                        ");
                        if (Cart.isEmpty()) {
                            System.out.println("Nothing Here");
                        } else {
                            try {
                                for (Products cartproducts : Cart) {
                                    cartproducts.Display();

                                }
                                String dummy = input.nextLine();
                                System.out.println("Enter Name : ");

                                String name = input.nextLine();
                                System.out.println("\nEnter Adress : ");
                                String address = input.nextLine();
                                System.out.println("\nEnter Phone Number : ");
                                String phone = input.next();
                                System.out.println("Enter Email : ");
                                String email = input.next();

                                PhoneNumber pho = new PhoneNumber(phone);

                                ValidEmail ema = new ValidEmail(email);
                                Products[] tempProductList = new Products[Cart.size()];
                                Cart.toArray(tempProductList);
                                int[] quantity = new int[Cart.size()];
                                for (int s = 0; s < Cart.size(); s++) {
                                    System.out.println("Enter Quantity for " + tempProductList[s].name + " : ");
                                    quantity[s] = input.nextInt();
                                }
                                CheckOut c = new CheckOut(name, address, quantity, pho, ema, Cart, tempProductList);
                                orders.add(c);
                                c.Display();
                                System.out.println("We have Recieved Your Order ");
                                System.out.println("Thanks for Visiting...");
                                break;
                            } catch (Exception ess) {
                                System.out.println(ess.getMessage());
                            }
                        }
                        break;
                    case 8:
                        System.out.println("                        ** CONTACT US **                        ");
                        System.out.println("Company Name : E Bakery");
                        System.out.println("Contact Number: 0216015387");
                        System.out.println("Email : contact@ebakery.com");
                        break;
                    case 9:
                        System.out.println("                        ** TERM&CONDITION **                        ");
                        System.out.println("All Right reserved");
                        break;
                    case 10:
                        System.out.println("                        ** Admin Area **                        ");
                        try {
                            System.out.println("...Login Here...");
                            System.out.print("User Name : ");
                            String user = input.next();
                            System.out.print("Password : ");
                            String pass = input.next();
                            Admin admin = new Admin(user, pass);
                            if (admin.getDetails()) {
                                System.out.println("Successfully Logged In");
                                int counter = 0;
                                do {
                                    System.out.println("1.Add Products");
                                    System.out.println("2.Delete Product");
                                    System.out.println("3.Delete All Products");
                                    System.out.println("4.Mark Product as Featured");
                                    System.out.println("5.Change Username and Password");
                                    System.out.println("6.SeeAllProducts");
                                    System.out.println("7.View Orders");
                                    System.out.println("8.Logut");

                                    System.out.println("Enter your choice...");
                                    int cho = input.nextInt();
                                    switch (cho) {
                                        case 1:
                                            op.DisplayProductCategories();
                                            try {
                                                System.out.print("What is Your Product Category ?");
                                                String cat = input.next();
                                                op.isCategoryTrue(cat);
                                                if (cat.equalsIgnoreCase("Pizza")) {
                                                    String dumy = input.nextLine();

                                                    System.out.print("Enter Name : ");
                                                    String name = input.nextLine();
                                                    System.out.println("Enter  Size S|M|L : ");
                                                    String size = input.next();
                                                    System.out.println("Product ID : ");
                                                    String id = input.next();
                                                    op.idAlreadyExist(id, ProductList);
                                                    System.out.println("Enter Product Price : ");
                                                    double pri = input.nextDouble();
                                                    System.out.println("Does this Product Featured Y|N: ");
                                                    String f = input.next();
                                                    boolean fea = false;
                                                    if (f.equalsIgnoreCase("y")) {
                                                        fea = true;
                                                    } else {
                                                        fea = false;
                                                    }
                                                    ProductList.add(new Pizza(size, name, id, pri, "Pizza", fea, 10));

                                                }
                                                if (cat.equalsIgnoreCase("Biscuits")) {
                                                    String duy = input.nextLine();

                                                    System.out.println("Enter Name : ");
                                                    String name = input.nextLine();
                                                    System.out.println("Enter Biscuits Quantity in Dozen: ");
                                                    int doz = input.nextInt();
                                                    System.out.println("Product ID : ");
                                                    String id = input.next();
                                                    op.idAlreadyExist(id, ProductList);
                                                    System.out.println("Enter Product Price : ");
                                                    double pri = input.nextDouble();
                                                    System.out.println("Does this Product Featured Y|N: ");
                                                    String f = input.next();
                                                    boolean fea = false;
                                                    if (f.equalsIgnoreCase("y")) {
                                                        fea = true;
                                                    } else {
                                                        fea = false;
                                                    }
                                                    ProductList.add(new Biscuits(doz, name, id, pri, "Biscuits", fea, 10));
                                                }
                                                if (cat.equalsIgnoreCase("Sandwich")) {
                                                    String dmmy = input.nextLine();

                                                    System.out.println("Enter Name : ");
                                                    String name = input.nextLine();
                                                    System.out.println("Product ID : ");
                                                    String id = input.next();
                                                    op.idAlreadyExist(id, ProductList);
                                                    System.out.println("Enter Product Price : ");
                                                    double pri = input.nextDouble();
                                                    System.out.println("Does this Product Featured Y|N: ");
                                                    String f = input.next();
                                                    boolean fea = false;
                                                    if (f.equalsIgnoreCase("y")) {
                                                        fea = true;
                                                    } else {
                                                        fea = false;
                                                    }
                                                    ProductList.add(new Sandwich(name, id, pri, "Sandwich", fea, 10));
                                                }
                                                if (cat.equalsIgnoreCase("CupCakes")) {
                                                    String ummy = input.nextLine();

                                                    System.out.println("Enter Name : ");
                                                    String name = input.nextLine();
                                                    System.out.println("Does your CupCake is Centrelly Filled? Y|N :");
                                                    String fi = input.next();
                                                    boolean fill = false;
                                                    if (fi.equalsIgnoreCase("y")) {
                                                        fill = true;
                                                    } else {
                                                        fill = false;
                                                    }
                                                    System.out.println("Product ID : ");
                                                    String id = input.next();
                                                    op.idAlreadyExist(id, ProductList);
                                                    System.out.println("Enter Product Price : ");
                                                    double pri = input.nextDouble();
                                                    System.out.println("Does this Product Featured Y|N: ");
                                                    String f = input.next();
                                                    boolean fea = false;
                                                    if (f.equalsIgnoreCase("y")) {
                                                        fea = true;
                                                    } else {
                                                        fea = false;
                                                    }
                                                    ProductList.add(new CupCakes(fill, name, id, pri, "CupCakes", fea, 10));

                                                }
                                                if (cat.equalsIgnoreCase("NormalCakes")) {
                                                    String mmy = input.nextLine();

                                                    System.out.println("Enter Product Name : ");
                                                    String name = input.nextLine();
                                                    System.out.println("Enter Weight in Pounds : ");
                                                    int w = input.nextInt();
                                                    System.out.println("Product ID : ");
                                                    String id = input.next();
                                                    op.idAlreadyExist(id, ProductList);
                                                    System.out.println("Enter Product Price : ");
                                                    double pri = input.nextDouble();
                                                    System.out.println("Does this Product Featured Y|N: ");
                                                    String f = input.next();
                                                    boolean fea = false;
                                                    if (f.equalsIgnoreCase("y")) {
                                                        fea = true;
                                                    } else {
                                                        fea = false;
                                                    }
                                                    ProductList.add(new NormalCakes(w, name, id, pri, "NormalCakes", fea, 10));

                                                }
                                                if (cat.equalsIgnoreCase("BestDeals")) {
                                                    String y = input.nextLine();

                                                    System.out.println("Enter What you are Offering : ");
                                                    String name = input.nextLine();
                                                    System.out.println("Product ID : ");
                                                    String id = input.next();
                                                    op.idAlreadyExist(id, ProductList);
                                                    System.out.println("Enter Product Price : ");
                                                    double pri = input.nextDouble();
                                                    System.out.println("Does this Product Featured Y|N: ");
                                                    String f = input.next();
                                                    boolean fea = false;
                                                    if (f.equalsIgnoreCase("y")) {
                                                        fea = true;
                                                    } else {
                                                        fea = false;
                                                    }
                                                    ProductList.add(new BestDeals(name, id, pri, "BestDeal", fea, 10));

                                                }
                                            } catch (Exception es) {
                                                System.out.println(es.getMessage());
                                            }
                                            break;
                                        case 2:
                                            try {
                                                System.out.println("Delete Product");
                                                System.out.println("Enter Product ID You want to delete");
                                                String idd8 = input.next();
                                                op.idAlreadyExist(idd8, ProductList);
                                                op.RemoveProductFromList(idd8, ProductList);
                                            } catch (Exception exx) {
                                                System.out.println(exx.getMessage());
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Delete All Products from Store");
                                            ProductList.clear();
                                            System.out.println("Your Store is Now Empty");
                                            break;
                                        case 4:
                                            try {
                                                System.out.println("Enter  ID of Product u want to featured");
                                                String idd9 = input.next();
                                                op.idAlreadyExist(idd9, ProductList);
                                                if (op.islistContainID(idd9, ProductList)) {
                                                    op.MakeProductFeaturedAgainstID(idd9, ProductList);
                                                } else {
                                                    System.out.println("Invalid ID");
                                                }
                                            } catch (Exception exxxx) {
                                                System.out.println(exxxx.getMessage());
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Set Username and Password");
                                            System.out.print("Enter new username : ");
                                            String nam = input.next();
                                            System.out.print("Enter new Password : ");
                                            String pas = input.next();
                                            admin.setUserNameandPassword(user, pass);
                                            System.out.println("User name and Password has Changed");
                                            break;
                                        case 6:
                                            System.out.println("All Products");
                                            if (ProductList.isEmpty()) {
                                                System.out.println("There is No Product. Store is Empty");
                                            } else {
                                                System.out.println("No of Active Products Are : " + ProductList.size());
                                                op.ShopNow(ProductList);
                                            }
                                            break;
                                        case 7:
                                            if (orders.isEmpty()) {
                                                System.out.println("No Pending Orders yet");
                                            } else {
                                                for (CheckOut ck : orders) {
                                                    ck.Display();
                                                }
                                            }

                                            break;
                                        case 8:

                                            System.out.println("Successfully Logout...");
                                            counter = 1;
                                            break;
                                        default:
                                            System.out.println("You have entered Wrong Choice");
                                            break;

                                    }
                                } while (counter != 1);
                            } else {
                                System.out.println("You have Entered Wrong Details");
                            }
                            break;
                        } catch (Exception essss) {
                            System.out.println(essss.getMessage());
                        }
                    default:
                        System.out.println("You have entered Wrong Choice");
                        break;
                }

            } while (i != 0);

        } catch (Exception ed) {
            System.out.println(ed.getMessage());
        }

    }
}
