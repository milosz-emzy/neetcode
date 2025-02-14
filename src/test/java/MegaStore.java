public class MegaStore {

    public enum DiscountType {
        Standard,
        Seasonal,
        Weight;
    }
    
    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {
        return switch (discountType) {
            case Standard -> totalPrice * (1.0d-0.06d);
            case Seasonal -> totalPrice * (1.0d-0.12d);
            case Weight -> {
                if (cartWeight <= 10) {
                    yield totalPrice * (1.0d-0.06d);
                } else {
                    yield totalPrice * (1.0d-0.18d);
                }
            }
        };
    }
    
    public static void main(String[] args) {        
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}
//Standard discount 6% weight=any
//seasonal discount 12% weight=any
//Weight <=10 discount 6% weight<=10
//Weight >10 discount 18% weight>10
