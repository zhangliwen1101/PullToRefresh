package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class SDPullToRefreshLinearLayout extends PullToRefreshBase<LinearLayout>
{

	public SDPullToRefreshLinearLayout(Context context)
	{
		super(context);
	}

	public SDPullToRefreshLinearLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public SDPullToRefreshLinearLayout(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode, com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle animStyle)
	{
		super(context, mode, animStyle);
	}

	public SDPullToRefreshLinearLayout(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode)
	{
		super(context, mode);
	}

	@Override
	public com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
	{
		// TODO Auto-generated method stub
		return Orientation.VERTICAL;
	}

	@Override
	protected LinearLayout createRefreshableView(Context context, AttributeSet attrs)
	{
		LinearLayout ll = new LinearLayout(context, attrs);
		ll.setId(R.id.linearlayout);
		return ll;
	}

	@Override
	protected boolean isReadyForPullEnd()
	{
		return mRefreshableView.getScrollY() == 0;
	}

	@Override
	protected boolean isReadyForPullStart()
	{
		View scrollViewChild = mRefreshableView.getChildAt(0);
		if (null != scrollViewChild)
		{
			return mRefreshableView.getScrollY() >= (scrollViewChild.getHeight() - getHeight());
		}
		return false;
	}

}
