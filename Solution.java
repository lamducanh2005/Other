import java.util.Scanner;

/**
 * Represents a solution for working with fractions.
 */
public class Solution {
    private int numerator; // Numerator of the fraction
    private int denominator; // Denominator of the fraction

    /**
     * Constructs a fraction with a default denominator of 1.
     */
    public Solution() {
        this.denominator = 1;
    }

    /**
     * Constructs a fraction with the given numerator and denominator.
     *
     * @param numerator   the numerator of the fraction
     * @param denominator the denominator of the fraction
     */
    public Solution(int numerator, int denominator) {
        this.numerator = numerator;
        setDenominator(denominator);
    }

    /**
     * Calculates the greatest common divisor (GCD) of two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the GCD of the two numbers
     */
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Reduces the fraction to its simplest form.
     *
     * @return this fraction after reduction
     */
    public Solution reduce() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    /**
     * Adds another fraction to this fraction.
     *
     * @param fraction the other fraction to add
     * @return the result of the addition as a new fraction
     */
    public Solution add(Solution fraction) {
        int num = this.numerator * fraction.denominator + this.denominator * fraction.numerator;
        int den = this.denominator * fraction.denominator;
        return new Solution(num, den).reduce();
    }

    /**
     * Subtracts another fraction from this fraction.
     *
     * @param fraction the other fraction to subtract
     * @return the result of the subtraction as a new fraction
     */
    public Solution subtract(Solution fraction) {
        int num = this.numerator * fraction.denominator - this.denominator * fraction.numerator;
        int den = this.denominator * fraction.denominator;
        return new Solution(num, den).reduce();
    }

    /**
     * Multiplies this fraction by another fraction.
     *
     * @param fraction the other fraction to multiply by
     * @return the result of the multiplication as a new fraction
     */
    public Solution multiply(Solution fraction) {
        int num = this.numerator * fraction.numerator;
        int den = this.denominator * fraction.denominator;
        return new Solution(num, den).reduce();
    }

    /**
     * Divides this fraction by another fraction.
     *
     * @param fraction the other fraction to divide by
     * @return the result of the division as a new fraction
     */
    public Solution divide(Solution fraction) {
        int num = this.numerator * fraction.denominator;
        int den = this.denominator * fraction.numerator;
        return new Solution(num, den).reduce();
    }

    /**
     * Checks if this fraction is equal to another object.
     *
     * @param obj the object to compare with this fraction
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            Solution thisReduced = this.reduce();
            Solution otherReduced = other.reduce();
            return thisReduced.numerator == otherReduced.numerator && thisReduced.denominator == otherReduced.denominator;
        }
        return false;
    }

    /**
     * Gets the numerator of this fraction.
     *
     * @return the numerator of this fraction
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * Gets the denominator of this fraction.
     *
     * @return the denominator of this fraction
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * Sets the numerator of this fraction.
     *
     * @param numerator the new numerator value
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Sets the denominator of this fraction, ensuring it is not zero.
     *
     * @param denominator the new denominator value
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            this.denominator = 1;
        }
    }
}
