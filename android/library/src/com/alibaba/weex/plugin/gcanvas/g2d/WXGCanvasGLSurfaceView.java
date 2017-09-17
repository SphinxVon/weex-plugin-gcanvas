//package com.alibaba.weex.plugin.gcanvas.g2d;
//
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//
//import com.taobao.gcanvas.GCanvas;
//import com.taobao.gcanvas.GCanvasView;
//import com.taobao.weex.ui.view.gesture.WXGesture;
//import com.taobao.weex.ui.view.gesture.WXGestureObservable;
//
//
//public class WXGCanvasGLSurfaceView extends GCanvasView implements WXGestureObservable, GCanvasView.CanvasLifecycleListener {
//    private WXGesture wxGesture;
//
//    protected WXCanvasLifecycleListener mWXLifecycleListener;
//
//    private G2DWXGCanvasDelegate mComponent;
//
//    private boolean mIsDetached = false;
//
//    public WXGCanvasGLSurfaceView(G2DWXGCanvasDelegate component, GCanvas canvas, Context context) {
//        super(canvas, context);
//        this.mComponent = component;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//    }
//
//    @Override
//    public void registerGestureListener(WXGesture wxGesture) {
//        this.wxGesture = wxGesture;
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        boolean result = super.onTouchEvent(event);
//        if (wxGesture != null) {
//            result |= wxGesture.onTouch(this, event);
//        }
//        return result;
//    }
//
//    public void setWXLifecycleListener(WXCanvasLifecycleListener listener) {
//        this.mWXLifecycleListener = listener;
//        setOnCanvasLifecycleListener(this);
//    }
//
//    @Override
//
//    protected void onLayout(boolean changed, int left, int top, int right,
//                            int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        super.surfaceDestroyed(holder);
//    }
//
//
//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        if (null != mWXLifecycleListener) {
//            mWXLifecycleListener.onGCanvasViewAttachToWindow(mComponent, this);
//        }
//
//        if(mIsDetached){
//            if(null != mWXLifecycleListener){
//                mWXLifecycleListener.onGCanvasViewReattached(mComponent, this);
//            }
//        }
//        mIsDetached = false;
//    }
//
//    @Override
//    protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        if (null != mWXLifecycleListener) {
//            mWXLifecycleListener.onGCanvasViewDetachedFromWindow(mComponent, this);
//        }
//        mIsDetached = true;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    public void onGCanvasViewDestroy(GCanvasView canvasView) {
//        if (null != mWXLifecycleListener) {
//            mWXLifecycleListener.onGCanvasViewDestroy(mComponent, this);
//        }
//    }
//
//    @Override
//    public void onGCanvasViewCreated(GCanvasView canvasView) {
//        if (null != mWXLifecycleListener) {
//            mWXLifecycleListener.onGCanvasViewCreated(mComponent, this);
//        }
//    }
//
////    extends GCanvasView.CanvasLifecycleListener
//
//    public interface WXCanvasLifecycleListener {
//
//        void onGCanvasViewAttachToWindow(G2DWXGCanvasDelegate component, GCanvasView canvasView);
//
//        void onGCanvasViewDetachedFromWindow(G2DWXGCanvasDelegate component, GCanvasView canvasView);
//
//        void onGCanvasViewDestroy(G2DWXGCanvasDelegate component, GCanvasView canvasView);
//
//        void onGCanvasViewCreated(G2DWXGCanvasDelegate component, GCanvasView canvasView);
//
//        void onGCanvasViewReattached(G2DWXGCanvasDelegate component, GCanvasView canvasView);
//    }
//}
//