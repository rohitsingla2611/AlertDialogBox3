package rohitsingla.rdrock.alertdialogbox3;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import static android.content.DialogInterface.BUTTON_POSITIVE;

public class DialogForm extends AppCompatDialogFragment implements DialogInterface.OnClickListener {

    private EditText editTextUsername, editTextPassword;
    private DialogFormListener dialogFormListener;
    String username, password;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
     //   setContentView(R.layout.activity_dialog_form);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.activity_dialog_form,null);


        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);

        builder.setView(view)
                .setTitle("Enter Yor Details")
                .setMessage("")
                .setNegativeButton("Cancel", this)
                .setPositiveButton("Confirm",this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        if (BUTTON_POSITIVE == i){
            username = editTextUsername.getText().toString();
            password = editTextPassword.getText().toString();
            dialogFormListener.applyText(username,password);
        }
//        switch (i){
//            case BUTTON_POSITIVE
//
    }

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        try {
            dialogFormListener = (DialogFormListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "must implement DialogFormListener");

        }
    }

    public interface DialogFormListener{
        void applyText(String username, String password);
    }
}
