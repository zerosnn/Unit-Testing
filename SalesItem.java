import java.util.ArrayList;
import java.util.List;

public class SalesItem {
    private String name;
    private double price;
    private List<CustomerReview> reviews;

    public SalesItem(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void addReview(CustomerReview review) {
        if (review == null) {
            throw new IllegalArgumentException("Review cannot be null");
        }
        reviews.add(review);
    }

    public List<CustomerReview> getReviews() {
        return new ArrayList<>(reviews); 
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (CustomerReview review : reviews) {
            total += review.getRating();
        }
        return total / reviews.size();
    }
}
