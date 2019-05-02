package com.example.david0926.sunrinmeal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;


public class Dialog_DevInfo extends DialogFragment {

    //개발 정보를 표시하는 Dialog

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()); //Dialog Builder 선언
        builder.setTitle("개발 정보") //Dialog 타이틀 설정
                .setMessage(R.string.dialog_devinfo) //Dialog 내용 설정
                .setNegativeButton("클립보드에 복사하기", new DialogInterface.OnClickListener() { //Dialog에 Negative 버튼 추가
            @Override
            public void onClick(DialogInterface dialog, int which) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", "24791027950007"); clipboard.setPrimaryClip(clip);
                Toast.makeText(getContext(), "클립보드에 복사했습니다!", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create(); //Builder 반환
    }
}
