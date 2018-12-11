package com.theaty.xiaoyuan.ui.mine.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.theaty.xiaoyuan.R;
import com.theaty.xiaoyuan.databinding.DialogBaseBinding;
import com.theaty.xiaoyuan.databinding.ItemDialogBaseBinding;

import java.util.ArrayList;
import java.util.Arrays;

import foundation.util.DpUtil;
import foundation.widget.recyclerView.SpaceItemDecoration;

/**
 * Created by track on 2017/4/19.
 */
public class ListDialog extends Dialog implements AdapterView.OnItemClickListener, View.OnClickListener {
    Context context;
    DialogBaseBinding binding;
    TheAdapter adapter;
    String title;
    ArrayList<ListDialogAction> actions;
    String confirm = "确定";
    String cancel = "取消";

    public void setOnDialogItemClick(ListDialog.onDialogItemClick onDialogItemClick) {
        this.onDialogItemClick = onDialogItemClick;
    }

    onDialogItemClick onDialogItemClick;
    View.OnClickListener cancelonClick;
    View.OnClickListener confirmonClickListener;

    public ListDialog(@NonNull Context context, ArrayList<String> items) {
        super(context, R.style.Dialog);
        this.context = context;
        adapter = new TheAdapter();
        adapter.addInfos(items);
        init();
    }

    public ListDialog(@NonNull Context context, String title, String[] items) {
        super(context, R.style.Dialog);
        this.context = context;
        this.title = title;
        adapter = new TheAdapter();
        adapter.addInfos(Arrays.asList(items));
        init();
    }

    public ListDialog(@NonNull Context context, int title, int[] items) {
        super(context, R.style.Dialog);
        this.context = context;
        this.title = context.getString(title);
        adapter = new TheAdapter();
        for (int item : items) {
            adapter.addInfo(context.getString(item));
        }
        init();
    }

    public ListDialog(@NonNull Context context, int title, ArrayList<ListDialogAction> actions) {
        super(context, R.style.Dialog);
        this.context = context;
        this.title = context.getString(title);
        this.actions = actions;
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < actions.size(); i++) {
            items.add(actions.get(i).title);
        }
        adapter = new TheAdapter();
        for (String item : items) {
            adapter.addInfo(item);
        }
        init();
    }

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        if (binding != null)
            binding.setMessage(message);
    }

    private ListDialog(@NonNull Context context, String message, View.OnClickListener confirmonClickListener) {
        super(context, R.style.Dialog);
        this.context = context;
        this.message = message;
        currentStyle = DialogStyle.ALERT;
        this.confirmonClickListener = confirmonClickListener;
        init();
    }

    private ListDialog(@NonNull Context context, String message, View.OnClickListener confirmonClickListener, View.OnClickListener cancelonClick) {
        super(context, R.style.Dialog);
        this.context = context;
        this.message = message;
        currentStyle = DialogStyle.ALERT;
        this.confirmonClickListener = confirmonClickListener;
        this.cancelonClick = cancelonClick;
        this.confirm = "确定";
        this.cancel = "取消";
        init();

    }

    private ListDialog(@NonNull Context context, String message, String confirm, String cancel, View.OnClickListener confirmonClickListener, View.OnClickListener cancelonClick) {
        super(context, R.style.Dialog);
        this.context = context;
        this.message = message;
        currentStyle = DialogStyle.ALERT;
        this.confirmonClickListener = confirmonClickListener;
        this.cancelonClick = cancelonClick;
        if (cancel != null)
            this.cancel = cancel;
        if (confirm != null)
            this.confirm = confirm;
        init();
    }

    private ListDialog(@NonNull Context context, DialogStyle style, String message, String confirm, String cancel, View.OnClickListener confirmonClickListener, View.OnClickListener cancelonClick) {
        super(context, R.style.Dialog);
        this.context = context;
        this.message = message;
        currentStyle = style;
        this.confirmonClickListener = confirmonClickListener;
        this.cancelonClick = cancelonClick;
        if (cancel != null)
            this.cancel = cancel;
        if (confirm != null)
            this.confirm = confirm;
        init();
    }

    public ListDialog(@NonNull Context context, int message, View.OnClickListener confirmonClickListener) {
        super(context, R.style.Dialog);
        this.context = context;
        this.message = context.getString(message);
        this.confirmonClickListener = confirmonClickListener;
        init();
    }

    public ListDialog(@NonNull Context context, String title, ArrayList<ListDialogAction> actions,
                      View.OnClickListener cancelonclick) {
        super(context, R.style.Dialog);
        this.context = context;
        this.title = title;
        this.actions = actions;
        this.cancelonClick = cancelonclick;
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < actions.size(); i++) {
            items.add(actions.get(i).title);
        }
        adapter = new TheAdapter();
        for (String item : items) {
            adapter.addInfo(item);
        }
        init();
    }

    public ListDialog(@NonNull Context context, String title, ArrayList<String> items) {
        super(context, R.style.Dialog);
        this.context = context;
        this.title = title;
        adapter = new TheAdapter();
        adapter.addInfos(items);
        init();
    }

    public enum DialogStyle {
        ALERT, LIST, ALERT_ONLY_OK, ALERT_1
    }

    DialogStyle currentStyle = DialogStyle.LIST;

    public ListDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }


    void init() {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_base, null, false);
        setContentView(binding.getRoot());
        if (currentStyle == DialogStyle.LIST) {
            if (adapter == null)
                adapter = new TheAdapter();
            binding.setDtype(1);
            if (title != null) {
                binding.setTitle(title);
                binding.title.setVisibility(View.VISIBLE);
            }
            binding.recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            binding.recycler.addItemDecoration(new SpaceItemDecoration(2));
            binding.recycler.setAdapter(adapter);
//            binding.listview.setOnItemClickListener(this);
        } else if (currentStyle == DialogStyle.ALERT_1) {
            binding.setDtype(3);
            binding.setMessage(message);
            binding.confirm1.setText(confirm);
            binding.cancelText1.setText(cancel);
        } else {
            binding.setDtype(2);
            binding.setMessage(message);
            binding.confirm.setText(confirm);
            binding.cancelText.setText(cancel);
            if (currentStyle == DialogStyle.ALERT_ONLY_OK) {
                binding.cancelText.setVisibility(View.GONE);
                binding.line1.setVisibility(View.GONE);
            }
        }


        binding.setOnClickListener(this);
        Point point = new Point();
        if (context instanceof Activity)
            ((Activity) context).getWindowManager().getDefaultDisplay().getSize(point);
        else {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getSize(point);
        }
        WindowManager.LayoutParams lp = this.getWindow()
                .getAttributes();
        lp.width = currentStyle == DialogStyle.LIST ? point.x : point.x - DpUtil.dip2px(80);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = currentStyle == DialogStyle.LIST ? Gravity.BOTTOM : Gravity.CENTER;

        if (currentStyle == DialogStyle.LIST) {
            this.getWindow().setWindowAnimations(R.style.dialoganimation);
        }
        this.getWindow().setAttributes(lp);

    }

    public void setTitle(String title) {
        if (title == null)
            return;
        this.title = title;
        binding.setTitle(title);
        binding.title.setVisibility(View.VISIBLE);
    }

    //列表弹窗无取消和title提示
    public void setNotitleAndCancel() {
        binding.title.setVisibility(View.GONE);
        binding.cancel.setVisibility(View.GONE);
    }
    //列表弹窗有取消和无title提示
    public void setNotitleButCancel() {
        binding.title.setVisibility(View.GONE);
        binding.cancel.setVisibility(View.VISIBLE);
    }
    public void setItem(ArrayList<String> items) {
        adapter.addInfos(items);
        adapter.notifyDataSetChanged();
    }

    public void addItem(String item) {
        adapter.addInfo(item);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (onDialogItemClick != null) {
            onDialogItemClick.onItemClick(i, adapter.getItem(i));
        } else {
            if (actions != null && actions.size() >= i) {
                actions.get(i).onClickListener.onClick(view);
            }
        }
        dismiss();
    }

    @Override
    public void onClick(View view) {
        dismiss();
        if (view.getId() == R.id.confirm || view.getId() == R.id.confirm1) {
            if (confirmonClickListener != null)
                confirmonClickListener.onClick(view);
            return;
        } else {
            if (cancelonClick != null)
                cancelonClick.onClick(view);
        }
    }

    class TheAdapter extends IViewDataRecyclerAdapter<String, ItemDialogBaseBinding> {

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.item_dialog_base;
        }

        @Override
        protected void bindData(ItemDialogBaseBinding itemDialogBaseBinding, String info, final int position) {
            itemDialogBaseBinding.setInfo(info);
            if(info.equals("男")){
                itemDialogBaseBinding.tvMale.setTextColor(getContext().getResources().getColor(R.color.blue));
            } else if(info.equals("女")){
                itemDialogBaseBinding.tvMale.setTextColor(getContext().getResources().getColor(R.color.red));
            } else {
                itemDialogBaseBinding.tvMale.setTextColor(getContext().getResources().getColor(R.color.grey));
            }
            itemDialogBaseBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onDialogItemClick != null) {
                        onDialogItemClick.onItemClick(position, adapter.getItem(position));
                    } else {
                        if (actions != null && actions.size() >= position) {
                            actions.get(position).onClickListener.onClick(view);
                        }
                    }
                    dismiss();
                }
            });

        }
    }

    public interface onDialogItemClick {
        public void onItemClick(int index, String info);
    }


    public static class Builder {
        String title;
        String message;
        String cancelText;
        String confirmText;
        ArrayList<ListDialogAction> actions;
        Context context;
        View.OnClickListener cancelClickListener;
        View.OnClickListener confirmClickListener;
        DialogStyle dialogStyle = DialogStyle.LIST;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.dialogStyle = DialogStyle.ALERT;
            this.message = message;
            return this;
        }

        public Builder setCancelText(String text) {
            this.cancelText = text;
            return this;
        }

        public Builder setConfirmText(String text) {
            this.confirmText = text;
            return this;
        }

        public Builder setDialog(DialogStyle dialogStyle) {
            this.dialogStyle = dialogStyle;
            return this;
        }

        public Builder addAction(ListDialogAction action) {
            if (actions == null) {
                actions = new ArrayList<>();
            }
            actions.add(action);
            return this;
        }

        public Builder setCancelonClick(View.OnClickListener onClickListener) {
            this.cancelClickListener = onClickListener;
            return this;
        }

        public Builder setConfirmClick(View.OnClickListener confirmClickListener) {
            this.confirmClickListener = confirmClickListener;
            return this;
        }

        public ListDialog create() {
            if (dialogStyle == DialogStyle.LIST)
                return new ListDialog(context, title, actions, cancelClickListener);
            else
                return new ListDialog(context, dialogStyle, message, confirmText, cancelText, confirmClickListener, cancelClickListener);

        }
    }

    public static class ListDialogAction {
        String title;
        View.OnClickListener onClickListener;

        public ListDialogAction(String title, View.OnClickListener onClickListener) {
            this.title = title;
            this.onClickListener = onClickListener;
        }
    }
}
