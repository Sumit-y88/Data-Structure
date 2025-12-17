class Pizza {
    String size;
    int cheeseCount;
    int pepperoniCount;
    int veggieCount;

    Pizza() {
        size = "Medium";
        cheeseCount = 1;
        pepperoniCount = 2;
        veggieCount = 4;
    }

    Pizza(String s) {
        size = s;
        cheeseCount = 4;
        pepperoniCount = 1;
        veggieCount = 3;
    }

    Pizza(String size, int cheese, int pepperoni, int veggie) {
        size = size;
        cheeseCount = cheese;
        pepperoniCount = pepperoni;
        veggieCount = veggie;
    }

    void display() {
        System.out.println("Pizza Size: " + size);
        System.out.println("Cheese Count: " + cheeseCount);
        System.out.println("Pepperoni Count: " + pepperoniCount);
        System.out.println("Veggie Count: " + veggieCount);
        System.out.println();
    }

    public static void main(String[] args) {
        Pizza p1 = new Pizza();
        Pizza p2 = new Pizza("large");
        Pizza p3 = new Pizza("large", 2, 3, 4);

        p1.display();
        p2.display();
        p3.display();
    }
}