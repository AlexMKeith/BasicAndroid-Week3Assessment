package com.example.rodneytressler.week3assessmentkey;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rodneytressler on 12/14/17.
 */

public class AccountFragment extends Fragment {

    @BindView(R.id.name_input)
    protected EditText nameInput;

    @BindView(R.id.class_input)
    protected EditText classInput;

    @OnClick(R.id.button_finish)
    protected void onFinishButtonClicked(View view) {

    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_creation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static AccountFragment newInstance() {

        Bundle args = new Bundle();

        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @OnClick(R.id.button_finish)
    private void showAlertDialog(String message) {
        if (nameInput.getText().toString().isEmpty() || classInput.getText().toString().isEmpty()) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog);

            } else {
                builder = new AlertDialog.Builder(getContext());
            } if(!classInput.ignoreCase("warrior") || !classInput.ignoreCase("mage") || !classInput.ignoreCase("archer"))
            builder.setTitle("Error, must be warrior, mage, or archer.")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    public void setCallback (ActivityCallback activityCallback){
        this.activityCallback = activityCallback;
    }

    public interface ActivityCallback {
        void createAccount(String name, String accountClass);
    }
}
