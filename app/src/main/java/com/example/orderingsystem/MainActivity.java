package com.example.orderingsystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mBtn;
    TextView mTextV;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.button01);
        mTextV = findViewById(R.id.textView02);

        mBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            String[] foodArray = new String[]{"美味蟹堡","義式香腸堡","蔬菜水果堡","香蕉潛艇堡","香烤雞肉堡"};
            final boolean[] checkedFoodArray = new boolean[]{
                    true,
                    false,
                    false,
                    true,
                    false
            };
            final List<String> foodList = Arrays.asList(foodArray);
            builder.setTitle("您點的餐點有："+"\n");
            builder.setMultiChoiceItems(foodArray, checkedFoodArray, (dialogInterface, which, isChecked) -> {
                checkedFoodArray[which] = isChecked;
                String currentItem = foodList.get(which);
                Toast.makeText(MainActivity.this,currentItem+" "+isChecked,Toast.LENGTH_SHORT).show();
            });

            builder.setPositiveButton("確定", (dialog, which) -> {
                for (int i=0; i<checkedFoodArray.length;i++){
                    boolean checked = checkedFoodArray[i];
                    if (checked){
                        mTextV.setText(mTextV.getText() + foodList.get(i)+"\n");
                    }
                }
            });

            builder.setNeutralButton("取消", (dialogInterface, i) -> {

            });

            AlertDialog dialog = builder.create();

            dialog.show();
        });

    }
}