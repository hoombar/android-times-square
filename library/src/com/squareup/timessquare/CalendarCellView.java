// Copyright 2013 Square, Inc.

package com.squareup.timessquare;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.squareup.timessquare.MonthCellDescriptor.RangeState;

public class CalendarCellView extends TextView {
	private static final int[] STATE_SELECTABLE = { R.attr.state_selectable };
	private static final int[] STATE_CURRENT_MONTH = { R.attr.state_current_month };
	private static final int[] STATE_TODAY = { R.attr.state_today };
	private static final int[] STATE_HIGHLIGHTED = { R.attr.state_highlighted };
	private static final int[] STATE_RANGE_FIRST = { R.attr.state_range_first };
	private static final int[] STATE_RANGE_MIDDLE = { R.attr.state_range_middle };
	private static final int[] STATE_RANGE_LAST = { R.attr.state_range_last };

	private static final int[] STATE_PAST_SWIM = { R.attr.state_past_swim };
	private static final int[] STATE_MISSED_SWIM = { R.attr.state_missed_swim };
	private static final int[] STATE_FUTURE_SWIM = { R.attr.state_future_swim };

	private boolean isSelectable = false;
	private boolean isCurrentMonth = false;
	private boolean isToday = false;
	private boolean isHighlighted = false;

	private boolean isPastSwim = false;
	private boolean isMissedSwim = false;
	private boolean isFutureSwim = false;
	private boolean isCompletedSwim = false;

	private RangeState rangeState = RangeState.NONE;

	@SuppressWarnings("UnusedDeclaration")
	public CalendarCellView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setSelectable(boolean isSelectable) {
		this.isSelectable = isSelectable;
		refreshDrawableState();
	}

	public void setCurrentMonth(boolean isCurrentMonth) {
		this.isCurrentMonth = isCurrentMonth;
		refreshDrawableState();
	}

	public void setToday(boolean isToday) {
		this.isToday = isToday;
		refreshDrawableState();
	}

	public void setRangeState(MonthCellDescriptor.RangeState rangeState) {
		this.rangeState = rangeState;
		refreshDrawableState();
	}

	public void setHighlighted(boolean highlighted) {
		isHighlighted = highlighted;
	}

	public void setPastSwim(boolean pastSwim) {
		isPastSwim = pastSwim;
	}

	public void setMissedSwim(boolean missedSwim) {
		isMissedSwim = missedSwim;
	}

	public void setFutureSwim(boolean futureSwim) {
		isFutureSwim = futureSwim;
	}

	public void setCompletedSwim( boolean completedSwim ) {
		isCompletedSwim = completedSwim;
	}
	
	@Override
	protected int[] onCreateDrawableState(int extraSpace) {
		final int[] drawableState = super.onCreateDrawableState(extraSpace + 5);

		if (isSelectable) {
			mergeDrawableStates(drawableState, STATE_SELECTABLE);
		}

		if (isCurrentMonth) {
			mergeDrawableStates(drawableState, STATE_CURRENT_MONTH);
		}

		if (isToday) {
			mergeDrawableStates(drawableState, STATE_TODAY);
		}

		if (isHighlighted) {
			mergeDrawableStates(drawableState, STATE_HIGHLIGHTED);
		}

		if (isPastSwim) {
			if (isMissedSwim) {
				mergeDrawableStates(drawableState, STATE_MISSED_SWIM);
			} else {
				mergeDrawableStates(drawableState, STATE_PAST_SWIM);	
			}
		}
		if (isFutureSwim) {
			// swim marked as done on current day should have the tick
			if ( isCompletedSwim && isToday ) {
				mergeDrawableStates(drawableState, STATE_PAST_SWIM);	
			} else {
				mergeDrawableStates(drawableState, STATE_FUTURE_SWIM);
			}
		}

		if (rangeState == MonthCellDescriptor.RangeState.FIRST) {
			mergeDrawableStates(drawableState, STATE_RANGE_FIRST);
		} else if (rangeState == MonthCellDescriptor.RangeState.MIDDLE) {
			mergeDrawableStates(drawableState, STATE_RANGE_MIDDLE);
		} else if (rangeState == RangeState.LAST) {
			mergeDrawableStates(drawableState, STATE_RANGE_LAST);
		}

		return drawableState;
	}
}
