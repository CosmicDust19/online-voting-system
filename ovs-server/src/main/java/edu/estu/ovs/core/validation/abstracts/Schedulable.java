package edu.estu.ovs.core.validation.abstracts;

public interface Schedulable<T> {

    Comparable<T> getStartDate();

    Comparable<T> getEndDate();

}
