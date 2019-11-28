package com.example.myapplication.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.google.android.material.chip.Chip;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_NULL;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);

        final TextView MemoText = root.findViewById(R.id.MemoText);
        Switch editSwitch = root.findViewById(R.id.editSwitch);
        editSwitch.setText("Save");
        editSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
              //  MemoText.setEnabled(!MemoText.isEnabled());
//                if (MemoText.getFreezesText() == true) {
//                    MemoText.setFreezesText(false);
//                    MemoText.setFocusable(false);
//                    MemoText.setFocusableInTouchMode(false);
//                } else {
//                    MemoText.setFreezesText(true);
//                    MemoText.setFocusable(true);
//                    MemoText.setFocusableInTouchMode(true);
//                }
                if (MemoText.getInputType() == TYPE_NULL) {
                    MemoText.setInputType(TYPE_CLASS_TEXT);
                } else {
                    MemoText.setInputType(TYPE_NULL);
                }
             //   MemoText.setFreezesText(MemoText.getFreezesText());
               // MemoText.setInputType(MemoText.getInputType());
                //MemoText.setFreezesText(!MemoText.getFreezesText());

            }

        });

//        shareViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        shareViewModel.getText().getValue();

        return root;
    }
}