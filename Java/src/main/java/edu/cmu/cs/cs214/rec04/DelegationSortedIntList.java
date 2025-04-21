package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    private final SortedIntList sortedList; // Delegate object
    private int totalAdded; // Tracks the total number of add operations attempted

    public DelegationSortedIntList() {
        this.sortedList = new SortedIntList(); // Initialize the delegate object
        this.totalAdded = 0;
    }

    @Override
    public boolean add(int value) {
        totalAdded++; // Increment the counter for each add attempt
        return sortedList.add(value); // Delegate the add operation
    }

    @Override
    public boolean addAll(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i)); // Use the overridden add method to track additions
        }
        return true;
    }

    @Override
    public int get(int index) {
        return sortedList.get(index); // Delegate the get operation
    }

    @Override
    public boolean remove(int value) {
        return sortedList.remove(value); // Delegate the remove operation
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list); // Delegate the removeAll operation
    }

    @Override
    public int size() {
        return sortedList.size(); // Delegate the size operation
    }

    public int getTotalAdded() {
        return totalAdded; // Return the total number of add operations
    }
}