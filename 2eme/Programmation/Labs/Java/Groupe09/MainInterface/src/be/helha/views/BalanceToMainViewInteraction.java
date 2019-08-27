package be.helha.views;

/**
 * This interface is used between our main controller and our "balance" view controller. It does manage the update of the weight for a certain product
 */
public interface BalanceToMainViewInteraction {
    void updateWeight(String input);                    // Update the weight of the balance
}
