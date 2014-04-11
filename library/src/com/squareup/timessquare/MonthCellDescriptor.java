// Copyright 2012 Square, Inc.

package com.squareup.timessquare;

import java.util.Date;

/** Describes the state of a particular date cell in a {@link MonthView}. */
class MonthCellDescriptor {
  public enum RangeState {
    NONE, FIRST, MIDDLE, LAST
  }

  private final Date date;
  private final int value;
  private final boolean isCurrentMonth;
  private boolean isSelected;
  private final boolean isToday;
  private final boolean isSelectable;
  private boolean isHighlighted;
  
  private boolean isPastSwim;
  private boolean isMissedSwim;
  private boolean isFutureSwim;
  private boolean isCompletedSwim;
  
  private RangeState rangeState;

  MonthCellDescriptor(Date date, boolean currentMonth, boolean selectable, boolean selected,
      boolean today, boolean highlighted, int value, RangeState rangeState, boolean pastSwim, 
      boolean missedSwim, boolean futureSwim, boolean completedSwim) {
    this.date = date;
    isCurrentMonth = currentMonth;
    isSelectable = selectable;
    isHighlighted = highlighted;
    isSelected = selected;
    isToday = today;
    
    isPastSwim = pastSwim;
    isMissedSwim = missedSwim;
    isFutureSwim = futureSwim;
    isCompletedSwim = completedSwim;
    
    this.value = value;
    this.rangeState = rangeState;
  }

  public Date getDate() {
    return date;
  }

  public boolean isCurrentMonth() {
    return isCurrentMonth;
  }

  public boolean isSelectable() {
    return isSelectable;
  }

  public boolean isSelected() {
    return isSelected;
  }
  
  public boolean isPastSwim() {
	  return isPastSwim;
  }

  public boolean isMissedSwim() {
	  return isMissedSwim;
  }
  
  public boolean isFutureSwim() {
	  return isFutureSwim;
  }
  
  public boolean isCompletedSwim() {
	return isCompletedSwim;
  }
  
  public void setSelected(boolean selected) {
    isSelected = selected;
  }

  boolean isHighlighted() {
    return isHighlighted;
  }

  void setHighlighted(boolean highlighted) {
    isHighlighted = highlighted;
  }

  public boolean isToday() {
    return isToday;
  }

  public RangeState getRangeState() {
    return rangeState;
  }

  public void setRangeState(RangeState rangeState) {
    this.rangeState = rangeState;
  }

  public int getValue() {
    return value;
  }

  @Override public String toString() {
	  
	  // TODO(benp) update toString to reflect is*Swim methods
	  
    return "MonthCellDescriptor{"
        + "date="
        + date
        + ", value="
        + value
        + ", isCurrentMonth="
        + isCurrentMonth
        + ", isSelected="
        + isSelected
        + ", isToday="
        + isToday
        + ", isSelectable="
        + isSelectable
        + ", isHighlighted="
        + isHighlighted
        + ", rangeState="
        + rangeState
        + '}';
  }
}
