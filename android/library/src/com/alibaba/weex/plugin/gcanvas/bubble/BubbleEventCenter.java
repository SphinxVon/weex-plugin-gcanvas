package com.alibaba.weex.plugin.gcanvas.bubble;

import java.util.ArrayList;

/**
 * @author ertong
 *         create at 2017/9/27
 */

public class BubbleEventCenter {
    private volatile static BubbleEventCenter _instance;

    private ArrayList<IBubbleAnimationListener> mAnimListeners = new ArrayList<>();

    private BubbleEventCenter() {
    }

    public static BubbleEventCenter getEventCenter() {
        if (null == _instance) {
            synchronized (BubbleEventCenter.class) {
                if (null == _instance) {
                    _instance = new BubbleEventCenter();
                }
            }
        }

        return _instance;
    }

    public boolean addBubbleAnimListener(IBubbleAnimationListener listener) {
        if (null != listener && !mAnimListeners.contains(listener)) {
            return mAnimListeners.add(listener);
        }

        return false;
    }

    public boolean removeBubbleAnimListener(IBubbleAnimationListener listener) {
        if (null != listener) {
            return mAnimListeners.remove(listener);
        }
        return false;
    }

    public void fireAnimationStart(AnimationType type, BubbleAnimateWrapper bubbleAnimateWrapper) {
        for (IBubbleAnimationListener listener : mAnimListeners) {
            listener.onStart(type, bubbleAnimateWrapper);
        }
    }

    public void fireAnimationEnd(AnimationType type, BubbleAnimateWrapper bubbleAnimateWrapper) {
        for (IBubbleAnimationListener listener : mAnimListeners) {
            listener.onEnd(type, bubbleAnimateWrapper);
        }
    }

    public interface IBubbleAnimationListener {
        void onStart(AnimationType type, BubbleAnimateWrapper bubbleAnimateWrapper);

        void onEnd(AnimationType type, BubbleAnimateWrapper bubbleAnimateWrapper);

        void onCancel(AnimationType type, BubbleAnimateWrapper bubbleAnimateWrapper);
    }

    public enum AnimationType {
        MoveLeft, MoveRight, EdgeBounceLeft, EdgeBounceRight, ReplaceScale
    }
}