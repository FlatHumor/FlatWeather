package ru.inpleasure.weather;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class TokenDialog extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_layout, null);
        builder.setView(dialogView)
                .setPositiveButton(R.string.dialog_token_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences preferences = getActivity().getSharedPreferences(
                                MainActivity.PREFERENCE_FILE, Context.MODE_PRIVATE);
                        String token = ((EditText)dialogView.findViewById(R.id.dialog_token_et))
                                .getText().toString();
                        preferences.edit()
                                .putString(MainActivity.PREFERENCE_KEY_TOKEN, token).apply();
                    }
                })
                .setNegativeButton(R.string.dialog_token_negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TokenDialog.this.getActivity().finish();
                        TokenDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
