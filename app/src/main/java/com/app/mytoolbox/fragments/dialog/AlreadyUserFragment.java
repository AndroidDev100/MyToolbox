package com.app.mytoolbox.fragments.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.app.mytoolbox.R;
import com.app.mytoolbox.activities.loginActivity.ui.AstrLoginActivity;
import com.app.mytoolbox.baseModel.BaseActivity;
import com.app.mytoolbox.utils.helpers.ActivityLauncher;
import com.app.mytoolbox.utils.helpers.AppLevelConstants;
import com.google.android.material.textfield.TextInputLayout;


public class AlreadyUserFragment extends DialogFragment {
    private EditDialogListener editDialogListener;
    private EditText etDialog;
    private TextInputLayout inputLayoutDialog;
    private String fileId = "";
    private String strMessage = "";
    private String from = "";
    private BaseActivity baseActivity;

    public AlreadyUserFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance`method
    }

    public static AlreadyUserFragment newInstance(String title, String message) {
        AlreadyUserFragment frag = new AlreadyUserFragment();
        Bundle args = new Bundle();
        args.putString(AppLevelConstants.TITLE, title);
        args.putString(AppLevelConstants.FILE_ID_KEY, message);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        baseActivity = (BaseActivity) context;
    }

    public void setEditDialogCallBack(EditDialogListener editDialogListener) {
        this.editDialogListener = editDialogListener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.edit_dialog_layout, container);

        View view = inflater.inflate(R.layout.already_user_dialog_fragment, container);
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color
                    .TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            // Get field from view
            inputLayoutDialog = view.findViewById(R.id.input_layout_dialog);
            from = getArguments().getString(AppLevelConstants.TITLE);
            fileId = getArguments().getString(AppLevelConstants.FILE_ID_KEY);
            TextView btnOk = view.findViewById(R.id.btnOk);
            TextView description = view.findViewById(R.id.description);


//
            btnOk.setOnClickListener(v -> {
                new ActivityLauncher(baseActivity).astrLoginActivity(baseActivity, AstrLoginActivity.class, "Profile");
                dismiss();
            });

            // Show soft keyboard automatically and request focus to field
            getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            //  etDialog.addTextChangedListener(new CustomTextWatcher(inputLayoutDialog));
            // etDialog.setOnEditorActionListener(this);


        }
        return view;
    }


    public void onResume() {
        int width = getResources().getDisplayMetrics().widthPixels-30;
        int height = getResources().getDimensionPixelSize(R.dimen.epiosode_dialog_fragment_height);
        if (getDialog().getWindow() != null)
            getDialog().getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        // Call super onResume after sizing
        super.onResume();
    }


    // 1. Defines the listener interface with a method passing back data result.
    public interface EditDialogListener {
        void onFinishEditDialog();
    }
}
