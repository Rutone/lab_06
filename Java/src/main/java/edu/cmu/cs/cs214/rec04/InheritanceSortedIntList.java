package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    private int totalAdded; // Tracks the total number of add operations attempted

    public InheritanceSortedIntList() {
        super(); // Call the constructor of SortedIntList
        totalAdded = 0;
    }

    @Override
    public boolean add(int value) {
        totalAdded++; // Increment the counter for each add attempt
        return super.add(value); // Call the parent class's add method
    }

    @Override
    public boolean addAll(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i)); // Use the overridden add method to track additions
        }
        return true;
    }

    public int getTotalAdded() {
        return totalAdded; // Return the total number of add operations
    }
}