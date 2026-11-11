import java.util.ArrayList;
import java.util.List;

/** A small in-memory gradebook. Scores are integers from 0 through 100. */
public class GradeBook {
    private final List<Integer> scores = new ArrayList<>();

    /** Adds a score; invalid scores throw without changing the gradebook. */
    public void addScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        scores.add(score);
    }

    /** Returns the number of recorded scores, including duplicates. */
    public int size() {
        return scores.size();
    }

    /** Returns the arithmetic mean, or 0.0 when no scores are recorded. */
    public double average() {
        double total = 0.0;
        for (int score : scores) {
            total += score;
        }
        return scores.isEmpty() ? 0.0 : total / scores.size();
    }

    /** A nonempty gradebook passes when its average is at least 60.0. */
    public boolean isPassing() {
        return !scores.isEmpty() && average() >= 60.0;
    }

    /** Returns the highest score, or null when no scores are recorded. */
    public Integer highestScore() {
        if (scores.isEmpty()) {
            return null;
        }
        int highest = scores.get(0);
        for (int score : scores) {
            highest = Math.max(highest, score);
        }
        return highest;
    }

    /** Returns a fresh array in insertion order; editing it cannot change this book. */
    public int[] getScores() {
        int[] result = new int[scores.size()];
        for (int i = 0; i < scores.size(); i++) {
            result[i] = scores.get(i);
        }
        return result;
    }
}
