import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 

class CustomerReviewTest {

    @Test
    void testCustomerReviewConstructor() {
        CustomerReview review = new CustomerReview(5, "Excellent product!");
        
        assertEquals(5, review.getRating());
        assertEquals("Excellent product!", review.getComment());
    }

    @Test
    void testInvalidRatingThrowsException() {
        assertThrows(IllegalArgumentException.class, 
            () -> new CustomerReview(6, "Out of range"));
        assertThrows(IllegalArgumentException.class, 
            () -> new CustomerReview(0, "Out of range"));
    }

    @Test
    void testEmptyCommentThrowsException() {
        assertThrows(IllegalArgumentException.class, 
            () -> new CustomerReview(3, ""));
        assertThrows(IllegalArgumentException.class, 
            () -> new CustomerReview(3, null));
    }
}

class SalesItemReviewTest {

    @Test
    void testAddReview() {
        SalesItem item = new SalesItem("Laptop", 1500.00);
        CustomerReview review = new CustomerReview(5, "Amazing quality!");
        
        item.addReview(review);

        assertEquals(1, item.getReviews().size());
        assertEquals("Amazing quality!", item.getReviews().get(0).getComment());
    }

    @Test
    void testGetAverageRating() {
        SalesItem item = new SalesItem("Phone", 800.00);
        item.addReview(new CustomerReview(4, "Good performance"));
        item.addReview(new CustomerReview(5, "Excellent value"));
        item.addReview(new CustomerReview(3, "Average build quality"));

        assertEquals(4.0, item.getAverageRating());
    }

    @Test
    void testEmptyReviewsAverageRating() {
        SalesItem item = new SalesItem("Tablet", 600.00);

        assertEquals(0.0, item.getAverageRating());
    }
}
