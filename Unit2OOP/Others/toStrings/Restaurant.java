public class Restaurant extends Business {
    private int rating;

    public void setRating(int userRating) {
        rating = userRating;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return super.toString() + ", Rating: " + rating;
    }
}
